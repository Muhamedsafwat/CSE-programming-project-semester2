package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    VBox root;
    @Override
    public void start(Stage stage) throws IOException {
        //initialize the scene
        root = new VBox();
        root.setMaxWidth(Double.MAX_VALUE);
        Scene scene = new Scene(root, 1000, 700);
        scene.setFill(Color.web("#DBDBDB"));
        //create main sections
        ComponentsList componentsList  = new ComponentsList();
        HBox mainSection = new HBox();
        Pane workingSpace = new Pane();
        ToolBar toolBar = new ToolBar();
        mainSection.getChildren().addAll(componentsList, workingSpace);
        //create a OR gate
         ORGate gate1 = new ORGate();
        //add elements to working space
        workingSpace.getChildren().addAll(gate1);
        //create a AND gate
        ANDGate gate2 = new ANDGate();
        //add elements to working space
        workingSpace.getChildren().addAll(gate2);
        //create a NAND gate
        NANDGate gate3 = new NANDGate();
        //add elements to working space
        workingSpace.getChildren().addAll(gate3);
        //create a NOR gate
        NORGate gate4 = new NORGate();
        //add elements to working space
        workingSpace.getChildren().addAll(gate4);
        //create a NOT gate
        NOTGate gate5 = new NOTGate();
        //add elements to working space
        workingSpace.getChildren().addAll(gate5);
        //create a XOR gate
        XORGate gate6 = new XORGate();
        //add elements to working space
        workingSpace.getChildren().addAll(gate6);
        //create a XNOR gate
        XNORGate gate7 = new XNORGate();
        //add elements to working space
        workingSpace.getChildren().addAll(gate7);
        //add elements to the root and show the stage
        root.getChildren().addAll(toolBar,mainSection);
        stage.setTitle("LogicSim || CSE#27");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
