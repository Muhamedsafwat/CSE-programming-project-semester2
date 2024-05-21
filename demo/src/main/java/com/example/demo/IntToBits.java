package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.Objects;

public class IntToBits extends HBox {
 public int[] bitss = new int[8];
 public boolean[] statess = new boolean[8];
 public int number;
 double startY;
 double startX;

  Terminal OutPut1,OutPut2,OutPut3,OutPut4,OutPut5,OutPut6,OutPut7,OutPut8;
  public IntToBits(){
  OutPut1 = new Terminal(true);
  OutPut1.setRadius(4);
  OutPut2 = new Terminal(true);
  OutPut2.setRadius(4);
  OutPut3 = new Terminal(true);
  OutPut3.setRadius(4);
  OutPut4 = new Terminal(true);
  OutPut4.setRadius(4);
  OutPut5 = new Terminal(true);
  OutPut5.setRadius(4);
  OutPut6 = new Terminal(true);
  OutPut6.setRadius(4);
  OutPut7 = new Terminal(true);
  OutPut7.setRadius(4);
  OutPut8 = new Terminal(true);
  OutPut8.setRadius(4);

     TextField field = new TextField();
     field.setAlignment(Pos.CENTER);
     field.setMaxWidth(40);
     field.setTranslateX(-12);
     field.setTranslateY(10);
     field.setPadding(new Insets(0,0,0, 0));
     field.setBackground(null);
     field.setBorder(new Border(new BorderStroke(Color.BLACK,
             BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));

     VBox V1 = new VBox(OutPut1,OutPut2,OutPut3,OutPut4,OutPut5,OutPut6,OutPut7,OutPut8);
     V1.setAlignment(Pos.CENTER);
     V1.setSpacing(3);
     ImageView image = new ImageView("8bit.png");
      image.setFitWidth(70);
      image.setFitHeight(100);
      image.setScaleX(-1);
     Button b1 = new Button();
     b1.setAlignment(Pos.TOP_RIGHT);
     b1.setTranslateY(-20);
     b1.setTranslateX(-12);
     b1.setMaxWidth(40);
     ImageView plusIcon = new ImageView(new Image("plus.png"));
      plusIcon.setFitHeight(20);
      plusIcon.setFitWidth(20);
      b1.setBackground(null);
      b1.setGraphic(plusIcon);
     StackPane S = new StackPane(image,field,b1);
     getChildren().addAll(S, V1);
            b1.setOnMouseClicked(e->{
                if (!field.getText().isEmpty() && Integer.parseInt(field.getText()) < 256 && Integer.parseInt(field.getText()) >= 0 ) {
                number = Integer.parseInt(field.getText());
                    bitss = intToBits(number);
                    for (int i = 0; i < 8; i++) {
                        if (bitss[i] == 1) {
                            statess[i] = true;
                        } else {
                            statess[i] = false;
                        }
                    }
                    OutPut1.setState(statess[0]);
                    OutPut2.setState(statess[1]);
                    OutPut3.setState(statess[2]);
                    OutPut4.setState(statess[3]);
                    OutPut5.setState(statess[4]);
                    OutPut6.setState(statess[5]);
                    OutPut7.setState(statess[6]);
                    OutPut8.setState(statess[7]);
                } else {
                    Alertbox.showAlert("Please enter a number between 0 and 255");
                }
            });

      //drag and drop functionality
      setTranslateX(10);
      setTranslateY(10);
      setOnMousePressed(e -> { if (Objects.equals(ToolBar.tool, "Drag")) {
          startX = e.getSceneX() - getTranslateX();
          startY = e.getSceneY() - getTranslateY();
      } else if (Objects.equals(ToolBar.tool, "Delete")) {
          HelloApplication.workingSpace.getChildren().remove(this);
          if (OutPut1.getConnectedWire() != null) {
              OutPut1.getConnectedWire().removeLine();
             // this.updateInputs();
          }
          if (OutPut2.getConnectedWire() != null) {
              OutPut2.getConnectedWire().removeLine();
          }
          if (OutPut3.getConnectedWire() != null) {
              OutPut3.getConnectedWire().removeLine();
          }
          if (OutPut4.getConnectedWire() != null) {
              OutPut4.getConnectedWire().removeLine();
          }
          if (OutPut5.getConnectedWire() != null) {
              OutPut5.getConnectedWire().removeLine();
          }
          if (OutPut6.getConnectedWire() != null) {
              OutPut6.getConnectedWire().removeLine();
          }
          if (OutPut7.getConnectedWire() != null) {
              OutPut7.getConnectedWire().removeLine();
          }
          if (OutPut8.getConnectedWire() != null) {
              OutPut8.getConnectedWire().removeLine();
          }
      } else if (Objects.equals(ToolBar.tool, "RotateLeft")) {
          setRotate(getRotate() - 90);
          if (OutPut1.getConnectedWire() != null) {
              OutPut1.getConnectedWire().updatePosition();
          }
          if (OutPut2.getConnectedWire() != null) {
              OutPut2.getConnectedWire().updatePosition();
          }
          if (OutPut3.getConnectedWire() != null) {
              OutPut3.getConnectedWire().updatePosition();
          }
          if (OutPut4.getConnectedWire() != null) {
              OutPut4.getConnectedWire().updatePosition();
          }
          if (OutPut5.getConnectedWire() != null) {
              OutPut5.getConnectedWire().updatePosition();
          }
          if (OutPut6.getConnectedWire() != null) {
              OutPut6.getConnectedWire().updatePosition();
          }
          if (OutPut7.getConnectedWire() != null) {
              OutPut7.getConnectedWire().updatePosition();
          }
          if (OutPut8.getConnectedWire() != null) {
              OutPut8.getConnectedWire().updatePosition();
          }
      }
      });
      setOnMouseDragged(e -> {
          if (Objects.equals(ToolBar.tool, "Drag")) {
              setTranslateX(e.getSceneX() - startX);
              setTranslateY(e.getSceneY() - startY);
              if (OutPut1.getConnectedWire() != null) {
                  OutPut1.getConnectedWire().updatePosition();
              }
              if (OutPut2.getConnectedWire() != null) {
                  OutPut2.getConnectedWire().updatePosition();
              }
              if (OutPut3.getConnectedWire() != null) {
                  OutPut3.getConnectedWire().updatePosition();
              }
              if (OutPut4.getConnectedWire() != null) {
                  OutPut4.getConnectedWire().updatePosition();
              }
              if (OutPut5.getConnectedWire() != null) {
                  OutPut5.getConnectedWire().updatePosition();
              }
              if (OutPut6.getConnectedWire() != null) {
                  OutPut6.getConnectedWire().updatePosition();
              }
              if (OutPut7.getConnectedWire() != null) {
                  OutPut7.getConnectedWire().updatePosition();
              }
              if (OutPut8.getConnectedWire() != null) {
                  OutPut8.getConnectedWire().updatePosition();
              }
          }
      });

      this.OutPut1.setOnMouseClicked(event ->  {if ( Objects.equals(ToolBar.tool, "Connect")) {
          Wire.handleCircleClick(this.OutPut1);
      } else if (Objects.equals(ToolBar.tool, "Disconnect") && this.OutPut1.getConnectedWire() != null) {
          OutPut1.getConnectedWire().removeLine();
      }
      });
      this.OutPut2.setOnMouseClicked(event ->  {if (Objects.equals(ToolBar.tool, "Connect")) {
          Wire.handleCircleClick(this.OutPut2);
      }
      else if (Objects.equals(ToolBar.tool, "Disconnect") && this.OutPut2.getConnectedWire() != null) {
          OutPut2.getConnectedWire().removeLine();
      }
      });
      this.OutPut3.setOnMouseClicked(event ->  {if (Objects.equals(ToolBar.tool, "Connect")) {
          Wire.handleCircleClick(this.OutPut3);
      }
      else if (Objects.equals(ToolBar.tool, "Disconnect") && this.OutPut3.getConnectedWire() != null) {
          OutPut3.getConnectedWire().removeLine();
      }
      });
      this.OutPut4.setOnMouseClicked(event ->  {if (Objects.equals(ToolBar.tool, "Connect")) {
          Wire.handleCircleClick(this.OutPut4);
      }
      else if (Objects.equals(ToolBar.tool, "Disconnect") && this.OutPut4.getConnectedWire() != null) {
          OutPut4.getConnectedWire().removeLine();
      }
      });
      this.OutPut5.setOnMouseClicked(event ->  {if (Objects.equals(ToolBar.tool, "Connect")) {
          Wire.handleCircleClick(this.OutPut5);
      }
      else if (Objects.equals(ToolBar.tool, "Disconnect") && this.OutPut5.getConnectedWire() != null) {
          OutPut5.getConnectedWire().removeLine();
      }
      });
      this.OutPut6.setOnMouseClicked(event ->  {if (Objects.equals(ToolBar.tool, "Connect")) {
          Wire.handleCircleClick(this.OutPut6);
      }
      else if (Objects.equals(ToolBar.tool, "Disconnect") && this.OutPut6.getConnectedWire() != null) {
          OutPut6.getConnectedWire().removeLine();
      }
      });
      this.OutPut7.setOnMouseClicked(event ->  {if (Objects.equals(ToolBar.tool, "Connect")) {
          Wire.handleCircleClick(this.OutPut7);
      }
      else if (Objects.equals(ToolBar.tool, "Disconnect") && this.OutPut7.getConnectedWire() != null) {
          OutPut7.getConnectedWire().removeLine();
      }
      });
      this.OutPut8.setOnMouseClicked(event ->  {if (Objects.equals(ToolBar.tool, "Connect")) {
          Wire.handleCircleClick(this.OutPut8);
      }
      else if (Objects.equals(ToolBar.tool, "Disconnect") && this.OutPut8.getConnectedWire() != null) {
          OutPut8.getConnectedWire().removeLine();
      }
      });
  }

    public  int[] intToBits(int number) {
        int[] bits = new int[8];
        for (int i = 7; i >= 0; i--) {
            bits[i] = (number & (1 << i)) != 0 ? 1 : 0;
        }
        return bits;
    }
}

