package com.example.demo;

import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;

import java.util.Objects;

public class Wire extends CubicCurve {
    //for drawing the line
    public static Terminal startCircle;
    //bind properties in the drawn line
    Terminal terminal1;
    Terminal terminal2;
    public Wire() {
        super();
        setStrokeWidth(2);
        setStroke(Color.BLACK);
        setFill(Color.TRANSPARENT);
        setVisible(true);
    }

    //draw the line method
    public static void handleCircleClick(Terminal terminal) {
        if (Objects.equals(ToolBar.tool, "Connect")) {
            if (startCircle == null) {
                // First circle clicked, set it as the start point
                startCircle = terminal;
            } else {
                // Second circle clicked, create a line between them
                Wire wire = new Wire();
                terminal.setState(startCircle.state);
                wire.setTerminal1(startCircle);
                wire.setTerminal2(terminal);
                // Reset start circle
                HelloApplication.workingSpace.getChildren().add(wire);
                // Reset start circle
                startCircle = null;
            }
        }
    }

    //add terminals to the line
    void setTerminal1 (Terminal terminal1) {
        this.terminal1 = terminal1;
        terminal1.setConnectWire(this);
        NodePositionProperty terminalPosition = new NodePositionProperty(terminal1);
        //set starting points
        setStartX(terminalPosition.absoluteX());
        setStartY(terminalPosition.absoluteY());
        //set control1 properties
        setControlX1(terminalPosition.absoluteX() + 50);
        setControlY1(terminalPosition.absoluteY());

    }
    void setTerminal2 (Terminal terminal2) {
        this.terminal2 = terminal2;
        terminal2.setConnectWire(this);
        NodePositionProperty terminal2Position = new NodePositionProperty(terminal2);
        //set starting points
        setEndX(terminal2Position.absoluteX());
        setEndY(terminal2Position.absoluteY());
        //set control2 properties
        setControlX2(terminal2Position.absoluteX() - 50);
        setControlY2(terminal2Position.absoluteY());
    }
    //update new positions when the gate is dropped
    public void updatePosition () {
        this.setTerminal1(terminal1);
        this.setTerminal2(terminal2);
    }

}
