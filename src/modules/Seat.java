package modules;

import enums.SeatCategory;

public class Seat {
    private final String seatId;
    private final SeatCategory seatCategory;

    public Seat(String seatId, SeatCategory seatCategory) {
        this.seatId = seatId;
        this.seatCategory = seatCategory;
    }

    public String getSeatId() {
        return seatId;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }
}
