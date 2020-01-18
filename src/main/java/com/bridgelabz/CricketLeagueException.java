package com.bridgelabz;

public class CricketLeagueException extends Exception  {

    enum ExceptionType {
        NO_DATA_AVAILABLE, FILE_PROBLEM
    }

    ExceptionType type;

    public CricketLeagueException(String mesage, String name) {
        super(mesage);
        this.type = ExceptionType.valueOf(name);
    }

    public CricketLeagueException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
