package com.bridgelabz;

import java.util.Map;

public class BowlersDetailsAdapter extends CricketAdapter {

    @Override
    public Map<String, CricketLeagueDAO> loadCricketerData(String... csvFilePath) throws CricketLeagueException {
        Map<String, CricketLeagueDAO> cricketLeagueDAOMap = super.loadData(BowlersDetails.class, csvFilePath[0]);
        return cricketLeagueDAOMap;
    }
}

