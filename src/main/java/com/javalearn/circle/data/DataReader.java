package com.javalearn.circle.data;

import com.javalearn.circle.exceptions.DataException;

import java.util.List;

public interface DataReader {

    public List<String> read (String path) throws DataException;
}
