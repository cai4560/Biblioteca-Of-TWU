package constant;

public class Constant {
    public static Integer quitNumber = 0;
    public interface NORMAL {
        String WELCOME_MESSAGE = "Welcome to the Bangalore Public Library !";
        String LOGIN_MESSAGE = "Please enter the username to login the server : ";
        String QUIT_MESSAGE = "Good Bye~~~";
        String MENU_OPTION_MESSAGE = "Please select the valid option you want : ";
        String BOOK_DETAIL_INPUT_MESSAGE = "Please input the id of book to view detail or 0 to go back to main menu : ";
        String BOOK_CHECK_OUT_INPUT_MESSAGE = "Please input the id of book to check out or 0 to go back to main menu : ";
        String BOOK_RETURN_INPUT_MESSAGE = "Please input the id of book to return or 0 to go back to main menu : ";
        String BOOK_CHECK_OUT_SUCCESSFUL = "\t" + "Thank you! Enjoy the book.";
        String BOOK_CHECK_OUT_UNSUCCESSFUL = "\t" + "That book is not available, please try another book.";
        String BOOK_RETURN_SUCCESSFUL = "\t" + "Thank you for returning the book";
        String BOOK_RETURN_UNSUCCESSFUL = "\t" + "That is not a valid book to return, please try another book.";
    }
    public interface EXCEPTION{
        String INVALID_OPTION_MESSAGE = "\t" + "The input option is invalid.";
        String EMPTY_BOOK_ID_MESSAGE = "\t" + "The input id of book is empty.";
        String INVALID_BOOK_ID_MESSAGE = "\t" + "The input id of book isn't exist.";
    }

    public static String[] MAIN_MENU_OPTION = {"Quit the server",
                                                "List all books",
                                                "Check out a book",
                                                "Return a book"};

    public static String[] BOOK_LIST_MENU_OPTION = {"Return to last page",
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
