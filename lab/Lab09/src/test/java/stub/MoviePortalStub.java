package stub;

import sqa.lab.api.MovieService;
import sqa.lab.model.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MoviePortalStub implements MovieService {
    @Override
    public List<Movie> getMovie(String location, LocalDate date) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Odyssey", LocalDate.now(), "IMAX with Laser"));
        movies.add(new Movie("Spider-Man: Brand New Day", LocalDate.now(), "IMAX with Laser"));
        movies.add(new Movie("The End of Oak Street", LocalDate.now(), "IMAX with Laser"));
        movies.add(new Movie("Niu Lai", LocalDate.now(), "Normal"));
        movies.add(new Movie("Minions", LocalDate.now(), "Normal"));
        return movies;
    }
}
