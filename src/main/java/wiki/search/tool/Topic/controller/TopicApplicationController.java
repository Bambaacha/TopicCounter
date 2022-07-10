package wiki.search.tool.Topic.controller;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class TopicApplicationController {

    public static int countTopicInText(JSONObject myJsonObject, String topicToCount){
        String myStringFromJson = myJsonObject.toString();
        int count = 0;
        String[] temp = myStringFromJson.split("\\s*[^a-zA-Z]+\\s*");

        for (String s : temp) {
            if (topicToCount.equals(s))
                count++;
        }

        return count;
    }

    public static JSONObject topicGetText(StringBuilder myStringResponse) throws JSONException {

        JSONObject jsonObj = new JSONObject(myStringResponse.toString());

        JSONObject jsonObject = jsonObj.getJSONObject("parse");
        return jsonObject.getJSONObject("text");
    }


}
