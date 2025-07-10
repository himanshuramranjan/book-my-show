package model;

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

    public void addSeat(Seat seat) {
        this.seats.add(seat);
    }

    public void removeSeat(Seat seat) {
        this.seats.remove(seat);
    }
}
