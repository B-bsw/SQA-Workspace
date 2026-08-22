package sqa.lab.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Movie {
    private String name;
    private LocalDate date;
    private String location;

    public Movie(String name, LocalDate date, String location) {
        this.name = name;
        this.date = date;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }
}
