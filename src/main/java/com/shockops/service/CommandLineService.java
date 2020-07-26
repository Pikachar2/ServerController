package com.shockops.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class CommandLineService {

    public Set<String> listFilesUsingJavaIOWithFilter(String dir, Predicate<? super File> filter) {
        return Stream.of(new File(dir).listFiles()).filter(filter).map(File::getName).collect(Collectors.toSet());
    }

    public Set<String> listDirectoriesUsingJavaIO(String dir) {
        return Stream.of(new File(dir).listFiles()).filter(file -> file.isDirectory()).map(File::getName)
                        .collect(Collectors.toSet());
    }

    /*
     * Executes the specified command. Returns the exit code, or -1 if something happened.
     */
    @SuppressWarnings("resource")
    public int executeProcess(String cmd) {
        ProcessBuilder builder = new ProcessBuilder(cmd);

        String runDirectory = System.getProperty("user.home");

        builder.directory(new File(runDirectory));
        try {
            Process process = builder.start();
            StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
            Executors.newSingleThreadExecutor().submit(streamGobbler);
            return process.waitFor();
        } catch (InterruptedException | IOException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    private static class StreamGobbler implements Runnable {
        private InputStream inputStream;
        private Consumer<String> consumer;

        public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
            this.inputStream = inputStream;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(inputStream)).lines().forEach(consumer);
        }
    }
}
