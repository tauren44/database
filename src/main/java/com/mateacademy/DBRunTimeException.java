package com.mateacademy;

public class DBRunTimeException extends RuntimeException {
    public DBRunTimeException (String errorMessage) {
        super(errorMessage);
    }
}
