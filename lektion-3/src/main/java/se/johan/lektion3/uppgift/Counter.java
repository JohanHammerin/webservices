package se.johan.lektion3.uppgift;

public class Counter {

    private final int id;
    private final int value;

    public Counter(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return this.id;
    }

    public int getValue() {
        return this.value;
    }
}
