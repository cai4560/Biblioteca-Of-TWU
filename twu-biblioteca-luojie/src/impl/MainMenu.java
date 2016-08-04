package impl;

import api.IMainMenu;
import constant.Constant;
import util.StringUtil;

import java.util.List;

public class MainMenu implements IMainMenu {
    private InputOptionValidator validator = new InputOptionValidator();

    @Override
    public void printMainMenu() {
        List<String> mainMenuOptions = StringUtil.getMenuOptions(Constant.MAIN_MENU_OPTION);
        if (mainMenuOptions != null && mainMenuOptions.size() > 1) {
            System.out.println(Constant.MENU_OPTION_MESSAGE);
            StringUtil.printMenuOptions(mainMenuOptions);
        }
    }

    @Override
    public Boolean isInputOptionValid(Integer option) {
        return validator.isValid(option, Constant.MAIN_MENU_OPTION);
    }
}
