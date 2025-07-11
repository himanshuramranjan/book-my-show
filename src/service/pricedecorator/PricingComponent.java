package service.pricedecorator;

import model.Seat;
import model.Show;

public interface PricingComponent {
    double calculatePrice(Seat seat, Show show);
}
