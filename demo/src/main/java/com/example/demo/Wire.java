package com.example.demo;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.Objects;

public class Wire extends Line {
    //for drawing the line
    public static Terminal startCircle;
    //bind properties in the drawn line
    Terminal terminal1;
    Terminal terminal2;
    public Wire(double absoluteStartCenterX, double absoluteStartCenterY, double absoluteEndCenterX, double absoluteEndCenterY) {
        super(absoluteStartCenterX,absoluteStartCenterY,absoluteEndCenterX,absoluteEndCenterY);
        setStrokeWidth(2);
        setStroke(Color.BLACK);
        setVisible(true);
    }

    //draw the line method
    public static void handleCircleClick(Terminal terminal) {
        if (Objects.equals(ToolBar.tool, "Connect")) {
            if (startCircle == null) {
                // First circle clicked, set it as the start point
                startCircle = terminal;
            } else {
                //get the absolute coordinates of the start terminals center
                double startCenterX = startCircle.getCenterX();
                double startCenterY = startCircle.getCenterY();
                Point2D startCenter = startCircle.localToScene(startCenterX, startCenterY);
                double absoluteStartCenterX = startCenter.getX() - 253;
                double absoluteStartCenterY = startCenter.getY() - 46;
                //get the absolute coordinates of the end terminals center
                double endCenterX = terminal.getCenterX();
                double endCenterY = terminal.getCenterY();
                Point2D endCenter = terminal.localToScene(endCenterX, endCenterY);
                double absoluteEndCenterX = endCenter.getX() - 253;
                double absoluteEndCenterY = endCenter.getY() - 46;
                // Second circle clicked, create a line between them
                Wire wire = new Wire(absoluteStartCenterX, absoluteStartCenterY,
                        absoluteEndCenterX, absoluteEndCenterY);
                terminal.setState(startCircle.state);
                // Reset start circle
                System.out.println(startCircle.state);
                System.out.println(terminal.state);
                HelloApplication.workingSpace.getChildren().add(wire);
                // Reset start circle
                startCircle = null;
            }
        }
    }


}
