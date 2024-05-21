package com.example.demo;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Objects;

//this gate for not gate
public class Splitter extends HBox{
    //define inputs and outputs
    boolean input = false;
    boolean output = false;
    Terminal inputButton;
    Terminal outputButton1;
    Terminal outputButton2;
    Terminal outputButton3;
    //X and Y coordinates for drag & drop
    double startX;
    double startY;

    public Splitter() {
        super();
        // Create input & output button
        inputButton = new Terminal(false);
        inputButton.setRadius(4);
        outputButton1 = new Terminal(true);
        outputButton1.setRadius(4);
        outputButton2 = new Terminal(true);
        outputButton2.setRadius(4);
        outputButton3 = new Terminal(true);
        outputButton3.setRadius(4);

        inputButton.setParentSplitter(this);
        //style inputs and outputs
        //create image view
        ImageView imageView = new ImageView(new Image("splitter.png"));
        imageView.setFitWidth(60);
        imageView.setFitHeight(30);
        // Set layout for the input elements
        VBox inputBox = new VBox(inputButton);
        inputBox.setAlignment(Pos.CENTER);
        VBox outputBox = new VBox(outputButton1, outputButton2, outputButton3);
        outputBox.setAlignment(Pos.CENTER);
        outputBox.setSpacing(4);
        outputBox.setTranslateX(-3);
        // Create the root node and add the elements
        setAlignment(Pos.CENTER);
        getChildren().addAll(inputBox,imageView, outputBox);
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
                this.updateInputs();
            }
            if (outputButton1.getConnectedWire() != null) {
               outputButton1.getConnectedWire().removeLine();
            }
            if (outputButton2.getConnectedWire() != null) {
                outputButton2.getConnectedWire().removeLine();
            }
            if (outputButton3.getConnectedWire() != null) {
                outputButton3.getConnectedWire().removeLine();
            }
        } else if (Objects.equals(ToolBar.tool, "RotateLeft")) {
            setRotate(getRotate() - 90);
            if (inputButton.getConnectedWire() != null) {
                inputButton.getConnectedWire().updatePosition();
            }
            if (outputButton1.getConnectedWire() != null) {
                outputButton1.getConnectedWire().updatePosition();
            }
            if (outputButton2.getConnectedWire() != null) {
                outputButton2.getConnectedWire().updatePosition();
            }
            if (outputButton3.getConnectedWire() != null) {
                outputButton3.getConnectedWire().updatePosition();
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
                if (outputButton1.getConnectedWire() != null) {
                    outputButton1.getConnectedWire().updatePosition();
                }
                if (outputButton2.getConnectedWire() != null) {
                    outputButton2.getConnectedWire().updatePosition();
                }
                if (outputButton3.getConnectedWire() != null) {
                    outputButton3.getConnectedWire().updatePosition();
                }
            }
        });

        this.inputButton.setOnMouseClicked(event ->  {if ( Objects.equals(ToolBar.tool, "Connect")) {
            Wire.handleCircleClick(this.inputButton);
        } else if (Objects.equals(ToolBar.tool, "Disconnect") && this.inputButton.getConnectedWire() != null) {
            inputButton.getConnectedWire().removeLine();
        }
        });
        this.outputButton1.setOnMouseClicked(event ->  {if (Objects.equals(ToolBar.tool, "Connect")) {
            Wire.handleCircleClick(this.outputButton1);
        }
        else if (Objects.equals(ToolBar.tool, "Disconnect") && this.outputButton1.getConnectedWire() != null) {
           outputButton1.getConnectedWire().removeLine();
        }
        });
        this.outputButton2.setOnMouseClicked(event ->  {if (Objects.equals(ToolBar.tool, "Connect")) {
            Wire.handleCircleClick(this.outputButton2);
        }
        else if (Objects.equals(ToolBar.tool, "Disconnect") && this.outputButton2.getConnectedWire() != null) {
           outputButton2.getConnectedWire().removeLine();
        }
        });
        this.outputButton3.setOnMouseClicked(event ->  {if (Objects.equals(ToolBar.tool, "Connect")) {
            Wire.handleCircleClick(this.outputButton3);
        }
        else if (Objects.equals(ToolBar.tool, "Disconnect") && this.outputButton3.getConnectedWire() != null) {
           outputButton3.getConnectedWire().removeLine();
        }
        });
    }

    // Method th update the input states when clicking on a terminal
    void updateInputs() {
        output = input = inputButton.state;
        updateOutput();
    }
    // Method to update the output label based on input values
    void updateOutput() {
        output = input;
        outputButton1.setState(output);
        outputButton2.setState(output);
        outputButton3.setState(output);
    }
}
