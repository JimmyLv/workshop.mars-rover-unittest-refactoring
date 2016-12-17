public enum Direction {
    N, E, S, W;

    public Direction left() {
        return values()[(ordinal() + 3) % 4];
    }

    public Direction right() {
        return values()[(ordinal() + 1) % 4];
    }

    public Direction over() {
        return values()[(ordinal() + 2) % 4];
    }
}
