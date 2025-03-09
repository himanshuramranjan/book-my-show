package modules;

import enums.SeatCategory;

public class Seat {
    private String seatId;
    private SeatCategory seatCategory;

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
