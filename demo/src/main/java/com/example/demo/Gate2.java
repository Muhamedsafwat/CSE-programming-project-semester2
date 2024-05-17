package com.example.demo;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        // Create input & output button
        inputButton = new Terminal(false);
        outputButton = new Terminal(true);
        //style inputs and outputs
        //create image view
        ImageView imageView = new ImageView(new Image(imageURL));
        imageView.setFitWidth(105);
        imageView.setFitHeight(60);
        // Set layout for the input elements
        VBox inputBox = new VBox(inputButton);
        inputBox.setAlignment(Pos.CENTER);
        // Create the root node and add the elements
        setAlignment(Pos.CENTER);
        getChildren().addAll(inputBox,imageView, outputButton);
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
            if (outputButton.getConnectedWire() != null) {
               outputButton.getConnectedWire().removeLine();
            }
        } else if (Objects.equals(ToolBar.tool, "RotateLeft")) {
            setRotate(getRotate() - 90);
            if (inputButton.getConnectedWire() != null) {
                inputButton.getConnectedWire().updatePosition();
            }
            if (outputButton.getConnectedWire() != null) {
                outputButton.getConnectedWire().updatePosition();
            }
        }
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
                if (inputButton.getConnectedWire() != null) {
                inputButton.getConnectedWire().updatePosition();
                }
                if (outputButton.getConnectedWire() != null) {
                   outputButton.getConnectedWire().updatePosition();
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
        input = inputButton.state;
        output = outputButton.state;
    }
    // Method to update the output label based on input values
     void updateOutput() {
        outputButton.setState(output);
     }
    public static void updateTool () {
        tool = ToolBar.tool;}

}
