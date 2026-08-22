package sqa.lab.service;

import sqa.lab.api.MovieService;
import sqa.lab.model.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NowPlaying {
    private MovieService movieService;

    public NowPlaying(MovieService movieService) {
        super();
        this.movieService = movieService;
    }

    public List<Movie> getMovieNowPlaying(String location, LocalDate date) {

        List<Movie> allMovies = movieService.getMovie(location, date);
        List<Movie> nowPlaying = new ArrayList<>();

        for (Movie movie : allMovies) {
            if(movie.getLocation().equals(location)) {
                nowPlaying.add(movie);
            }
        }

    return nowPlaying;
    }
}
