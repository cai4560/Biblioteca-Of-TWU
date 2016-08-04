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

    private InputOptionValidator validator = new InputOptionValidator();

    @Override
    public void printAllBooks() {
        List<BookDTO> bookList = getAllBooks();
        printTitleLine();
        bookList.forEach(this::printBookInfoByFormat);
    }


    @Override
    public void printBookMenuOptions() {
        List<String> bookMenuOption = StringUtil.getMenuOptions(Constant.BOOK_MENU_OPTION);
        if (bookMenuOption != null && bookMenuOption.size() > 0) {
            System.out.println(Constant.MENU_OPTION_MESSAGE);
            StringUtil.printMenuOptions(bookMenuOption);
        }
    }

    @Override
    public Boolean isInputOptionValid(Integer option) {
        return validator.isValid(option, Constant.BOOK_MENU_OPTION);
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
        Integer bookId = 0;
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
}
