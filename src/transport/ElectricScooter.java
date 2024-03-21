package transport;

public enum ElectricScooter {

    ALPHA_SEGMENT(5),
    SAND_SEGMENT(40);

    private final int value;

    ElectricScooter(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
