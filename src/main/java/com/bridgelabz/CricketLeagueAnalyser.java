package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

    List<BatsmanDetails> batsmanDetailsArrayList = new ArrayList<>();

    public int loadFactsheetMostRunsFile(String csvFilePath) throws CricketLeagueException {
        batsmanDetailsArrayList = new DataLoader().loadData(csvFilePath, BatsmanDetails.class);
        return batsmanDetailsArrayList.size();
    }

    public List<BatsmanDetails> sortingToGetTopBattingAvgOfCricketers() throws CricketLeagueException {
        if (batsmanDetailsArrayList == null || batsmanDetailsArrayList.size() == 0) {
            throw new CricketLeagueException("No Data Available", CricketLeagueException.ExceptionType.NO_DATA_AVAILABLE);
        }
        List topBattingAvg = batsmanDetailsArrayList.stream().sorted(Comparator.comparing(BatsmanDetails::getAvg).reversed()).collect(Collectors.toList());
        return topBattingAvg;
    }

    public List<BatsmanDetails> sortingToKnowTopStrikingRatesOfTheBatsman() throws CricketLeagueException {
        if (batsmanDetailsArrayList == null || batsmanDetailsArrayList.size() == 0) {
            throw new CricketLeagueException("No Data Available", CricketLeagueException.ExceptionType.NO_DATA_AVAILABLE);
        }
        List topStrikingRates = batsmanDetailsArrayList.stream().sorted(Comparator.comparing(BatsmanDetails::getSr).reversed()).collect(Collectors.toList());
        return topStrikingRates;
    }

    public List<BatsmanDetails> sortingAccordingNumberOfFourAndNumberOfSix() throws CricketLeagueException {
        if (batsmanDetailsArrayList == null || batsmanDetailsArrayList.size() == 0) {
            throw new CricketLeagueException("No Data Available", CricketLeagueException.ExceptionType.NO_DATA_AVAILABLE);
        }

        Comparator<BatsmanDetails> sortNumberOfFourAndSix = (obj1, obj2) -> ((obj1.four * 4 + obj1.six * 6) < (obj2.four * 4 + obj2.six * 6) ? 1 : -1);
        Collections.sort(batsmanDetailsArrayList, sortNumberOfFourAndSix);
        return batsmanDetailsArrayList;
    }
}
