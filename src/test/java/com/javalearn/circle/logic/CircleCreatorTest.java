package com.javalearn.circle.logic;

import com.javalearn.circle.entity.Circle;
import com.javalearn.circle.entity.Point;
import com.javalearn.circle.logic.CircleCreator;
import org.junit.Assert;
import org.junit.Test;

public class CircleCreatorTest {

    CircleCreator creator  = new CircleCreator();

    @Test
    public void testCreate (){
        //given
        String testDataExample = "2.1 10.1 11.2";
        //when
        Circle testedCircle = creator.createCircle(testDataExample);
        //then
        Circle expectedCircle = new Circle (new Point(10.1, 11.2), 2.1);
        Assert.assertEquals(expectedCircle, testedCircle);
    }
}
