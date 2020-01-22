package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CricketAnalyserTest {

    private static final String FACTS_SHEET_MOST_RUNS = "./src/test/resources/IPLFactSheetRuns.csv";
    private static final String WORNG_FACTS_SHEET_MOST_RUNS = "./src/main/resources/IPLFactSheetRuns.csv";
    private static final String FACTS_SHEET_MOST_WKTS = "./src/test/resources/IPL2019FactSheetWkts.csv";

    @Test
    public void givenFile_WhenCorrect_ShouldReturnData() throws CricketLeagueException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        List<CricketLeagueDAO> cricketLeagueData = cricketLeagueAnalyser.loadBatsmanDetailsFile(FACTS_SHEET_MOST_RUNS);
        Assert.assertEquals(101, cricketLeagueData.size());
    }

    @Test
    public void givenFile_WhenCorrect_ReturnException() throws CricketLeagueException {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            List<CricketLeagueDAO> cricketLeagueData = cricketLeagueAnalyser.loadBatsmanDetailsFile(WORNG_FACTS_SHEET_MOST_RUNS);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }


    @Test
    public void givenFile_WhenSort_ShouldReturnCricketersAvg() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadBatsmanDetailsFile(FACTS_SHEET_MOST_RUNS);
            List<CricketLeagueDAO> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.AVG_BATING_RATE);
            Assert.assertEquals(83.2, cricketLeagueData.get(0).avg, 0);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_WhenSort_ShouldReturnCricketers() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadBatsmanDetailsFile(FACTS_SHEET_MOST_RUNS);
            List<CricketLeagueDAO> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.STRIKING_RATE);
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
            cricketLeagueAnalyser.loadBatsmanDetailsFile(FACTS_SHEET_MOST_RUNS);
            List<CricketLeagueDAO> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.FOUR_SIX);
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
            cricketLeagueAnalyser.loadBatsmanDetailsFile(FACTS_SHEET_MOST_RUNS);
            List<CricketLeagueDAO> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.FOUR_SIX_STRIKE_RATE);
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
            cricketLeagueAnalyser.loadBatsmanDetailsFile(FACTS_SHEET_MOST_RUNS);
            List<CricketLeagueDAO> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.AVG_STRIKE_RATE);
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
            cricketLeagueAnalyser.loadBatsmanDetailsFile(FACTS_SHEET_MOST_RUNS);
            List<CricketLeagueDAO> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.RUNNS_AVERAGES);
            Assert.assertEquals("David Warner ", cricketLeagueData.get(0).player);
            Assert.assertEquals("Tim Southee", cricketLeagueData.get(100).player);

        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_WhenLoadShouldReturnData() throws CricketLeagueException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        List<CricketLeagueDAO> cricketLeagueData = cricketLeagueAnalyser.loadBowlersDetails(FACTS_SHEET_MOST_WKTS);
        Assert.assertEquals(99, cricketLeagueData.size());
    }


    @Test
    public void givenFileBowlerDetailsFile_WhenSort_ShouldReturnCricketersAvg() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadBowlersDetails(FACTS_SHEET_MOST_WKTS);
            List<CricketLeagueDAO> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.AVG_BATING_RATE);
            Assert.assertEquals(166.0, cricketLeagueData.get(0).avg, 0);
            Assert.assertEquals(0.0, cricketLeagueData.get(98).avg, 0);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }


}

