package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    public static Pane workingSpace;
    VBox root;
    @Override
    public void start(Stage stage) throws IOException {
        //initialize the scene
        root = new VBox();
        root.setMaxWidth(Double.MAX_VALUE);
        Scene scene = new Scene(root, 1000, 700);
        scene.setFill(Color.web("#DBDBDB"));
        //create main sections
        ComponentsList componentsList  = new ComponentsList();
        HBox mainSection = new HBox();
        workingSpace = new Pane();
        // Load the image
        Image backgroundImage = new Image("Grid.png");
        // Create a BackgroundImage
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, null);
        // Create a Background
        Background backgroundImg = new Background(background);
        // Set the background
        workingSpace.setBackground(backgroundImg);

        workingSpace.prefWidthProperty().bind(stage.widthProperty().subtract(253));
        workingSpace.setPrefHeight(1000);
        ToolBar toolBar = new ToolBar();
        mainSection.getChildren().addAll(componentsList, workingSpace);
        //add elements to the root and show the stage
        root.getChildren().addAll(toolBar,mainSection);
        Image icon = new Image("appicon.png");
        stage.setTitle("LogicSim || CSE#27");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
