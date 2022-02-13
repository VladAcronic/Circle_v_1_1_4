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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class DirectorTest {

    private final static String PATH = "src/test/resources/DirectorsTestData.txt";
    private final static String INVALID_PATH = "";

    private final static List<String> MOCKED_VALID_LINES = Arrays.asList("10 0.1 -1.2");
    private final static List<String> MOCKED_INVALID_LINES = Arrays.asList("");
    private final static List<Circle> CIRCLES_ON_VALID_DATA = Arrays.asList(
            new Circle(new Point(0.1, -1.2),10));
    private final static List<Circle> CIRCLES_ON_INVALID_DATA = Arrays.asList();

    @Test
    public void testShouldReadAndCreateCirclesWhenDataIsValid () throws DataException {
        //given
        List<Circle> resultCircles = new ArrayList<>();

        DataReader reader = Mockito.mock(DataReader.class);
        CircleValidator validator = Mockito.mock(CircleValidator.class);
        CircleCreator creator = Mockito.mock(CircleCreator.class);

        when(reader.read (PATH)).thenReturn(MOCKED_VALID_LINES);
        when(validator.isCircleDataValid (anyString())).thenReturn(true);
        when(creator.createCircle (anyString())).thenReturn(CIRCLES_ON_VALID_DATA.get(0));
        Director director = new Director(reader, validator, creator);
        //when
        resultCircles = director.readAndCreateCircles(PATH);
        //then
        Assert.assertEquals(CIRCLES_ON_VALID_DATA, resultCircles);
    }

    @Test
    public void testShouldReadAndCreateCirclesWhenDataIsInvalid () throws DataException {
        //given
        List<Circle> resultCircles = new ArrayList<>();

        DataReader reader = Mockito.mock(DataReader.class);
        CircleValidator validator = Mockito.mock(CircleValidator.class);
        CircleCreator creator = Mockito.mock(CircleCreator.class);

        when(reader.read(PATH)).thenReturn(MOCKED_INVALID_LINES);
        when(validator.isCircleDataValid (anyString())).thenReturn(false);
        when(creator.createCircle (anyString())).thenReturn(null);
        Director director = new Director(reader, validator, creator);
        //when
        resultCircles = director.readAndCreateCircles(PATH);
        //then
        Assert.assertEquals(CIRCLES_ON_INVALID_DATA, resultCircles);
    }

    @Test
    public void testShouldReadAndCreateEmptyCirclesListWhenFileIsNotFound () throws DataException {
        //given
        List<Circle> resultCircles = new ArrayList<>();

        DataReader reader = Mockito.mock(DataReader.class);
        CircleValidator validator = Mockito.mock(CircleValidator.class);
        CircleCreator creator = Mockito.mock(CircleCreator.class);

        when(validator.isCircleDataValid(anyString())).thenReturn(false);
        when(creator.createCircle(anyString())).thenReturn(null);
        Director director = new Director(reader, validator, creator);
        //when
        resultCircles = director.readAndCreateCircles(INVALID_PATH);
        //then
        Assert.assertEquals(CIRCLES_ON_INVALID_DATA, resultCircles);
    }
}
