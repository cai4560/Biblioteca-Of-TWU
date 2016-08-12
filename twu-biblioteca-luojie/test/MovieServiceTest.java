import api.IMovieService;
import constant.Constant;
import constant.ExceptionMessage;
import constant.NormalMessage;
import constant.PresetData;
import impl.MovieService;
import org.junit.Assert;
import org.junit.Test;

public class MovieServiceTest extends BaseResource{
    private IMovieService movieService = new MovieService();

    private final String username = "luojie";

    @Test
    public void testPrintAllMovies() {
        movieService.printAllMovies();
        for (Integer movieIndex = 0; movieIndex < PresetData.MOVIE_LIST.length; movieIndex ++) {
            String[] movieInfo = PresetData.MOVIE_LIST[movieIndex].split(", ");
            for (Integer infoIndex = 0; infoIndex < movieInfo.length - 1; infoIndex ++) {
                Assert.assertTrue(bytes.toString().contains(movieInfo[infoIndex]));
            }
        }
    }

    @Test
    public void testCheckOutMovieById() {
        final Integer movieId = 3;
        Assert.assertTrue(movieService.checkOutMovieById(movieId, username));
        Assert.assertTrue(bytes.toString().contains(NormalMessage.MOVIE_CHECK_OUT_SUCCESSFUL));

        Assert.assertTrue(!movieService.checkOutMovieById(movieId, username));
        Assert.assertTrue(bytes.toString().contains(NormalMessage.MOVIE_CHECK_OUT_SUCCESSFUL));
    }

    @Test
    public void testCheckOutMovieByIdWithInvalidInput() {
        Assert.assertTrue(!movieService.checkOutMovieById(null, username));
        Assert.assertTrue(bytes.toString().contains(ExceptionMessage.EMPTY_MOVIE_ID_MESSAGE));

        Assert.assertTrue(!movieService.checkOutMovieById(-1, username));
        Assert.assertTrue(bytes.toString().contains(ExceptionMessage.INVALID_MOVIE_ID_MESSAGE));
    }
}
