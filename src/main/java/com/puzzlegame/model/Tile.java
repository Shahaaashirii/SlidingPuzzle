package main.java.com.puzzlegame.model;

public class Tile {
    private int value;
    private boolean isEmpty;

    public Tile(int value) {
        this.value = value;
        this.isEmpty = (value == 0);
    }

    public int getValue() {
        return value;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public String toString() {
        return isEmpty ? "" : String.valueOf(value);
    }
}

