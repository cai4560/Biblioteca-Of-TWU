package api;

public interface IHomePage {
    void printWelcomeMessage();

    void printLoginMessage();

    Boolean isLoginSuccess(String userName);
}
