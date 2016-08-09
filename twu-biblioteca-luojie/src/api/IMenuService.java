package api;

public interface IMenuService {
    void printWelcomeMessage();

    void printMainMenu();

    void printBookMenu();

    void printMovieMenu();

    Boolean isInputOptionValid(Integer option, String[] menu);
}
