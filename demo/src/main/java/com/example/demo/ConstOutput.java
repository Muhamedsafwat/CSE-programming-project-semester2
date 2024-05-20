
package com.example.demo;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.util.Objects;

public class ConstOutput extends HBox {
    //Circle output;
    ImageView imageView;
    Terminal output;
    double startX;
    double startY;
    public ConstOutput(boolean outputState){
        Image constHigh = new Image("ConstHigh.png");
        Image constLow = new Image("ConstLow.png");

        output= new Terminal(true);
        imageView = new ImageView();
       if (outputState){
           imageView.setImage(constHigh);
           output.setState(true);
       } else {
           imageView.setImage(constLow);
           output.setState(false);
       }
        imageView.setFitWidth(40);
        imageView.setFitHeight(30);


        output.setOnMouseClicked(e -> {
            if (Objects.equals(ToolBar.tool, "Connect")) {
                Wire.handleCircleClick(output);
            } else if (Objects.equals(ToolBar.tool, "Disconnect") && output.getConnectedWire() != null) {
                output.getConnectedWire().removeLine();
            }
        });
        setAlignment(Pos.CENTER);
        getChildren().addAll(imageView,output);
        setTranslateX(10);
        setTranslateY(10);
        setOnMousePressed(e -> { if (Objects.equals(ToolBar.tool, "Drag")) {
            startX = e.getSceneX() - getTranslateX();
            startY = e.getSceneY() - getTranslateY();
        } else if (Objects.equals(ToolBar.tool, "Delete")) {
            HelloApplication.workingSpace.getChildren().remove(this);
            if (output.getConnectedWire() != null) {
                output.getConnectedWire().removeLine();
            }
        } else if (Objects.equals(ToolBar.tool, "RotateLeft")) {
            setRotate( getRotate() - 90 );
            if (output.getConnectedWire() != null) {
                output.getConnectedWire().updatePosition();
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
                if (output.getConnectedWire() != null) {
                    output.getConnectedWire().updatePosition();
                }
            }
        });
    }}
