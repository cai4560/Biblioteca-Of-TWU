import api.IHomePage;
import constant.Constant;
import impl.HomePage;
import org.junit.Assert;
import org.junit.Test;

public class HomePageTest extends BaseResource{
    private IHomePage homePage = new HomePage();

    @Test
    public void testPrintWelcomeMessage() {
        homePage.printWelcomeMessage();
        Assert.assertTrue(bytes.toString().indexOf(Constant.WELCOME_MESSAGE) >= 0);
    }

    @Test
    public void testPrintLoginMessage() {
        homePage.printLoginMessage();
        Assert.assertTrue(bytes.toString().indexOf(Constant.LOGIN_MESSAGE) >= 0);
    }

    @Test
    public void testIsLoginSuccess() {
        final String userName = "LuoJie";
        homePage.isLoginSuccess(userName);
        Assert.assertTrue(homePage.isLoginSuccess(userName));
        Assert.assertTrue(!homePage.isLoginSuccess(null));
    }
}
