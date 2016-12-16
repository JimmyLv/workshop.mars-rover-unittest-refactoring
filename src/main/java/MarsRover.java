import java.util.Arrays;
import java.util.List;

public class MarsRover {
    private static final List<String> VALID_COMMANDS = Arrays.asList("L", "R", "M");
    private static final List<String> DIRECTIONS = Arrays.asList("N", "E", "S", "W");

    private static final int Y = 1;
    private static final int X = 0;

    private String direction;
    private int[] position;

    public MarsRover(int startingX, int startingY, String direction) {
        this.position = new int[]{startingX, startingY};
        this.direction = direction;
    }

    public String run(String input) {
        String[] commands = convertInputIntoCommands(input);

        for (String command : commands) {
            if (command.equals("M")) {
                move();
            } else if (command.equals("R")) {
                turnRight();
            } else if (command.equals("L")) {
                turnLeft();
            }
        }

        return asString();
    }

    private void move() {
        if (direction.equals("N")) {
            position[Y] += +1;
        } else if (direction.equals("S")) {
            position[Y] += -1;
        } else if (direction.equals("E")) {
            position[X] += +1;
        } else if (direction.equals("W")) {
            position[X] += -1;
        }
    }

    private String asString() {
        return position[X] + " " + position[Y] + " " + direction;
    }

    private void turnLeft() {
        direction = DIRECTIONS.get((DIRECTIONS.indexOf(direction) + 3) % DIRECTIONS.size());
    }

    private void turnRight() {
        direction = DIRECTIONS.get((DIRECTIONS.indexOf(direction) + 1) % DIRECTIONS.size());
    }

    private static String[] convertInputIntoCommands(String input) {
        String[] commandArray = input.split("(?!^)");

        validateCommands(input, commandArray);

        return commandArray;
    }

    private static void validateCommands(String input, String[] commandArray) {
        for (String command : commandArray) {
            if (!VALID_COMMANDS.contains(command)) {
                throw new IllegalArgumentException("Invalid command sequence: " + input);
            }
        }
    }
}