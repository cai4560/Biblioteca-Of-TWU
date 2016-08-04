package api;

public interface IHomePage {
    void printWelcomeMessage();

    void printLoginMessage();

    void login(String userName);

    String getUserName();
}
