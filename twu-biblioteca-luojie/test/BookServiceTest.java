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
}
