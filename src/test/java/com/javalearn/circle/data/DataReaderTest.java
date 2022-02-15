package com.javalearn.circle.data;

import com.javalearn.circle.exceptions.DataException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    private static final DataReader reader  = new SimpleDataReader();

    private static final String VALID_DATA_PATH =
            "src/test/resources/ValidLinesData.txt";
    private static final String INVALID_DATA_PATH =
            "src/test/resources/InValidLinesData.txt";
    private static final String ABSENT_PATH =
            "src/test/resources/absentFile.txt";

    private final static List<String> VALID_LINES =
            Arrays.asList(
                    "10 0 0",
                    "1.5 1.1 2.0",
                    "5.0 -10 -20.5");
    private final static List<String> INVALID_LINES =
            Arrays.asList(
                    "0 0 0",
                    "-1.5 1.1 2.0",
                    "5.0z -10 -20.5",
                    "",
                    "10 12");

    @Test
    public void testReadWhenValidData  () throws DataException {
        //given
        //when
        List<String> testLines = reader.read(VALID_DATA_PATH);
        //then
        Assert.assertEquals(testLines, VALID_LINES);
    }

    @Test
    public void testReadWhenInvalidData  () throws DataException {
        //given
        //when
        List<String> testLines = reader.read(INVALID_DATA_PATH);
        //then
        Assert.assertEquals(testLines, INVALID_LINES);
    }

    @Test (expected = DataException.class)
    public void testReadWhenFileIsAbsent  () throws DataException {
        //given
        //when
        List<String> testLines = reader.read(ABSENT_PATH);
    }
}

