package service.pricedecorator;

import model.Seat;
import model.Show;

public abstract class PricingDecorator implements PricingComponent {
    protected PricingComponent pricingComponent;

    protected PricingDecorator(PricingComponent pricingComponent) {
        this.pricingComponent = pricingComponent;
    }

    public abstract double calculatePrice(Seat seat, Show show);
}
