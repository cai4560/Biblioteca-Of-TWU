package impl;

import api.IBookService;
import constant.Constant;
import dto.BookDTO;
import util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService {
    private Integer maxLengthOfName = new Integer(0);
    private Integer maxLengthOfAuthor = new Integer(0);
    private Integer columnSpaceNum = 2;
    private Character space = ' ';
    private Boolean isCheckedOut = true;
    private List<BookDTO> bookList = new ArrayList<>();

    private InputOptionValidator validator = new InputOptionValidator();

    public BookService() {
        bookList = getAllBooks();
    }

    @Override
    public void printAllBooks() {
        printTitleLine();
        bookList.forEach(this::printBookInfoByFormat);
    }


    @Override
    public void printBookMenuOptions() {
        List<String> bookMenuOption = StringUtil.getMenuOptions(Constant.BOOK_MENU_OPTION);
        if (bookMenuOption != null && bookMenuOption.size() > 0) {
            System.out.println(Constant.NORMAL.MENU_OPTION_MESSAGE);
            StringUtil.printMenuOptions(bookMenuOption);
        }
    }

    @Override
    public Boolean isInputOptionValid(Integer option) {
        return validator.isValid(option, Constant.BOOK_MENU_OPTION);
    }

    @Override
    public void printBookDetailInputMessage() {
        System.out.println(Constant.NORMAL.BOOK_DETAIL_INPUT_MESSAGE);
    }

    @Override
    public Boolean printDetailById(Integer bookId) {
        if (isBookIdEmpty(bookId)) {
            return false;
        }
        for (BookDTO book : bookList) {
            if (book.getId().equals(bookId)) {
                System.out.println("  " + book.getDescription());
                return true;
            }
        }
        System.out.println(Constant.EXCEPTION.INVALID_BOOK_ID_MESSAGE);
        return false;
    }

    @Override
    public void printCheckOutMessage() {
        System.out.println(Constant.NORMAL.BOOK_CHECK_OUT_INPUT_MESSAGE);
    }

    @Override
    public Boolean checkOutBookById(Integer bookId) {
        if (isBookIdEmpty(bookId)) {
            return false;
        }
        for (BookDTO book : bookList) {
            if (book.getId().equals(bookId)) {
                if (book.getCheckOut().equals(isCheckedOut)) {
                    System.out.println(Constant.NORMAL.BOOK_CHECK_OUT_UNSUCCESSFUL);
                    return false;
                } else {
                    System.out.println(Constant.NORMAL.BOOK_CHECK_OUT_SUCCESSFUL);
                    book.setCheckOut(isCheckedOut);
                    return true;
                }
            }
        }
        System.out.println(Constant.EXCEPTION.INVALID_BOOK_ID_MESSAGE);
        return false;
    }

    private void printTitleLine() {
        String spaces = StringUtil.getRepeatCharsByNum(columnSpaceNum, space);
        String bookInfo = spaces + "id" + spaces
                + getFormatBookInfo("Name", maxLengthOfName)
                + spaces
                + getFormatBookInfo("Author", maxLengthOfAuthor)
                + "Checked Out";
        System.out.println(bookInfo);
    }

    private void printBookInfoByFormat(BookDTO book) {
        String spaces = StringUtil.getRepeatCharsByNum(columnSpaceNum, space);
        String bookInfo = spaces + String.valueOf(book.getId().intValue() + 1) + spaces
                + getFormatBookInfo(book.getName(), maxLengthOfName)
                + spaces
                + getFormatBookInfo(book.getAuthor(), maxLengthOfAuthor)
                + spaces + book.getCheckOut();
        System.out.println(bookInfo);
    }

    public List<BookDTO> getAllBooks() {
        List<BookDTO> bookList = new ArrayList<>();
        Integer bookId = 1;
        for (Integer index = 0 ; index < Constant.BOOK_LIST.length; index ++) {
            String[] bookInfo = Constant.BOOK_LIST[index].split(", ");
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

    private String getFormatBookInfo(String info, Integer maxLength) {
        Integer spaceLength = maxLength - info.length();
        String spaceStr = StringUtil.getRepeatCharsByNum(spaceLength / 2, space);
        if (spaceLength % 2 != 0) {
            return spaceStr + info + spaceStr + space;
        }
        return spaceStr + info + spaceStr;
    }

    private Boolean isBookIdEmpty(Integer bookId) {
        if (bookId == null) {
            System.out.println(Constant.EXCEPTION.EMPTY_BOOK_ID_MESSAGE);
            return true;
        }
        return false;
    }
}
