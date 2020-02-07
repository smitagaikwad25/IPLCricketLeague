package com.bridgelabz.com.bridgelabz;

import com.bridgelabz.AdapterFactory;
import com.bridgelabz.CricketLeagueAnalyser;
import com.bridgelabz.CricketLeagueDAO;
import com.bridgelabz.CricketLeagueException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

public class CricketLeagueMockitoTest {

    public String FACTS_SHEET_MOST_RUNS = "./src/test/resources/IPLFactSheetRuns.csv";

    @Mock
    AdapterFactory adapterFactoryMock;

    @Rule
    public MockitoRule mockitoRule = new MockitoJUnit().rule();


    @Test
    public void givenFile_WhenCorrect_ShouldReturnData() throws CricketLeagueException {
        Map<String, CricketLeagueDAO> data = new HashMap<>();
        data.put("smita",new CricketLeagueDAO());
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.CricketerType.BATING,adapterFactoryMock);
        when(adapterFactoryMock.getCricketerData(CricketLeagueAnalyser.CricketerType.BATING,FACTS_SHEET_MOST_RUNS)).thenReturn(data);
        int cricketLeagueData = cricketLeagueAnalyser.loadCricketerData(FACTS_SHEET_MOST_RUNS);
        System.out.println(data);
        Assert.assertEquals(1, cricketLeagueData);
    }

}
