package com.example.demo;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;

import java.util.Objects;

public class ComponentsList extends Pane {
    public ComponentsList() {
        super();
        //create buttons
        Button b1=new Button("Input Controls");
        Button switchBtn=new Button("Toggle Switch");
        Button constLowBtn=new Button("Low Constant");
        Button constHighBtn=new Button("High Constant");
        Button b7=new Button("OutPut Controls");
        Button bulbBtn=new Button("Light Bulb");
        Button b10=new Button("Logic Gates");
        Button NOTBtn=new Button("NOT Gate");
        Button ANDBtn=new Button("AND Gate");
        Button NANDBtn=new Button("NAND Gate");
        Button ORBtn=new Button("OR Gate");
        Button NORBtn=new Button("NOR Gate");
        Button XORBtn=new Button("XOR Gate");
        Button XNORBtn=new Button("XNOR Gate");

        //adjust buttons width
        b1.setPrefWidth(240);
        b7.setPrefWidth(240);
        b10.setPrefWidth(240);

        //create HBoxes
        HBox h1=new HBox();
        HBox h2=new HBox();
        HBox h3=new HBox();
        HBox h4=new HBox();
        HBox h5=new HBox();
        HBox h6=new HBox();
        HBox h7=new HBox();
        HBox h8=new HBox();
        HBox h9=new HBox();
        HBox h10=new HBox();
        HBox h11=new HBox();
        HBox h12=new HBox();
        HBox h13=new HBox();
        HBox h14=new HBox();
        HBox h15=new HBox();
        HBox h16=new HBox();
        HBox h17=new HBox();
        HBox h18=new HBox();
        //add buttons to HBoxes
        h1.getChildren().addAll(b1);
        h2.getChildren().addAll(switchBtn);
        h3.getChildren().addAll(constLowBtn,constHighBtn);
        h6.getChildren().addAll(bulbBtn);
        h5.getChildren().addAll(b7);
        h7.getChildren().addAll(b10);
        h8.getChildren().addAll(NOTBtn,ANDBtn);
        h9.getChildren().addAll(NANDBtn,ORBtn);
        h10.getChildren().addAll(NORBtn,XORBtn);
        h11.getChildren().addAll(XNORBtn);
        //set HBoxes spacings
        h2.setSpacing(50);
        h3.setSpacing(50);
        h6.setSpacing(50);
        h7.setSpacing(50);
        h8.setSpacing(73);
        h9.setSpacing(50);
        h10.setSpacing(58);
        h11.setSpacing(52);
        h12.setSpacing(50);
        h13.setSpacing(50);
        h14.setSpacing(50);
        h15.setSpacing(50);
        h16.setSpacing(50);
        h17.setSpacing(59);
        h18.setSpacing(50);
        //create the list view
        ListView <VBox>listview=new ListView<>();
        listview.setPrefSize(253, 800);
        listview.setTranslateX(0);
        listview.setTranslateY(0);
        listview.setItems(FXCollections.observableArrayList(
                new VBox(h1),
                new VBox(h2),
                new VBox(h3),
                new VBox(h4),
                new VBox(h5),
                new VBox(h6),
                new VBox(h7),
                new VBox(h8),
                new VBox(h9),
                new VBox(h10),
                new VBox(h11),
                new VBox(h12),
                new VBox(h13),
                new VBox(h14),
                new VBox(h15),
                new VBox(h16),
                new VBox(h17),
                new VBox(h18)
        ));
        //set margins
        VBox.setMargin(h1, new Insets(2,0,2,0));
        VBox.setMargin(h2, new Insets(2,0,2,0));
        VBox.setMargin(h3, new Insets(2,0,2,0));
        VBox.setMargin(h4, new Insets(2,0,2,0));
        VBox.setMargin(h5, new Insets(2,0,2,0));
        VBox.setMargin(h6, new Insets(2,0,2,0));
        VBox.setMargin(h7, new Insets(2,0,2,0));
        VBox.setMargin(h8, new Insets(2,0,2,0));
        VBox.setMargin(h9, new Insets(2,0,2,0));
        VBox.setMargin(h10, new Insets(2,0,2,0));
        VBox.setMargin(h11, new Insets(2,0,2,0));
        VBox.setMargin(h12, new Insets(2,0,2,0));
        VBox.setMargin(h13, new Insets(2,0,2,0));
        VBox.setMargin(h14, new Insets(2,0,2,0));
        VBox.setMargin(h15, new Insets(2,0,2,0));
        VBox.setMargin(h16, new Insets(2,0,2,0));
        VBox.setMargin(h17, new Insets(2,0,2,0));
        VBox.setMargin(h18, new Insets(2,0,2,0));
        //Add button actions to create components
        NOTBtn.setOnAction(e -> {
            addComponent(new NOTGate());
        });
        getChildren().addAll(listview);
    }

    void addComponent (Node node) {
        HelloApplication.workingSpace.getChildren().add(node);
        node.setOnMouseClicked(event -> {
            if (Objects.equals(ToolBar.tool, "Delete")) {
                HelloApplication.workingSpace.getChildren().remove(node);
            }
        });
    }
}


