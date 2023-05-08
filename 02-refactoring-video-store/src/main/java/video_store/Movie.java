package video_store;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private MovieType movieType;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.movieType = MovieType.create(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public double getAmount(final int rentedDays) {
        return movieType.getAmount(rentedDays);
    }

    public boolean isANewRelease() {
        return movieType == MovieType.NEW_RELEASE;
    }
}
