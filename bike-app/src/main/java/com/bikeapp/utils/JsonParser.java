package com.bikeapp.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {

    //accept json string and return trimmed json object
    public static JSONObject getStrippedJsonObject (String jsonString){

        JSONObject trimmedJson = null;

        //remove brackets at start and end if they exist
        jsonString = jsonString.startsWith("[") ? jsonString.substring(1) : jsonString;
        jsonString = jsonString.endsWith("]") ? jsonString.substring(0,jsonString.length() - 1) : jsonString;

        try {
            trimmedJson = new JSONObject(jsonString);

        } catch (JSONException e) {

        }
        return trimmedJson;
    }

    //accept json string and return trimmed json string
    public static String getStrippedJsonString (String jsonString){

        String trimmedJson = "";

        //remove brackets at start and end if they exist
        jsonString = jsonString.startsWith("[") ? jsonString.substring(1) : jsonString;
        trimmedJson = jsonString.endsWith("]") ? jsonString.substring(0,jsonString.length() - 1) : jsonString;

        return trimmedJson;
    }
}
