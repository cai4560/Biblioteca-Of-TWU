package api;

public interface IBookService{
    void printAllBooks();

    void printBookMenuOptions();

    Boolean isInputOptionValid(Integer option);

    void printDetailById(Integer bookId);
}
