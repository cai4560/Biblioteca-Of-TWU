package impl;

import api.IBookService;
import constant.Constant;
import constant.ExceptionMessage;
import constant.NormalMessage;
import constant.PresetData;
import dto.BookDTO;
import util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService {
    private int maxLengthOfName = 0;
    private int maxLengthOfAuthor = 0;
    private List<BookDTO> bookList = new ArrayList<>();
    private int SPACE_NUMBER = 2;

    public BookService() {
        bookList = getAllBooks();
    }

    @Override
    public void printAllBooks() {
        printTitleLine();
        bookList.forEach(this::printBookInfoByFormat);
    }

    @Override
    public void printBookDetailInputMessage() {
        System.out.print(NormalMessage.BOOK_DETAIL_INPUT_MESSAGE);
    }

    @Override
    public Boolean printDetailById(Integer bookId) {
        if (isBookIdInvalid(bookId)) {
            return false;
        }
        for (BookDTO book : bookList) {
            if (book.getId().equals(bookId)) {
                System.out.println(book.getDescription());
                return true;
            }
        }
        System.out.println(ExceptionMessage.INVALID_BOOK_ID_MESSAGE);
        return false;
    }

    @Override
    public void printCheckOutMessage() {
        System.out.print(NormalMessage.BOOK_CHECK_OUT_INPUT_MESSAGE);
    }

    @Override
    public void printReturnMessage() {
        System.out.print(NormalMessage.BOOK_RETURN_INPUT_MESSAGE);
    }

    @Override
    public Boolean checkOutOrReturnBookById(Integer bookId, String action, String userName) {
        if (isBookIdInvalid(bookId)) {
            return false;
        }
        for (BookDTO book : bookList) {
            if (book.getId().equals(bookId)) {
                if (action.equals(Constant.CHECK_OUT)) {
                    return getCheckOutResult(book, userName);
                } else if (action.equals(Constant.RETURN)){
                    return getReturnResult(book);
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    private void printTitleLine() {
        String spaces = StringUtil.getRepeatCharsByNum(SPACE_NUMBER, Constant.SPACE);
        String bookInfo = spaces + "Id"
                        + spaces + StringUtil.getFormatInfo("Name", maxLengthOfName)
                        + spaces + StringUtil.getFormatInfo("Author", maxLengthOfAuthor)
                        + spaces + "Borrower";
        System.out.println(bookInfo);
    }

    private void printBookInfoByFormat(BookDTO book) {
        String spaces = StringUtil.getRepeatCharsByNum(SPACE_NUMBER, Constant.SPACE);
        String bookInfo = spaces + StringUtil.getFormatInfo(String.valueOf(book.getId().intValue()), "Id".length())
                        + spaces + StringUtil.getFormatInfo(book.getName(), maxLengthOfName)
                        + spaces + StringUtil.getFormatInfo(book.getAuthor(), maxLengthOfAuthor)
                        + spaces + StringUtil.getFormatInfo(book.getBorrower(), "Borrower".length());
        System.out.println(bookInfo);
    }

    private List<BookDTO> getAllBooks() {
        List<BookDTO> bookList = new ArrayList<>();
        Integer bookId = 1;
        for (Integer index = 0; index < PresetData.BOOK_LIST.length; index ++) {
            String[] bookInfo = PresetData.BOOK_LIST[index].split(", ");
            bookList.add(new BookDTO(bookId, bookInfo[0], bookInfo[1], bookInfo[2]));

            if (maxLengthOfName < bookInfo[0].length()) {
                maxLengthOfName = bookInfo[0].length();
            }
            if (maxLengthOfAuthor < bookInfo[1].length()) {
                maxLengthOfAuthor = bookInfo[1].length();
            }
            bookId ++;
        }
        return bookList;
    }


    private Boolean isBookIdInvalid(Integer bookId) {
        if (bookId == null) {
            System.out.println(ExceptionMessage.EMPTY_BOOK_ID_MESSAGE);
            return true;
        }
        if (bookId.compareTo(0) < 0
                || bookId.compareTo(bookList.size()) > 0) {
            System.out.println(ExceptionMessage.INVALID_BOOK_ID_MESSAGE);
            return true;
        }
        return false;
    }

    private Boolean getCheckOutResult(BookDTO book, String userName) {
        if (book.getBorrower().equals(Constant.NONE)) {
            System.out.println(NormalMessage.BOOK_CHECK_OUT_SUCCESSFUL);
            book.setBorrower(userName);
            return true;
        } else {
            System.out.println(NormalMessage.BOOK_CHECK_OUT_UNSUCCESSFUL);
            return false;
        }
    }

    private Boolean getReturnResult(BookDTO book) {
        if (!book.getBorrower().equals(Constant.NONE)) {
            System.out.println(NormalMessage.BOOK_RETURN_SUCCESSFUL);
            book.setBorrower(Constant.NONE);
            return true;
        } else {
            System.out.println(NormalMessage.BOOK_RETURN_UNSUCCESSFUL);
            return false;
        }
    }

    public List<BookDTO> getBookList() {
        return bookList;
    }
}
