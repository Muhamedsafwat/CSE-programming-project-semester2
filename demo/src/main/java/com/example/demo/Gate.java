package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Objects;


public class Gate extends HBox {
    public static String tool = ToolBar.tool;
    //define inputs and outputs
    boolean input1, input2, output = false;
    Terminal input1Button, input2Button, outputButton;
    DropShadow shadow;
    //X and Y coordinates for drag & drop
    double startX;
    double startY;

    public Gate(String imageURL) {
        super();

        // Create input & output buttons
        input1Button = new Terminal(false);
        input2Button = new Terminal(false);
        outputButton = new Terminal(true);
        //create image view
        ImageView imageView = new ImageView(new Image(imageURL));
        // Set layout for the input elements
        VBox inputBox = new VBox(input1Button, input2Button);
        inputBox.setSpacing(8);
        inputBox.setAlignment(Pos.CENTER);
        // Handle button actions
        input1Button.setOnMouseClicked(e -> {
            input1 = !input1;
            updateOutput();
        });
        input2Button.setOnMouseClicked(e -> {
            input2 = !input2;
            updateOutput();
        });
        // Create the root node and add the elements
        setAlignment(Pos.CENTER);
        getChildren().addAll(inputBox,imageView, outputButton);
        //drag and drop functionality
        setTranslateX(10);
        setTranslateY(10);

        setOnMousePressed(e -> {
            startX = e.getSceneX() - getTranslateX();
            startY = e.getSceneY() - getTranslateY();
        });
        setOnMouseDragged(e -> {
            if (Objects.equals(tool, "Drag")) {
                setTranslateX(e.getSceneX() - startX);
                setTranslateY(e.getSceneY() - startY);
            }
        });
    }

    // Method to update the output label based on input values
    void updateOutput() {
        input1Button.setState(input1);
        input2Button.setState(input2);
        outputButton.setState(output);
    }
    //static method to update the tool
    public static void updateTool () {
        tool = ToolBar.tool;
    }

}
