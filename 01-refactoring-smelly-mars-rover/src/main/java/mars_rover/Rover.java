package mars_rover;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rover {

    private static final int DISPLACEMENT = 1;
    private static final String LEFT_ENCODING = "l";
    private static final String RIGHT_ENCODING = "r";
    private static final String FRONT_ENCODING = "f";
    private Direction direction;
    private Coordinates coordinates;

    public Rover(int x, int y, String direction) {
        this.direction = Direction.create(direction);
        setCoordinates(x, y);
    }

    private void setCoordinates(int x, int y) {
        this.coordinates = new Coordinates(x, y);
    }

    public void receive(String commandsSequence) {
        extractCommands(commandsSequence).forEach(this::executeCommand);
    }

    private static List<String> extractCommands(final String commandsSequence) {
        List<String> commands = new ArrayList<>();
        for (int i = 0; i < commandsSequence.length(); ++i) {
            String command = commandsSequence.substring(i, i + 1);
            commands.add(command);
        }
        return commands;
    }

    private void executeCommand(final String command) {
        switch (command) {
            case LEFT_ENCODING:
                this.direction = this.direction.rotateLeft();
                break;
            case RIGHT_ENCODING:
                this.direction = this.direction.rotateRight();
                break;
            case FRONT_ENCODING:
                this.coordinates = this.direction.move(coordinates, DISPLACEMENT);
                break;
            default:
                this.coordinates = this.direction.move(coordinates, -DISPLACEMENT);
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return direction == rover.direction && Objects.equals(coordinates, rover.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, coordinates);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "directionType=" + direction +
                ", coordinates=" + coordinates +
                '}';
    }

}
