package modules;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Show {
    private Movie movie;
    private Screen screen;
    private LocalDateTime showStartTime;
    private final List<Seat> listOfSeats;

    public Show(Movie movie, Screen screen, LocalDateTime showStartTime) {
        this.movie = movie;
        this.screen = screen;
        this.showStartTime = showStartTime;
        this.listOfSeats = new ArrayList<>();
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

    public List<Seat> getListOfSeats() {
        return listOfSeats;
    }

    public void addSeats(Seat seat) {
        this.listOfSeats.add(seat);
    }

    public void removeSeats(Seat seat) {
        this.listOfSeats.remove(seat);
    }
}
