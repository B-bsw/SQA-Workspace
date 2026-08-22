package sqa.lab.api;

import sqa.lab.model.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {
    public List<Movie> getMovie(String location, LocalDate date);
}
