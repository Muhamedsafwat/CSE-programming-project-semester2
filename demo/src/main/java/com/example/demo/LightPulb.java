package com.example.demo;

import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class LightPulb extends VBox {
    Image pulbOn ;
    Image pulbOff;
    ImageView image;
    Terminal  inputButton;
    //X and Y coordinates for drag & drop
    double startX;
    double startY;
   boolean input = false;
    LightPulb(){

        inputButton = new Terminal(false);
        inputButton.setParentLight(this);
        pulbOff = new Image("Lamp OFF.png");
        pulbOn  = new Image("Lamp ON.png");
        image = new ImageView();
        image.setImage(pulbOff);
        LightPulb.super.setAlignment(Pos.CENTER);
        image.setFitWidth(50);
        image.setFitHeight(60);
       getChildren().addAll(image,inputButton);

        //drag and drop functionality
        setTranslateX(10);
        setTranslateY(10);
        setOnMousePressed(e -> { if (Objects.equals(ToolBar.tool, "Drag")) {
            startX = e.getSceneX() - getTranslateX();
            startY = e.getSceneY() - getTranslateY();
        } else if (Objects.equals(ToolBar.tool, "Delete")) {
            HelloApplication.workingSpace.getChildren().remove(this);
            if (inputButton.getConnectedWire() != null) {
                inputButton.getConnectedWire().removeLine();
            }
        } else if (Objects.equals(ToolBar.tool, "RotateLeft")) {
            setRotate(getRotate() - 90);
            if (inputButton.getConnectedWire() != null) {
                inputButton.getConnectedWire().updatePosition();
            }
        }
        });
        setOnMouseDragged(e -> {
            if (Objects.equals(ToolBar.tool, "Drag")) {
                Bounds parentBounds = HelloApplication.workingSpace.getBoundsInLocal();
                double newX = e.getSceneX() - startX;
                double newY = e.getSceneY() - startY;
                // Ensure the circle stays within the bounds of the parent pane
                if (newX >= 0 && newX <= parentBounds.getWidth() - this.getWidth()) {
                    setTranslateX(newX);
                }
                if (newY >= 0 && newY <= parentBounds.getHeight() - this.getHeight()) {
                    setTranslateY(newY);
                }
                if (inputButton.getConnectedWire() != null) {
                    inputButton.getConnectedWire().updatePosition();
                }
            }
        });

        this.inputButton.setOnMouseClicked(event ->  {if ( Objects.equals(ToolBar.tool, "Connect")) {
            Wire.handleCircleClick(this.inputButton);
        } else if (Objects.equals(ToolBar.tool, "Disconnect") && this.inputButton.getConnectedWire() != null) {
            inputButton.getConnectedWire().removeLine();
            this.updateInputs();
        }
        });
    }
    // Method th update the input states when clicking on a terminal
    void updateInputs() {
        input = inputButton.state;
        System.out.println("updateInputs: " + input);
        if (input) {
            image.setImage(pulbOn);
            System.out.println("pulbOn");
        } else {
            image.setImage(pulbOff);
            System.out.println("pulbOff");
        }
    }
}
