package com.bikeapp.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {
    public static JSONObject getStrippedJsonObject (String jsonString){

        JSONObject trimmedJson = null;

        jsonString = jsonString.startsWith("[") ? jsonString.substring(1) : jsonString;
        jsonString = jsonString.endsWith("]") ? jsonString.substring(0,jsonString.length() - 1) : jsonString;

        try {
            trimmedJson = new JSONObject(jsonString);

        } catch (JSONException e) {

        }
        return trimmedJson;
    }

    public static String getStrippedJsonString (String jsonString){

        String trimmedJson = "";

        jsonString = jsonString.startsWith("[") ? jsonString.substring(1) : jsonString;
        trimmedJson = jsonString.endsWith("]") ? jsonString.substring(0,jsonString.length() - 1) : jsonString;

        return trimmedJson;
    }
}
