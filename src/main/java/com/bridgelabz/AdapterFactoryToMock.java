package com.bridgelabz;

import java.util.Map;

public class AdapterFactoryToMock {
    public Map<String, CricketLeagueDAO> getCricketerData(CricketLeagueAnalyser.CricketerType cricketerType, String... csvFilePath) throws CricketLeagueException {
    return new AdapterFactory().getCricketerData(cricketerType, csvFilePath);
    }
    }
