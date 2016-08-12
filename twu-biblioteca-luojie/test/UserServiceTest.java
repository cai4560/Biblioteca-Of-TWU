import api.IUserService;
import constant.Constant;
import constant.PresetData;
import dto.UserDTO;
import impl.UserService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserServiceTest extends BaseResource{
    private IUserService userService = new UserService();

    @Test
    public void testGetAllUsers() {
        List<UserDTO> userList = userService.getAllUsers();
        for (Integer index = 0; index < userList.size(); index ++) {
            UserDTO currentUser = userList.get(index);
            Assert.assertTrue(PresetData.USER_LIST[index].contains(currentUser.getUserName()));
            Assert.assertTrue(PresetData.USER_LIST[index].contains(currentUser.getPassword()));
            Assert.assertTrue(PresetData.USER_LIST[index].contains(currentUser.getLibraryNumber()));
            Assert.assertTrue(PresetData.USER_LIST[index].contains(currentUser.getTelephoneNumber()));
            Assert.assertTrue(PresetData.USER_LIST[index].contains(currentUser.getEmailAddress()));
        }
    }

    @Test
    public void testIsLoginSuccess() {
        final String userName = "luojie";
        final String userPassword = "luojie";
        final String librarianName = "007";
        final String librarianPassword = "007";
        Assert.assertTrue(userService.isLoginSuccess(userName, userPassword));
        Assert.assertEquals(userService.getCurrentUser().getUserName(), userName);
        Assert.assertTrue(!userService.isLoginSuccess(userName, librarianPassword));
        Assert.assertTrue(userService.isLoginSuccess(librarianName, librarianPassword));
        Assert.assertEquals(userService.getCurrentUser().getUserName(), librarianName);
        Assert.assertTrue(!userService.isLoginSuccess(librarianName, userPassword));
    }
}
