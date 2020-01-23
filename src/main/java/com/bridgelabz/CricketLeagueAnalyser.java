package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

    public enum CricketerType{
        BATING,BOWLER
    }

    private CricketerType cricketerType;

    Map<String, CricketLeagueDAO> cricketLeagueDetails = new HashMap<>();;

    public CricketLeagueAnalyser(CricketerType cricketerType) {
        this.cricketerType = cricketerType;
    }

    public <E> int loadCricketerData(String... csvFilePath) throws CricketLeagueException{
       cricketLeagueDetails = new AdapterFactory().getCricketerData(cricketerType,csvFilePath);
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
