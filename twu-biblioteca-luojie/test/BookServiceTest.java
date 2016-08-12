import api.IBookService;
import constant.Constant;
import constant.ExceptionMessage;
import constant.NormalMessage;
import constant.PresetData;
import dto.BookDTO;
import impl.BookService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BookServiceTest extends BaseResource {
    private IBookService bookService = new BookService();

    private String CHECK_OUT = "check out";
    private String RETURN    = "return";
    private final String username = "luojie";

    @Test
    public void testPrintAllBooks() {
        bookService.printAllBooks();
        for (Integer bookIndex = 0; bookIndex < PresetData.BOOK_LIST.length; bookIndex ++) {
            String[] bookInfo = PresetData.BOOK_LIST[bookIndex].split(", ");
            for (Integer infoIndex = 0; infoIndex < bookInfo.length - 1; infoIndex ++) {
                Assert.assertTrue(bytes.toString().contains(bookInfo[infoIndex]));
            }
        }
    }

    @Test
    public void testPrintDetailById() {
        final Integer bookId = 3;
        bookService.printDetailById(bookId);
        for (Integer bookIndex = 0; bookIndex < PresetData.BOOK_LIST.length; bookIndex ++) {
            String[] bookInfo = PresetData.BOOK_LIST[bookIndex].split(", ");
            for (Integer infoIndex = 0; infoIndex < bookInfo.length - 1; infoIndex ++) {
                if (bookInfo[0].equals(bookId.toString())) {
                    Assert.assertTrue(bytes.toString().contains(bookInfo[2]));
                }
            }
        }
    }

    @Test
    public void testPrintDetailByIdWithInvalidInput() {
        Assert.assertTrue(!bookService.printDetailById(null));
        Assert.assertTrue(bytes.toString().contains(ExceptionMessage.EMPTY_BOOK_ID_MESSAGE));
        Assert.assertTrue(!bookService.printDetailById(0));
        Assert.assertTrue(bytes.toString().contains(ExceptionMessage.INVALID_BOOK_ID_MESSAGE));
    }

    @Test
    public void testCheckOutBookById() {
        final Integer bookId = 3;
        Assert.assertTrue(bookService.checkOutOrReturnBookById(bookId, CHECK_OUT, username));
        Assert.assertTrue(bytes.toString().contains(NormalMessage.BOOK_CHECK_OUT_SUCCESSFUL));

        Assert.assertTrue(!bookService.checkOutOrReturnBookById(bookId, CHECK_OUT, username));
        Assert.assertTrue(bytes.toString().contains(NormalMessage.BOOK_CHECK_OUT_UNSUCCESSFUL));
    }

    @Test
    public void testCheckOutBookByIdWithInvalidInput() {
        Assert.assertTrue(!bookService.checkOutOrReturnBookById(null, CHECK_OUT, username));
        Assert.assertTrue(bytes.toString().contains(ExceptionMessage.EMPTY_BOOK_ID_MESSAGE));

        Assert.assertTrue(!bookService.checkOutOrReturnBookById(-1, CHECK_OUT, username));
        Assert.assertTrue(bytes.toString().contains(ExceptionMessage.INVALID_BOOK_ID_MESSAGE));
    }

    @Test
    public void testReturnBookById() {
        final Integer bookId = 3;
        List<BookDTO> bookList = bookService.getBookList();
        bookList.stream().filter(book -> book.getId().equals(bookId)).forEach(book -> book.setBorrower(username));

        Assert.assertTrue(bookService.checkOutOrReturnBookById(bookId, RETURN, username));
        Assert.assertTrue(bytes.toString().contains(NormalMessage.BOOK_RETURN_SUCCESSFUL));

        Assert.assertTrue(!bookService.checkOutOrReturnBookById(bookId, RETURN, username));
        Assert.assertTrue(bytes.toString().contains(NormalMessage.BOOK_RETURN_UNSUCCESSFUL));
    }

    @Test
    public void testReturnBookByIdWithInvalidInput() {
        Assert.assertTrue(!bookService.checkOutOrReturnBookById(null, RETURN, username));
        Assert.assertTrue(bytes.toString().contains(ExceptionMessage.EMPTY_BOOK_ID_MESSAGE));

        Assert.assertTrue(!bookService.checkOutOrReturnBookById(-1, RETURN, username));
        Assert.assertTrue(bytes.toString().contains(ExceptionMessage.INVALID_BOOK_ID_MESSAGE));
    }
}
