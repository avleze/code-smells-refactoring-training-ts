package mars_rover;

import java.util.Objects;

public class Rover {

    private Direction directionType;
    private int y;
    private int x;

    public Rover(int x, int y, String direction) {
        this.setDirection(direction);
        this.y = y;
        this.x = x;
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (command.equals("l")) {

                // Rotate Rover
                if (isFacingNorth()) {
                    setDirection("W");
                } else if (isFacingSouth()) {
                    setDirection("E");
                } else if (isFacingWest()) {
                    setDirection("S");
                } else {
                    setDirection("N");
                }
            } else if (command.equals("r")) {

                // Rotate Rover
                if (isFacingNorth()) {
                    setDirection("E");
                } else if (isFacingSouth()) {
                    setDirection("W");
                } else if (isFacingWest()) {
                    setDirection("N");
                } else {
                    setDirection("S");
                }
            } else {

                // Displace Rover
                int displacement1 = -1;

                if (command.equals("f")) {
                    displacement1 = 1;
                }
                int displacement = displacement1;

                if (isFacingNorth()) {
                    y += displacement;
                } else if (isFacingSouth()) {
                    y -= displacement;
                } else if (isFacingWest()) {
                    x -= displacement;
                } else {
                    x += displacement;
                }
            }
        }
    }

    private boolean isFacingWest() {
        return directionType.equals(Direction.W);
    }

    private boolean isFacingSouth() {
        return directionType.equals(Direction.S);
    }

    private boolean isFacingNorth() {
        return directionType.equals(Direction.N);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Rover rover = (Rover) o;
        return y == rover.y && x == rover.x && directionType == rover.directionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(directionType, y, x);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "directionType=" + directionType +
                ", y=" + y +
                ", x=" + x +
                '}';
    }

    private void setDirection(String direction) {
        this.directionType = Direction.create(direction);
    }
}
