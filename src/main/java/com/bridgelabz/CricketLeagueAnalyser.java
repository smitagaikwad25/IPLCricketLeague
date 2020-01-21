package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

    List<BatsmanDetails> batsmanDetailsArrayList = new ArrayList<>();
    List<BowlersDetails> bowlersDetailsArrayList = new ArrayList<>();


    public List<BatsmanDetails> loadBatsmanDetailsFile(String csvFilePath) throws CricketLeagueException {
        batsmanDetailsArrayList = new DataLoader().loadBatsmansData(csvFilePath, BatsmanDetails.class);
        return batsmanDetailsArrayList;
    }

    public List<BowlersDetails> loadBowlersDetails(String csvFilePath) throws CricketLeagueException {
        bowlersDetailsArrayList =  new DataLoader().loadBowlersData(csvFilePath, BowlersDetails.class);
        return bowlersDetailsArrayList;
    }

    public List<BatsmanDetails> letsSorting(Sorting.fields sortingFields) {

        Comparator<BatsmanDetails> comparator = new Sorting().getFiled(sortingFields);
        ArrayList sortedData = (ArrayList) batsmanDetailsArrayList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        Collections.reverse(sortedData);
        System.out.println(sortedData);
        return sortedData;
    }


}
