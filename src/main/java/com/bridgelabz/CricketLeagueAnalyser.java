package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

    List<CricketLeagueDAO> cricketLeagueDetails = null;

    public CricketLeagueAnalyser() {
        this.cricketLeagueDetails = new ArrayList<CricketLeagueDAO>();
    }

    public List<CricketLeagueDAO> loadBatsmanDetailsFile(String csvFilePath) throws CricketLeagueException {
        cricketLeagueDetails = new DataLoader().loadData(csvFilePath, BatsmanDetails.class);
        return cricketLeagueDetails;
    }

    public List<CricketLeagueDAO> loadBowlersDetails(String csvFilePath) throws CricketLeagueException {
        cricketLeagueDetails = new DataLoader().loadData(csvFilePath, BowlersDetails.class);
        return cricketLeagueDetails;
    }

    public List<CricketLeagueDAO> letsSorting(Sorting.fields sortingFields) {
        Comparator<CricketLeagueDAO> comparator = new Sorting().getFiled(sortingFields);
        cricketLeagueDetails = cricketLeagueDetails.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        Collections.reverse(cricketLeagueDetails);
        return cricketLeagueDetails;
    }
}
