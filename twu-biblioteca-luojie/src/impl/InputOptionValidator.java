package impl;

import constant.ExceptionMessage;

public class InputOptionValidator {
    public Boolean isValid(Integer optionNum, String mainOptions[]) {
        if (optionNum == null) {
            System.out.println(ExceptionMessage.EMPTY_OPTION_MESSAGE);
            return false;
        }
        else if (optionNum.compareTo(0) < 0 ||
                optionNum.compareTo(mainOptions.length - 1) > 0) {
            System.out.println(ExceptionMessage.INVALID_OPTION_MESSAGE);
            return false;
        }
        return true;
    }
}
