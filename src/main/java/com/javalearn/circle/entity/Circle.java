package com.javalearn.circle.entity;

public class Circle {
    private Point centre;
    private double radius;


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

    public void setCentre(Point modifiedPoint) {
        this.centre = modifiedPoint;
    }

    public void setRadius(double modifiedRadius) {
        this.radius = modifiedRadius;
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
