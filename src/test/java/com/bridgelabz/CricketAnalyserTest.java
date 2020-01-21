package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CricketAnalyserTest {

    private static final String FACTS_SHEET_MOST_RUNS = "./src/test/resources/IPLFactSheetRuns.csv";
    private static final String WORNG_FACTS_SHEET_MOST_RUNS = "./src/main/resources/IPLFactSheetRuns.csv";
    private static final String FACTS_SHEET_MOST_WKTS = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenFile_WhenCorrect_ShouldReturnData() throws CricketLeagueException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        List<BatsmanDetails> cricketLeagueData = cricketLeagueAnalyser.loadFactsheetMostRunsFile(FACTS_SHEET_MOST_RUNS);
        System.out.println(cricketLeagueData);
        Assert.assertEquals(101, cricketLeagueData.size());
    }

    @Test
    public void givenFile_WhenCorrect_ReturnException() throws CricketLeagueException {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            List<BatsmanDetails> cricketLeagueData = cricketLeagueAnalyser.loadFactsheetMostRunsFile(WORNG_FACTS_SHEET_MOST_RUNS);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }


    @Test
    public void givenFile_WhenSort_ShouldReturnCricketersAvg() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadFactsheetMostRunsFile(FACTS_SHEET_MOST_RUNS);
            List<BatsmanDetails> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.AVG_BATING_RATE);
            Assert.assertEquals(83.2, cricketLeagueData.get(0).avg, 0);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_WhenSort_ShouldReturnCricketers() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadFactsheetMostRunsFile(FACTS_SHEET_MOST_RUNS);
            List<BatsmanDetails> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.STRIKING_RATE);
            Assert.assertEquals(333.33, cricketLeagueData.get(0).sr, 0);
            Assert.assertEquals(63.15, cricketLeagueData.get(100).sr, 0);

        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_WhenSortAccordingFourAndSix_ShouldReturnSortedOutPut() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadFactsheetMostRunsFile(FACTS_SHEET_MOST_RUNS);
            List<BatsmanDetails> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.FOUR_SIX);
            Assert.assertEquals("Andre Russell", cricketLeagueData.get(0).player);
            Assert.assertEquals("Shakib Al Hasan", cricketLeagueData.get(100).player);

        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_WhenSortToKnowStrikingRatesWith6sAnd4s_ShouldReturnSortedOutPut() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadFactsheetMostRunsFile(FACTS_SHEET_MOST_RUNS);
            List<BatsmanDetails> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.FOUR_SIX_STRIKE_RATE);
            Assert.assertEquals("Andre Russell", cricketLeagueData.get(0).player);
            Assert.assertEquals("Shakib Al Hasan", cricketLeagueData.get(100).player);

        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_WhenSortToKnowAveragesWithBestStrikingRate_ShouldReturnSortedOutPut() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadFactsheetMostRunsFile(FACTS_SHEET_MOST_RUNS);
            List<BatsmanDetails> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.AVG_STRIKE_RATE);
            Assert.assertEquals("MS Dhoni", cricketLeagueData.get(0).player);
            Assert.assertEquals("Tim Southee", cricketLeagueData.get(100).player);

        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_WhenSortToKnowRunsWithAverages_ShouldReturnSortedOutPut() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadFactsheetMostRunsFile(FACTS_SHEET_MOST_RUNS);
            List<BatsmanDetails> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.RUNNS_AVERAGES);
            Assert.assertEquals("David Warner ", cricketLeagueData.get(0).player);
            Assert.assertEquals("Tim Southee", cricketLeagueData.get(100).player);

        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }


}

