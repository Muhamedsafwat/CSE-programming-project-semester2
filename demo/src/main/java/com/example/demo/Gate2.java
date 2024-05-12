package com.example.demo;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Objects;

//this gate for not gate
public abstract class Gate2 extends HBox{
    public static String tool = ToolBar.tool;
    //define inputs and outputs
     boolean input = false;
     boolean output = false;
     Terminal inputButton;
     Terminal outputButton;
    //X and Y coordinates for drag & drop
    double startX;
    double startY;

    public Gate2(String imageURL) {
        super();
        boolean input = false;
        boolean output = false;

        // Create input & output button
        inputButton = new Terminal(false);
        outputButton = new Terminal(true);
        //style inputs and outputs
        //create image view
        ImageView imageView = new ImageView(new Image(imageURL));
        // Set layout for the input elements
        VBox inputBox = new VBox(inputButton);
        inputBox.setAlignment(Pos.CENTER);
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

       this.inputButton.setOnMouseClicked(event ->  {if (event.getButton() == MouseButton.PRIMARY) {
            Wire.handleCircleClick(this.inputButton);
            this.updateOutput();
            System.out.println("output:" + output);
        }});
       this.outputButton.setOnMouseClicked(event ->  {if (event.getButton() == MouseButton.PRIMARY) {
            Wire.handleCircleClick(this.outputButton);
        }});
    }

    // Method to update the output label based on input values
     void updateOutput() {
        output = !input;
        inputButton.setState(input);
        outputButton.setState(output);

     }
    public static void updateTool () {
        tool = ToolBar.tool;
    }

}
