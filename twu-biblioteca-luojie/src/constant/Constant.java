package constant;

public class Constant {
    public static Integer quitNumber = 0;
    public static String WELCOME_MESSAGE = "  Welcome to the Bangalore Public Library !!! ";
    public static String LOGIN_MESSAGE = "Please enter the username to login the server : ";
    public static String MENU_OPTION_MESSAGE = "Please choose the option you want : ";
    public static String BOOK_DETAIL_MESSAGE = "Please input the id of book to view detail: ";
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
