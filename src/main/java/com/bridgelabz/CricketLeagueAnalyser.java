package com.bridgelabz;

import com.bridgeLab.CSVBuilderException;
import com.bridgeLab.CsvBuilderFactory;
import com.bridgeLab.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

    List<BatsmanDetailsCsv> batsmanDetailsArrayList = new ArrayList<>();

    public int loadFactsheetMostRunsFile(String csvFilePath) throws CricketLeagueException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CsvBuilderFactory.createCSVBuilder();
            List csvList = csvBuilder.getCSVList(reader, BatsmanDetailsCsv.class);
            csvList.stream().filter(CensusData -> batsmanDetailsArrayList.add((BatsmanDetailsCsv) CensusData)).collect(Collectors.toList());
            System.out.println(batsmanDetailsArrayList);
            return batsmanDetailsArrayList.size();
        } catch (IOException e) {
            throw new CricketLeagueException(e.getMessage(),
                    CricketLeagueException.ExceptionType.FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new CricketLeagueException(e.getMessage(), CricketLeagueException.ExceptionType.FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new CricketLeagueException(e.getMessage(), e.type.name());
        }

    }

    public List<BatsmanDetailsCsv> sortingToGetTopBattingAvgOfCricketers() throws CricketLeagueException {
        if (batsmanDetailsArrayList == null || batsmanDetailsArrayList.size() == 0) {
            throw new CricketLeagueException("No Data Available", CricketLeagueException.ExceptionType.NO_DATA_AVAILABLE);
        }
        List topBattingAvg = batsmanDetailsArrayList.stream().sorted(Comparator.comparing(BatsmanDetailsCsv::getAvg).reversed()).collect(Collectors.toList());
        System.out.println(topBattingAvg);
        return topBattingAvg;
    }

    public List<BatsmanDetailsCsv> sortingToKnowTopStrikingRatesOfTheBatsman() throws CricketLeagueException {
        if (batsmanDetailsArrayList == null || batsmanDetailsArrayList.size() == 0) {
            throw new CricketLeagueException("No Data Available", CricketLeagueException.ExceptionType.NO_DATA_AVAILABLE);
        }
        List topStrikingRates = batsmanDetailsArrayList.stream().sorted(Comparator.comparing(BatsmanDetailsCsv::getSr).reversed()).collect(Collectors.toList());
        System.out.println(topStrikingRates);
        return topStrikingRates;
    }

    public List<BatsmanDetailsCsv> sortingAccordingNumberOfFourAndNumberOfSix() throws CricketLeagueException {
        if (batsmanDetailsArrayList == null || batsmanDetailsArrayList.size() == 0) {
            throw new CricketLeagueException("No Data Available", CricketLeagueException.ExceptionType.NO_DATA_AVAILABLE);
        }

        Comparator<BatsmanDetailsCsv> sortNumberOfFourAndSix = (obj1, obj2) -> ((obj1.four * 4 + obj1.six * 6) < (obj2.four * 4 + obj2.six * 6) ? 1 : -1);
        Collections.sort(batsmanDetailsArrayList, sortNumberOfFourAndSix);
        System.out.println(batsmanDetailsArrayList);
        return batsmanDetailsArrayList;

    }
}
