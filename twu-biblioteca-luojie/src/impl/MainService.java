package impl;

import constant.Constant;
import constant.MenuOption;
import constant.NormalMessage;
import util.StringUtil;


public class MainService {
    private MenuService menuService;
    private BookService bookService;
    private UserService userService;
    private MovieService movieService;

    public MainService() {
        menuService = new MenuService();
        userService = new UserService();
        bookService = new BookService();
        movieService = new MovieService();
    }

    public void start() {
        showHomePage();
        login();
        startService();
    }

    private void showHomePage() {
        menuService.printWelcomeMessage();
        System.out.println();
    }

    private void login() {
        while (userService.getCurrentUser() == null) {
            userService.printLoginUsernameMessage();
            String username = StringUtil.getNextLineFromConsole();
            userService.printLoginPasswordMessage();
            String password = StringUtil.getNextLineFromConsole();
            userService.isLoginSuccess(username, password);
        }
    }

    private void startService() {
        Integer inputOption;
        while (true) {
            menuService.printMainMenu();
            inputOption = StringUtil.getOptionNumFromConsole();
            if (menuService.isInputOptionValid(inputOption, MenuOption.MAIN_MENU_OPTION)) {
                break;
            }
        }
        chooseOptionsInMainMenu(inputOption);
    }

    private void chooseOptionsInMainMenu(Integer option) {
        switch (option) {
            case 0 : quitTheServer();
                     break;
            case 1 : startBookService();
                     break;
            case 2 : startMovieService();
                     break;
            case 3 : userService.printCurrentUserInfo();
                     startService();
                     break;
            default: break;
        }
    }

    private void quitTheServer() {
        System.out.println(NormalMessage.QUIT_MESSAGE);
        System.exit(0);
    }

    private void startBookService() {
        Integer inputOption;
        while (true) {
            menuService.printBookMenu();
            inputOption = StringUtil.getOptionNumFromConsole();
            if (menuService.isInputOptionValid(inputOption, MenuOption.BOOK_MENU_OPTION)) {
                break;
            }
        }

        switch (inputOption) {
            case 0 : startService();
                     break;
            case 1 : listAllBooks();
                     break;
            case 2 : checkOutOrReturnBook(Constant.CHECK_OUT);
                     break;
            case 3 : checkOutOrReturnBook(Constant.RETURN);
                     break;
            default: break;
        }
    }

    private void startMovieService() {
        Integer inputOption;
        while (true) {
            menuService.printMovieMenu();
            inputOption = StringUtil.getOptionNumFromConsole();
            if (menuService.isInputOptionValid(inputOption, MenuOption.MOVIE_MENU_OPTION)) {
                break;
            }
        }

        switch (inputOption) {
            case 0 : startService();
                     break;
            case 1 : listAllMovies();
                     break;
            case 2 : checkOutMovie();
                     break;
            default: break;
        }
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
            if (bookId != null && bookId.equals(0)) {
                this.startBookService();
                break;
            }
        }
    }

    private void checkOutOrReturnBook(String action) {
        while(true) {
            if (action.equals(Constant.CHECK_OUT)) {
                bookService.printCheckOutMessage();
            } else {
                bookService.printReturnMessage();
            }
            Integer bookId = StringUtil.getOptionNumFromConsole();
            if (bookService.checkOutOrReturnBookById(bookId, action, userService.getCurrentUser().getUserName())) {
                bookService.printAllBooks();
                this.checkOutOrReturnBook(action);
            }
            if (bookId != null && bookId.equals(0)) {
                this.startBookService();
                break;
            }
        }
    }

    private void checkOutMovie() {
        while (true) {
            movieService.printCheckOutMessage();
            Integer movieId = StringUtil.getOptionNumFromConsole();
            if (movieService.checkOutMovieById(movieId, userService.getCurrentUser().getUserName())) {
                movieService.printAllMovies();
                this.checkOutMovie();
            }
            if (movieId != null && movieId.equals(0)) {
                this.startMovieService();
                break;
            }
        }
    }

    private void listAllMovies() {
        movieService.printAllMovies();
        System.out.println();
        startMovieService();
    }
}
