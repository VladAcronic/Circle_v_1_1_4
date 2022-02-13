package com.javalearn.circle;

import com.javalearn.circle.data.DataReader;
import com.javalearn.circle.data.SimpleDataReader;
import com.javalearn.circle.entity.Circle;
import com.javalearn.circle.exceptions.DataException;
import com.javalearn.circle.logic.CircleCreator;
import com.javalearn.circle.logic.CircleValidator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Director {

    private DataReader reader;
    private CircleValidator validator;
    private CircleCreator creator;

    private final static Logger LOGGER = Logger.getLogger(SimpleDataReader.class);

    public Director (DataReader reader, CircleValidator validator, CircleCreator creator){
        this.reader = reader;
        this.validator = validator;
        this.creator = creator;
    }

    public List<Circle> readAndCreateCircles (String path) throws DataException {
        List<Circle> circles = new ArrayList<>();
        List<String> lines = new ArrayList<>();

        try {
            lines = reader.read(path);
        } catch (DataException e){
            LOGGER.error (e.getMessage(), e);
        }

        for (String line: lines){
            if (validator.isCircleDataValid(line)){
                Circle circle = creator.createCircle(line);
                circles.add(circle);
            }
        }
        return circles;
    }
}
