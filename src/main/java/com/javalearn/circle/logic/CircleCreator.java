package com.javalearn.circle.logic;

import com.javalearn.circle.entity.Circle;
import com.javalearn.circle.entity.Point;

public class CircleCreator {
    private final String DELIMITER = "\\s+";

    public Circle createCircle (String line){

        String[] tokensNumber = line.split(DELIMITER);

        double radius = Double.parseDouble(tokensNumber[0]);
        double xCoordinate = Double.parseDouble(tokensNumber[1]);
        double yCoordinate = Double.parseDouble(tokensNumber[2]);

        Point centre = new Point(xCoordinate, yCoordinate);
        Circle circle = new Circle(centre, radius);
        return circle;
    }
}
