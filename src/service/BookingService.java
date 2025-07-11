package service;

import model.Booking;
import model.Seat;
import model.Show;
import service.pricedecorator.BasePriceComponent;
import service.pricedecorator.PricingComponent;
import service.pricedecorator.SeatCategoryAddon;
import service.pricedecorator.TimeBasedAddon;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private PaymentService paymentService;

    public BookingService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public Booking bookSeats(Show show, List<Seat> seats) {
        if(!tryLockingSeats(seats)) {
            System.out.println("Couldnt book all the selected seats, please choose some other seats");
            return null;
        }

        PricingComponent pricing = new TimeBasedAddon(new SeatCategoryAddon(new BasePriceComponent()));
        double amount = 0.0;

        for(Seat seat : seats) amount += pricing.calculatePrice(seat, show);

        if(!paymentService.processPayment(amount)) {
            System.out.println("Payment failed. Unlocking seats.");
            unlockAll(seats);
            return null;
        }
        return new Booking(seats, show, amount);
    }

    private boolean tryLockingSeats(List<Seat> seats) {
        List<Seat> lockedSeats = new ArrayList<>();

        for(Seat seat : seats) {
            boolean locked = seat.tryLockSeat();

            if(!locked) {
                for(Seat lockedSeat : lockedSeats) {
                    lockedSeat.unlockSeat();
                }
                return false;
            } else {
                lockedSeats.add(seat);
            }
        }
        return true;
    }

    private void unlockAll(List<Seat> seats) {
        for(Seat seat : seats) {
            seat.unlockSeat();
        }
    }

}
