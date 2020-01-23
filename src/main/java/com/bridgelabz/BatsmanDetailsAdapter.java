package com.bridgelabz;

import java.util.Map;

public class BatsmanDetailsAdapter extends CricketAdapter {

    @Override
    public<E> Map<String, CricketLeagueDAO> loadCricketerData(String... csvFilePath) throws CricketLeagueException {
        Map<String, CricketLeagueDAO> cricketLeagueDAOMap = super.loadData(BatsmanDetails.class, csvFilePath[0]);
        return cricketLeagueDAOMap;
    }
}
