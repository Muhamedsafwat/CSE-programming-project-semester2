package com.example.demo;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.Objects;

public class Terminal extends Circle {
    private Wire connectedWire = null;
    boolean state = false;

    //create shadows
    DropShadow shadow;

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
    public void updateStyle () {
        if (state) {
        setFill(Color.DARKCYAN);
        setEffect(shadow);
        } else {
            setFill(Color.GRAY);
            setEffect(null);
        }

    }

    public void setConnectWire(Wire wire) {
        this.connectedWire = wire;
        System.out.println("setConnectWire is fired states is");
    }
    public Wire getConnectedWire () {
        return this.connectedWire;
    }



}
