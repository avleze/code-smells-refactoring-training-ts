package mars_rover;

import java.util.Objects;

public class Rover {

    private Direction directionType;
    private Coordinates coordinates;

    public Rover(int x, int y, String direction) {
        this.directionType = Direction.create(direction);
        setCoordinates(x, y);
    }

    private void setCoordinates(int x, int y) {
        this.coordinates = new Coordinates(x,y);
    }

    public void receive(String commandsSequence) {
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);

            if (command.equals("l")) {
                this.directionType = this.directionType.rotateLeft();
            } else if (command.equals("r")) {
                this.directionType = this.directionType.rotateRight();
            } else {

                // Displace Rover
                int displacement1 = -1;

                if (command.equals("f")) {
                    displacement1 = 1;
                }
                int displacement = displacement1;

                this.coordinates = this.directionType.move(coordinates, displacement);
            }
        }
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

}
