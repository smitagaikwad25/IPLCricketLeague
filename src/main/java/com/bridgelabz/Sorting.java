package com.bridgelabz;

import java.util.Comparator;
import java.util.HashMap;

public class Sorting {

    public enum fields {
        AVG_BATING_RATE, STRIKING_RATE, FOUR_SIX, FOUR_SIX_STRIKE_RATE, Avg_STRIKE_RATE;
    }

    HashMap<fields, Comparator<BatsmanDetails>> compareFields = new HashMap<>();

    public Comparator getFiled(fields field) {

        Comparator<BatsmanDetails> avgBatingRate = (data1, data2) -> (int) (data1.avg - data2.avg);
        compareFields.put(fields.AVG_BATING_RATE, avgBatingRate);

        Comparator<BatsmanDetails> striking = (data1, data2) -> (int) (data1.sr - data2.sr);
        compareFields.put(fields.STRIKING_RATE, striking);

        Comparator<BatsmanDetails> sortNumberOfFourAndSix = (obj1, obj2) -> ((obj1.four * 4 + obj1.six * 6) < (obj2.four * 4 + obj2.six * 6) ? -1 : 1);
        compareFields.put(fields.FOUR_SIX, sortNumberOfFourAndSix);

        Comparator<BatsmanDetails> FourAndSixWithStrik = sortNumberOfFourAndSix.thenComparing((data1, data2) -> (int) (data1.sr - data2.sr));
        compareFields.put(field.FOUR_SIX_STRIKE_RATE, FourAndSixWithStrik);

        Comparator<BatsmanDetails> AverageWithStriking =avgBatingRate.thenComparing(striking);
        compareFields.put(fields.Avg_STRIKE_RATE,AverageWithStriking);

        Comparator comparator = compareFields.get(field);
        return comparator;
    }
}
