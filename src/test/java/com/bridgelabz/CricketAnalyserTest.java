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
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.CricketerType.BATING);
        int cricketLeagueData = cricketLeagueAnalyser.loadCricketerData(FACTS_SHEET_MOST_RUNS);
        System.out.println(cricketLeagueData);
        Assert.assertEquals(100, cricketLeagueData);
    }

    @Test
    public void givenFile_WhenCorrect_ReturnException() throws CricketLeagueException {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.CricketerType.BATING);
            int cricketLeagueData = cricketLeagueAnalyser.loadCricketerData(WORNG_FACTS_SHEET_MOST_RUNS);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_WhenSort_ShouldReturnCricketersAvg() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.CricketerType.BATING);
            cricketLeagueAnalyser.loadCricketerData(FACTS_SHEET_MOST_RUNS);
            List<BatsmanDetails> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.AVG_BATING_RATE);
            System.out.println(cricketLeagueData);
            Assert.assertEquals(83.2, cricketLeagueData.get(0).avg, 0);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_WhenSort_ShouldReturnCricketers() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.CricketerType.BATING);
            cricketLeagueAnalyser.loadCricketerData(FACTS_SHEET_MOST_RUNS);
            List<BatsmanDetails> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.STRIKING_RATE);
            Assert.assertEquals(333.33, cricketLeagueData.get(0).sr, 0);
            Assert.assertEquals(63.15, cricketLeagueData.get(99).sr, 0);

        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_WhenSortAccordingFourAndSix_ShouldReturnSortedOutPut() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.CricketerType.BATING);
            cricketLeagueAnalyser.loadCricketerData(FACTS_SHEET_MOST_RUNS);
            List<BatsmanDetails> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.FOUR_SIX);
            Assert.assertEquals("Andre Russell", cricketLeagueData.get(0).player);
            Assert.assertEquals("Tim Southee", cricketLeagueData.get(99).player);

        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_WhenSortToKnowStrikingRatesWith6sAnd4s_ShouldReturnSortedOutPut() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.CricketerType.BATING);
            cricketLeagueAnalyser.loadCricketerData(FACTS_SHEET_MOST_RUNS);
            List<BatsmanDetails> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.FOUR_SIX_STRIKE_RATE);
            Assert.assertEquals("Andre Russell", cricketLeagueData.get(0).player);
            Assert.assertEquals("Tim Southee", cricketLeagueData.get(99).player);

        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_WhenSortToKnowAveragesWithBestStrikingRate_ShouldReturnSortedOutPut() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.CricketerType.BATING);
            cricketLeagueAnalyser.loadCricketerData(FACTS_SHEET_MOST_RUNS);
            List<BatsmanDetails> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.AVG_STRIKE_RATE);
            Assert.assertEquals("MS Dhoni", cricketLeagueData.get(0).player);
            Assert.assertEquals("Tim Southee", cricketLeagueData.get(99).player);

        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_WhenSortToKnowRunsWithAverages_ShouldReturnSortedOutPut() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.CricketerType.BATING);
            cricketLeagueAnalyser.loadCricketerData(FACTS_SHEET_MOST_RUNS);
            List<BatsmanDetails> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.RUNNS_AVERAGES);
            Assert.assertEquals("David Warner ", cricketLeagueData.get(0).player);
            Assert.assertEquals("Tim Southee", cricketLeagueData.get(99).player);

        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFile_WhenLoadShouldReturnData() throws CricketLeagueException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.CricketerType.BOWLER);
        int cricketLeagueData = cricketLeagueAnalyser.loadCricketerData(FACTS_SHEET_MOST_WKTS);
        Assert.assertEquals(99, cricketLeagueData);
    }

    @Test
    public void givenFileBowlerDetailsFile_WhenSort_ShouldReturnCricketersAvg() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.CricketerType.BOWLER);
            cricketLeagueAnalyser.loadCricketerData(FACTS_SHEET_MOST_WKTS);
            List<BowlersDetails> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.AVG_BATING_RATE);
            Assert.assertEquals(166.0, cricketLeagueData.get(0).avg, 0);
            Assert.assertEquals(0.0, cricketLeagueData.get(98).avg, 0);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFileBowlerDetailsFile_WhenSortToKnowStrikingRates_ShouldReturnCricketersAvg() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.CricketerType.BOWLER);
            cricketLeagueAnalyser.loadCricketerData(FACTS_SHEET_MOST_WKTS);
            List<BowlersDetails> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.STRIKING_RATE);
            System.out.println(cricketLeagueData);
            Assert.assertEquals(120.0, cricketLeagueData.get(0).sr, 0);
            Assert.assertEquals(0.0, cricketLeagueData.get(98).sr, 0);

        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFileBowlerDetailsFile_WhenSortToKnowBestEcom_ShouldReturnCricketersAvg() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.CricketerType.BOWLER);
            cricketLeagueAnalyser.loadCricketerData(FACTS_SHEET_MOST_WKTS);
            List<BowlersDetails> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.Ecom);
            Assert.assertEquals(13.5, cricketLeagueData.get(0).econ, 0);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFileBowlerDetailsFile_WhenSortToKnowStrikingWith4WAnd5W_ShouldReturnCricketersAvg() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.CricketerType.BOWLER);
            cricketLeagueAnalyser.loadCricketerData(FACTS_SHEET_MOST_WKTS);
            List<BowlersDetails> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.STRIKING_RATE_4W_5w);
            Assert.assertEquals("Krishnappa Gowtham", cricketLeagueData.get(0).player);
            Assert.assertEquals("Suresh Raina", cricketLeagueData.get(98).player);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFileBowlerDetailsFile_WhenSortToKnowAgerageWithStrikingRate_ShoudReturnSortedOutPut() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.CricketerType.BOWLER);
            cricketLeagueAnalyser.loadCricketerData(FACTS_SHEET_MOST_WKTS);
            List<BowlersDetails> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.AVG_STRIKE_RATE);
            Assert.assertEquals("Krishnappa Gowtham", cricketLeagueData.get(0).player);
            Assert.assertEquals("Suresh Raina", cricketLeagueData.get(98).player);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }

    @Test
    public void givenFileBowlerDetailsFile_WhenSortToKnowWhoTookMaximunWicketsWithBestBowling_ShoudReturnSortedOutPut() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.CricketerType.BOWLER);
            cricketLeagueAnalyser.loadCricketerData(FACTS_SHEET_MOST_WKTS);
            List<BowlersDetails> cricketLeagueData = cricketLeagueAnalyser.letsSorting(Sorting.fields.MAX_WICKETS_BOWLING);
            Assert.assertEquals("Imran Tahir", cricketLeagueData.get(0).player);
            Assert.assertEquals("Suresh Raina", cricketLeagueData.get(98).player);
        } catch (CricketLeagueException e) {
            Assert.assertEquals(CricketLeagueException.ExceptionType.FILE_PROBLEM, e.type);
        }
    }
}

