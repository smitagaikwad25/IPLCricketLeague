package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {


    public enum CricketerType {
        BATING, BOWLER, BATING_BOWLER
    }

    private CricketerType cricketerType;
    AdapterFactory adapterFactory;

    Map<String, CricketLeagueDAO> cricketLeagueDetails = new HashMap<>();
    ;

    public CricketLeagueAnalyser(CricketerType cricketerType) {
        this.cricketerType = cricketerType;
        adapterFactory = new AdapterFactory();
    }

    public CricketLeagueAnalyser(CricketerType cricketerType, AdapterFactory adapterFactory) {
        this.cricketerType = cricketerType;
        this.adapterFactory = adapterFactory;
    }

    public <E> int loadCricketerData(String... csvFilePath) throws CricketLeagueException {
        cricketLeagueDetails = adapterFactory.getCricketerData(cricketerType, csvFilePath);
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
