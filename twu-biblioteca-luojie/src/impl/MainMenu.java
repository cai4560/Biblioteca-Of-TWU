package impl;

import api.IMainMenu;
import constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class MainMenu implements IMainMenu {
    @Override
    public void printMainMenu() {
        List<String> mainMenuOptions = getMainMenuOptions();
        if (mainMenuOptions != null && mainMenuOptions.size() > 1) {
            printFunctionMenu(mainMenuOptions);
        }
    }

    @Override
    public Boolean isInputOptionValid(Integer option) {
        if (option == null || option.compareTo(0) < 0 ||
                option.compareTo(Constant.MENU_OPTION.length - 1) > 0) {
            System.out.println("The input option is invalid, Please input again.");
            return false;
        }
        return true;
    }

    public List<String> getMainMenuOptions() {
        List<String> optionList = new ArrayList<>();
        for (Integer index = 0; index < Constant.MENU_OPTION.length; index ++) {
            optionList.add(Constant.MENU_OPTION[index]);
        }
        return optionList;
    }

    private void printFunctionMenu(List<String> mainMenuOptions) {
        System.out.println(Constant.MAIN_MENU_MESSAGE);
        for (Integer index = 1; index < mainMenuOptions.size(); index ++) {
            System.out.println(getOptionInfo(mainMenuOptions.get(index), index));
        }
        System.out.println(getOptionInfo(mainMenuOptions.get(Constant.quitNumber), Constant.quitNumber));
    }

    private String getOptionInfo(String option, Integer index) {
        return "  " + index.toString() + ". " + option;
    }
}
