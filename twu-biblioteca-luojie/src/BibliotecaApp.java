import impl.HomePage;
import util.StringUtil;

public class BibliotecaApp {

    public static void main(String[] args) {
        HomePage homePage = new HomePage();
        homePage.printWelcomeMessage();
        while (homePage.getUserName() == null) {
            homePage.printLoginMessage();
            homePage.login(StringUtil.getNextLineFromConsole());
        }
    }
}
