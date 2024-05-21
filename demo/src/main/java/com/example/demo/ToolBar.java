package com.example.demo;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Objects;

public class ToolBar extends HBox {
    public static String tool = "Drag";
    Button setDrag;
    Button setConnect;
    Button setDelete;
    Button setRotateLeft;
    Button setDisconnect;
    Button clearBtn;
    public ToolBar() {
        super();
        //create label
        Pane titleContainer = new Pane();
        Label title = new Label("LogicSim");
        title.setTextFill(Color.WHITE);
        title.setFont(Font.font("System", FontWeight.BOLD, 20));
        titleContainer.getChildren().add(title);
        titleContainer.setPadding(new Insets(0, 140,0 , 0));
        //create buttons
        setDrag = new Button();
        setConnect = new Button();
        setDelete = new Button();
        setRotateLeft = new Button();
        setDisconnect = new Button();
        clearBtn = new Button();
        //create images for button icons
        ImageView connectIcon = new ImageView(new Image("connect.png"));
        ImageView moveIcon = new ImageView(new Image("move.png"));
        ImageView deleteIcon = new ImageView(new Image("delete.png"));
        ImageView rotateIcon = new ImageView(new Image("rotateIcon.png"));
        ImageView disconnectIcon = new ImageView(new Image("disconnect.png"));
        ImageView clearIcon = new ImageView(new Image("clear.png"));
        connectIcon.setFitHeight(20);
        connectIcon.setFitWidth(20);
        moveIcon.setFitHeight(20);
        moveIcon.setFitWidth(20);
        deleteIcon.setFitHeight(20);
        deleteIcon.setFitWidth(20);
        rotateIcon.setFitHeight(20);
        rotateIcon.setFitWidth(20);
        disconnectIcon.setFitHeight(20);
        disconnectIcon.setFitWidth(20);
        clearIcon.setFitHeight(20);
        clearIcon.setFitWidth(20);
        //add icons to buttons
        setDrag.setBackground(null);
        setDrag.setStyle("-fx-background-color: lightblue;");
        setConnect.setBackground(null);
        setDrag.setGraphic(moveIcon);
        setDelete.setBackground(null);
        setDelete.setGraphic(deleteIcon);
        setConnect.setGraphic(connectIcon);
        setRotateLeft.setBackground(null);
        setRotateLeft.setGraphic(rotateIcon);
        setDisconnect.setBackground(null);
        setDisconnect.setGraphic(disconnectIcon);
        clearBtn.setGraphic(clearIcon);
        clearBtn.setBackground(null);
        clearBtn.setStyle("-fx-background-color: lightblue;");

        //handle button actions
        setDrag.setOnAction(e -> {
            updateState("Drag");
        });
        setConnect.setOnAction(e -> {
            updateState("Connect");
        });
        setDelete.setOnAction(e -> {
            updateState("Delete");
        });
        setRotateLeft.setOnAction(e -> {
            updateState("RotateLeft");
        });
        setDisconnect.setOnAction(e -> {
            updateState("Disconnect");
        });
        clearBtn.setOnAction(e -> {
            HelloApplication.workingSpace.getChildren().clear();
        });
        //adjust the menu layout
        setPadding(new Insets(8,10,8,30 ));
        setBackground(new Background(new BackgroundFill(Color.web("#2B2D30"), null, null)));
        setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(setConnect, javafx.scene.layout.Priority.ALWAYS);
        HBox.setHgrow(setDrag, javafx.scene.layout.Priority.ALWAYS);
        HBox.setHgrow(setDelete, javafx.scene.layout.Priority.ALWAYS);
        //add buttons to the toolbar
        setSpacing(10);
        getChildren().addAll(titleContainer,setDrag, setConnect,setDisconnect, setDelete, setRotateLeft, clearBtn);

    }
    //click handler
    void updateState (String state) {
        tool = state;
        if (Objects.equals(state, "Drag")) {
            setDrag.setStyle("-fx-background-color: lightblue;");
            setConnect.setStyle("-fx-background-color: transparent;");
            setDelete.setStyle("-fx-background-color: transparent;");
            setRotateLeft.setStyle("-fx-background-color: transparent;");
            setDisconnect.setStyle("-fx-background-color: transparent;");
        } else if (Objects.equals(state, "Connect")) {
            setConnect.setStyle("-fx-background-color: lightblue;");
            setDrag.setStyle("-fx-background-color: transparent;");
            setDelete.setStyle("-fx-background-color: transparent;");
            setRotateLeft.setStyle("-fx-background-color: transparent;");
            setDisconnect.setStyle("-fx-background-color: transparent;");

        } else if (Objects.equals(state, "Delete")) {
            setDelete.setStyle("-fx-background-color: lightblue;");
            setDrag.setStyle("-fx-background-color: transparent;");
            setConnect.setStyle("-fx-background-color: transparent;");
            setRotateLeft.setStyle("-fx-background-color: transparent;");
            setDisconnect.setStyle("-fx-background-color: transparent;");
        } else if (Objects.equals(state, "RotateLeft")) {
            setRotateLeft.setStyle("-fx-background-color: lightblue;");
            setDelete.setStyle("-fx-background-color: transparent;");
            setDrag.setStyle("-fx-background-color: transparent;");
            setConnect.setStyle("-fx-background-color: transparent;");
            setDisconnect.setStyle("-fx-background-color: transparent;");
        } else if (Objects.equals(state, "Disconnect")) {
            setDisconnect.setStyle("-fx-background-color: lightblue;");
            setRotateLeft.setStyle("-fx-background-color: transparent;");
            setConnect.setStyle("-fx-background-color: transparent;");
            setDrag.setStyle("-fx-background-color: transparent;");
            setDelete.setStyle("-fx-background-color: transparent;");

        }

    };
}
