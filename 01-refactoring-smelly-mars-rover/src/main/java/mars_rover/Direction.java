package mars_rover;

public enum Direction {
    N {
        @Override
        public Direction rotateLeft() {
            return Direction.create("W");
        }

        @Override
        public Direction rotateRight() {
            return Direction.create("E");
        }

        @Override
        public Coordinates move(final Coordinates coordinates, final Integer displacement) {
            return coordinates.moveAlongYAxis(displacement);
        }
    }, S {
        @Override
        public Direction rotateLeft() {
            return Direction.create("E");
        }

        @Override
        public Direction rotateRight() {
            return Direction.create("W");
        }

        @Override
        public Coordinates move(final Coordinates coordinates, final Integer displacement) {
            return coordinates.moveAlongYAxis(-displacement);
        }
    }, W {
        @Override
        public Direction rotateLeft() {
            return Direction.create("S");
        }

        @Override
        public Direction rotateRight() {
            return Direction.create("N");
        }

        @Override
        public Coordinates move(final Coordinates coordinates, final Integer displacement) {
            return coordinates.moveAlongXAxis(-displacement);
        }
    }, E {
        @Override
        public Direction rotateLeft() {
            return Direction.create("N");
        }

        @Override
        public Direction rotateRight() {
            return Direction.create("S");
        }

        @Override
        public Coordinates move(final Coordinates coordinates, final Integer displacement) {
            return coordinates.moveAlongXAxis(displacement);
        }
    };

    public static Direction create(final String directionEncoding) {
        if(directionEncoding.equals("S"))
            return S;
        else if(directionEncoding.equals("W"))
            return W;
        else if(directionEncoding.equals("E"))
            return E;
        return N;
    }

    public abstract Direction rotateLeft();
    public abstract Direction rotateRight();
    public abstract Coordinates move(Coordinates coordinates, Integer displacement);
}
