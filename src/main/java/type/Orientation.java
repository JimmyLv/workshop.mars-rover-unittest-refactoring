package type;

public enum Orientation {
    N, E, S, W;

    public Orientation left() {
        return values()[(ordinal() + 3) % 4];
    }

    public Orientation right() {
        return values()[(ordinal() + 1) % 4];
    }
}
