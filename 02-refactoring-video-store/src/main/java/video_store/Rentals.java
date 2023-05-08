package video_store;

import java.util.ArrayList;
import java.util.List;

public class Rentals {
    private final List<Rental> rentals;

    public Rentals() {
        this.rentals = new ArrayList<>();
    }

    public void add(final Rental rental) {
        rentals.add(rental);
    }

    public int getFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::computeFrequentRenterPoints).sum();
    }

    public double getTotalAmount() {
        return rentals.stream().mapToDouble(Rental::getAmount).sum();
    }
}
