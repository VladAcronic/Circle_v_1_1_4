package com.javalearn.circle.logic;
import java.util.regex.*;

public class CircleValidator {

    public boolean isCircleDataValid (String line){

        boolean result = false;

        if (Pattern.matches("[0](\\.[0]+)?\\s+.*", line)){
            result = false;
            return result;
        }

        result = Pattern.matches(
                "\\d+(\\.\\d+)?\\s+(-?)\\d+(\\.\\d+)?\\s+(-?)\\d+(\\.\\d+)?",
                line);
        return result;
    }
}
