package transport;

public enum Foot {

    ALPHA_SEGMENT(20),
    SAND_SEGMENT(30);

    private final int value;

    Foot(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
