package modules;

public class PaymentService {
    // Payment to implement
    private boolean isBillPaid;

    public PaymentService(boolean isBillPaid) {
        this.isBillPaid = false;
    }

    public boolean isBillPaid() {
        return isBillPaid;
    }

    public void setBillPaid(boolean billPaid) {
        isBillPaid = billPaid;
    }
}
