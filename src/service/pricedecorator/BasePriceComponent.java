package service.pricedecorator;

import model.Seat;
import model.Show;

public class BasePriceComponent implements PricingComponent {
    @Override
    public double calculatePrice(Seat seat, Show show) {
        return show.getMovie().getBasePrice();
    }
}
