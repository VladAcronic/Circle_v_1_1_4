package com.javalearn.circle.entity;

public class
Point {
    private final double xCoordinate;
    private final double yCoordinate;

    public Point (double xCoordinate, double yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public double getXCoordinate (){
        return this.xCoordinate;
    }

    public double getYCoordinate (){
        return this.yCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point anotherPoint = (Point) o;
        return Double.compare(anotherPoint.xCoordinate, this.xCoordinate) == 0 &&
                Double.compare(anotherPoint.yCoordinate, this.yCoordinate) == 0;
    }

}
