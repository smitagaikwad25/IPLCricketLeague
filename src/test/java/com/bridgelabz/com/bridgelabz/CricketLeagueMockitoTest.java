package com.bridgelabz.com.bridgelabz;

import com.bridgelabz.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

public class CricketLeagueMockitoTest {

    public String FACTS_SHEET_MOST_RUNS = "./src/test/resources/IPLFactSheetRuns.csv";

    @Mock
    AdapterFactoryToMock adapterFactoryMock;

    @Rule
    public MockitoRule mockitoRule = new MockitoJUnit().rule();


    @Before
    public void givenFile_WhenCorrect_ShouldReturnData() throws CricketLeagueException {
        Map<String, CricketLeagueDAO> data = new HashMap<>();
        BatsmanDetails batsmanDetails = new BatsmanDetails(1, "David Warner", 12, 12, 2, 692, 100, 69.2, 481, 143.86, 1, 8, 57, 21);
        BatsmanDetails batsmanDetails1 = new BatsmanDetails(2, "KL Rahul", 14, 14, 3, 593, 100, 53.9, 438, 135.38, 1, 6, 49, 25);
        data.put("David Warner", new CricketLeagueDAO(batsmanDetails));
        data.put("KL Rahul", new CricketLeagueDAO(batsmanDetails1));
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.CricketerType.BATING, adapterFactoryMock);
        when(adapterFactoryMock.getCricketerData(CricketLeagueAnalyser.CricketerType.BATING, FACTS_SHEET_MOST_RUNS)).thenReturn(data);
        int cricketLeagueData = cricketLeagueAnalyser.loadCricketerData(FACTS_SHEET_MOST_RUNS);
        Assert.assertEquals(2, cricketLeagueData);
    }
    @Test
    public void givenFile_WhenCorrect_ShouldReturnInformation() throws CricketLeagueException {
        Map<String, CricketLeagueDAO> data = new HashMap<>();
        data.put("smita", new CricketLeagueDAO());
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.CricketerType.BOWLER, adapterFactoryMock);
        when(adapterFactoryMock.getCricketerData(CricketLeagueAnalyser.CricketerType.BOWLER, FACTS_SHEET_MOST_RUNS)).thenReturn(data);
        int cricketLeagueData = cricketLeagueAnalyser.loadCricketerData(FACTS_SHEET_MOST_RUNS);
        Assert.assertEquals(1, cricketLeagueData);
    }
}

