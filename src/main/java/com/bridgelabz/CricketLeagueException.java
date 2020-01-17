package com.bridgelabz;

public class CricketLeagueException extends Exception  {
    enum ExceptionType {
        No_Census_Data,CENSUS_FILE_PROBLEM
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
