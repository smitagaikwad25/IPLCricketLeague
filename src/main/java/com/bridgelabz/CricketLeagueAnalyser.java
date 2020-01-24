package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

    public enum CricketerType{
        BATING,BOWLER,BATING_BOWLER
    }

    private CricketerType cricketerType;

    Map<String, CricketLeagueDAO> cricketLeagueDetails = new HashMap<>();;

    public CricketLeagueAnalyser(CricketerType cricketerType) {
        this.cricketerType = cricketerType;
    }

    public <E> int loadCricketerData(String... csvFilePath) throws CricketLeagueException{
       cricketLeagueDetails = AdapterFactory.getCricketerData(cricketerType,csvFilePath);
       return cricketLeagueDetails.size();
    }

    public List letsSorting(Sorting.fields sortingFields) {
        Comparator<CricketLeagueDAO> comparator = new Sorting().getFiled(sortingFields);
        List sortedData = cricketLeagueDetails.values().stream()
                .sorted(comparator)
                .map(CricketInfo -> CricketInfo.getCricketDTO(cricketerType))
                .collect(Collectors.toList());
        Collections.reverse(sortedData);
        return sortedData;
    }
}
