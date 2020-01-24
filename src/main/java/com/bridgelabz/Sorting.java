package com.bridgelabz;

import java.util.Comparator;
import java.util.HashMap;

public class Sorting {

    public enum fields {
        AVG_BATING_RATE, STRIKING_RATE, FOUR_SIX, FOUR_SIX_STRIKE_RATE, AVG_STRIKE_RATE, RUNNS_AVERAGES, Ecom, STRIKING_RATE_4W_5w, MAX_WICKETS_BOWLING, ALL_ROUNDER_PLAYER, BEST_BATING_BOWLING_AVG, AVG_BOWLING_RATE;
    }

    HashMap<fields, Comparator<CricketLeagueDAO>> compareFields = new HashMap<>();

    public Comparator getFiled(fields field) {

        Comparator<CricketLeagueDAO> avgBatingRate = (data1, data2) -> (int) (data1.batsmanAvg - data2.batsmanAvg);
        compareFields.put(fields.AVG_BATING_RATE, avgBatingRate);

        Comparator<CricketLeagueDAO> avgBowlingRate = (data1, data2) -> (int) (data1.bowlerAvg - data2.bowlerAvg);
        compareFields.put(fields.AVG_BOWLING_RATE, avgBowlingRate);


        Comparator<CricketLeagueDAO> striking = (data1, data2) -> (int) (data1.sr - data2.sr);
        compareFields.put(fields.STRIKING_RATE, striking);

        Comparator<CricketLeagueDAO> sortNumberOfFourAndSix = (obj1, obj2) -> ((obj1.four * 4 + obj1.six * 6) < (obj2.four * 4 + obj2.six * 6) ? -1 : 1);
        compareFields.put(fields.FOUR_SIX, sortNumberOfFourAndSix);

        Comparator<CricketLeagueDAO> FourAndSixWithStrik = sortNumberOfFourAndSix.thenComparing((data1, data2) -> (int) (data1.sr - data2.sr));
        compareFields.put(field.FOUR_SIX_STRIKE_RATE, FourAndSixWithStrik);

        Comparator<CricketLeagueDAO> AverageWithStriking = avgBatingRate.thenComparing(striking);
        compareFields.put(fields.AVG_STRIKE_RATE, AverageWithStriking);

        Comparator<CricketLeagueDAO> cricketersRun = (data1, data2) -> (int) (data1.runs - data2.runs);

        Comparator<CricketLeagueDAO> runnsWithAverages = cricketersRun.thenComparing(avgBatingRate);
        compareFields.put(fields.RUNNS_AVERAGES, runnsWithAverages);

        Comparator<CricketLeagueDAO> bestEcom = (data1, data2) -> (int) ((data1.econ) < (data2.econ) ? -1 : 1);
        compareFields.put(fields.Ecom, bestEcom);

        Comparator<CricketLeagueDAO> fourAndFiveWkts = (obj1, obj2) -> ((obj1.fourWkts * 4 + obj2.fiveWkts) < (obj1.fiveWkts * 4 + obj2.fourWkts) ? -1 : 1);

        Comparator<CricketLeagueDAO> strikingFourAndFiveWkts = striking.thenComparing(fourAndFiveWkts);
        compareFields.put(fields.STRIKING_RATE_4W_5w, strikingFourAndFiveWkts);

        Comparator<CricketLeagueDAO> wkts = (data1, data2) -> (int) ((data1.wkts - data2.wkts));
        Comparator<CricketLeagueDAO> maxWktsWithBestBowling = wkts.thenComparing((obj1, obj2) -> ((int) (obj1.bestBowlerInn) < (obj2.bestBowlerInn) ? -1 : 1));
        compareFields.put(fields.MAX_WICKETS_BOWLING, maxWktsWithBestBowling);

        Comparator<CricketLeagueDAO> bestBatsmanAndBowlerAvg = avgBatingRate.thenComparing(avgBowlingRate);
        compareFields.put(fields.BEST_BATING_BOWLING_AVG, bestBatsmanAndBowlerAvg);

        Comparator<CricketLeagueDAO> allRounderPlayer = Comparator.comparing(CricketLeagueDAO -> {
            if (CricketLeagueDAO.wkts > 7 && CricketLeagueDAO.runs > 150)
                return CricketLeagueDAO.runs + (CricketLeagueDAO.wkts * 20);
            return 0;
        });
        compareFields.put(fields.ALL_ROUNDER_PLAYER, allRounderPlayer);

        Comparator comparator = compareFields.get(field);
        return comparator;

    }

}
