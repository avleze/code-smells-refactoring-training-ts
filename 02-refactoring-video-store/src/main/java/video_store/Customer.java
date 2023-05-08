package video_store;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();
    private final Rentals rentalsDomain;
    
    public Customer(String name) {
        this.name = name;
        this.rentalsDomain = new Rentals();
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
        rentalsDomain.add(rental);
    }

    public String statement() {
        return generateTextStatement(rentalsDomain.getFrequentRenterPoints(), rentalsDomain.getTotalAmount(), name);
    }

    private String generateTextStatement(final int frequentRenterPoints, final double totalAmount, final String customerName) {
        String result = "Rental Record for " + customerName + "\n";
        for(Rental rental : rentals) {
            result += "\t" + rental.getMovieTitle() + "\t"
                    + rental.getMovieAmount() + "\n";
        }
        result += "You owed " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";
        return result;
    }

}
