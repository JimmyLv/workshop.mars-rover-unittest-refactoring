import type.Command;
import type.Orientation;
import type.Position;

import java.util.Arrays;
import java.util.HashMap;

import static type.Command.*;

public class MarsRover {
    private final HashMap<Command, Runnable> COMMANDS = new HashMap<Command, Runnable>() {{
        put(R, () -> orientation = orientation.right());
        put(L, () -> orientation = orientation.left());
        put(M, () -> position = position.shift(orientation));
        put(B, () -> position = position.shift(orientation.right().right()));
    }};

    private Orientation orientation;
    private Position position;

    public MarsRover(int x, int y, String orientation) {
        this.position = new Position(x, y);
        this.orientation = Orientation.valueOf(orientation);
    }

    public String execute(String commands) {
        Arrays.stream(commands.split(""))
                .map(Command::valueOf)
                .forEach(command -> COMMANDS.get(command).run());

        return status();
    }

    private String status() {
        return position + " " + orientation;
    }
}
