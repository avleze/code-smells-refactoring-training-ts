package mars_rover;

public enum Direction {
    N {
        @Override
        public Direction rotateLeft() {
            return Direction.create(WEST_ENCODING);
        }

        @Override
        public Direction rotateRight() {
            return Direction.create(EAST_ENCODING);
        }

        @Override
        public Coordinates move(final Coordinates coordinates, final Integer displacement) {
            return coordinates.moveAlongYAxis(displacement);
        }
    }, S {
        @Override
        public Direction rotateLeft() {
            return Direction.create(EAST_ENCODING);
        }

        @Override
        public Direction rotateRight() {
            return Direction.create(WEST_ENCODING);
        }

        @Override
        public Coordinates move(final Coordinates coordinates, final Integer displacement) {
            return coordinates.moveAlongYAxis(-displacement);
        }
    }, W {
        @Override
        public Direction rotateLeft() {
            return Direction.create(SOUTH_ENCODING);
        }

        @Override
        public Direction rotateRight() {
            return Direction.create(NORTH_ENCODING);
        }

        @Override
        public Coordinates move(final Coordinates coordinates, final Integer displacement) {
            return coordinates.moveAlongXAxis(-displacement);
        }
    }, E {
        @Override
        public Direction rotateLeft() {
            return Direction.create(NORTH_ENCODING);
        }

        @Override
        public Direction rotateRight() {
            return Direction.create(SOUTH_ENCODING);
        }

        @Override
        public Coordinates move(final Coordinates coordinates, final Integer displacement) {
            return coordinates.moveAlongXAxis(displacement);
        }
    };

    public static final String NORTH_ENCODING = "N";
    public static final String SOUTH_ENCODING = "S";
    public static final String EAST_ENCODING = "E";
    public static final String WEST_ENCODING = "W";

    public static Direction create(final String directionEncoding) {
        switch (directionEncoding) {
            case SOUTH_ENCODING:
                return S;
            case WEST_ENCODING:
                return W;
            case EAST_ENCODING:
                return E;
        }
        return N;
    }

    public abstract Direction rotateLeft();
    public abstract Direction rotateRight();
    public abstract Coordinates move(Coordinates coordinates, Integer displacement);
}
