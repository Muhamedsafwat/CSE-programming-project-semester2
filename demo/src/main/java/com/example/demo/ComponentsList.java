package com.example.demo;

import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Objects;

public class ComponentsList extends VBox {
    public ComponentsList() {
        super();
        setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));

        // Create buttons
        Button bt1 = new Button("Input Controls");
        Button bt7 = new Button("Output Controls");
        Button bt10 = new Button("Logic Gates");
        Button bt11 = new Button("Other Components");
        //NOT
        ImageView NOT = new ImageView(new Image("NOT-list.png"));
        NOT.setFitHeight(40);
        NOT.setFitWidth(70);
        NOT.setOnMouseClicked(e -> {
            addComponent(new NOTGate());
        });
        //AND
        ImageView AND = new ImageView(new Image("AND-list.png"));
        AND.setFitHeight(40);
        AND.setFitWidth(70);
        AND.setOnMouseClicked(e -> {
            addComponent(new ANDGate());
        });
        //NAND
        ImageView NAND = new ImageView(new Image("NAND-list.png"));
        NAND.setFitHeight(40);
        NAND.setFitWidth(70);
        NAND.setOnMouseClicked(e -> {
            addComponent(new NANDGate());
        });
        //NOR
        ImageView NOR = new ImageView(new Image("NOR-list.png"));
        NOR.setFitHeight(40);
        NOR.setFitWidth(70);
        NOR.setOnMouseClicked(e -> {
            addComponent(new NORGate());
        });
        //OR
        ImageView OR = new ImageView(new Image("OR-list.png"));
        OR.setFitHeight(40);
        OR.setFitWidth(70);
        OR.setOnMouseClicked(e -> {
            addComponent(new ORGate());
        });
        //XNOR
        ImageView XNOR = new ImageView(new Image("XNOR-list.png"));
        XNOR.setFitHeight(40);
        XNOR.setFitWidth(70);
        XNOR.setOnMouseClicked(e -> {
            addComponent(new XNORGate());
        });
        //XOR
        ImageView XOR = new ImageView(new Image("XOR-list.png"));
        XOR.setFitHeight(40);
        XOR.setFitWidth(70);
        XOR.setOnMouseClicked(e -> {
            addComponent(new XORGate());
        });
        //Lamb
        ImageView LED = new ImageView(new Image("Lamp OFF.png"));
        LED.setFitHeight(42);
        LED.setFitWidth(51);
        LED.setOnMouseClicked(e -> addComponent(new LightPulb()));
        //8-bit converter
        ImageView BIT = new ImageView(new Image("8bit-list.png"));
        BIT.setFitHeight(42);
        BIT.setFitWidth(60);
        BIT.setOnMouseClicked(e -> addComponent(new _8bit_converter()));
        //const low
        ImageView LOW = new ImageView(new Image("ConstLow-list.png"));
        LOW.setFitHeight(39);
        LOW.setFitWidth(52);
        //const high
        ImageView HIGH = new ImageView(new Image("ConstHigh-list.png"));
        HIGH.setFitHeight(39);
        HIGH.setFitWidth(52);
        //switch
        ImageView Switch = new ImageView(new Image("switch-list.png"));
        Switch.setFitHeight(30);
        Switch.setFitWidth(60);
        Switch.setOnMouseClicked(e -> addComponent(new Switch()));
        //full adder
        ImageView fullAdder = new ImageView(new Image("FullAdder-list.PNG"));
        fullAdder.setFitHeight(40);
        fullAdder.setFitWidth(70);
        fullAdder.setOnMouseClicked(e -> addComponent(new FullAdder()));
        //half adder
        ImageView halfAdder = new ImageView(new Image("HalfAdder-list.PNG"));
        halfAdder.setFitHeight(40);
        halfAdder.setFitWidth(70);
        halfAdder.setOnMouseClicked(e -> addComponent(new HalfAdder()));
        //Splitter
        ImageView splitter = new ImageView(new Image("splitter-list.PNG"));
        splitter.setFitHeight(40);
        splitter.setFitWidth(70);
        splitter.setOnMouseClicked(e -> addComponent(new Splitter()));



        // Style buttons
        bt1.setStyle("-fx-background-color: black;");
        bt7.setStyle("-fx-background-color: black;");
        bt10.setStyle("-fx-background-color: black;");
        bt11.setStyle("-fx-background-color: black;");
        bt1.setTextFill(Color.WHITE);
        bt7.setTextFill(Color.WHITE);
        bt10.setTextFill(Color.WHITE);
        bt11.setTextFill(Color.WHITE);
        bt1.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        bt7.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        bt10.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        bt11.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        // Adjust buttons width
        bt1.setPrefWidth(240);
        bt7.setPrefWidth(240);
        bt10.setPrefWidth(240);
        bt11.setPrefWidth(240);

        // Create HBoxes
        HBox h1 = new HBox();
        HBox h2 = new HBox();
        HBox h3 = new HBox();
        HBox h4 = new HBox();
        HBox h5 = new HBox();
        HBox h6 = new HBox();
        HBox h7 = new HBox();
        HBox h8 = new HBox();
        HBox h9 = new HBox();
        HBox h10 = new HBox();
        HBox h11 = new HBox();
        HBox h12 = new HBox();
        HBox h13 = new HBox();
        HBox h14 = new HBox();
        // Add buttons to HBoxes
        h1.getChildren().addAll(bt1);
        h2.getChildren().addAll(Switch);
        h3.getChildren().addAll(LOW, HIGH);
        h6.getChildren().addAll(LED, BIT);
        h5.getChildren().addAll(bt7);
        h7.getChildren().addAll(bt10);
        h8.getChildren().addAll(NOT, AND);
        h9.getChildren().addAll(NAND, OR);
        h10.getChildren().addAll(NOR, XOR);
        h11.getChildren().addAll(XNOR, halfAdder);
        h12.getChildren().addAll(fullAdder);
        h13.getChildren().add(bt11);
        h14.getChildren().add(splitter);
        h1.setPadding(new Insets(13)); // Add padding of 5 pixels
        h2.setPadding(new Insets(13));
        h3.setPadding(new Insets(13));
        h6.setPadding(new Insets(13));
        h5.setPadding(new Insets(5));
        h7.setPadding(new Insets(5));
        h8.setPadding(new Insets(13));
        h9.setPadding(new Insets(13));
        h10.setPadding(new Insets(13));
        h11.setPadding(new Insets(13));
        h12.setPadding(new Insets(13));
        h13.setPadding(new Insets(5));
        h14.setPadding(new Insets(13));
        // Set HBoxes spacings
        h2.setSpacing(50);
        h3.setSpacing(90);
        h6.setSpacing(90);
        h7.setSpacing(50);
        h8.setSpacing(90);
        h9.setSpacing(90);
        h10.setSpacing(90);
        h11.setSpacing(90);
        h12.setSpacing(90);
        h13.setSpacing(50);
        h14.setSpacing(90);

// Set background color for VBox containers
        h1.setStyle("-fx-background-color: LightGrey;"); // Light grey
        h2.setStyle("-fx-background-color: LightGrey;");
        h3.setStyle("-fx-background-color: LightGrey;");
        h4.setStyle("-fx-background-color: LightGrey;");
        h5.setStyle("-fx-background-color: LightGrey;");
        h6.setStyle("-fx-background-color: LightGrey;");
        h7.setStyle("-fx-background-color: LightGrey;");
        h8.setStyle("-fx-background-color: LightGrey;");
        h9.setStyle("-fx-background-color: LightGrey;");
        h10.setStyle("-fx-background-color:LightGrey;");
        h11.setStyle("-fx-background-color: LightGrey;");
        h12.setStyle("-fx-background-color: LightGrey;");
        h13.setStyle("-fx-background-color: LightGrey;");

        this.getChildren().addAll(h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13, h14);

    }

    void addComponent(Node node) {
        HelloApplication.workingSpace.getChildren().add(node);
        node.setOnMouseClicked(event -> {
            if (Objects.equals(ToolBar.tool, "Delete")) {
                HelloApplication.workingSpace.getChildren().remove(node);
            }
        });
    }
}