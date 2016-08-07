package util;

import constant.Constant;

import java.util.ArrayList;
import java.util.List;
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

    public static Integer getOptionNumFromConsole() {
        String inputStr = StringUtil.getNextLineFromConsole();
        return (inputStr == null) ? null
                : Integer.valueOf(inputStr);
    }

    public static List<String> getMenuOptions(String options[]) {
        List<String> optionList = new ArrayList<>();
        for (Integer index = 0; index < options.length; index ++) {
            optionList.add(options[index]);
        }
        return optionList;
    }

    public static void printMenuOptions(List<String> mainOptions) {
        for (Integer index = 1; index < mainOptions.size(); index ++) {
            System.out.println(getOptionInfo(mainOptions.get(index), index));
        }
        System.out.println(getOptionInfo(mainOptions.get(Constant.quitNumber), Constant.quitNumber));
    }

    private static String getOptionInfo(String option, Integer index) {
        return "  " + index.toString() + ". " + option;
    }
}
