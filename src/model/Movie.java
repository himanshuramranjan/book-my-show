package model;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private final String movieName;
    private int duration;
    private final List<String> genre;
    private final List<String> languages;
    private int basePrice;

    public Movie(String movieName, int duration, int basePrice) {
        this.movieName = movieName;
        this.duration = duration;
        this.basePrice = basePrice;
        this.genre = new ArrayList<>();
        this.languages = new ArrayList<>();
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getDuration() {
        return duration;
    }

    public List<String> getGenre() {
        return genre;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }
}
