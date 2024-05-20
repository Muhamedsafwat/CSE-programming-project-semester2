package com.example.demo;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Light;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.Objects;

public class Terminal extends Circle {
    NOTGate parentNot;
    Splitter parentSplitter;
    Gate parentGate;
    LightPulb parentLight;
    FullAdder parentFullAdder;
    HalfAdder parentHalfAdder;
    Multiplexer4to1 parentMultiplexer;
    private Wire connectedWire = null;
    boolean state = false;
    boolean isOutput = false;

    //create shadows
    DropShadow shadow;

    public Terminal(boolean isOutput) {
        super();
        // Set properties of the shadow
        shadow = new DropShadow();
        shadow.setColor(Color.CYAN);
        shadow.setRadius(15);
        shadow.setSpread(.1);
        this.isOutput = isOutput;
        //style the circle
        setRadius(6);
        setFill(Color.GRAY);
    }

    public void setState(boolean state) {
        this.state = state;
        if (connectedWire != null && this.isOutput) {
            connectedWire.updateState();
        }
        if (parentNot != null) {
            parentNot.updateInputs();
            parentNot.updateOutput();
        }
        if (parentSplitter != null) {
            parentSplitter.updateInputs();
            parentSplitter.updateOutput();
        }
        if (parentGate != null) {
            parentGate.updateInputs();
            parentGate.updateOutput();
        }
        if (parentLight != null) {
            parentLight.updateInputs();
        }
        if (parentFullAdder != null) {
            parentFullAdder.updateOutputs();
        }
        if (parentHalfAdder != null) {
            parentHalfAdder.updateOutputs();
        }
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
    }
    public Wire getConnectedWire () {
        return this.connectedWire;
    }
    void setParentNot (NOTGate parent) {
        this.parentNot = parent;
    }
    void setParentSplitter (Splitter splitter) {
        this.parentSplitter = splitter;
    }
    void setParentGate (Gate parentGate) {
        this.parentGate = parentGate;
    }
    void setParentLight (LightPulb lightPulb) {
        this.parentLight = lightPulb;
    }
    void setParentFullAdder (FullAdder fullAdder) {
        this.parentFullAdder = fullAdder;
    }
    void setParentHalfAdder (HalfAdder halfAdder) {
        this.parentHalfAdder = halfAdder;
    }
    void setParentMultiplexer(Multiplexer4to1 multiplexer) {
        this.parentMultiplexer = multiplexer;
    }

    public void setParentMultiplexer4to1(Multiplexer4to1 multiplexer4to1) {

    }
}
