import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarsRover {
    Map<String, Runnable>  COMMANDS = new HashMap<String, Runnable>(){{
        put("M", () -> move());
        put("B", () -> moveBackward());
        put("L", () -> turnLeft());
        put("R", () -> turnRight());
    }};;

    private Direction direction;
    private Position position;

    public MarsRover(int startingX, int startingY, String direction) {
        this.position = new Position(startingX, startingY);
        this.direction = Direction.valueOf(direction);
    }

    public String run(String commands) {
        String[] commandArray = commands.split("");

        validateCommands(commands);

        Arrays.stream(commandArray)
                .forEach(command -> COMMANDS.get(command).run());

        return asString();
    }

    private void moveBackward() {
        turnOver();
        move();
        turnOver();
    }


    private void move() {

        switch (direction) {
            case N:
                position.y += +1;
                break;
            case S:
                position.y += -1;
                break;
            case E:
                position.x += +1;
                break;
            case W:
                position.x += -1;
                break;
        }
    }

    private void turnLeft() {
        direction = direction.left();
    }

    private void turnRight() {
        direction = direction.right();
    }

    private void turnOver() {
        direction = direction.over();
    }

    static Pattern pattern = Pattern.compile("(L|R|M|B)*");

    private void validateCommands(String input) {

        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches())
            throw new IllegalArgumentException("Invalid command sequence: " + input);

    }

    private String asString() {
        return position.x + " " + position.y + " " + direction;
    }
}