package com.javalearn.circle.logic;

import com.javalearn.circle.entity.Circle;
import com.javalearn.circle.entity.CoordinateAxes;
import com.javalearn.circle.entity.Point;

public class Calculator {

    public boolean isCircle (Point centre, double radius){
        return radius > 0;
    }

    public double calculateArea(Circle circle){
        return Math.PI * Math.pow(circle.getRadius(), 2);
    }

    public boolean isCrossingAreaOnDistance (Circle circle, double distance, CoordinateAxes axis){

        double minimalCirclePoint;
        double maximalCirclePoint;
        Point centre = circle.getCentre();;

        if (axis == CoordinateAxes.X_AXIS){

            minimalCirclePoint = centre.getYCoordinate() - circle.getRadius();
            maximalCirclePoint = centre.getYCoordinate() + circle.getRadius();
        }
        else { //(axis == Axis.Y_AXIS){
            minimalCirclePoint = centre.getXCoordinate() - circle.getRadius();
            maximalCirclePoint = centre.getXCoordinate() + circle.getRadius();
        }

        boolean circleCrossing = false;
        boolean circleCrossingOnDistance = false;
        if (minimalCirclePoint < 0  & maximalCirclePoint > 0)  {
            circleCrossing  = true;
        }

        if (circleCrossing){
            double minimalDistanceFromCirclePointToAxis =
                    Math.min ( Math.abs(minimalCirclePoint), Math.abs(maximalCirclePoint));

            if (distance <= minimalDistanceFromCirclePointToAxis) {
                circleCrossingOnDistance = true;
            }
        }
        return circleCrossingOnDistance;
    }
}

