package model;

import java.util.List;

public class Booking {

    private final List<Seat> bookedSeats;
    private final Show show;
    private final double amount;

    public Booking(List<Seat> bookedSeats, Show show, double amount) {
        this.bookedSeats = bookedSeats;
        this.show = show;
        this.amount = amount;
    }

    public String getBookingInformation() {
        return "Booking {" +
                "bookedSeats=" + bookedSeats +
                ", show=" + show +
                ", amount=" + amount +
                '}';
    }
}
