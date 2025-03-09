package modules;

import java.util.List;

public class Movie {

    private final String movieName;
    private int duration;
    private final List<String> genre;
    private final List<String> languages;

    public Movie(String movieName, int duration, List<String> genre, List<String> languages) {
        this.movieName = movieName;
        this.duration = duration;
        this.genre = genre;
        this.languages = languages;
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
}
