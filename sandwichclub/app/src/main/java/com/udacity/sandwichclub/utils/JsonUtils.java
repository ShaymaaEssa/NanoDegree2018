package com.udacity.sandwichclub.utils;

import android.widget.Toast;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static final String JSON_NAME= "name";
    public static final String JSON_MAINNAME = "mainName";
    public static final String JSON_ALSOKNOWNAS = "alsoKnownAs";
    public static final String JSON_ORIGIN ="placeOfOrigin";
    public static final String JSON_DESC = "description";
    public static final String JSON_IMAGE = "image";
    public static final String JSON_INGREDIENTS ="ingredients";

    public static Sandwich parseSandwichJson(String json) {
        try {
            if (json.contains(JSON_NAME)) {
                JSONObject data = new JSONObject(json);
                JSONObject name = data.getJSONObject(JSON_NAME);
                String mainName = name.optString(JSON_MAINNAME);

                JSONArray alsoKnownAs = name.getJSONArray(JSON_ALSOKNOWNAS);
                List<String> alsoKnownAsList = new ArrayList<String>();
                for (int i = 0; i < alsoKnownAs.length(); i++) {
                    alsoKnownAsList.add(alsoKnownAs.optString(i));
                }

                String placeOfOrigin = data.optString(JSON_ORIGIN);
                String description = data.optString(JSON_DESC);
                String image = data.optString(JSON_IMAGE);

                JSONArray ingredients = data.getJSONArray(JSON_INGREDIENTS);
                List<String> ingredientsList = new ArrayList<String>();
                for (int i = 0; i < ingredients.length(); i++) {
                    ingredientsList.add(ingredients.optString(i));
                }

                Sandwich sandwich = new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);
                return sandwich;
            }
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
            return null;
        }
            return null;
    }
}
