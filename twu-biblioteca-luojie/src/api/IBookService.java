package api;

import dto.BookDTO;

import java.util.List;


public interface IBookService{
    void printBookListMenuOptions();

    Boolean isInputOptionValid(Integer option, String[] optionsList);

    void printAllBooks();

    void printBookDetailInputMessage();

    Boolean printDetailById(Integer bookId);

    void printCheckOutMessage();

    void printReturnMessage();

    Boolean checkOutOrReturnBookById(Integer bookId, String action);

    List<BookDTO> getBookList() ;
}
