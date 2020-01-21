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

    List<BatsmanDetails> batsmanDetailsArrayList = new ArrayList<>();
    List<BowlersDetails> bowlersDetailsArrayList = new ArrayList<>();

    public List loadBatsmansData(String csvFilePath, Class<BatsmanDetails> sourceClass) throws CricketLeagueException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CsvBuilderFactory.createCSVBuilder();
            List csvList = csvBuilder.getCSVList(reader, sourceClass);
            csvList.stream().filter(CricketData -> batsmanDetailsArrayList.add((BatsmanDetails) CricketData)).collect(Collectors.toList());
            return batsmanDetailsArrayList;
        } catch (IOException e) {
            throw new CricketLeagueException(e.getMessage(),
                    CricketLeagueException.ExceptionType.FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new CricketLeagueException(e.getMessage(), CricketLeagueException.ExceptionType.FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            throw new CricketLeagueException(e.getMessage(), e.type.name());
        }

    }

    public List loadBowlersData(String csvFilePath, Class<BowlersDetails> sourceClass) throws CricketLeagueException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder csvBuilder = CsvBuilderFactory.createCSVBuilder();
            List csvList = csvBuilder.getCSVList(reader, sourceClass);
            csvList.stream().filter(CricketData -> bowlersDetailsArrayList.add((BowlersDetails) CricketData)).collect(Collectors.toList());
            return bowlersDetailsArrayList;
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
