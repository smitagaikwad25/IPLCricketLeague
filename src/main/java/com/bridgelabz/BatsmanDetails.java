package com.bridgelabz;

import com.opencsv.bean.CsvBindByName;

public class BatsmanDetails {

    @CsvBindByName(column = "POS", required = true)
    public int pos;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int matches;

    @CsvBindByName(column = "Inns", required = true)
    public int inns;

    @CsvBindByName(column = "NO", required = true)
    public int no;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "HS", required = true)
    public int hs;

    @CsvBindByName(column = "Avg", required = true)
    public double batsmanAvg;

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

    public int getPos() {
        return pos;
    }

    public String getPlayer() {
        return player;
    }

    public int getMat() {
        return matches;
    }

    public int getInns() {
        return inns;
    }

    public int getNo() {
        return no;
    }

    public int getRuns() {
        return runs;
    }

    public int getHs() {
        return hs;
    }

    public double getAvg() {
        return batsmanAvg;
    }

    public double getBf() {
        return bf;
    }

    public double getSr() {
        return sr;
    }

    public int getCentury() {
        return century;
    }

    public int getHalfCentury() {
        return halfCentury;
    }

    public int getFour() {
        return four;
    }

    public int getSix() {
        return six;
    }

    public BatsmanDetails() {
    }

    public BatsmanDetails(int pos, String player, int matches, int inns, int no, int runs, int hs, double batsmanAvg, double bf, double sr, int century, int halfCentury, int four, int six) {
        this.pos = pos;
        this.player = player;
        this.matches = matches;
        this.inns = inns;
        this.no = no;
        this.runs = runs;
        this.hs = hs;
        this.batsmanAvg = batsmanAvg;
        this.bf = bf;
        this.sr = sr;
        this.century = century;
        this.halfCentury = halfCentury;
        this.four = four;
        this.six = six;
    }

    @Override
    public String toString() {
        return "BatsmanDetails{" +
                "pos=" + pos +
                ", player='" + player + '\'' +
                ", mat=" + matches +
                ", inns=" + inns +
                ", no=" + no +
                ", runs=" + runs +
                ", hs=" + hs +
                ", batsmanAvg=" + batsmanAvg +
                ", bf=" + bf +
                ", sr=" + sr +
                ", century=" + century +
                ", halfCentury=" + halfCentury +
                ", four=" + four +
                ", six=" + six +
                '}';
    }
}
