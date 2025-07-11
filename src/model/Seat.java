package model;

import enums.SeatCategory;

public class Seat {
    private final String seatId;
    private final String seatLoc; // e.g 4A, 8C
    private final SeatCategory seatCategory;
    private boolean isBooked;
    private boolean isLocked;

    public Seat(String seatId, String seatLoc, SeatCategory seatCategory) {
        this.seatId = seatId;
        this.seatLoc = seatLoc;
        this.seatCategory = seatCategory;
        this.isBooked = false;
        this.isLocked = false;
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

    public synchronized boolean isBooked() {
        return isBooked;
    }

    public synchronized boolean isLocked() { return isLocked; }

    public synchronized boolean tryLockSeat() {
        if(isLocked || isBooked) {
            return false;
        }
        isLocked = true;
        return  true;
    }

    public synchronized void unlockSeat() { isLocked = false; }

    public synchronized void confirmBooking() {
        isBooked = true;
        isLocked = false;
    }
}
