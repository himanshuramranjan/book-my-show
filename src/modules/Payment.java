package modules;

public class Payment {
    // Payment to implement
    private boolean isBillPaid;

    public Payment(boolean isBillPaid) {
        this.isBillPaid = false;
    }

    public boolean isBillPaid() {
        return isBillPaid;
    }

    public void setBillPaid(boolean billPaid) {
        isBillPaid = billPaid;
    }
}
