package impl;

import constant.Constant;

public class InputOptionValidator {
    public Boolean isValid(Integer optionNum, String mainOptions[]) {
        if (optionNum == null) {
            System.out.println(Constant.EXCEPTION.EMPTY_OPTION_MESSAGE);
            return false;
        }
        else if (optionNum.compareTo(0) < 0 ||
                optionNum.compareTo(mainOptions.length - 1) > 0) {
            System.out.println(Constant.EXCEPTION.INVALID_OPTION_MESSAGE);
            return false;
        }
        return true;
    }
}
