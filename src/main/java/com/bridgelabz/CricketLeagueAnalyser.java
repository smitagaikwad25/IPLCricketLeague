package com.bridgelabz;

import com.bridgeLab.CSVBuilderException;
import com.bridgeLab.CsvBuilderFactory;
import com.bridgeLab.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CricketLeagueAnalyser {

  List mostRunCSVList = new ArrayList();

    public int loadFactsheetMostRunsFile(String csvFilePath) throws CricketLeagueException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
        ICSVBuilder csvBuilder = CsvBuilderFactory.createCSVBuilder();
        List csvList= csvBuilder.getCSVList(reader,FactSheetMostRunsCsv.class);
        csvList.stream().filter(CensusData -> mostRunCSVList.add((FactSheetMostRunsCsv) CensusData)).collect(Collectors.toList());
        return csvList.size();
    } catch (IOException e) {
        throw new CricketLeagueException(e.getMessage(),
                CricketLeagueException.ExceptionType.CENSUS_FILE_PROBLEM);
    } catch (RuntimeException e) {
        throw new CricketLeagueException(e.getMessage(), CricketLeagueException.ExceptionType.CENSUS_FILE_PROBLEM);
    } catch (CSVBuilderException e) {
        throw new CricketLeagueException(e.getMessage(), e.type.name());
    }

    }
}
