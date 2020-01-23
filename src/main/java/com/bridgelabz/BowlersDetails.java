package com.bridgelabz;

import com.opencsv.bean.CsvBindByName;

public class BowlersDetails {

    @CsvBindByName(column = "POS", required = true)
    public int pos;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int matches;

    @CsvBindByName(column = "Inns", required = true)
    public int inns;

    @CsvBindByName(column = "Ov", required = true)
    public double overs;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "Wkts", required = true)
    public int wkts;

    @CsvBindByName(column = "BBI", required = true)
    public int bestBowlerInn;

    @CsvBindByName(column = "Avg", required = true)
    public double avg;

    @CsvBindByName(column = "Econ", required = true)
    public double econ;

    @CsvBindByName(column = "SR", required = true)
    public double sr;

    @CsvBindByName(column = "4w", required = true)
    public int fourWkts;

    @CsvBindByName(column = "5w", required = true)
    public int fiveWkts;

    public int getPos() {
        return pos;
    }

    public String getPlayer() {
        return player;
    }

    public int getMatches() {
        return matches;
    }

    public int getInns() {
        return inns;
    }

    public double getOvers() {
        return overs;
    }

    public int getRuns() {
        return runs;
    }

    public int getWkts() {
        return wkts;
    }

    public int getBestBowlerInn() {
        return bestBowlerInn;
    }

    public double getAvg() {
        return avg;
    }

    public double getEcon() {
        return econ;
    }

    public double getSr() {
        return sr;
    }

    public int getFourWkts() {
        return fourWkts;
    }

    public int getFiveWkts() {
        return fiveWkts;
    }

    public BowlersDetails() {
    }

    public BowlersDetails(int pos, String player, int matches, int inns, double overs, int runs, int wkts, int bestBowlerInn, double avg, double econ, double sr, int fourWkts, int fiveWkts) {
        this.pos = pos;
        this.player = player;
        this.matches = matches;
        this.inns = inns;
        this.overs = overs;
        this.runs = runs;
        this.wkts = wkts;
        this.bestBowlerInn = bestBowlerInn;
        this.avg = avg;
        this.econ = econ;
        this.sr = sr;
        this.fourWkts = fourWkts;
        this.fiveWkts = fiveWkts;
    }

    @Override
    public String toString() {
        return "BowlersDetails{" +
                "pos=" + pos +
                ", player=" + player +
                ", matches=" + matches +
                ", inns=" + inns +
                ", overs=" + overs +
                ", runs=" + runs +
                ", wkts=" + wkts +
                ", bestBowlerInn=" + bestBowlerInn +
                ", avg=" + avg +
                ", econ=" + econ +
                ", sr=" + sr +
                ", fourWkts=" + fourWkts +
                ", fiveWkts=" + fiveWkts +
                '}';
    }
}
