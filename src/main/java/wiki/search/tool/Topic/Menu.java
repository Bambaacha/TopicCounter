package wiki.search.tool.Topic;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import wiki.search.tool.Topic.api.GetTopicFromApi;
import wiki.search.tool.Topic.controller.TopicApplicationController;
import wiki.search.tool.Topic.utils.Utils;

public class Menu {

        public static void main() throws JSONException {
            System.out.println("###################################");
            System.out.println("Welcome to the Topic-counter Application");
            System.out.println("1 Chose one specific topic");
            System.out.println("0 exit the applicationb.");
            System.out.println("###################################");
            int option = Utils.inputInt();
    
            mainMenu(option);
        }

        public static void mainMenu(int menuOption) throws JSONException {
            String topic;
            int countedNumber;

            switch (menuOption) {
                case 0:
                    System.out.println("Bye!");
                    break;
                case 1:
                    topic = specificTopic();
                    StringBuilder myStringResponse = GetTopicFromApi.main(topic);
                    JSONObject jsonMyText = TopicApplicationController.topicGetText(myStringResponse);
                    countedNumber = TopicApplicationController.countTopicInText(jsonMyText, topic);
                    System.out.println("###################################");
                    System.out.println("It occurs: " + countedNumber + " The Topic was: " + topic);
                    System.out.println("###################################");
                    main();
                case 2:
                    System.out.println("###################################");
                    System.out.println("Creator:");
                    System.out.println("Miltiadis Orfanidis");
                    System.out.println("###################################");
                    System.out.println(" ");
                    main();
            }
        }

    public static String specificTopic(){
            String myStringTopic;

            System.out.print("Write the topic you want to count: ");
            myStringTopic = Utils.inputString();

            return myStringTopic;
        }
}
