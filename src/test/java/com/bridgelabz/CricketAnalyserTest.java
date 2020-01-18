package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class CricketAnalyserTest {

    private static final String FACTS_SHEET_MOST_RUNS = "./src/test/resources/IPLFactSheetRuns.csv";
    private static final String WORNG_FACTS_SHEET_MOST_RUNS = "./src/main/resources/IPLFactSheetRuns.csv";
    private static final String FACTS_SHEET_MOST_WKTS = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenFileIPL2019FactsheetMostRuns_WhenCorrect_ShouldReturnData() throws CricketLeagueException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        int cricketLeagueData = cricketLeagueAnalyser.loadFactsheetMostRunsFile(FACTS_SHEET_MOST_RUNS);
        System.out.println(cricketLeagueData);
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

    @Test
    public void givenFileIPL2019FactsheetMostRuns_WhenSort_ShouldReturnCricketersAvg() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadFactsheetMostRunsFile(FACTS_SHEET_MOST_RUNS);
            List<FactSheetMostRunsCsv> cricketLeagueData = cricketLeagueAnalyser.sortingToGetTopBattingAvgOfCricketers();
            Assert.assertEquals(83.2, cricketLeagueData.get(0).getAvg(),0);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFileIPL2019FactsheetMostRuns_WhenSort_ShouldReturnCricketers() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadFactsheetMostRunsFile(FACTS_SHEET_MOST_RUNS);
            List<FactSheetMostRunsCsv> cricketLeagueData = cricketLeagueAnalyser.sortingToKnowTopStrikingRatesOfTheBatsman();
            Assert.assertEquals(333.33, cricketLeagueData.get(0).getSr(),0);
            Assert.assertEquals(63.15, cricketLeagueData.get(100).getSr(),0);

        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFileIPL2019FactsheetMostRuns_WhenSortAccordingFourAndSix_ShouldReturnSortedOutPut() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadFactsheetMostRunsFile(FACTS_SHEET_MOST_RUNS);
            List<FactSheetMostRunsCsv> cricketLeagueData = cricketLeagueAnalyser.sortingAccordingNumberOfFourAndNumberOfSix();
           Assert.assertEquals("Andre Russell", cricketLeagueData.get(0).player);
           Assert.assertEquals("Shakib Al Hasan", cricketLeagueData.get(100).player);

        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }
}

