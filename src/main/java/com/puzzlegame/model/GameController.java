package main.java.com.puzzlegame.model;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert;

public class GameController {
    @FXML
    private GridPane gridPane;

    private Puzzle puzzle;

    public void initialize() {
        puzzle = new Puzzle(4); // 4x4 puzzle
        updateGrid();
    }

    private void updateGrid() {
        gridPane.getChildren().clear();
        Tile[][] tiles = puzzle.getTiles();

        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {
                Button button = new Button(tiles[row][col].toString());
                button.setMinSize(100, 100);

                int value = tiles[row][col].getValue();
                button.setOnAction(e -> {
                    if (puzzle.move(value)) {
                        updateGrid();
                        if (puzzle.isSolved()) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You solved the puzzle!");
                            alert.showAndWait();
                        }
                    }
                });

                gridPane.add(button, col, row);
            }
        }
    }
}
