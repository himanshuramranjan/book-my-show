package modules;

public class BookingService {
    private final Show show;
    private Payment payment;

    public BookingService(Show show, Payment payment) {
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
