package com.javalearn.circle;

import com.javalearn.circle.data.DataReader;
import com.javalearn.circle.data.SimpleDataReader;
import com.javalearn.circle.entity.Circle;
import com.javalearn.circle.exceptions.DataException;
import com.javalearn.circle.logic.CircleCreator;
import com.javalearn.circle.logic.CircleValidator;

import java.util.ArrayList;
import java.util.List;

public class Director {

    private DataReader reader;// = new SimpleDataReader();
    private CircleValidator validator;// = new CircleValidator();
    private CircleCreator creator;// = new CircleCreator();


    public Director (DataReader reader, CircleValidator validator, CircleCreator creator){
        this.reader = reader;
        this.validator = validator;
        this.creator = creator;
    }

/*
    Director (){
        this.reader = new SimpleDataReader();
        this.validator = new CircleValidator();
        this.creator = new CircleCreator();
    }

 */


    public List<Circle> readAndCreateCircles (String path) throws DataException {
        List<Circle> circles = new ArrayList<>();
        List<String> lines = reader.read(path);

        for (String line: lines){
            if (validator.isCircleDataValid(line)){
                Circle circle = creator.createCircle(line);
                circles.add(circle);
            }
        }
        return circles;
    }
}
