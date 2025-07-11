package service.pricedecorator;

import model.Seat;
import model.Show;

public class SeatCategoryAddon extends PricingDecorator {
    public SeatCategoryAddon(PricingComponent pricing) {
        super(pricing);
    }

    @Override
    public double calculatePrice(Seat seat, Show show) {
        double base = pricingComponent.calculatePrice(seat, show);
        return switch (seat.getSeatCategory()) {
            case GOLD -> base + 50;
            case PLATINUM -> base + 100;
            default -> base;
        };
    }
}
