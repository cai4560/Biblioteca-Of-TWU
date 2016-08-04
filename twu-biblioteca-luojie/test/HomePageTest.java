import api.IHomePage;
import constant.Constant;
import impl.HomePage;
import org.junit.Assert;
import org.junit.Test;

public class HomePageTest extends BaseResource{
    private IHomePage homePageServices = new HomePage();

    @Test
    public void testPrintWelcomeMessage() {
        homePageServices.printWelcomeMessage();
        Boolean expectResult = true;
        Assert.assertEquals(expectResult, bytes.toString().indexOf(Constant.welcomeMessage) >= 0);
    }

    @Test
    public void testPrintLoginMessage() {
        homePageServices.printLoginMessage();
        Boolean expectResult = true;
        Assert.assertEquals(expectResult, bytes.toString().indexOf(Constant.loginMessage) >= 0);
    }

    @Test
    public void testLogin() {
        final String userName = "LuoJie";
        homePageServices.login(userName);
        Assert.assertEquals(userName, homePageServices.getUserName());
    }
}
