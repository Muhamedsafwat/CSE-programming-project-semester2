package com.example.demo;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    VBox root;
    Pane workingSpace;
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
        workingSpace = new Pane();
        ToolBar toolBar = new ToolBar();
        mainSection.getChildren().addAll(componentsList, workingSpace);
        //create a OR gate
         ORGate gate1 = new ORGate();
        //create a AND gate
        ANDGate gate2 = new ANDGate();
        //create a NAND gate
        NANDGate gate3 = new NANDGate();
        //create a NOR gate
        NORGate gate4 = new NORGate();
        //create a NOT gate
        NOTGate gate5 = new NOTGate();
        //create a XOR gate
        XORGate gate6 = new XORGate();
        //create a XNOR gate
        XNORGate gate7 = new XNORGate();
        //add elements to working space
        workingSpace.getChildren().addAll(gate1, gate2, gate3, gate4, gate5, gate6,gate7);
        workingSpace.getChildren().forEach(this::makeRemovable);
        //add elements to the root and show the stage
        root.getChildren().addAll(toolBar,mainSection);
        Image icon = new Image("appicon.png");
        stage.setTitle("LogicSim || CSE#27");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    void makeRemovable (Node node) {
        node.setOnMouseClicked(e -> {
            if (Objects.equals(ToolBar.tool, "Delete")) {
                workingSpace.getChildren().remove(node);
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
