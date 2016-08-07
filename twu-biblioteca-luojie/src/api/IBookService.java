package api;

public interface IBookService{
    void printAllBooks();

    void printBookMenuOptions();

    Boolean isInputOptionValid(Integer option);

    void printBookDetailInputMessage();

    Boolean printDetailById(Integer bookId);

    void printCheckOutMessage();

    Boolean checkOutBookById(Integer bookId);
}
