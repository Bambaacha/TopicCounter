package wiki.search.tool.Topic.utils;

import java.util.Scanner;

public class Utils {
    public static int inputInt() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if(number == 0) {
            scanner.close();
            System.exit(1);
        }

        return number;
    }

    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();

        if(string == null) {
            scanner.close();
            System.exit(1);
        }

        return string;
    }
}
