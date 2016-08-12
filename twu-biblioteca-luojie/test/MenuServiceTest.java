import api.IMenuService;
import constant.MenuOption;
import constant.NormalMessage;
import impl.MenuService;
import org.junit.Assert;
import org.junit.Test;

public class MenuServiceTest extends BaseResource {
    private IMenuService menuService = new MenuService();

    @Test
    public void testPrintWelcomeMessage() {
        menuService.printWelcomeMessage();
        Assert.assertTrue(bytes.toString().contains(NormalMessage.WELCOME_MESSAGE));
    }

    @Test
    public void testPrintMainMenu() {
        menuService.printMainMenu();
        for (Integer index = 0; index < MenuOption.MAIN_MENU_OPTION.length; index ++) {
            Assert.assertTrue(bytes.toString().contains(MenuOption.MAIN_MENU_OPTION[index]));
        }
    }

    @Test
    public void testPrintBookMenu() {
        menuService.printBookMenu();
        for (Integer index = 0; index < MenuOption.BOOK_MENU_OPTION.length; index ++) {
            Assert.assertTrue(bytes.toString().contains(MenuOption.BOOK_MENU_OPTION[index]));
        }
    }

    @Test
    public void testPrintMovieMenu() {
        menuService.printMovieMenu();
        for (Integer index = 0; index < MenuOption.MOVIE_MENU_OPTION.length; index ++) {
            Assert.assertTrue(bytes.toString().contains(MenuOption.MOVIE_MENU_OPTION[index]));
        }
    }

    @Test
    public void testIsInputOptionValid() {
        Assert.assertTrue(menuService.isInputOptionValid(0, MenuOption.MAIN_MENU_OPTION));
        Assert.assertTrue(!menuService.isInputOptionValid(-1, MenuOption.MAIN_MENU_OPTION));
        Assert.assertTrue(menuService.isInputOptionValid(0, MenuOption.BOOK_MENU_OPTION));
        Assert.assertTrue(!menuService.isInputOptionValid(-1, MenuOption.BOOK_MENU_OPTION));
    }
}
