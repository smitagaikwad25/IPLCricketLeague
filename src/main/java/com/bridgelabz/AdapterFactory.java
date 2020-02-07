package com.bridgelabz;

import java.util.Map;

public class AdapterFactory {
    public Map<String, CricketLeagueDAO> getCricketerData(CricketLeagueAnalyser.CricketerType cricketerType, String... csvFilePath) throws CricketLeagueException {
        if (cricketerType.equals(CricketLeagueAnalyser.CricketerType.BATING)) {
            return new BatsmanDetailsAdapter().loadCricketerData(csvFilePath);
        } else if (cricketerType.equals(CricketLeagueAnalyser.CricketerType.BOWLER)) {
            return new BowlersDetailsAdapter().loadCricketerData(csvFilePath);
        }else if (cricketerType.equals(CricketLeagueAnalyser.CricketerType.BATING_BOWLER)){
            return new MergingAdapter().loadCricketerData(csvFilePath);
        } else {
            throw new CricketLeagueException("INCORRECT_TYPE", CricketLeagueException.ExceptionType.INCORRECT_CRICKETER_TYPE);
        }
    }
}
