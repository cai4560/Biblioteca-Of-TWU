package impl;

import api.IMovieService;
import constant.Constant;
import constant.ExceptionMessage;
import constant.NormalMessage;
import constant.PresetData;
import dto.MovieDTO;
import util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class MovieService implements IMovieService {
    private int maxLengthOfName = 0;
    private int maxLengthOfDirector = 0;
    private List<MovieDTO> movieList = new ArrayList<>();

    private int SPACE_NUMBER = 2;

    public MovieService() {
        movieList = getAllMovies();
    }

    @Override
    public void printAllMovies() {
        printTitleLine();
        movieList.forEach(this::printMovieInfoByFormat);
    }

    @Override
    public void printCheckOutMessage() {
        System.out.print(NormalMessage.MOVIE_CHECK_OUT_INPUT_MESSAGE);
    }

    @Override
    public Boolean checkOutMovieById(Integer movieId, String userName) {
        if (isMovieIdInvalid(movieId)) {
            return false;
        }
        for (MovieDTO movie : movieList) {
            if (movie.getId().equals(movieId)) {
                return getCheckOutResult(movie, userName);
            }
        }
        return false;
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<MovieDTO> movieList = new ArrayList<>();
        Integer movieId = 1;
        for (Integer index = 0; index < PresetData.MOVIE_LIST.length; index ++) {
            String[] movieInfo = PresetData.MOVIE_LIST[index].split(", ");
            movieList.add(new MovieDTO(movieId, movieInfo[0]
                    , Integer.valueOf(movieInfo[1]), movieInfo[2], movieInfo[3]));

            if (maxLengthOfName < movieInfo[0].length()) {
                maxLengthOfName = movieInfo[0].length();
            }
            if (maxLengthOfDirector < movieInfo[2].length()) {
                maxLengthOfDirector = movieInfo[2].length();
            }
            movieId ++;
        }
        return movieList;
    }

    private void printTitleLine() {
        String spaces = StringUtil.getRepeatCharsByNum(SPACE_NUMBER, Constant.SPACE);
        String movieInfo = spaces + "Id"
                         + spaces + StringUtil.getFormatInfo("Name", maxLengthOfName)
                         + spaces + StringUtil.getFormatInfo("Director", maxLengthOfDirector)
                         + spaces + "Year"
                         + spaces + "Rating"
                         + spaces + "Borrower";
        System.out.println(movieInfo);
    }

    private void printMovieInfoByFormat(MovieDTO movie) {
        String spaces = StringUtil.getRepeatCharsByNum(SPACE_NUMBER, Constant.SPACE);
        String bookInfo = spaces + StringUtil.getFormatInfo(String.valueOf(movie.getId().intValue()), "Id".length())
                        + spaces + StringUtil.getFormatInfo(movie.getName(), maxLengthOfName)
                        + spaces + StringUtil.getFormatInfo(movie.getDirector(), maxLengthOfDirector)
                        + spaces + movie.getYear()
                        + spaces + StringUtil.getFormatInfo(movie.getRating(), "Rating".length())
                        + spaces + StringUtil.getFormatInfo(movie.getBorrower(), "Borrower".length());
        System.out.println(bookInfo);
    }

    private Boolean isMovieIdInvalid(Integer movieId) {
        if (movieId == null) {
            System.out.println(ExceptionMessage.EMPTY_MOVIE_ID_MESSAGE);
            return true;
        }
        if (movieId.compareTo(0) < 0
                || movieId.compareTo(movieList.size()) > 0) {
            System.out.println(ExceptionMessage.INVALID_MOVIE_ID_MESSAGE);
            return true;
        }
        return false;
    }

    private Boolean getCheckOutResult(MovieDTO movie, String userName) {
        if (movie.getBorrower().equals(Constant.NONE)) {
            System.out.println(NormalMessage.MOVIE_CHECK_OUT_SUCCESSFUL);
            movie.setBorrower(userName);
            return true;
        } else {
            System.out.println(NormalMessage.MOVIE_CHECK_OUT_UNSUCCESSFUL);
            return false;
        }
    }

}
