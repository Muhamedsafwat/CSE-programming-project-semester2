package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class IntToBits extends HBox {

 public    int[] bitss = new int[8];
   public boolean[] statess = new boolean[8];
public int number;

  Terminal OutPut1,OutPut2,OutPut3,OutPut4,OutPut5,OutPut6,OutPut7,OutPut8;

 public IntToBits(){

  OutPut1 = new Terminal(true);
  OutPut2 = new Terminal(true);
  OutPut3 = new Terminal(true);
  OutPut4 = new Terminal(true);
  OutPut5 = new Terminal(true);
  OutPut6 = new Terminal(true);
  OutPut7 = new Terminal(true);
  OutPut8 = new Terminal(true);

     TextField field = new TextField();
     field.setAlignment(Pos.CENTER);
     field.setMaxWidth(50);
     field.setTranslateX(10);
     VBox V1 = new VBox(OutPut1,OutPut2,OutPut3,OutPut4,OutPut5,OutPut6,OutPut7,OutPut8);
     V1.setAlignment(Pos.CENTER);
     V1.setSpacing(7);
     ImageView image = new ImageView("8-bit Digit.png");
     Button b1 = new Button("Enter ");
     b1.setAlignment(Pos.TOP_RIGHT);
     b1.setTranslateY(-50);
     b1.setTranslateX(9);
     b1.setMaxWidth(50);
     StackPane S = new StackPane(image,field,b1);
     getChildren().addAll(V1,S);
            b1.setOnMouseClicked(e->{
                number = Integer.parseInt(field.getText());
                bitss  = intToBits(number);
                for(int i=0 ; i<8 ; i++) {
                    if (bitss[i] == 1) {
                        statess[i] = true ;
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
            }  );
                   }
    public  int[] intToBits(int number) {
        int[] bits = new int[8];
        for (int i = 7; i >= 0; i--) {
            bits[i] = (number & (1 << i)) != 0 ? 1 : 0;
        }
        return bits;
    }
}
