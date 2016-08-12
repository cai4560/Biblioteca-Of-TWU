package api;

import dto.MovieDTO;

import java.util.List;

public interface IMovieService {
    void printAllMovies();

    void printCheckOutMessage();

    Boolean checkOutMovieById(Integer movieId, String userName);

    List<MovieDTO> getAllMovies() ;

}
