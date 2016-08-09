package api;

import dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> getAllUsers();

    void printLoginUsernameMessage();

    void printLoginPasswordMessage();

    Boolean isLoginSuccess(String userName, String password);

    void printCurrentUserInfo();

    UserDTO getCurrentUser();
}
