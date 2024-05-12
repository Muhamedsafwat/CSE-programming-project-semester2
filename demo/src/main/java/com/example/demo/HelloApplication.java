package com.example.demo;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    public static Pane workingSpace;
    public static Line line;
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
        ToolBar toolBar = new ToolBar();
        mainSection.getChildren().addAll(componentsList, workingSpace);
        // Create a scale transformation
        Scale scale = new Scale(1, 1);

       // Set the transformation pivot point to the center of the working space
        workingSpace.getTransforms().add(scale);
        // Add an event handler to the working space to handle zooming
        workingSpace.setOnScroll(event -> {
            double delta = event.getDeltaY();
            double scaleFactor = (delta > 0) ? 1.1 : 0.9;
            scale.setX(scale.getX() * scaleFactor);
            scale.setY(scale.getY() * scaleFactor);
});


        //add elements to the root and show the stage
        root.getChildren().addAll(toolBar,mainSection);
        stage.setTitle("LogicSim || CSE#27");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
