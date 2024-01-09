package com.example.tv;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUILauncher extends Application {
    Controller myController;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUILauncher.class.getResource("View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 571);
        myController = (Controller) fxmlLoader.getController();
        stage.setTitle("This is all of my data.");
        stage.setScene(scene);
        stage.show();
    }

    public void stop() throws Exception {
        myController.saveData();
    }

    public static void main(String[] args) {
        launch();
    }
}