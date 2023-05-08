package video_store;

public enum MovieType {
    CHILDRENS {
        @Override
        public double getAmount(final int rentedDays) {
            double amount = 1.5;
            if (rentedDays > 3)
                amount += (rentedDays - 3) * 1.5;
            return amount;
        }
    },
    NEW_RELEASE {
        @Override
        public double getAmount(final int rentedDays) {
            return rentedDays * 3;
        }
    },
    REGULAR {
        @Override
        public double getAmount(final int rentedDays) {
            double amount = 2;
            if (rentedDays > 2)
                amount += (rentedDays - 2) * 1.5;
            return amount;
        }
    };

    public static MovieType create(int priceCode) {
        if(priceCode == 1) {
            return NEW_RELEASE;
        } else if (priceCode == 2) {
            return CHILDRENS;
        }
        return REGULAR;
    }

    public abstract double getAmount(int rentedDays);
}
