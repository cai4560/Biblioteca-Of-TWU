import api.IMainMenu;
import constant.Constant;
import impl.MainMenu;
import org.junit.Assert;
import org.junit.Test;

public class MainMenuTest extends BaseResource {
    private IMainMenu mainMenu = new MainMenu();

    @Test
    public void testPrintMainMenu() {
        mainMenu.printMainMenu();
        for (Integer index = 0; index < Constant.MENU_OPTION.length; index ++) {
            Assert.assertTrue(bytes.toString().indexOf(Constant.MENU_OPTION[index]) >= 0);
        }
    }

    @Test
    public void testIsInputOptionValid() {
        Assert.assertTrue(mainMenu.isInputOptionValid(new Integer(0)));
        Assert.assertTrue(!mainMenu.isInputOptionValid(new Integer(-1)));
    }
}
