package constant;

public class Constant {
    public static Integer quitNumber = 0;
    public interface NORMAL {
        String WELCOME_MESSAGE = "Welcome to the Bangalore Public Library !";
        String LOGIN_MESSAGE = "Please enter the username to login the server : ";
        String MENU_OPTION_MESSAGE = "Please choose the option you want : ";
        String BOOK_DETAIL_INPUT_MESSAGE = "Please input the id of book to view detail: ";
        String BOOK_CHECK_OUT_INPUT_MESSAGE = "Please input the id of book to check out:";
        String BOOK_CHECK_OUT_SUCCESSFUL = "Thank you! Enjoy the book.";
        String BOOK_CHECK_OUT_UNSUCCESSFUL = "That book is not available, please try another book.";
    }
    public interface EXCEPTION{
        String INVALID_OPTION_MESSAGE = "The input option is invalid, Please input again.";
        String EMPTY_BOOK_ID_MESSAGE = "The input id of book is empty, Please input again.";
        String INVALID_BOOK_ID_MESSAGE = "The input id of book isn't exist , Please input again.";
    }

    public static String[] MAIN_MENU_OPTION = {"Quit the server",
                                          "List all books",
                                          "Check out a book",
                                          "Return a book"};

    public static String[] BOOK_MENU_OPTION = {"Return to last page",
                                               "View details"};

    public static String[] BOOK_LIST = {"Slowing Down to the Speed of Life" +
                                        ", Richard Carlson and Joseph Bailey" +
                                        ", Living in the present.",
                                        "Your Money or Your Life" +
                                        ", Joe Dominguez and Vicki Robins" +
                                        ", Use simple method to change our world.",
                                        "The Art of Happiness" +
                                        ", DalaiLama" +
                                        ", To feel the strength of kindness and happiness."};
}
