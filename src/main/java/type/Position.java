package type;

import java.util.HashMap;

import static type.Orientation.*;

public class Position {
    private static final int MAX_BOUNDARY = 5;
    private static final int MIN_BOUNDARY = 0;
    private static final HashMap<Orientation, Vector> DIRECTIONS = new HashMap<Orientation, Vector>() {{
        put(N, new Vector(0, 1));
        put(E, new Vector(1, 0));
        put(S, new Vector(0, -1));
        put(W, new Vector(-1, 0));
    }};

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position shift(Orientation orientation) {
        Vector vector = DIRECTIONS.get(orientation);
        return new Position(limit(x + vector.x), limit(y + vector.y));
    }

    private int limit(int value) {
        if (value < MIN_BOUNDARY) return MIN_BOUNDARY;
        if (value > MAX_BOUNDARY) return MAX_BOUNDARY;
        return value;
    }

    private static class Vector {
        int x;
        int y;

        Vector(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    @Override
    public String toString() {
        return String.format("%d %d", x, y);
    }
}
