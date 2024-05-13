package com.example.demo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;
import javafx.scene.Node;

public class NodePositionProperty {

   private double absoluteStartCenterX;
   private double absoluteStartCenterY;
    public NodePositionProperty(Terminal terminal) {
        //get the absolute coordinates of the start terminals center
        double startCenterX = terminal.getCenterX();
        double startCenterY = terminal.getCenterY();
        Point2D startCenter = terminal.localToScene(startCenterX, startCenterY);
         absoluteStartCenterX = startCenter.getX() - 253;
         absoluteStartCenterY = startCenter.getY() - 46;

    }

    public double absoluteX() {
        return absoluteStartCenterX;
    }

    public double absoluteY() {
        return absoluteStartCenterY;
    }
}
