package wiki.search.tool.Topic;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import wiki.search.tool.Topic.api.GetTopicFromApi;
import wiki.search.tool.Topic.controller.TopicApplicationController;
import wiki.search.tool.Topic.utils.Utils;

public class Menu {

        //This here is the Menu of the Command Line Application
        public static void main() throws JSONException {

            //Command Line Output
            System.out.println("###################################");
            System.out.println("Welcome to the Topic-counter Application");
            System.out.println("1 Chose one specific topic");
            System.out.println("0 exit the applicationb.");
            System.out.println("###################################");

            //Calls one utils method that returns us the input from the User
            int option = Utils.inputInt();

            //Calls the Menu logic and gets as parameter the option
            mainMenu(option);
        }

        //Switch-case for the Option witch is the User choising
        public static void mainMenu(int menuOption) throws JSONException {
            String topic;
            int countedNumber;

            switch (menuOption) {
                case 0:
                    //Exit from the application
                    System.out.println("Bye!");
                    break;
                case 1:
                    //Getting the topic for the option from the Menu
                    topic = specificTopic();

                    //Getting the topic from the api of Wikipedia
                    StringBuilder myStringResponse = GetTopicFromApi.main(topic);
                    //Get the "text" attribute from the response(JSON)
                    JSONObject jsonMyText = TopicApplicationController.topicGetText(myStringResponse);
                    //Returns the counter as Integer
                    countedNumber = TopicApplicationController.countTopicInText(jsonMyText, topic);

                    //Command line Answer
                    System.out.println("###################################");
                    System.out.println("It occurs: " + countedNumber + " The Topic was: " + topic);
                    System.out.println("###################################");
                    main();
                case 2:

                    //Command Line Output
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

            //Command Line Output
            System.out.print("Write the topic you want to count: ");

            //Calls one utils method that returns us the input from the User
            //The actual Keyword
            myStringTopic = Utils.inputString();

            return myStringTopic;
        }
}
