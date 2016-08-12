package impl;

import api.IUserService;
import constant.Constant;
import constant.ExceptionMessage;
import constant.NormalMessage;
import constant.PresetData;
import dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    private List<UserDTO> userList;

    private UserDTO user;

    public UserService() {
        userList = getAllUsers();
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> allUsers = new ArrayList<>();
        Integer userId = 1;

        for (Integer index = 0; index < PresetData.USER_LIST.length; index ++) {
            String[] userInfo = PresetData.USER_LIST[index].split(", ");
            allUsers.add(new UserDTO(userId, userInfo[0], userInfo[1], userInfo[2],
                    userInfo[3], userInfo[4], userInfo[5]));
            userId ++;
        }
        return allUsers;
    }

    @Override
    public void printLoginUsernameMessage() {
        System.out.print(NormalMessage.LOGIN_MESSAGE_USERNAME);
    }

    @Override
    public void printLoginPasswordMessage() {
        System.out.print(NormalMessage.LOGIN_MESSAGE_PASSWORD);
    }

    @Override
    public Boolean isLoginSuccess(String userName, String password) {
        if (userName == null || password == null) {
            System.out.println(ExceptionMessage.EMPTY_USERNAME_OR_PASSWORD);
            return false;
        }
        for (UserDTO user :userList) {
            if (user.getUserName().equals(userName)) {
                if (user.getPassword().equals(password)) {
                    System.out.println(NormalMessage.LOGIN_SUCCESSFUL_MESSAGE + user.getUserName());
                    this.user = user;
                    return true;
                } else  {
                    System.out.println(ExceptionMessage.INVALID_PASSWORD_MESSAGE);
                    return false;
                }
            }
        }
        System.out.println(ExceptionMessage.INVALID_USERNAME_MESSAGE);
        return false;
    }

    @Override
    public void printCurrentUserInfo() {
        System.out.println("Username : " + user.getUserName());
        System.out.println("Library number : " + user.getLibraryNumber());
        System.out.println("Telephone number : " + user.getTelephoneNumber());
        System.out.println("Email address : " + user.getEmailAddress());
        System.out.println("User lever : " + user.getUserLever());
    }

    @Override
    public UserDTO getCurrentUser() {
        return user;
    }
}
