package service.pricedecorator;

import model.Seat;
import model.Show;

import java.time.LocalTime;

public class TimeBasedAddon extends PricingDecorator {

    public TimeBasedAddon(PricingComponent pricing) {
        super(pricing);
    }

    @Override
    public double calculatePrice(Seat seat, Show show) {
        double base = pricingComponent.calculatePrice(seat, show);
        LocalTime time = show.getShowStartTime().toLocalTime();
        return time.isAfter(LocalTime.of(20, 0)) ? base + 30 : base; // Extra for day show
    }
}
