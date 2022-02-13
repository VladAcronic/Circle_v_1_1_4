package com.javalearn.circle.logic;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class CircleValidatorTest {

    private static final CircleValidator validator = new CircleValidator();

    private final static List<String> VALID_LINES =
            Arrays.asList(
                    "1 10 20",
                    "1.0 1.0 2.0",
                    "1.12 -10 2.0",
                    "0.1 0.0 -0.0");

    private final static List<String> INVALID_LINES =
            Arrays.asList(
                    "-1 10 20",
                    "0 0.0 0.0",
                    "1.0 1.0",
                    "1.12z -10 2.0");

    @Test
    public void testIsCircleWhenValidDataAreIntegers () {
        //given
        String line = VALID_LINES.get(0);
        //when
        boolean result = validator.isCircleDataValid(line);
        //then
        Assert.assertTrue(result);
    }
    @Test
    public void testIsCircleWhenValidDataAreFloats () {
        //given
        String line = VALID_LINES.get(1);
        //when
        boolean result = validator.isCircleDataValid(line);
        //then
        Assert.assertTrue(result);
    }
    @Test
    public void testIsCircleWhenValidDataWithNegativeCoordinate () {
        //given
        String line = VALID_LINES.get(2);
        //when
        boolean result = validator.isCircleDataValid(line);
        //then
        Assert.assertTrue(result);
    }
    @Test
    public void testIsCircleWhenValidDataWithZeroCoordinate () {
        //given
        String line = VALID_LINES.get(3);
        //when
        boolean result = validator.isCircleDataValid(line);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsCircleWhenInvalidDataWithNegativeRadius () {
        //given
        String line = INVALID_LINES.get(0);
        //when
        boolean result = validator.isCircleDataValid(line);
        //then
        Assert.assertFalse(result);
    }
    @Test
    public void testIsCircleWhenInvalidDataWithZeroRadius () {
        //given
        String line = INVALID_LINES.get(1);
        //when
        boolean result = validator.isCircleDataValid(line);
        //then
        Assert.assertFalse(result);
    }
    @Test
    public void testIsCircleWhenInvalidDataWithIncompleteData() {
        //given
        String line = INVALID_LINES.get(2);
        //when
        boolean result = validator.isCircleDataValid(line);
        //then
        Assert.assertFalse(result);
    }
    @Test
    public void testIsCircleWhenInvalidDataWithInvalidChar() {
        //given
        String line = INVALID_LINES.get(3);
        //when
        boolean result = validator.isCircleDataValid(line);
        //then
        Assert.assertFalse(result);
    }
}
