package com.example.demo;

import javafx.geometry.Bounds;
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
        input1Button.setParentGate(this);
        input2Button = new Terminal(false);
        input2Button.setParentGate(this);
        outputButton = new Terminal(true);
        //create image view
        ImageView imageView = new ImageView(new Image(imageURL));
        imageView.setFitWidth(100);
        imageView.setFitHeight(50);
        // Set layout for the input elements
        VBox inputBox = new VBox(input1Button, input2Button);
        inputBox.setTranslateX(8);
        inputBox.setSpacing(14);
        inputBox.setAlignment(Pos.CENTER);
        // Handle button actions

        // Create the root node and add the elements
        setAlignment(Pos.CENTER);
        getChildren().addAll(inputBox,imageView, outputButton);
        setTranslateX(10);
        setTranslateY(10);
        //click handlers
        setOnMousePressed(e -> { if (Objects.equals(ToolBar.tool, "Drag")) {
            startX = e.getSceneX() - getTranslateX();
            startY = e.getSceneY() - getTranslateY();
        } else if (Objects.equals(ToolBar.tool, "Delete")) {
            HelloApplication.workingSpace.getChildren().remove(this);
            if (input1Button.getConnectedWire() != null) {
                input1Button.getConnectedWire().removeLine();
            }
            if (input2Button.getConnectedWire() != null) {
                input2Button.getConnectedWire().removeLine();
            }
            if (outputButton.getConnectedWire() != null) {
                outputButton.getConnectedWire().removeLine();
            }
        } else if (Objects.equals(ToolBar.tool, "RotateLeft")) {
            setRotate(getRotate() - 90);
            if (input1Button.getConnectedWire() != null) {
                input1Button.getConnectedWire().updatePosition();
            }
            if (input2Button.getConnectedWire() != null) {
                input2Button.getConnectedWire().updatePosition();
            }
            if (outputButton.getConnectedWire() != null) {
                outputButton.getConnectedWire().updatePosition();
            }
        }
        //drag and drop
        });
        setOnMouseDragged(e -> {
            if (Objects.equals(tool, "Drag")) {
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
                if (input1Button.getConnectedWire() != null) {
                    input1Button.getConnectedWire().updatePosition();
                }
                if (input2Button.getConnectedWire() != null) {
                    input2Button.getConnectedWire().updatePosition();
                }
                if (outputButton.getConnectedWire() != null) {
                    outputButton.getConnectedWire().updatePosition();
                }
            }
        });
        //connecting functionality
        this.input1Button.setOnMouseClicked(event ->  {if ( Objects.equals(ToolBar.tool, "Connect")) {
            Wire.handleCircleClick(this.input1Button);
        } else if (Objects.equals(ToolBar.tool, "Disconnect") && this.input1Button.getConnectedWire() != null) {
            input1Button.getConnectedWire().removeLine();
            this.updateInputs();
        }
        });
        this.input2Button.setOnMouseClicked(event ->  {if ( Objects.equals(ToolBar.tool, "Connect")) {
            Wire.handleCircleClick(this.input2Button);
        } else if (Objects.equals(ToolBar.tool, "Disconnect") && this.input2Button.getConnectedWire() != null) {
            input2Button.getConnectedWire().removeLine();
            this.updateInputs();
        }
        });
        this.outputButton.setOnMouseClicked(event ->  {if (Objects.equals(ToolBar.tool, "Connect")) {
            Wire.handleCircleClick(this.outputButton);
        }
        else if (Objects.equals(ToolBar.tool, "Disconnect") && this.outputButton.getConnectedWire() != null) {
            outputButton.getConnectedWire().removeLine();
        }
        });
    }

    // Method th update the input states when clicking on a terminal
    void updateInputs() {
        input1 = input1Button.state;
        input2 = input2Button.state;
        output = outputButton.state;
    }
    // Method to update the output label based on input values
    void updateOutput() {
        outputButton.setState(output);
    }
    //static method to update the tool
    public static void updateTool () {
        tool = ToolBar.tool;
    }
}
