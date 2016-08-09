import api.IMenuService;
import constant.Constant;
import impl.MenuService;
import org.junit.Assert;
import org.junit.Test;

public class MenuServiceTest extends BaseResource {
    private IMenuService mainMenu = new MenuService();

    @Test
    public void testPrintWelcomeMessage() {
        mainMenu.printWelcomeMessage();
        Assert.assertTrue(bytes.toString().indexOf(Constant.NORMAL.WELCOME_MESSAGE) >= 0);
    }

    @Test
    public void testPrintMainMenu() {
        mainMenu.printMainMenu();
        for (Integer index = 0; index < Constant.BOOK_MENU_OPTION.length; index ++) {
            Assert.assertTrue(bytes.toString().indexOf(Constant.BOOK_MENU_OPTION[index]) >= 0);
        }
    }

    @Test
    public void testIsInputOptionValid() {
        Assert.assertTrue(mainMenu.isInputOptionValid(new Integer(0)));
        Assert.assertTrue(!mainMenu.isInputOptionValid(new Integer(-1)));
    }
}
