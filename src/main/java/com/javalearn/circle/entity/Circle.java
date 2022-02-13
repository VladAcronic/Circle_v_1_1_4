package com.javalearn.circle.entity;

public class Circle {
    private final Point centre;
    private final double radius;

    public Circle (Point centre, double radius){
        this.centre = centre;
        this.radius = radius;
    }
    public Point getCentre (){
        return centre;
    }

    public double getRadius(){
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Circle anotherCircle = (Circle) o;
        return Double.compare(anotherCircle.radius, this.radius) == 0 &&
                this.centre.equals(anotherCircle.centre);
    }

}
