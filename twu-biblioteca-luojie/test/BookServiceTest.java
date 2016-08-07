import api.IBookService;
import constant.Constant;
import impl.BookService;
import org.junit.Assert;
import org.junit.Test;

public class BookServiceTest extends BaseResource {
    private IBookService bookService = new BookService();

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
    public void testPrintBookMenuOptions() {
        bookService.printBookMenuOptions();
        for (Integer index = 0; index < Constant.BOOK_MENU_OPTION.length; index ++) {
            Assert.assertTrue(bytes.toString().indexOf(Constant.BOOK_MENU_OPTION[index]) >= 0);
        }
    }

    @Test
    public void testIsInputOptionValid() {
        Assert.assertTrue(bookService.isInputOptionValid(new Integer(0)));
        Assert.assertTrue(!bookService.isInputOptionValid(new Integer(-1)));
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
        Assert.assertTrue(bookService.checkOutBookById(bookId));
        Assert.assertTrue(bytes.toString().indexOf(Constant.NORMAL.BOOK_CHECK_OUT_SUCCESSFUL) >= 0);

        Assert.assertTrue(!bookService.checkOutBookById(bookId));
        Assert.assertTrue(bytes.toString().indexOf(Constant.NORMAL.BOOK_CHECK_OUT_UNSUCCESSFUL) >= 0);
    }

    @Test
    public void testCheckOutBookByIdWithInvalidInput() {
        Assert.assertTrue(!bookService.checkOutBookById(null));
        Assert.assertTrue(bytes.toString().indexOf(Constant.EXCEPTION.EMPTY_BOOK_ID_MESSAGE) >= 0);

        Assert.assertTrue(!bookService.checkOutBookById(new Integer(-1)));
        Assert.assertTrue(bytes.toString().indexOf(Constant.EXCEPTION.INVALID_BOOK_ID_MESSAGE) >= 0);
    }
}
