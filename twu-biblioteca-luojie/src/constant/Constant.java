package constant;

public class Constant {
    public static Integer QUIT_NUMBER = 0;
    public static String NONE = "-";
    public static Character SPACE = ' ';
    public static Character ASTERISK = '*';
    public static String CHECK_OUT = "check out";
    public static String RETURN = "return";

    public interface NORMAL {
        String WELCOME_MESSAGE = "Welcome to the Bangalore Public Library !";
        String LOGIN_MESSAGE_USERNAME = "Please enter the your username : ";
        String LOGIN_MESSAGE_PASSWORD = "Please enter the your password : ";
        String LOGIN_SUCCESSFUL_MESSAGE = "Successfully login to the server, ";
        String QUIT_MESSAGE = "Good Bye~~~";
        String MENU_OPTION_MESSAGE = "Please select the valid option you want : ";
        String BOOK_DETAIL_INPUT_MESSAGE = "Please input the id of book to view detail or 0 to go back to previous menu : ";
        String BOOK_CHECK_OUT_INPUT_MESSAGE = "Please input the id of book to check out or 0 to go back to previous menu : ";
        String BOOK_RETURN_INPUT_MESSAGE = "Please input the id of book to return or 0 to go back to previous menu : ";
        String BOOK_CHECK_OUT_SUCCESSFUL = "--> " + "Thank you! Enjoy the book.";
        String BOOK_CHECK_OUT_UNSUCCESSFUL = "--> " + "That book is not available, please try another book.";
        String BOOK_RETURN_SUCCESSFUL = "--> " + "Thank you for returning the book";
        String BOOK_RETURN_UNSUCCESSFUL = "--> " + "That is not a valid book to return, please try another book.";

        String MOVIE_CHECK_OUT_INPUT_MESSAGE = "Please input the id of movie to check out or 0 to go back to previous menu : ";
        String MOVIE_CHECK_OUT_SUCCESSFUL = "--> " + "Thank you! Enjoy the movie.";
        String MOVIE_CHECK_OUT_UNSUCCESSFUL = "--> " + "That movie is not available, please try another movie.";
    }

    public interface EXCEPTION{
        String EMPTY_USERNAME_OR_PASSWORD = "--> " + "The username or password cannot be empty";
        String INVALID_USERNAME_MESSAGE = "--> " + "The username you input is not exist";
        String INVALID_PASSWORD_MESSAGE = "--> " + "The password you input is incorrect";
        String EMPTY_OPTION_MESSAGE = "--> " + "The option cannot be empty.";
        String INVALID_OPTION_MESSAGE = "--> " + "The option you input is invalid.";
        String EMPTY_BOOK_ID_MESSAGE = "--> " + "The book id cannot be empty.";
        String INVALID_BOOK_ID_MESSAGE = "--> " + "The book id you input is invalid.";
        String EMPTY_MOVIE_ID_MESSAGE = "--> " + "The movie id cannot be empty.";
        String INVALID_MOVIE_ID_MESSAGE = "--> " + "The movie id you input is invalid.";
    }

    public static String[] MAIN_MENU_OPTION = { "Quit server",
                                                "Book service",
                                                "Movie service",
                                                "View your information"};

    public static String[] BOOK_MENU_OPTION = {"Back to main menu",
                                               "List all books",
                                               "Check out a book",
                                               "Return a book"};

    public static String[] MOVIE_MENU_OPTION = {"Back to main menu",
                                                "List all movies",
                                                "Check out a movie"};

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

    public static String[] MOVIE_LIST =  {"movie 1, 2011, director 1, 1"
                                        , "movie 2, 2012, director 2, 2"
                                        , "movie 3, 2013, director 3, 3"
                                        , "movie 4, 2014, director 4, 4"
                                        , "movie 5, 2015, director 5, 5"
                                        , "movie 6, 2016, director 6, -"};

    public static String[] USER_LIST = {"luojie, luojie, 002-0001, luojie@tw.com, 123456, Customer",
                                        "007, 007, 001-0002, 007@tw.com, 654321, Librarian"};
}
