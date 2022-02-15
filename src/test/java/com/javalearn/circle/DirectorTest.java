package com.javalearn.circle;

import com.javalearn.circle.data.DataReader;
import com.javalearn.circle.entity.Circle;
import com.javalearn.circle.entity.Point;
import com.javalearn.circle.exceptions.DataException;
import com.javalearn.circle.logic.CircleCreator;
import com.javalearn.circle.logic.CircleValidator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class DirectorTest {

    private final static String PATH = "src/test/resources/testedData.txt";

    private final static List<String> MOCKED_VALID_LINES = Arrays.asList(
            "10 0 0",
            "1.5 1.1 2.0",
            "5.0 -10 -20.5",
            "",
            "0 0 0",
            "-1.5 1.1 2.0");

    private final static List<Circle> ValidatedCircles = Arrays.asList(
            new Circle(new Point(0, 0),10),
            new Circle(new Point(1.1, 2.0),1.5),
            new Circle(new Point(-10, -20.5),5.0));


    private static DataReader reader = Mockito.mock(DataReader.class);
    private static CircleValidator validator = Mockito.mock(CircleValidator.class);
    private static CircleCreator creator = Mockito.mock(CircleCreator.class);

    private DataReader getMockedLines() throws DataException {
        when(reader.read(PATH)).thenReturn(MOCKED_VALID_LINES);
        return reader;
    }

    private void printCirclesList(List<Circle> circles){
        for (Circle circle: circles) {
            System.out.println("***********");
            System.out.println(circle.getCentre().getXCoordinate());
            System.out.println(circle.getCentre().getYCoordinate());
            System.out.println(circle.getRadius());
        }
    }


    @Test
    public void testReadAndCreateCircles () throws DataException {
        //given
        List<Circle> resultCircles = new ArrayList<>();
        Director director;

        //when

        when(reader.read(PATH)).thenReturn(MOCKED_VALID_LINES);
        when(validator.isCircleDataValid (MOCKED_VALID_LINES.get(0))).thenReturn(true);
        when(creator.createCircle (MOCKED_VALID_LINES.get(0))).thenReturn(ValidatedCircles.get(0));
        director = new Director(reader, validator, creator);
        resultCircles = director.readAndCreateCircles(PATH);

        when(validator.isCircleDataValid (MOCKED_VALID_LINES.get(1))).thenReturn(true);
        when(creator.createCircle (MOCKED_VALID_LINES.get(1))).thenReturn(ValidatedCircles.get(1));
        director = new Director(reader, validator, creator);
        resultCircles = director.readAndCreateCircles(PATH);

        when(validator.isCircleDataValid (MOCKED_VALID_LINES.get(2))).thenReturn(true);
        when(creator.createCircle (MOCKED_VALID_LINES.get(2))).thenReturn(ValidatedCircles.get(2));
        director = new Director(reader, validator, creator);
        resultCircles = director.readAndCreateCircles(PATH);

        when(validator.isCircleDataValid (MOCKED_VALID_LINES.get(3))).thenReturn(false);
        when(creator.createCircle (MOCKED_VALID_LINES.get(3))).thenReturn(null);
        director = new Director(reader, validator, creator);
        resultCircles = director.readAndCreateCircles(PATH);

        when(validator.isCircleDataValid (MOCKED_VALID_LINES.get(4))).thenReturn(false);
        when(creator.createCircle (MOCKED_VALID_LINES.get(4))).thenReturn(null);
        director = new Director(reader, validator, creator);
        resultCircles = director.readAndCreateCircles(PATH);

        when(validator.isCircleDataValid (MOCKED_VALID_LINES.get(5))).thenReturn(false);
        when(creator.createCircle (MOCKED_VALID_LINES.get(5))).thenReturn(null);
        director = new Director(reader, validator, creator);
        resultCircles = director.readAndCreateCircles(PATH);

        //then
        Assert.assertEquals(ValidatedCircles, resultCircles);
    }
}

