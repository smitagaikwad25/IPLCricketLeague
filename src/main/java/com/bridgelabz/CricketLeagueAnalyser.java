package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

    Map<String, CricketLeagueDAO> cricketLeagueDetails = null;

    public CricketLeagueAnalyser() {

        this.cricketLeagueDetails = new HashMap<>();
    }

    public int loadBatsmanDetailsFile(String csvFilePath) throws CricketLeagueException {
        cricketLeagueDetails = new DataLoader().loadData(csvFilePath, BatsmanDetails.class);
        return cricketLeagueDetails.size();
    }

    public int loadBowlersDetails(String csvFilePath) throws CricketLeagueException {
        cricketLeagueDetails = new DataLoader().loadData(csvFilePath, BowlersDetails.class);
        return cricketLeagueDetails.size();
    }

    public List<CricketLeagueDAO> letsSorting(Sorting.fields sortingFields) {
        Comparator<CricketLeagueDAO> comparator = new Sorting().getFiled(sortingFields);
        List sortedData = cricketLeagueDetails.values().stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        Collections.reverse(sortedData);
        return sortedData;
    }
}
