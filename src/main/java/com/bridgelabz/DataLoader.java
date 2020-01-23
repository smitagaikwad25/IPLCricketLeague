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
import java.util.stream.StreamSupport;

public class DataLoader {
//    List<CricketLeagueDAO> cricketLeagueDetails  = new ArrayList<>();
    Map<String,CricketLeagueDAO> cricketLeagueDetails = new HashMap<>();


    public <E> Map<String, CricketLeagueDAO> loadData(String csvFilePath, Class<E> sourceClass) throws CricketLeagueException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CsvBuilderFactory.createCSVBuilder();
            Iterator<E> csvIterator = csvBuilder.getCSVIterator(reader, sourceClass);
            Iterable<E> csvIterable = () -> csvIterator;

            if (sourceClass.getName().equals("com.bridgelabz.BatsmanDetails")) {
                StreamSupport.stream(csvIterable.spliterator(),false)
                        .map(BatsmanDetails.class::cast)
                        .forEach(cricketcsv -> cricketLeagueDetails.put(cricketcsv.getPlayer(),new CricketLeagueDAO(cricketcsv)));
            } else if (sourceClass.getName().equals("com.bridgelabz.BowlersDetails")) {
//                csvList.stream().filter(CricketData -> cricketLeagueDetails.add(new CricketLeagueDAO((BowlersDetails) CricketData))).collect(Collectors.toList());
                StreamSupport.stream(csvIterable.spliterator(),false)
                        .map(BowlersDetails.class::cast)
                        .forEach(cricketcsv -> cricketLeagueDetails.put(cricketcsv.getPlayer(),new CricketLeagueDAO(cricketcsv)));
            }
            return cricketLeagueDetails;
        } catch (IOException e) {
            throw new CricketLeagueException(e.getMessage(),
                    CricketLeagueException.ExceptionType.FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new CricketLeagueException(e.getMessage(), CricketLeagueException.ExceptionType.FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new CricketLeagueException(e.getMessage(), e.type.name());
        }

    }
}
