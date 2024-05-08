
package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.util.Objects;


public class _8bit_converter extends HBox{
    public static String tool = ToolBar.tool;
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
        input2 = new Terminal(false);
        input3 = new Terminal(false);
        input4 = new Terminal(false);
        input5 = new Terminal(false);
        input6 = new Terminal(false);
        input7 = new Terminal(false);
        input8 = new Terminal(false);
        //create labels
        label = new Label("0");
        label.setFont(Font.font("", FontWeight.BOLD, 20));
        label.setTextAlignment(TextAlignment.CENTER);
        //create input box and add inputs
        VBox inputBox = new VBox(input1,input2,input3,input4,input5,input6,input7,input8);
        inputBox.setSpacing(7);
        inputBox.setTranslateY(1);
        inputBox.setAlignment(Pos.CENTER);
        //converter image
        image = new ImageView("8-bit Digit.png");
        //handle click events
        input1.setOnMouseClicked(e -> {
            states[7] = !states[7];
            updateOutput();
            num = bitsToInt(bits);
            label.setText(""+num);
        });
        input2.setOnMouseClicked(e -> {
            states[6] = !states[6];
            updateOutput();
            num = bitsToInt(bits);
            label.setText(""+num);
        });
        input3.setOnMouseClicked(e -> {
            states[5] = !states[5];
            updateOutput();
            num = bitsToInt(bits);
            label.setText(""+num);
        });
        input4.setOnMouseClicked(e -> {
            states[4] = !states[4];
            updateOutput();
            num = bitsToInt(bits);
            label.setText(""+num);
        });
        input5.setOnMouseClicked(e -> {
            states[3] = !states[3];
            updateOutput();
            num = bitsToInt(bits);
            label.setText(""+num);
        });
        input6.setOnMouseClicked(e -> {
            states[2] = !states[2];
            updateOutput();
            num = bitsToInt(bits);
            label.setText(""+num);
        });
        input7.setOnMouseClicked(e -> {
            states[1] = !states[1];
            updateOutput();
            num = bitsToInt(bits);
            label.setText(""+num);
        });
        input8.setOnMouseClicked(e -> {
            states[0] = !states[0];
            updateOutput();
            num = bitsToInt(bits);
            label.setText(""+num);
        });
        //create Stack pane for display
        VBox output = new VBox(label);
        output.setAlignment(Pos.CENTER);
        output.setMaxWidth(64);
        StackPane display = new StackPane(image,output);
        display.setAlignment(Pos.TOP_RIGHT);
        getChildren().addAll(inputBox,display);

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
        input1.setState(states[7]);
        input2.setState(states[6]);
        input3.setState(states[5]);
        input4.setState(states[4]);
        input5.setState(states[3]);
        input6.setState(states[2]);
        input7.setState(states[1]);
        input8.setState(states[0]);
        for(int i=0 ; i<8 ; i++){
            if (states[i]){ bits[i] = 1 ;}
            else{bits[i] = 0 ;}
        }
    }

    //static method to update the tool
    public static void updateTool () {
        tool = ToolBar.tool;
    }
}
