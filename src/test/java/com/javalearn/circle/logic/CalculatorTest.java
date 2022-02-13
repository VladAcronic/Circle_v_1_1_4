package com.javalearn.circle.logic;


import com.javalearn.circle.entity.Circle;
import com.javalearn.circle.entity.CoordinateAxes;
import com.javalearn.circle.entity.Point;
import com.javalearn.circle.logic.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private final static double EPSILON = 0.0001;

    private static final Point testPoint = new Point(0.1, 0.2);
    private static final Circle testCircle = new Circle(testPoint, 2);

    private static final Point centreForIsCrossingByXAxis = new Point (10, 1);
    private static final Point centreForIsCrossingByYAxis = new Point (1, 10);
    private static final Circle circleForIsCrossingByXAxis = new Circle(centreForIsCrossingByXAxis, 2);
    private static final Circle circleForIsCrossingByYAxis = new Circle(centreForIsCrossingByYAxis, 2);

    private static final double distanceWhenPositive = 0.9;
    private static final double distanceWhenNegative = 1.5;


    private Calculator calculator = new Calculator();

    @Test
    public void testCalculateArea (){
        //given
        //when
        double circleAreaCalculated = calculator.calculateArea (testCircle);
        //then
        Assert.assertEquals(12.5664, circleAreaCalculated, EPSILON);
    }

    @Test
    public void testIsCircleWhenRadiusPositive (){
        //given
        double validRadius = 1.5;
        //when
        boolean checkResult = calculator.isCircle(testPoint, validRadius);
        //then
        Assert.assertTrue(checkResult);
    }

    @Test
    public void testIsCircleWhenRadiusZero (){
        //given
        double invalidRadius = 0;
        //when
        boolean checkResult = calculator.isCircle(testPoint, invalidRadius);
        //then
        Assert.assertFalse (checkResult);
    }

    @Test
    public void testIsCircleWhenRadiusNegative (){
        //given
        double invalidRadius = -1.5;
        //when
        boolean checkResult = calculator.isCircle(testPoint, invalidRadius);
        //then
        Assert.assertFalse (checkResult);
    }

    @Test
    public void testIsCrossingAreaOnDistanceByXAxisWhenPositive(){
        //given
        //when
        boolean checkResult = calculator.isCrossingAreaOnDistance(circleForIsCrossingByXAxis,
                distanceWhenPositive, CoordinateAxes.X_AXIS);
        //then
        Assert.assertTrue(checkResult);
    }
    @Test
    public void testIsCrossingAreaOnDistanceByYAxisWhenPositive(){
        //given
        //when
        boolean checkResult = calculator.isCrossingAreaOnDistance(circleForIsCrossingByYAxis,
                distanceWhenPositive, CoordinateAxes.Y_AXIS);
        //then
        Assert.assertTrue(checkResult);
    }

    @Test
    public void testIsCrossingAreaOnDistanceByXAxisWhenNegative(){
        //given
        //when
        boolean checkResult = calculator.isCrossingAreaOnDistance(circleForIsCrossingByXAxis,
                distanceWhenNegative, CoordinateAxes.X_AXIS);
        //then
        Assert.assertFalse(checkResult);
    }
    @Test
    public void testIsCrossingAreaOnDistanceByYAxisWhenNegative(){
        //given
        //when
        boolean checkResult = calculator.isCrossingAreaOnDistance(circleForIsCrossingByYAxis,
                distanceWhenNegative, CoordinateAxes.Y_AXIS);
        //then
        Assert.assertFalse(checkResult);
    }
}

