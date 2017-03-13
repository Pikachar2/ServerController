package com.shockops.beans;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import org.json.JSONException;
//import org.json.JSONObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArkData {

	// private ArkInfo info;
	// private ArkPlayers players;
	// private Map<String, String> rules;
	private Map<String, Object> info;
	private Map<String, Object> players;
	private Map<String, Object> rules;

	public ArkData() {
		// empty?
	}

	// public ArkData(Map<String, String> info, Map<String, String> players,
	// Map<String, String> rules) {
	// super();
	// this.info = info;
	// this.players = players;
	// this.rules = rules;
	// }

	public ArkData(String input) {
		super();
		JSONObject json = null;
		String value = null;
		JSONObject item = null;
		JSONArray array = null;
		

		try {
			json = new JSONObject(input);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<?> keys = json.keys();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			try {
				value = json.getString(key);
				checkValue(key, value, String.class);
			} catch (JSONException e) {
				try {
					item = json.getJSONObject(key);
					checkValue(key, item, JSONObject.class);
				} catch (JSONException e1) {
					try {
						array = json.getJSONArray(key);
						//TODO add parse JSONArray
					} catch (JSONException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}
			
//			if (key.contains("info")) {
//				 this.info = jsonToMap(value);
//			} else if (key.contains("players")) {
//				// this.players = jsonToMap(value);
//			} else if (key.contains("rules")) {
//				// this.rules = jsonToMap(value);
//			} else {
//				// do nothing?
//			}
		}
	}

	private <T> void checkValue(String key, Object value, Class<T> type){

		if(type.equals(String.class)){
			getValueString(key, (String) value);
		}else if(type.equals(JSONObject.class)){
			getValueObject(key, (JSONObject) value);
		}else if(type.equals(JSONArray.class)){
			getValueArray(key, (JSONArray) value);
		}
		
		
	}
	
	private void getValueArray(String key, JSONArray value){
		if (key.contains("info")) {
			 this.info = jsonToMap(value);
		} else if (key.contains("players")) {
			 this.players = jsonToMap(value);
		} else if (key.contains("rules")) {
			 this.rules = jsonToMap(value);
		} else {
			// do nothing?
		}
	}
	
	private void getValueObject(String key, JSONObject value){
		if (key.contains("info")) {
			 this.info = jsonToMap(value);
		} else if (key.contains("players")) {
			 this.players = jsonToMap(value);
		} else if (key.contains("rules")) {
			 this.rules = jsonToMap(value);
		} else {
			// do nothing?
		}
	}
	
	private void getValueString(String key, String value){
		if (key.contains("info")) {
			 this.info = jsonToMap(value);
		} else if (key.contains("players")) {
			 this.players = jsonToMap(value);
		} else if (key.contains("rules")) {
			 this.rules = jsonToMap(value);
		} else {
			// do nothing?
		}
	}
	
	private Map<String, Object> jsonToMap(String input)  {
		Map<String, Object> map = new HashMap<String, Object>();

		JSONObject json = null;
				try {
					json = new JSONObject(input);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		Iterator<?> keys = json.keys();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String value = null;
			try {
				value = json.getString(key);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put(key, value);
		}

		return map;
	}

	private Map<String, Object> jsonToMap(JSONObject json) {
		Map<String, Object> map = new HashMap<String, Object>();
		Iterator<?> keys = json.keys();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String value = null;
			try {
				value = json.getString(key);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put(key, value);
		}

		return map;
	}

	private Map<String, Object> jsonToMap(JSONArray jsonArray) {
		Map<String, Object> map = new HashMap<String, Object>();
		
//		jsonArray.
//		Iterator<?> keys = json.keys();
//		while (keys.hasNext()) {
//			String key = (String) keys.next();
//			String value = null;
//			try {
//				value = json.getString(key);
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			map.put(key, value);
//		}

		return map;
	}

	@Override
	public String toString() {
		return "ArkData [info=" + info + ", players=" + players + ", rules=" + rules + "]";
	}

	
	
}
