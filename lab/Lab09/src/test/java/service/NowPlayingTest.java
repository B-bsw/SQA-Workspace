package service;

import org.junit.jupiter.api.Test;
import sqa.lab.api.MovieService;
import sqa.lab.model.Movie;
import sqa.lab.service.NowPlaying;
import stub.MoviePortalStub;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

public class NowPlayingTest {

    @Test
    void test_nowPlaying_with_stub() {
        MovieService movieService = new MoviePortalStub();
        NowPlaying nowPlaying = new NowPlaying(movieService);

        List<Movie> allMovies = nowPlaying.getMovieNowPlaying("IMAX with Laser", LocalDate.now());

        assertEquals(3,allMovies.size());
    }
}
