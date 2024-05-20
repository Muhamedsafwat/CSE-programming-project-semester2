package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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

public class ComponentsList extends ScrollPane {
    VBox container = new VBox();
    public ComponentsList() {
        super();
        setFitToHeight(true);
        setFitToWidth(true);
        // Create buttons
        Button bt1 = new Button("Input Controls");
        Button bt7 = new Button("Output Controls");
        Button bt10 = new Button("Logic Gates");
        Button bt11 = new Button("Other Components");
        //NOT
        VBox NOTBtn = new VBox();
        Label NOTLabel = new Label("NOT");
        NOTLabel.setFont(Font.font("", FontWeight.BOLD, 12));
        ImageView NOT = new ImageView(new Image("NOT-list.png"));
        NOT.setFitHeight(40);
        NOT.setFitWidth(70);
        NOTBtn.getChildren().addAll(NOT, NOTLabel);
        NOTBtn.setAlignment(Pos.CENTER);
        NOTBtn.setOnMouseClicked(e -> {
            addComponent(new NOTGate());
        });
        //AND
        VBox ANDBtn = new VBox();
        Label ANDBLabel = new Label("AND");
        ANDBLabel.setFont(Font.font("", FontWeight.BOLD, 12));
        ImageView AND = new ImageView(new Image("AND-list.png"));
        AND.setFitHeight(40);
        AND.setFitWidth(70);
        ANDBtn.getChildren().addAll(AND, ANDBLabel);
        ANDBtn.setAlignment(Pos.CENTER);
        ANDBtn.setOnMouseClicked(e -> {
            addComponent(new ANDGate());
        });
        //NAND
        VBox NANDBtn = new VBox();
        Label NANLabel = new Label("NAND");
        NANLabel.setFont(Font.font("", FontWeight.BOLD, 12));
        ImageView NAND = new ImageView(new Image("NAND-list.png"));
        NAND.setFitHeight(40);
        NAND.setFitWidth(70);
        NANDBtn.getChildren().addAll(NAND, NANLabel);
        NANDBtn.setAlignment(Pos.CENTER);
        NANDBtn.setOnMouseClicked(e -> {
            addComponent(new NANDGate());
        });
        //NOR
        VBox NORBtn = new VBox();
        Label NORLabel = new Label("NOR");
        NORLabel.setFont(Font.font("", FontWeight.BOLD, 12));
        ImageView NOR = new ImageView(new Image("NOR-list.png"));
        NOR.setFitHeight(40);
        NOR.setFitWidth(70);
        NORBtn.getChildren().addAll(NOR, NORLabel);
        NORBtn.setAlignment(Pos.CENTER);
        NORBtn.setOnMouseClicked(e -> {
            addComponent(new NORGate());
        });
        //OR
        VBox ORBtn = new VBox();
        Label ORLabel = new Label("OR");
        ORLabel.setFont(Font.font("", FontWeight.BOLD, 12));
        ImageView OR = new ImageView(new Image("OR-list.png"));
        OR.setFitHeight(40);
        OR.setFitWidth(70);
        ORBtn.getChildren().addAll(OR, ORLabel);
        ORBtn.setAlignment(Pos.CENTER);
        ORBtn.setOnMouseClicked(e -> {
            addComponent(new ORGate());
        });
        //XNOR
        VBox XNORBtn = new VBox();
        Label XNORLabel = new Label("XNOR");
        XNORLabel.setFont(Font.font("", FontWeight.BOLD, 12));
        ImageView XNOR = new ImageView(new Image("XNOR-list.png"));
        XNOR.setFitHeight(40);
        XNOR.setFitWidth(70);
        XNORBtn.getChildren().addAll(XNOR, XNORLabel);
        XNORBtn.setAlignment(Pos.CENTER);
        XNORBtn.setOnMouseClicked(e -> {
            addComponent(new XNORGate());
        });
        //XOR
        VBox XORBtn = new VBox();
        Label XORLabel = new Label("XOR");
        XORLabel.setFont(Font.font("", FontWeight.BOLD, 12));
        ImageView XOR = new ImageView(new Image("XOR-list.png"));
        XOR.setFitHeight(40);
        XOR.setFitWidth(70);
        XORBtn.getChildren().addAll(XOR, XORLabel);
        XORBtn.setAlignment(Pos.CENTER);
        XORBtn.setOnMouseClicked(e -> {
            addComponent(new XORGate());
        });
        //Lamb
        VBox LEDBtn = new VBox();
        Label LEDBLabel = new Label("Led");
        LEDBLabel.setFont(Font.font("", FontWeight.BOLD, 12));
        ImageView LED = new ImageView(new Image("Lamp OFF.png"));
        LED.setFitHeight(42);
        LED.setFitWidth(51);
        LEDBtn.getChildren().addAll(LED, LEDBLabel);
        LEDBtn.setAlignment(Pos.CENTER);
        LEDBtn.setOnMouseClicked(e -> addComponent(new LightPulb()));
        //8-bit converter
        VBox _8bitBtn = new VBox();
        Label _8bitLabel = new Label("8-bit display");
        _8bitLabel.setFont(Font.font("", FontWeight.BOLD, 12));
        ImageView BIT = new ImageView(new Image("8bit-list.png"));
        BIT.setFitHeight(42);
        BIT.setFitWidth(60);
        _8bitBtn.getChildren().addAll(BIT, _8bitLabel);
        _8bitBtn.setAlignment(Pos.CENTER);
        _8bitBtn.setOnMouseClicked(e -> addComponent(new _8bit_converter()));
        //const low
        VBox constLowBtn = new VBox();
        Label constLowLabel = new Label("Const Low");
        constLowLabel.setFont(Font.font("", FontWeight.BOLD, 12));
        ImageView LOW = new ImageView(new Image("ConstLow-list.png"));
        LOW.setFitHeight(39);
        LOW.setFitWidth(52);
        constLowBtn.getChildren().addAll(LOW, constLowLabel);
        constLowBtn.setAlignment(Pos.CENTER);
        constLowBtn.setOnMouseClicked(e -> addComponent(new ConstOutput(false)));
        //const high
        VBox constHighBtn = new VBox();
        Label constHighLabel = new Label("Const High");
        constHighLabel.setFont(Font.font("", FontWeight.BOLD, 12));
        ImageView HIGH = new ImageView(new Image("ConstHigh-list.png"));
        HIGH.setFitHeight(39);
        HIGH.setFitWidth(52);
        constHighBtn.getChildren().addAll(HIGH, constHighLabel);
        constHighBtn.setAlignment(Pos.CENTER);
        constHighBtn.setOnMouseClicked(e -> addComponent(new ConstOutput(true)));
        //switch
        VBox SwitchBtn = new VBox();
        Label SwitchLabel = new Label("Toggle Switch");
        SwitchLabel.setFont(Font.font("", FontWeight.BOLD, 12));
        ImageView Switch = new ImageView(new Image("switch-list.png"));
        Switch.setFitHeight(30);
        Switch.setFitWidth(60);
        SwitchBtn.getChildren().addAll(Switch, SwitchLabel);
        SwitchBtn.setAlignment(Pos.CENTER);
        SwitchBtn.setOnMouseClicked(e -> addComponent(new Switch()));
        //full adder
        VBox fullAdderBtn = new VBox();
        Label fullAdderLabel = new Label("Full Adder");
        fullAdderLabel.setFont(Font.font("", FontWeight.BOLD, 12));
        ImageView fullAdder = new ImageView(new Image("FullAdder-list.PNG"));
        fullAdder.setFitHeight(40);
        fullAdder.setFitWidth(70);
        fullAdderBtn.getChildren().addAll(fullAdder, fullAdderLabel);
        fullAdderBtn.setAlignment(Pos.CENTER);
        fullAdderBtn.setOnMouseClicked(e -> addComponent(new FullAdder()));
        //half adder
        VBox halfAdderBtn = new VBox();
        Label halfAdderLabel = new Label("Half Adder");
        halfAdderLabel.setFont(Font.font("", FontWeight.BOLD, 12));
        ImageView halfAdder = new ImageView(new Image("HalfAdder-list.PNG"));
        halfAdder.setFitHeight(40);
        halfAdder.setFitWidth(70);
        halfAdderBtn.getChildren().addAll(halfAdder, halfAdderLabel);
        halfAdderBtn.setAlignment(Pos.CENTER);
        halfAdderBtn.setOnMouseClicked(e -> addComponent(new HalfAdder()));
        //Splitter
        VBox SplitterBtn = new VBox();
        Label SplitterLabel = new Label("Splitter");
        SplitterLabel.setFont(Font.font("", FontWeight.BOLD, 12));
        ImageView splitter = new ImageView(new Image("splitter-list.PNG"));
        splitter.setFitHeight(40);
        splitter.setFitWidth(70);
        SplitterBtn.getChildren().addAll(splitter, SplitterLabel);
        SplitterBtn.setAlignment(Pos.CENTER);
        SplitterBtn.setOnMouseClicked(e -> addComponent(new Splitter()));
        //Multiplexer
        VBox MUX = new VBox();
        Label muxLabel = new Label("Multiplexer");
        muxLabel.setFont(Font.font("", FontWeight.BOLD, 12));
        ImageView mux = new ImageView(new Image("Mux.png"));
        mux.setFitHeight(60);
        mux.setFitWidth(40);
        MUX.getChildren().addAll(mux, muxLabel);
        MUX.setAlignment(Pos.CENTER);
        MUX.setOnMouseClicked(e -> addComponent(new Multiplexer4to1()));

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
        h2.getChildren().addAll(SwitchBtn);
        h3.getChildren().addAll(constLowBtn, constHighBtn);
        h6.getChildren().addAll(LEDBtn, _8bitBtn);
        h5.getChildren().addAll(bt7);
        h7.getChildren().addAll(bt10);
        h8.getChildren().addAll(NOTBtn, ANDBtn);
        h9.getChildren().addAll(NANDBtn, ORBtn);
        h10.getChildren().addAll(NORBtn, XORBtn);
        h11.getChildren().addAll(XNORBtn, halfAdderBtn);
        h12.getChildren().addAll(fullAdderBtn);
        h13.getChildren().add(bt11);
        h14.getChildren().addAll(SplitterBtn, MUX);
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

        container.getChildren().addAll(h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13, h14);
        container.setAlignment(Pos.CENTER);
        container.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
        container.setPrefWidth(253);
        container.setPrefHeight(2000);
        setPrefHeight(1000);
        setPrefWidth(300);
        setContent(container);
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