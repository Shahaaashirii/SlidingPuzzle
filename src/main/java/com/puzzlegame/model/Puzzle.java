package main.java.com.puzzlegame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Puzzle {
    private Tile[][] tiles;
    private int size;

    public Puzzle(int size) {
        this.size = size;
        this.tiles = new Tile[size][size];
        initializePuzzle();
    }

    private void initializePuzzle() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size * size; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        int index = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                tiles[row][col] = new Tile(numbers.get(index++));
            }
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public boolean move(int number) {
        int row = -1, col = -1;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (tiles[r][c].getValue() == number) {
                    row = r;
                    col = c;
                    break;
                }
            }
        }

        if (row == -1 || col == -1) return false;

        if (isAdjacentEmpty(row, col)) {
            swap(row, col);
            return true;
        }
        return false;
    }

    private boolean isAdjacentEmpty(int row, int col) {
        return (row > 0 && tiles[row - 1][col].isEmpty()) ||
                (row < size - 1 && tiles[row + 1][col].isEmpty()) ||
                (col > 0 && tiles[row][col - 1].isEmpty()) ||
                (col < size - 1 && tiles[row][col + 1].isEmpty());
    }

    private void swap(int row, int col) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (tiles[r][c].isEmpty()) {
                    Tile temp = tiles[r][c];
                    tiles[r][c] = tiles[row][col];
                    tiles[row][col] = temp;
                    return;
                }
            }
        }
    }

    public boolean isSolved() {
        int expected = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (tiles[row][col].getValue() != expected++) {
                    return false;
                }
            }
        }
        return true;
    }
}

