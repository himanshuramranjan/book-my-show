package modules;

import enums.SeatCategory;

public class Seat {
    private final String seatId;
    private final String seatLoc; // e.g 4A, 8C
    private final SeatCategory seatCategory;
    private boolean isBooked;

    public Seat(String seatId, String seatLoc, SeatCategory seatCategory) {
        this.seatId = seatId;
        this.seatLoc = seatLoc;
        this.seatCategory = seatCategory;
        this.isBooked = false;
    }

    public String getSeatLoc() {
        return seatLoc;
    }

    public String getSeatId() {
        return seatId;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookSeat(boolean booked) {
        isBooked = booked;
    }
}
