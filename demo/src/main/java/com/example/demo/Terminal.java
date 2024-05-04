package com.example.demo;

import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Terminal extends Circle {
    //create shadows
    DropShadow shadow;
    private boolean state = false;
    public Terminal(boolean isOutput) {
        super();
        // Set properties of the shadow
        shadow = new DropShadow();
        shadow.setColor(Color.CYAN);
        shadow.setRadius(15);
        shadow.setSpread(.1);
        //style the circle
        setRadius(6);
        setFill(Color.GRAY);
    }


    public void setState(boolean state) {
        this.state = state;
        updateStyle();
    }
    //update the appearance according to the state
    private void updateStyle () {
        if (state) {
        setFill(Color.DARKCYAN);
        setEffect(shadow);
        } else {
            setFill(Color.GRAY);
            setEffect(null);
        }
    }


}
