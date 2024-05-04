package com.example.demo;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

//this gate for not gate
public class Gate2 extends HBox{
    //define inputs and outputs
    boolean input, output = false;
    Circle inputButton ,outputButton;
    //X and Y coordinates for drag & drop
    double startX;
    double startY;

    public Gate2(String imageURL) {
        super();
        // Create input & output button
        inputButton = new Circle();
        outputButton = new Circle();
        //style inputs and outputs
        inputButton.setRadius(6);
        outputButton.setRadius(6);
        inputButton.setFill(Color.GRAY);
        outputButton.setFill(Color.GRAY);
        //create image view
        ImageView imageView = new ImageView(new Image(imageURL));
        // Set layout for the input elements
        VBox inputBox = new VBox(inputButton);
        inputBox.setAlignment(Pos.CENTER);
        // Handle button actions
        inputButton.setOnMouseClicked(e -> {
            input = !input;
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

        if (input) {
            inputButton.setFill(Color.GREEN);
        } else {
            inputButton.setFill(Color.GRAY);
        }
        if (output) {
            outputButton.setFill(Color.GREEN);
        } else {
            outputButton.setFill(Color.GRAY);
        }
    }

}
