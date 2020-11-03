package com.ydv.pim;

//import com.ydv.utils.UpdateJson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class rough {

    public static void main(String[] args) throws Exception {
       JSONObject jsonObject = parseJSONFile("./src/test/resources/Payloads/XPMPayloads/XpmGCHeaderPayload/createNewHeaderVersion.json");
        JSONObject response = function1(jsonObject, "description", "Test");
        System.out.println(response);
    }

    public static JSONObject parseJSONFile(String filename) throws JSONException, IOException {
        String content = new String(Files.readAllBytes(Paths.get(filename)));
        return new JSONObject(content);
    }


    public static JSONObject function1(JSONObject obj, String keyMain, String newValue) throws Exception {
        // We need to know keys of Jsonobject
        JSONObject json = new JSONObject();
       // for(ke)
        Iterator iterator = obj.keys();
        String key = null;
        while (iterator.hasNext()) {
            key = (String) iterator.next();
            // if object is just string we change value in key
            if ((obj.optJSONArray(key)==null) && (obj.optJSONObject(key)==null)) {
                if ((key.equals(keyMain))) {
                    // put new value
                    obj.put(key, newValue);
                    return obj;
                }
            }

            // if it's jsonobject
            if (obj.optJSONObject(key) != null) {
                function1(obj.getJSONObject(key), keyMain, newValue);
            }

            // if it's jsonarray
            if (obj.optJSONArray(key) != null) {
                JSONArray jArray = obj.getJSONArray(key);
                for (int i=0;i<jArray.length();i++) {
                    function1(jArray.getJSONObject(i), keyMain, newValue);
                }
            }
        }
        return obj;
    }



}
