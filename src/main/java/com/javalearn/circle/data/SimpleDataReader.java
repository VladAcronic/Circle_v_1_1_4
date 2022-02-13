package com.javalearn.circle.data;

import com.javalearn.circle.exceptions.DataException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimpleDataReader implements DataReader {

    private final static Logger LOGGER = Logger.getLogger(SimpleDataReader.class);

    public List<String> read (String path) throws DataException {

        List<String> lines = new ArrayList<String>();
        BufferedReader reader = null;

        try {
            try {
                reader = new BufferedReader(new FileReader(path));
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
                throw new DataException(e.getMessage(), e);

            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        } catch (IOException e){
            LOGGER.error(e.getMessage(), e);
            throw new DataException(e.getMessage(), e);
        }
        return lines;
    }
}
