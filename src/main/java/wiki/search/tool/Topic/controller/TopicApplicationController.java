package wiki.search.tool.Topic.controller;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class TopicApplicationController {

    //The actual logic about to find and count the keyword in a JSONObject full of everything
    public static int countTopicInText(JSONObject myJsonObject, String topicToCount) {

        //converting the JSONObject to a String
        String myStringFromJson = myJsonObject.toString();

        //counter is setted to 0 before the run
        int count = 0;

        //Regular expression to clean and split the String in a Array
        String[] temp = myStringFromJson.split("\\s*[^a-zA-Z]+\\s*");

        //Iterate trough the Array and count how manny times the Keyword append
        for (String s : temp) {
            //checks if the word is the same case sensitive
            if (topicToCount.equals(s))
                count++;
        }

        //returning the counter
        return count;
    }

    //Here am i manipulataning my Object actualy i am getting the Attribute "text"
    public static JSONObject topicGetText(StringBuilder myStringResponse) throws JSONException {

        JSONObject jsonObj = new JSONObject(myStringResponse.toString());

        JSONObject jsonObject = jsonObj.getJSONObject("parse");
        return jsonObject.getJSONObject("text");
    }


}
