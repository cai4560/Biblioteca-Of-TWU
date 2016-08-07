package impl;

import constant.Constant;
import util.StringUtil;

/**
 * Created by Administrator on 2016/8/7 0007.
 */
public class MainService {
    private HomePage homePage;
    private MainMenu mainMenu;
    private BookService bookService;

    private String CHECK_OUT = "check out";
    private String RETURN    = "return";

    public MainService() {
        homePage = new HomePage();
        mainMenu = new MainMenu();
        bookService = new BookService();
    }

    public void start() {
        showHomePage();
        startService();
    }

    public void showHomePage() {
        homePage.printWelcomeMessage();
        while (homePage.getUserName() == null) {
            homePage.printLoginMessage();
            homePage.isLoginSuccess(StringUtil.getNextLineFromConsole());
        }
        System.out.println();
    }

    public void startService() {
        Integer inputOption;
        while (true) {
            mainMenu.printMainMenu();
            inputOption = StringUtil.getOptionNumFromConsole();
            if (mainMenu.isInputOptionValid(inputOption)) {
                break;
            }
        }
        startServiceByOption(inputOption);
    }

    private void startServiceByOption(Integer inputOption) {
        switch (inputOption) {
            case 0 : quitTheServer();
                break;
            case 1 : listAllBooks();
                break;
            case 2 : checkOutOrReturnBook(CHECK_OUT);
                break;
            case 3 : checkOutOrReturnBook(RETURN);
                break;
            default: break;
        }
    }

    private void quitTheServer() {
        System.out.println(Constant.NORMAL.QUIT_MESSAGE);
    }

    private void listAllBooks() {
        bookService.printAllBooks();
        System.out.println();
        showBookDetails();
    }

    private void showBookDetails() {
        while(true) {
            bookService.printBookDetailInputMessage();
            Integer bookId = StringUtil.getOptionNumFromConsole();
            if (bookService.printDetailById(bookId)) {
                this.showBookDetails();
            }
            if (bookId != null && bookId.equals(new Integer(0))) {
                this.startService();
                break;
            }
        }
    }

    private void checkOutOrReturnBook(String action) {
        while(true) {
            if (action.equals(CHECK_OUT)) {
                bookService.printCheckOutMessage();
            } else {
                bookService.printReturnMessage();
            }
            Integer bookId = StringUtil.getOptionNumFromConsole();
            if (bookService.checkOutOrReturnBookById(bookId, action)) {
                bookService.printAllBooks();
                this.checkOutOrReturnBook(action);
            }
            if (bookId != null && bookId.equals(new Integer(0))) {
                this.startService();
                break;
            }
        }
    }


}
