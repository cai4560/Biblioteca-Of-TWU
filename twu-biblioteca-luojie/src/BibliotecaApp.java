import impl.HomePage;
import impl.MainMenu;
import util.StringUtil;

public class BibliotecaApp {

    public static void main(String[] args) {
        HomePage homePage = new HomePage();
        homePage.printWelcomeMessage();
        while (homePage.getUserName() == null) {
            homePage.printLoginMessage();
            homePage.isLoginSuccess(StringUtil.getNextLineFromConsole());
        }

        MainMenu mainMenu = new MainMenu();
        mainMenu.printMainMenu();
        while (true) {
            Integer inputOption = Integer.valueOf(StringUtil.getNextLineFromConsole());
            if (mainMenu.isInputOptionValid(inputOption)) {
                break;
            }
        }
    }
}
