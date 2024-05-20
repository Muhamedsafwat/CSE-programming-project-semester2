package com.example.demo;

import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.Objects;

public class Multiplexer4to1 extends BorderPane {

    double startX;
    double startY;
   public Terminal input1, input2, input3, input4, S0, S1, output;
    ImageView image = new ImageView("Mux.png");


    public Multiplexer4to1() {

        input1 = new Terminal(false);
        input1.setParentMultiplexer4to1(this);
        input1.setRadius(4);
        input2 = new Terminal(false);
        input2.setParentMultiplexer4to1(this);
        input2.setRadius(4);
        input3 = new Terminal(false);
        input3.setParentMultiplexer4to1(this);
        input3.setRadius(4);
        input4 = new Terminal(false);
        input4.setParentMultiplexer4to1(this);
        input4.setRadius(4);
        S0 = new Terminal(false);
        S0.setParentMultiplexer4to1(this);
        S0.setRadius(4);
        S1 = new Terminal(false);
        S1.setParentMultiplexer4to1(this);
        S1.setRadius(4);
        output = new Terminal(true);
        output.setRadius(4);

        VBox v1 = new VBox(input1, input2, input3, input4);
        v1.setSpacing(7);
        v1.setAlignment(Pos.CENTER);
        HBox H1 = new HBox(S1, S0);
        H1.setAlignment(Pos.CENTER);
        H1.setSpacing(3);
        // BorderPane border = new BorderPane();
        VBox v2 = new VBox(output);
        v2.setAlignment(Pos.CENTER);
        image.setFitHeight(100);
        image.setFitWidth(70);
        setCenter(image);
        setLeft(v1);
        setTop(H1);
        setRight(v2);


//drag and drop functionality
        setTranslateX(10);
        setTranslateY(10);
        setOnMousePressed(e -> {
            if (Objects.equals(ToolBar.tool, "Drag")) {
                startX = e.getSceneX() - getTranslateX();
                startY = e.getSceneY() - getTranslateY();
            } else if (Objects.equals(ToolBar.tool, "Delete")) {
                HelloApplication.workingSpace.getChildren().remove(this);
                if (input1.getConnectedWire() != null) {
                    input1.getConnectedWire().removeLine();
                }
                if (input2.getConnectedWire() != null) {
                    input2.getConnectedWire().removeLine();
                }
                if (input3.getConnectedWire() != null) {
                    input3.getConnectedWire().removeLine();
                }
                if (input3.getConnectedWire() != null) {
                    input3.getConnectedWire().removeLine();
                }
                if (input4.getConnectedWire() != null) {
                    input4.getConnectedWire().removeLine();
                }
                if (S1.getConnectedWire() != null) {
                    S1.getConnectedWire().removeLine();
                }
                if (S0.getConnectedWire() != null) {
                    S0.getConnectedWire().removeLine();
                }
                if (output.getConnectedWire() != null) {
                    output.getConnectedWire().removeLine();
                }
            } else if (Objects.equals(ToolBar.tool, "RotateLeft")) {
                setRotate(getRotate() - 90);
                if (input1.getConnectedWire() != null) {
                    input1.getConnectedWire().updatePosition();
                }
                if (input2.getConnectedWire() != null) {
                    input2.getConnectedWire().updatePosition();
                }
                if (input3.getConnectedWire() != null) {
                    input3.getConnectedWire().updatePosition();
                }
                if (input3.getConnectedWire() != null) {
                    input3.getConnectedWire().updatePosition();
                }
                if (input4.getConnectedWire() != null) {
                    input4.getConnectedWire().updatePosition();
                }
                if (S1.getConnectedWire() != null) {
                    S1.getConnectedWire().updatePosition();
                }
                if (S0.getConnectedWire() != null) {
                    S0.getConnectedWire().updatePosition();
                }
                if (output.getConnectedWire() != null) {
                    output.getConnectedWire().updatePosition();
                }
            }
        });
        //drag and drop
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
                if (input1.getConnectedWire() != null) {
                    input1.getConnectedWire().updatePosition();
                }
                if (input2.getConnectedWire() != null) {
                    input2.getConnectedWire().updatePosition();
                }
                if (input3.getConnectedWire() != null) {
                    input3.getConnectedWire().updatePosition();
                }
                if (input3.getConnectedWire() != null) {
                    input3.getConnectedWire().updatePosition();
                }
                if (input4.getConnectedWire() != null) {
                    input4.getConnectedWire().updatePosition();
                }
                if (S1.getConnectedWire() != null) {
                    S1.getConnectedWire().updatePosition();
                }
                if (S0.getConnectedWire() != null) {
                    S0.getConnectedWire().updatePosition();
                }
                if (output.getConnectedWire() != null) {
                    output.getConnectedWire().updatePosition();
                }
            }
        });
        //terminals actions
        this.input1.setOnMouseClicked(event -> {
            if (Objects.equals(ToolBar.tool, "Connect")) {
                Wire.handleCircleClick(this.input1);
            } else if (Objects.equals(ToolBar.tool, "Disconnect") && this.input1.getConnectedWire() != null) {
                input1.getConnectedWire().removeLine();
                this.updateOutputs();
            }
        });
        this.input2.setOnMouseClicked(event -> {
            if (Objects.equals(ToolBar.tool, "Connect")) {
                Wire.handleCircleClick(this.input2);
            } else if (Objects.equals(ToolBar.tool, "Disconnect") && this.input2.getConnectedWire() != null) {
                input2.getConnectedWire().removeLine();
                this.updateOutputs();
            }
        });
        this.input3.setOnMouseClicked(event -> {
            if (Objects.equals(ToolBar.tool, "Connect")) {
                Wire.handleCircleClick(this.input3);
            } else if (Objects.equals(ToolBar.tool, "Disconnect") && this.input3.getConnectedWire() != null) {
                input3.getConnectedWire().removeLine();
                this.updateOutputs();
            }
        });
        this.input4.setOnMouseClicked(event -> {
            if (Objects.equals(ToolBar.tool, "Connect")) {
                Wire.handleCircleClick(this.input4);
            } else if (Objects.equals(ToolBar.tool, "Disconnect") && this.input4.getConnectedWire() != null) {
                input4.getConnectedWire().removeLine();
                this.updateOutputs();
            }
        });
        this.S0.setOnMouseClicked(event -> {
            if (Objects.equals(ToolBar.tool, "Connect")) {
                Wire.handleCircleClick(this.S0);
            } else if (Objects.equals(ToolBar.tool, "Disconnect") && this.S0.getConnectedWire() != null) {
                S0.getConnectedWire().removeLine();
                this.updateOutputs();
            }
        });
        this.S1.setOnMouseClicked(event -> {
            if (Objects.equals(ToolBar.tool, "Connect")) {
                Wire.handleCircleClick(this.S1);
            } else if (Objects.equals(ToolBar.tool, "Disconnect") && this.S1.getConnectedWire() != null) {
                S1.getConnectedWire().removeLine();
                this.updateOutputs();
            }
        });
        this.output.setOnMouseClicked(event -> {
            if (Objects.equals(ToolBar.tool, "Connect")) {
                Wire.handleCircleClick(this.output);
            } else if (Objects.equals(ToolBar.tool, "Disconnect") && this.output.getConnectedWire() != null) {
                output.getConnectedWire().removeLine();
                this.updateOutputs();
            }
        });


    }

    // Method th update the input states when clicking on a terminal
    void updateOutputs() {

               output.setState(((!S1.state)&&(!S0.state)&&(input1.state))||
                       ((!S1.state)&&(S0.state)&&(input2.state))||
                       ((S1.state)&&(!S0.state)&&(input3.state))||
                       ((S1.state)&&(S0.state)&&(input4.state)));
    }



    }




