
package com.example.demo;

import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import java.util.Objects;


public class _8bit_converter extends HBox{
    //X and Y coordinates for drag & drop
    double startX;
    double startY;
    Terminal input1,input2,input3,input4,input5,input6,input7,input8;
    boolean[] states= {false,false,false,false,false,false,false,false};
    int[] bits = new int[8];
    int num;
    Label label;
    ImageView image;
    _8bit_converter(){
        super();
        //create inputs
        input1 = new Terminal(false);
        input1.setRadius(4);
        input1.setParent8bit_converter(this);
        input2 = new Terminal(false);
        input2.setRadius(4);
        input2.setParent8bit_converter(this);
        input3 = new Terminal(false);
        input3.setRadius(4);
        input3.setParent8bit_converter(this);
        input4 = new Terminal(false);
        input4.setRadius(4);
        input4.setParent8bit_converter(this);
        input5 = new Terminal(false);
        input5.setRadius(4);
        input5.setParent8bit_converter(this);
        input6 = new Terminal(false);
        input6.setRadius(4);
        input6.setParent8bit_converter(this);
        input7 = new Terminal(false);
        input7.setRadius(4);
        input7.setParent8bit_converter(this);
        input8 = new Terminal(false);
        input8.setRadius(4);
        input8.setParent8bit_converter(this);
        //create labels
        label = new Label("0");
        label.setFont(Font.font("", FontWeight.BOLD, 18));
        label.setTextAlignment(TextAlignment.CENTER);
        //create input box and add inputs
        VBox inputBox = new VBox(input1,input2,input3,input4,input5,input6,input7,input8);
        inputBox.setSpacing(3);
        inputBox.setTranslateY(1);
        inputBox.setAlignment(Pos.CENTER);
        //converter image
        image = new ImageView("8bit.png");
        image.setFitWidth(70);
        image.setFitHeight(100);
        //create Stack pane for display
        VBox output = new VBox(label);
        output.setAlignment(Pos.CENTER);
        output.setMaxWidth(50);
        StackPane display = new StackPane(image,output);
        display.setAlignment(Pos.TOP_RIGHT);
        getChildren().addAll(inputBox,display);

        //drag and drop functionality
        //drag and drop functionality
        setTranslateX(10);
        setTranslateY(10);
        setOnMousePressed(e -> { if (Objects.equals(ToolBar.tool, "Drag")) {
            startX = e.getSceneX() - getTranslateX();
            startY = e.getSceneY() - getTranslateY();
        } else if (Objects.equals(ToolBar.tool, "Delete")) {
            HelloApplication.workingSpace.getChildren().remove(this);
            if (input1.getConnectedWire() != null) {
                input1.getConnectedWire().removeLine();
                // this.updateInputs();
            }
            if (input2.getConnectedWire() != null) {
                input2.getConnectedWire().removeLine();
            }
            if (input3.getConnectedWire() != null) {
                input3.getConnectedWire().removeLine();
            }
            if (input4.getConnectedWire() != null) {
                input4.getConnectedWire().removeLine();
            }
            if (input5.getConnectedWire() != null) {
                input5.getConnectedWire().removeLine();
            }
            if (input6.getConnectedWire() != null) {
                input6.getConnectedWire().removeLine();
            }
            if (input7.getConnectedWire() != null) {
                input7.getConnectedWire().removeLine();
            }
            if (input8.getConnectedWire() != null) {
                input8.getConnectedWire().removeLine();
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
            if (input4.getConnectedWire() != null) {
                input4.getConnectedWire().updatePosition();
            }
            if (input5.getConnectedWire() != null) {
                input5.getConnectedWire().updatePosition();
            }
            if (input6.getConnectedWire() != null) {
                input6.getConnectedWire().updatePosition();
            }
            if (input7.getConnectedWire() != null) {
                input7.getConnectedWire().updatePosition();
            }
            if (input7.getConnectedWire() != null) {
                input7.getConnectedWire().updatePosition();
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
                if (input1.getConnectedWire() != null) {
                    input1.getConnectedWire().updatePosition();
                }
                if (input2.getConnectedWire() != null) {
                    input2.getConnectedWire().updatePosition();
                }
                if (input3.getConnectedWire() != null) {
                    input3.getConnectedWire().updatePosition();
                }
                if (input4.getConnectedWire() != null) {
                    input4.getConnectedWire().updatePosition();
                }
                if (input5.getConnectedWire() != null) {
                    input5.getConnectedWire().updatePosition();
                }
                if (input6.getConnectedWire() != null) {
                    input6.getConnectedWire().updatePosition();
                }
                if (input7.getConnectedWire() != null) {
                    input7.getConnectedWire().updatePosition();
                }
                if (input7.getConnectedWire() != null) {
                    input7.getConnectedWire().updatePosition();
                }
            }
        });

        this.input1.setOnMouseClicked(event ->  {if ( Objects.equals(ToolBar.tool, "Connect")) {
            Wire.handleCircleClick(this.input1);
        } else if (Objects.equals(ToolBar.tool, "Disconnect") && this.input1.getConnectedWire() != null) {
            input1.getConnectedWire().removeLine();
        }
        });
        this.input2.setOnMouseClicked(event ->  {if (Objects.equals(ToolBar.tool, "Connect")) {
            Wire.handleCircleClick(this.input2);
        }
        else if (Objects.equals(ToolBar.tool, "Disconnect") && this.input2.getConnectedWire() != null) {
            input2.getConnectedWire().removeLine();
        }
        });
        this.input3.setOnMouseClicked(event ->  {if (Objects.equals(ToolBar.tool, "Connect")) {
            Wire.handleCircleClick(this.input3);
        }
        else if (Objects.equals(ToolBar.tool, "Disconnect") && this.input3.getConnectedWire() != null) {
            input3.getConnectedWire().removeLine();
        }
        });
        this.input4.setOnMouseClicked(event ->  {if (Objects.equals(ToolBar.tool, "Connect")) {
            Wire.handleCircleClick(this.input4);
        }
        else if (Objects.equals(ToolBar.tool, "Disconnect") && this.input4.getConnectedWire() != null) {
            input4.getConnectedWire().removeLine();
        }
        });
        this.input5.setOnMouseClicked(event ->  {if (Objects.equals(ToolBar.tool, "Connect")) {
            Wire.handleCircleClick(this.input5);
        }
        else if (Objects.equals(ToolBar.tool, "Disconnect") && this.input5.getConnectedWire() != null) {
            input5.getConnectedWire().removeLine();
        }
        });
        this.input5.setOnMouseClicked(event ->  {if (Objects.equals(ToolBar.tool, "Connect")) {
            Wire.handleCircleClick(this.input5);
        }
        else if (Objects.equals(ToolBar.tool, "Disconnect") && this.input6.getConnectedWire() != null) {
            input6.getConnectedWire().removeLine();
        }
        });
        this.input7.setOnMouseClicked(event ->  {if (Objects.equals(ToolBar.tool, "Connect")) {
            Wire.handleCircleClick(this.input7);
        }
        else if (Objects.equals(ToolBar.tool, "Disconnect") && this.input7.getConnectedWire() != null) {
            input7.getConnectedWire().removeLine();
        }
        });
        this.input8.setOnMouseClicked(event ->  {if (Objects.equals(ToolBar.tool, "Connect")) {
            Wire.handleCircleClick(this.input8);
        }
        else if (Objects.equals(ToolBar.tool, "Disconnect") && this.input8.getConnectedWire() != null) {
            input8.getConnectedWire().removeLine();
        }
        });
    }

    //convert binary bits into integer number
    public static int bitsToInt(int[] bits) {
        int l = 0;
        for (int i = 0; i < bits.length; i++) {
            l += bits[i] << (bits.length - 1 - i);
        }
        return l;
    }

    void updateOutput() {
       states[7] = input1.state;
       states[6] = input2.state;
       states[5] = input3.state;
       states[4] = input4.state;
       states[3] = input5.state;
       states[2] = input6.state;
       states[1] = input7.state;
       states[0] = input8.state;

       System.out.println(states[0] + "" + input1.state);
        for (int i = 0; i < 8; i++) {
            if (states[i]) {
                bits[i] = 1;
            } else {
                bits[i] = 0;
            }
            System.out.println(bits[i]);
        }
        label.setText("" + bitsToInt(bits));
    }
}
