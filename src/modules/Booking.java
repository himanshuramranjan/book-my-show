package modules;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private final Show show;
    private Payment payment;
    private final List<Seat> bookedSeats;

    public Booking(Show show, Payment payment) {
        this.show = show;
        this.payment = payment;
        this.bookedSeats = new ArrayList<>();
    }

    public Show getShow() {
        return show;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }
}
