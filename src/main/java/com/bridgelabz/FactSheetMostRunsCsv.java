package com.bridgelabz;

import com.opencsv.bean.CsvBindByName;

public class FactSheetMostRunsCsv {

    @CsvBindByName(column = "POS", required = true)
    public int pos;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int mat;

    @CsvBindByName(column = "Inns", required = true)
    public int inns;

    @CsvBindByName(column = "NO", required = true)
    public int no;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "HS", required = true)
    public int hs;

    @CsvBindByName(column = "Avg", required = true)
    public double avg;

    @CsvBindByName(column = "BF", required = true)
    public double bf;

    @CsvBindByName(column = "SR", required = true)
    public double sr;

    @CsvBindByName(column = "100", required = true)
    public int century;

    @CsvBindByName(column = "50", required = true)
    public int halfCentury;

    @CsvBindByName(column = "4s", required = true)
    public int four;

    @CsvBindByName(column = "6s", required = true)
    public int six;


    @Override
    public String toString() {
        return "FactSheetMostRunsCsv{" +
                "pos=" + pos +
                ", player='" + player + '\'' +
                ", mat=" + mat +
                ", inns=" + inns +
                ", no=" + no +
                ", runs=" + runs +
                ", hs=" + hs +
                ", avg=" + avg +
                ", bf=" + bf +
                ", sr=" + sr +
                ", century=" + century +
                ", halfCentury=" + halfCentury +
                ", four=" + four +
                ", six=" + six +
                '}';
    }
}
