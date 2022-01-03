#!/bin/bash
# Original Source: https://github.com/Donavan/docker_steambase/blob/master/extract_mod.sh
mod_appid=$1
#mod_branch=Linux
mod_branch=Windows
modid=$2

modsrcdir="/home/zach/Steam/steamapps/workshop/content/$mod_appid/$modid"
moddestdir="$3$modid"
#moddestdir="/opt/steam/mods/$modid"
modbranch="${mod_branch:-Windows}"

echo "Mod source: $modsrcdir"
echo "Mod dest:$moddestdir"

for varname in "${!mod_branch_@}"; do
  if [ "mod_branch_$modid" == "$varname" ]; then
    modbranch="${!varname}"
  fi
done

if [ \( ! -f "$moddestdir/.modbranch" \) ] || [ "$(<"$moddestdir/.modbranch")" != "$modbranch" ]; then
  rm -rf "$moddestdir"
fi

if [ -f "$modsrcdir/mod.info" ]; then
  echo "Copying files to $moddestdir"

  if [ -f "$modsrcdir/${modbranch}NoEditor/mod.info" ]; then
    modsrcdir="$modsrcdir/${modbranch}NoEditor"
  fi

  find "$modsrcdir" -type d -printf "$moddestdir/%P\0" | xargs -0 -r mkdir -p

  find "$modsrcdir" -type f ! \( -name '*.z' -or -name '*.z.uncompressed_size' \) -printf "%P\n" | while read f; do
    if [ \( ! -f "$moddestdir/$f" \) -o "$modsrcdir/$f" -nt "$moddestdir/$f" ]; then
      printf "%10d  %s  " "`stat -c '%s' "$modsrcdir/$f"`" "$f"
      cp "$modsrcdir/$f" "$moddestdir/$f"
      echo -ne "\r\\033[K"
    fi
  done

  find "$modsrcdir" -type f -name '*.z' -printf "%P\n" | while read f; do
    if [ \( ! -f "$moddestdir/${f%.z}" \) -o "$modsrcdir/$f" -nt "$moddestdir/${f%.z}" ]; then
      printf "%10d  %s  " "`stat -c '%s' "$modsrcdir/$f"`" "${f%.z}"
      perl -M'Compress::Raw::Zlib' -e '
        my $sig;
        read(STDIN, $sig, 8) or die "Unable to read compressed file";
        if ($sig != "\xC1\x83\x2A\x9E\x00\x00\x00\x00"){
          die "Bad file magic";
        }
        my $data;
        read(STDIN, $data, 24) or die "Unable to read compressed file";
        my ($chunksizelo, $chunksizehi,
            $comprtotlo,  $comprtothi,
            $uncomtotlo,  $uncomtothi)  = unpack("(LLLLLL)<", $data);
        my @chunks = ();
        my $comprused = 0;
        while ($comprused < $comprtotlo) {
          read(STDIN, $data, 16) or die "Unable to read compressed file";
          my ($comprsizelo, $comprsizehi,
              $uncomsizelo, $uncomsizehi) = unpack("(LLLL)<", $data);
          push @chunks, $comprsizelo;
          $comprused += $comprsizelo;
        }
        foreach my $comprsize (@chunks) {
          read(STDIN, $data, $comprsize) or die "File read failed";
          my ($inflate, $status) = new Compress::Raw::Zlib::Inflate();
          my $output;
          $status = $inflate->inflate($data, $output, 1);
          if ($status != Z_STREAM_END) {
            die "Bad compressed stream; status: " . ($status);
          }
          if (length($data) != 0) {
            die "Unconsumed data in input"
          }
          print $output;
        }
      ' <"$modsrcdir/$f" >"$moddestdir/${f%.z}"
      touch -c -r "$modsrcdir/$f" "$moddestdir/${f%.z}"
      echo -ne "\r\\033[K"
    fi
  done

  perl -e '
    my $data;
    { local $/; $data = <STDIN>; }
    my $mapnamelen = unpack("@0 L<", $data);
    my $mapname = substr($data, 4, $mapnamelen - 1);
    $mapnamelen += 4;
    my $mapfilelen = unpack("@" . ($mapnamelen + 4) . " L<", $data);
    my $mapfile = substr($data, $mapnamelen + 8, $mapfilelen);
    print pack("L< L< L< Z8 L< C L< L<", $ARGV[0], 0, 8, "ModName", 1, 0, 1, $mapfilelen);
    print $mapfile;
    print "\x33\xFF\x22\xFF\x02\x00\x00\x00\x01";
  ' $modid <"$moddestdir/mod.info" >"$moddestdir/../$modid.mod"

  if [ -f "$moddestdir/modmeta.info" ]; then
    cat "$moddestdir/modmeta.info" >>"$moddestdir/../$modid.mod"
  else
    echo -ne '\x01\x00\x00\x00\x08\x00\x00\x00ModType\x00\x02\x00\x00\x001\x00' >>"$moddestdir/../$modid.mod"
  fi

  echo "$modbranch" >"$moddestdir/.modbranch"
fi

