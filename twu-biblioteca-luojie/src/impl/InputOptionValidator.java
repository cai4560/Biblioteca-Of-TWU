package impl;

import constant.Constant;

public class InputOptionValidator {
    public boolean isValid(Integer optionNum, String mainOptions[]) {
        if (optionNum == null || optionNum.compareTo(0) < 0 ||
                optionNum.compareTo(mainOptions.length - 1) > 0) {
            System.out.println("\t" + Constant.EXCEPTION.INVALID_OPTION_MESSAGE);
            return false;
        }
        return true;
    }
}
