package impl;

import api.IHomePage;
import constant.Constant;
import util.StringUtil;

public class HomePage implements IHomePage {
    private String userName;

    @Override
    public void printWelcomeMessage() {
        System.out.println();
        System.out.println(StringUtil.getRepeatCharsByNum(50, '*'));
        System.out.println(Constant.NORMAL.WELCOME_MESSAGE);
        System.out.println(StringUtil.getRepeatCharsByNum(50, '*'));
        System.out.println();
    }

    @Override
    public void printLoginMessage() {
        System.out.print(Constant.NORMAL.LOGIN_MESSAGE);
    }


    @Override
    public Boolean isLoginSuccess(String userName) {
        if (userName != null) {
            this.setUserName(userName);
            System.out.println("Hello, " + userName);
            return true;
        } else {
            System.out.println("UserName is empty.");
            return false;
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
