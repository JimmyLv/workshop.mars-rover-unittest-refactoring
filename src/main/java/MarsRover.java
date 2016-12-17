import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MarsRover {
    private Map<String, Runnable> COMMANDS = new HashMap<String, Runnable>(){{
        put("M", () -> move());
        put("B", () -> moveBackward());
        put("L", () -> turnLeft());
        put("R", () -> turnRight());
    }};

    private Parser commandParser;
    private Direction direction;
    private Position position;

    public MarsRover(int startingX, int startingY, String direction, Parser commandParser) {
        this.position = new Position(startingX, startingY);
        this.direction = Direction.valueOf(direction);
        this.commandParser = commandParser;
    }

    public String run(String commands) {
        Arrays.stream(commandParser.parse(commands))
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

    private String asString() {
        return position.x + " " + position.y + " " + direction;
    }
}