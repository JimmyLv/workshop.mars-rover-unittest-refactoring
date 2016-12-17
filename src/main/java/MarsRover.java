import java.util.Arrays;
import java.util.List;

public class MarsRover {
    private static final List<String> VALID_COMMANDS = Arrays.asList("L", "R", "M", "B");
    private static final List<String> DIRECTIONS = Arrays.asList("N", "E", "S", "W");


    private String direction;
    // position which contains startingX and startingY
    private Position position;

    public MarsRover(int startingX, int startingY, String direction) {
        this.position = new Position(startingX, startingY);
        this.direction = direction;
    }

    public String run(String input) {
        String[] commandArray = input.split("");

        validateCommands(input, commandArray);

        for (String command : commandArray) {

            switch (command) {

                case "M":
                    move();
                    break;
                case "B":
                    moveBackward();
                    break;
                case "R":
                   turnRight();
                    break;
                case "L":
                    turnLeft();
                    break;
            }
        }

        return asString();
    }

    private void moveBackward() {
        turnRight();
        turnRight();
        move();
        turnRight();
        turnRight();
    }


    private void move() {

        switch (direction) {
            case "N":
                position.y += +1;
                break;
            case "S":
                position.y += -1;
                break;
            case "E":
                position.x += +1;
                break;
            case "W":
                position.x += -1;
                break;
        }
    }

    private void turnLeft() {
        direction = DIRECTIONS.get((DIRECTIONS.indexOf(direction) + 3) % DIRECTIONS.size());
    }

    private void turnRight() {
        direction = DIRECTIONS.get((DIRECTIONS.indexOf(direction) + 1) % DIRECTIONS.size());
    }

    private void validateCommands(String input, String[] commandArray) {
        for (String command : commandArray) {
            if (!VALID_COMMANDS.contains(command)) {
                throw new IllegalArgumentException("Invalid command sequence: " + input);
            }
        }
    }

    private String asString() {
        return position.x + " " + position.y + " " + direction;
    }
}