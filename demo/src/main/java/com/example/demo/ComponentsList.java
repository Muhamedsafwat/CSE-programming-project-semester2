package com.example.demo;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;

public class ComponentsList extends Pane {
    public ComponentsList() {
        super();
        //create buttons
        Button b1=new Button("Input Controls");
        Button b2=new Button("Toogle Switch");
        Button b3=new Button("Push Button");
        Button b4=new Button("Clock");
        Button b5=new Button("Low Constant");
        Button b6=new Button("High Constant");
        Button b7=new Button("OutPut Controls");
        Button b8=new Button("Light Blumb");
        Button b9=new Button("4-Bits Dight");
        Button b10=new Button("Logic Gates");
        Button b11=new Button("Buffer");
        Button b12=new Button("NOT Gate");
        Button b13=new Button("AND Gate");
        Button b14=new Button("NAND Gate");
        Button b15=new Button("OR Gate");
        Button b16=new Button("NOR Gate");
        Button b17=new Button("XOR Gate");
        Button b18=new Button("XNOR Gate");
        Button b19=new Button("Tri-State");
        Button b20=new Button("Flip-Flop");
        Button b21=new Button("SR Flip-Flop");
        Button b22=new Button("D Flip-Flop");
        Button b23=new Button("JK Flip-Flop ");
        Button b24=new Button("T Flip-Flop");
        Button b25=new Button("Other");
        Button b26=new Button("Label");
        Button b27=new Button("Bus");
        Button b28=new Button("Pull Up");
        Button b29=new Button("Pull Down");
        //adjust buttons width
        b1.setPrefWidth(240);
        b7.setPrefWidth(240);
        b10.setPrefWidth(240);
        b20.setPrefWidth(240);
        b25.setPrefWidth(240);
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
        h2.getChildren().addAll(b2,b3);
        h3.getChildren().addAll(b4,b5);
        h4.getChildren().addAll(b6);
        h5.getChildren().addAll(b7);
        h6.getChildren().addAll(b8,b9);
        h7.getChildren().addAll(b10);
        h8.getChildren().addAll(b11,b12);
        h9.getChildren().addAll(b13,b14);
        h10.getChildren().addAll(b15,b16);
        h11.getChildren().addAll(b17,b18);
        h12.getChildren().addAll(b19);
        h13.getChildren().addAll(b20);
        h14.getChildren().addAll(b21,b22);
        h15.getChildren().addAll(b23,b24);
        h16.getChildren().addAll(b25);
        h17.getChildren().addAll(b26,b27);
        h18.getChildren().addAll(b28,b29);
        //set HBoxes spacings
        h2.setSpacing(50);
        h3.setSpacing(95);
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

        getChildren().addAll(listview);
    }
}


