package video_store;

public class Rental {

    private static final int NEW_RELEASE_FREQUENT_POINTS = 2;
    private static final int DEFAULT_FREQUENT_POINTS = 1;

    private Movie movie;

    public int getDaysRented() {
        return daysRented;
    }

    private int daysRented;
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double getAmount() {
        return movie.getAmount(daysRented);
    }

    public Movie getMovie() {
        return movie;
    }

    public int computeFrequentRenterPoints() {
        if (movie.isANewRelease() && daysRented > 1) return NEW_RELEASE_FREQUENT_POINTS;

        return DEFAULT_FREQUENT_POINTS;
    }

    public String generateRentalTextStatement() {
        return "\t" + movie.getTitle() + "\t"
                + movie.getAmount(daysRented) + "\n";
    }

    public String getMovieTitle() {
        return getMovie().getTitle();
    }

    double getMovieAmount() {
        return getMovie().getAmount(getDaysRented());
    }
}
