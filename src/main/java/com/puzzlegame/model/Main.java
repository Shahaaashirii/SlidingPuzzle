package main.java.com.puzzlegame.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Correct FXMLLoader instantiation
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/puzzlegame/view/MainView.fxml"));

        // Use fxmlLoader to load the FXML
        Scene scene = new Scene(fxmlLoader.load());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Sliding Puzzle Game");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
