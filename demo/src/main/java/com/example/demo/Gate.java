package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Gate extends HBox {
    //define inputs and outputs
    boolean input1, input2, output = false;
    Circle input1Button, input2Button, outputButton;
    //X and Y coordinates for drag & drop
    double startX;
    double startY;

    public Gate(String imageURL) {
        super();
        // Create input & output buttons
        input1Button = new Circle();
        input2Button = new Circle();
        outputButton = new Circle();
        //style inputs and outputs
        input1Button.setRadius(6);
        input2Button.setRadius(6);
        outputButton.setRadius(6);
        input1Button.setFill(Color.GRAY);
        input2Button.setFill(Color.GRAY);
        outputButton.setFill(Color.GRAY);
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
            setTranslateX(e.getSceneX() - startX);
            setTranslateY(e.getSceneY() - startY);
        });
    }

    // Method to update the output label based on input values
     void updateOutput() {
         if (input1) {
             input1Button.setFill(Color.GREEN);
         } else {
             input1Button.setFill(Color.GRAY);
         }
         if (input2) {
             input2Button.setFill(Color.GREEN);
         } else {
             input2Button.setFill(Color.GRAY);
         }
         if (output) {
             outputButton.setFill(Color.GREEN);
         } else {
             outputButton.setFill(Color.GRAY);
         }
     }

}
