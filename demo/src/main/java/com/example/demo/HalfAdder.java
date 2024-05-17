package com.example.demo;

import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class HalfAdder extends HBox {

  Terminal A;
  Terminal B;
  Terminal S;
  Terminal Cout;
  double startX;
  double startY;

  public  HalfAdder(){


    A = new Terminal(false);
    A.setParentHalfAdder(this);
    B = new Terminal(false);
    B.setParentHalfAdder(this);
    S = new Terminal(true);
    Cout = new Terminal(true);

    VBox V1 = new VBox(A,B);
    V1.setAlignment(Pos.CENTER);
    V1.setSpacing(17);

    VBox V2 = new VBox(S,Cout);
    V2.setAlignment(Pos.CENTER);
    V2.setSpacing(17);
    ImageView image = new ImageView("HalfAdder.PNG");
    image.setFitHeight(70);
    image.setFitWidth(125);

    //drag and drop functionality
    setTranslateX(10);
    setTranslateY(10);
    setOnMousePressed(e -> { if (Objects.equals(ToolBar.tool, "Drag")) {
      startX = e.getSceneX() - getTranslateX();
      startY = e.getSceneY() - getTranslateY();
    } else if (Objects.equals(ToolBar.tool, "Delete")) {
      HelloApplication.workingSpace.getChildren().remove(this);
      if (A.getConnectedWire() != null) {
        A.getConnectedWire().removeLine();
      }
      if (B.getConnectedWire() != null) {
        B.getConnectedWire().removeLine();
      }
      if (S.getConnectedWire() != null) {
        S.getConnectedWire().removeLine();
      }
      if (Cout.getConnectedWire() != null) {
        Cout.getConnectedWire().removeLine();
      }
    } else if (Objects.equals(ToolBar.tool, "RotateLeft")) {
      setRotate(getRotate() - 90);
      if (A.getConnectedWire() != null) {
        A.getConnectedWire().updatePosition();
      }
      if (B.getConnectedWire() != null) {
        B.getConnectedWire().updatePosition();
      }
      if (S.getConnectedWire() != null) {
        S.getConnectedWire().updatePosition();
      }
      if (Cout.getConnectedWire() != null) {
        Cout.getConnectedWire().updatePosition();
      }
    }
    });
    //drag and drop
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
        if (A.getConnectedWire() != null) {
          A.getConnectedWire().updatePosition();
        }
        if (B.getConnectedWire() != null) {
          B.getConnectedWire().updatePosition();
        }
        if (S.getConnectedWire() != null) {
          S.getConnectedWire().updatePosition();
        }
        if (Cout.getConnectedWire() != null) {
          Cout.getConnectedWire().updatePosition();
        }
      }
    });

    //terminals actions
    this.A.setOnMouseClicked(event ->  {if ( Objects.equals(ToolBar.tool, "Connect")) {
      Wire.handleCircleClick(this.A);
    } else if (Objects.equals(ToolBar.tool, "Disconnect") && this.A.getConnectedWire() != null) {
      A.getConnectedWire().removeLine();
      this.updateOutputs();
    }
    });
    this.B.setOnMouseClicked(event ->  {if ( Objects.equals(ToolBar.tool, "Connect")) {
      Wire.handleCircleClick(this.B);
    } else if (Objects.equals(ToolBar.tool, "Disconnect") && this.B.getConnectedWire() != null) {
      B.getConnectedWire().removeLine();
      this.updateOutputs();
    }
    });
    this.S.setOnMouseClicked(event ->  {if ( Objects.equals(ToolBar.tool, "Connect")) {
      Wire.handleCircleClick(this.S);
    } else if (Objects.equals(ToolBar.tool, "Disconnect") && this.S.getConnectedWire() != null) {
      S.getConnectedWire().removeLine();
      this.updateOutputs();
    }
    });
    this.Cout.setOnMouseClicked(event ->  {if ( Objects.equals(ToolBar.tool, "Connect")) {
      Wire.handleCircleClick(this.Cout);
    } else if (Objects.equals(ToolBar.tool, "Disconnect") && this.Cout.getConnectedWire() != null) {
      Cout.getConnectedWire().removeLine();
      this.updateOutputs();
    }
    });

    getChildren().addAll(V1,image,V2);
  }

  void updateOutputs () {
    S.setState(A.state ^ B.state);
    Cout.setState(A.state && B.state);
  }
}
