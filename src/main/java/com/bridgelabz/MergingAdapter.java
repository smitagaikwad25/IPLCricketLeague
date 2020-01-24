package com.bridgelabz;

import java.util.Map;

public class MergingAdapter extends CricketAdapter {

    @Override
    public <E> Map<String, CricketLeagueDAO> loadCricketerData(String... csvFilePath) throws CricketLeagueException {
        Map<String,CricketLeagueDAO> cricketBatsman=super.loadData(BatsmanDetails.class,csvFilePath[0]);
        Map<String,CricketLeagueDAO> cricketBowler=super.loadData(BowlersDetails.class,csvFilePath[1]);
        cricketBowler.values().stream()
                .filter(cricketData-> cricketBatsman.get(cricketData.player)!=null)
                .forEach(cricketData->{cricketBatsman.get(cricketData.player).
                        bowlerAvg=cricketData.bowlerAvg;
                    cricketBatsman.get(cricketData.player).wkts=cricketData.wkts;
                });

        return cricketBatsman;
    }
}

