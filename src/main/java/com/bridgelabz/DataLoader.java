package com.bridgelabz;

import com.bridgeLab.CSVBuilderException;
import com.bridgeLab.CsvBuilderFactory;
import com.bridgeLab.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataLoader {

    List<CricketLeagueDAO> cricketLeagueDetails  = new ArrayList<>();

    public <E> List loadData(String csvFilePath, Class<E> sourceClass) throws CricketLeagueException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CsvBuilderFactory.createCSVBuilder();
            List csvList = csvBuilder.getCSVList(reader, sourceClass);
            if (sourceClass.getName().equals("com.bridgelabz.BatsmanDetails")) {
                csvList.stream().filter(CricketData -> cricketLeagueDetails.add(new CricketLeagueDAO((BatsmanDetails) CricketData))).collect(Collectors.toList());
            } else if (sourceClass.getName().equals("com.bridgelabz.BowlersDetails")) {
                csvList.stream().filter(CricketData -> cricketLeagueDetails.add(new CricketLeagueDAO((BowlersDetails) CricketData))).collect(Collectors.toList());
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
