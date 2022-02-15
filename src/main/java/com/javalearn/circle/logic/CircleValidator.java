package com.javalearn.circle.logic;
import java.util.regex.*;

public class CircleValidator {

    private static final String ZERO_RADIUS_DATA = "^[0]+(\\.[0]+)?\\s+.*";
    private static final String FULL_LINE = "^\\d+(\\.\\d+)?(\\s+(-?)\\d+(\\.\\d+)?){2}";

    public boolean isCircleDataValid (String line){

        Pattern patternZeroRadius = Pattern.compile(ZERO_RADIUS_DATA);
        Matcher matcherZeroRadius = patternZeroRadius.matcher(line);

        if (matcherZeroRadius.matches()){
            return false;
        }

        Pattern pattern = Pattern.compile(FULL_LINE);
        Matcher matcher = pattern.matcher(line);

        return matcher.matches();
    }
}
