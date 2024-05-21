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
    //line state
    boolean state = false;
    public Wire() {
        super();
        setStrokeWidth(3);
        setStroke(Color.GRAY);
        setFill(Color.TRANSPARENT);
        setVisible(true);
    }

    //draw the line method
    public static void handleCircleClick(Terminal terminal) {
        if (Objects.equals(ToolBar.tool, "Connect")) {
            if (startCircle == null && terminal.isOutput && terminal.getConnectedWire() == null) {
                // First circle clicked, set it as the start point
                startCircle = terminal;
            } else if (!terminal.isOutput && startCircle != null && terminal.getConnectedWire() == null) {
                    // Second circle clicked, create a line between them
                    Wire wire = new Wire();
                    wire.setTerminal1(startCircle);
                    wire.setTerminal2(terminal);
                    wire.updateState();
                    // Reset start circle
                    HelloApplication.workingSpace.getChildren().add(wire);
                    // Reset start circle
                    startCircle = null;

            } else if (!terminal.isOutput) {
                Alertbox.showAlert("You can only connect output to input");
            } else if (terminal.getConnectedWire() != null ) {
                Alertbox.showAlert("This terminal is already connected\n if you want to connect multiple wires try using a splitter instead");
            }
        }
    }

    //add terminals to the line
    void setTerminal1 (Terminal terminal1) {
        this.terminal1 = terminal1;
        this.terminal1.setConnectWire(this);
        NodePositionProperty terminalPosition = new NodePositionProperty(terminal1);
        //set starting points
        setStartX(terminalPosition.absoluteX() + 5);
        setStartY(terminalPosition.absoluteY());
        //set control1 properties
        setControlX1(terminalPosition.absoluteX() + 50);
        setControlY1(terminalPosition.absoluteY());

    }
    void setTerminal2 (Terminal terminal2) {
        this.terminal2 = terminal2;
        this.terminal2.setConnectWire(this);
        NodePositionProperty terminal2Position = new NodePositionProperty(terminal2);
        //set starting points
        setEndX(terminal2Position.absoluteX() + 3);
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
    //update the state
    void updateState () {
        this.state = terminal1.state;
        this.terminal2.setState(this.state);
        if (this.state) {
            setStroke(Color.DARKCYAN);
        } else {
            setStroke(Color.GRAY);
        }
    }

    public void removeLine () {
        this.terminal2.setState(false);
        this.terminal1.setConnectWire(null);
        this.terminal2.setConnectWire(null);
        HelloApplication.workingSpace.getChildren().remove(this);
    }

}
