package modules;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private final Show show;
    private Payment payment;

    public Booking(Show show, Payment payment) {
        this.show = show;
        this.payment = payment;
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

}
