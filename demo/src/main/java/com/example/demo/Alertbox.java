package com.example.demo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Alertbox {
    public static void showAlert(String message) {
        Stage window = new Stage();
        window.setTitle("Warning");
        window.setResizable(false);
        Button close = new Button("Close");
        window.initModality(Modality.WINDOW_MODAL);
        VBox layout = new VBox();
        Scene scene = new Scene(layout);
        window.setScene(scene);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setSpacing(10);
        layout.setAlignment(Pos.CENTER);
        Label label = new Label(message);
        layout.getChildren().addAll(label, close);

        close.setOnAction(event -> window.close());
        window.showAndWait();
    }

}
