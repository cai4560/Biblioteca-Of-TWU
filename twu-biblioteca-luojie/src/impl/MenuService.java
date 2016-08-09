package impl;

import api.IMenuService;
import constant.Constant;
import util.StringUtil;

import java.util.List;

public class MenuService implements IMenuService {
    private InputOptionValidator validator = new InputOptionValidator();


    @Override
    public void printWelcomeMessage() {
        System.out.println();
        System.out.println(StringUtil.getRepeatCharsByNum(50, Constant.ASTERISK));
        System.out.println(Constant.NORMAL.WELCOME_MESSAGE);
        System.out.println(StringUtil.getRepeatCharsByNum(50, Constant.ASTERISK));
    }

    @Override
    public void printMainMenu() {
        printMenu(StringUtil.getMenuOptions(Constant.MAIN_MENU_OPTION));
    }

    @Override
    public void printBookMenu() {
        printMenu(StringUtil.getMenuOptions(Constant.BOOK_MENU_OPTION));
    }

    @Override
    public void printMovieMenu() {
        printMenu(StringUtil.getMenuOptions(Constant.MOVIE_MENU_OPTION));
    }

    @Override
    public Boolean isInputOptionValid(Integer option, String[] menu) {
        return validator.isValid(option, menu);
    }

    private void printMenu(List<String> menu) {
        if (menu != null && menu.size() > 1) {
            System.out.println(Constant.NORMAL.MENU_OPTION_MESSAGE);
            StringUtil.printMenuOptions(menu);
        }
    }

}
