package mars_rover;

import java.util.Objects;

public class Rover {

    private Direction directionType;
    private Coordinates coordinates;

    public Rover(int x, int y, String direction) {
        this.setDirection(direction);
        setCoordinates(x, y);
    }

    private void setCoordinates(int x, int y) {
        this.coordinates = new Coordinates(x,y);
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
                    setCoordinates(coordinates.getX(), coordinates.getY() + displacement);
                } else if (isFacingSouth()) {
                    setCoordinates(coordinates.getX(), coordinates.getY() - displacement);
                } else if (isFacingWest()) {
                    setCoordinates(coordinates.getX() - displacement, coordinates.getY());
                } else {
                    setCoordinates(coordinates.getX() + displacement, coordinates.getY());
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return directionType == rover.directionType && Objects.equals(coordinates, rover.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directionType, coordinates);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "directionType=" + directionType +
                ", coordinates=" + coordinates +
                '}';
    }

    private void setDirection(String direction) {
        this.directionType = Direction.create(direction);
    }
}
