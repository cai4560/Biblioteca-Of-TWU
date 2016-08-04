package util;

import java.util.Scanner;

public class StringUtil {
    public static String getRepeatCharsByNum(Integer num, Character character) {
        String repeatString = "";
        for (Integer index = 0; index < num ; index ++) {
            repeatString = repeatString.concat(character.toString());
        }
        return repeatString;
    }

    public static String getNextLineFromConsole() {
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        return (inputLine != null && inputLine.length() > 0) ? inputLine : null;
    }
}
