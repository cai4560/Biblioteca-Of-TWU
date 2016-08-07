import constant.Constant;
import impl.BookService;
import impl.HomePage;
import impl.MainMenu;
import util.StringUtil;

public class BibliotecaApp {

    public static void main(String[] args) {
        HomePage homePage = new HomePage();
        homePage.printWelcomeMessage();
        while (homePage.getUserName() == null) {
            homePage.printLoginMessage();
            homePage.isLoginSuccess(StringUtil.getNextLineFromConsole());
        }

        MainMenu mainMenu = new MainMenu();
        mainMenu.printMainMenu();
        Integer inputOption;
        while (true) {
            inputOption = Integer.valueOf(StringUtil.getNextLineFromConsole());
            if (mainMenu.isInputOptionValid(inputOption)) {
                break;
            }
        }

        switch (inputOption) {
            case 0 : System.out.println("Good bye~\n");
                     break;
            case 1 : {
                        BookService bookService = new BookService();
                        while(true) {
                            bookService.printAllBooks();
                            bookService.printBookMenuOptions();
                            inputOption = Integer.valueOf(StringUtil.getNextLineFromConsole());
                            if (bookService.isInputOptionValid(inputOption)) {
                                break;
                            }
                        }
                        System.out.println(Constant.BOOK_DETAIL_MESSAGE);
                        Integer bookId = Integer.valueOf(StringUtil.getNextLineFromConsole());
                        bookService.printDetailById(bookId);
                        break;
                }
        }
    }
}
