package modules;

import java.util.List;

public class Screen {
    private final int screenId;
    private final List<Seat> seats;

    public Screen(int screenId, List<Seat> seats) {
        this.screenId = screenId;
        this.seats = seats;
    }

    public int getScreenId() {
        return screenId;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
