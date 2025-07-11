package model;

import java.time.LocalDateTime;

public class Show {
    private Movie movie;
    private Screen screen;
    private LocalDateTime showStartTime;

    public Show(Movie movie, Screen screen, LocalDateTime showStartTime) {
        this.movie = movie;
        this.screen = screen;
        this.showStartTime = showStartTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public LocalDateTime getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(LocalDateTime showStartTime) {
        this.showStartTime = showStartTime;
    }

    @Override
    public String toString() {
        return "Show{" +
                "movie=" + movie +
                ", screen=" + screen +
                ", showStartTime=" + showStartTime +
                '}';
    }
}
