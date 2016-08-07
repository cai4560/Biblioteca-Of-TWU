import api.IBookService;
import constant.Constant;
import dto.BookDTO;
import impl.BookService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BookServiceTest extends BaseResource {
    private IBookService bookService = new BookService();

    private String CHECK_OUT = "check out";
    private String RETURN    = "return";

    @Test
    public void testPrintAllBooks() {
        bookService.printAllBooks();
        for (Integer bookIndex = 0; bookIndex < Constant.BOOK_LIST.length; bookIndex ++) {
            String[] bookInfo = Constant.BOOK_LIST[bookIndex].split(", ");
            for (Integer infoIndex = 0; infoIndex < bookInfo.length - 1; infoIndex ++) {
                Assert.assertTrue(bytes.toString().indexOf(bookInfo[infoIndex]) >= 0);
            }
        }
    }

    @Test
    public void testPrintDetailById() {
        final Integer bookId = 3;
        bookService.printDetailById(new Integer(bookId));
        for (Integer bookIndex = 0; bookIndex < Constant.BOOK_LIST.length; bookIndex ++) {
            String[] bookInfo = Constant.BOOK_LIST[bookIndex].split(", ");
            for (Integer infoIndex = 0; infoIndex < bookInfo.length - 1; infoIndex ++) {
                if (bookInfo[0].equals(bookId.toString())) {
                    Assert.assertTrue(bytes.toString().indexOf(bookInfo[2]) >= 0);
                }
            }
        }
    }

    @Test
    public void testPrintDetailByIdWithInvalidInput() {
        Assert.assertTrue(!bookService.printDetailById(null));
        Assert.assertTrue(bytes.toString().indexOf(Constant.EXCEPTION.EMPTY_BOOK_ID_MESSAGE) >= 0);
        Assert.assertTrue(!bookService.printDetailById(0));
        Assert.assertTrue(bytes.toString().indexOf(Constant.EXCEPTION.INVALID_BOOK_ID_MESSAGE) >= 0);
    }

    @Test
    public void testCheckOutBookById() {
        final Integer bookId = 3;
        Assert.assertTrue(bookService.checkOutOrReturnBookById(bookId, CHECK_OUT));
        Assert.assertTrue(bytes.toString().indexOf(Constant.NORMAL.BOOK_CHECK_OUT_SUCCESSFUL) >= 0);

        Assert.assertTrue(!bookService.checkOutOrReturnBookById(bookId, CHECK_OUT));
        Assert.assertTrue(bytes.toString().indexOf(Constant.NORMAL.BOOK_CHECK_OUT_UNSUCCESSFUL) >= 0);
    }

    @Test
    public void testCheckOutBookByIdWithInvalidInput() {
        Assert.assertTrue(!bookService.checkOutOrReturnBookById(null, CHECK_OUT));
        Assert.assertTrue(bytes.toString().indexOf(Constant.EXCEPTION.EMPTY_BOOK_ID_MESSAGE) >= 0);

        Assert.assertTrue(!bookService.checkOutOrReturnBookById(new Integer(-1), CHECK_OUT));
        Assert.assertTrue(bytes.toString().indexOf(Constant.EXCEPTION.INVALID_BOOK_ID_MESSAGE) >= 0);
    }

    @Test
    public void testReturnBookById() {
        final Integer bookId = 3;
        List<BookDTO> bookList = bookService.getBookList();
        bookList.stream().filter(book -> book.getId().equals(bookId)).forEach(book -> {
            book.setIsCheckedOut(true);
        });

        Assert.assertTrue(bookService.checkOutOrReturnBookById(bookId, RETURN));
        Assert.assertTrue(bytes.toString().indexOf(Constant.NORMAL.BOOK_RETURN_SUCCESSFUL) >= 0);

        Assert.assertTrue(!bookService.checkOutOrReturnBookById(bookId, RETURN));
        Assert.assertTrue(bytes.toString().indexOf(Constant.NORMAL.BOOK_RETURN_UNSUCCESSFUL) >= 0);
    }

    @Test
    public void testReturnBookByIdWithInvalidInput() {
        Assert.assertTrue(!bookService.checkOutOrReturnBookById(null, RETURN));
        Assert.assertTrue(bytes.toString().indexOf(Constant.EXCEPTION.EMPTY_BOOK_ID_MESSAGE) >= 0);

        Assert.assertTrue(!bookService.checkOutOrReturnBookById(new Integer(-1), RETURN));
        Assert.assertTrue(bytes.toString().indexOf(Constant.EXCEPTION.INVALID_BOOK_ID_MESSAGE) >= 0);
    }
}
