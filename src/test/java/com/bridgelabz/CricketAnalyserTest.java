package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class CricketAnalyserTest {

    private static final String FACTS_SHEET_MOST_RUNS = "./src/test/resources/IPLFactSheetRuns.csv";
    private static final String WORNG_FACTS_SHEET_MOST_RUNS = "./src/main/resources/IPLFactSheetRuns.csv";
    private static final String FACTS_SHEET_MOST_WKTS = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenFileIPL2019FactsheetMostRuns_WhenCorrect_ShouldReturnData() throws CricketLeagueException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        int cricketLeagueData = cricketLeagueAnalyser.loadFactsheetMostRunsFile(FACTS_SHEET_MOST_RUNS);
        Assert.assertEquals(101, cricketLeagueData);
    }

    @Test
    public void givenFileIPL2019FactsheetMostRuns_WhenCorrect_ReturnException() throws CricketLeagueException {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int cricketLeagueData = cricketLeagueAnalyser.loadFactsheetMostRunsFile(WORNG_FACTS_SHEET_MOST_RUNS);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }
}

