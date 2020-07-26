// package com.shockops.converter;
//
// import java.util.Map;
// import java.util.Set;
//
// public class JsonConverter {
//
// // TODO Really should use jackson for this...
// // TODO redo with jackson
//
// public static String createJson(Map<String, String> input) {
// StringBuilder json = new StringBuilder();
// Set<String> keys = input.keySet();
//
// for (String key : keys) {
// json.append(createKVPair(key, input.get(key)));
// }
//
// return json.toString();
// }
//
// private static String createKVPair(String left, String right) {
// String retval = left + " = " + right;
//
// return retval;
// }
// }
