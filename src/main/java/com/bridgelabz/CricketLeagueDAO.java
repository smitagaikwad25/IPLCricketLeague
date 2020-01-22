package com.bridgelabz;

public class CricketLeagueDAO {

    public int pos;
    public String player;
    public int matches;
    public int inns;
    public int no;
    public int runs;
    public int hs;
    public double avg;
    public double bf;
    public double sr;
    public int century;
    public int halfCentury;
    public int four;
    public int six;
    public double overs;
    public int wkts;
    public int bestBowlerInn;
    public double econ;
    public int fourWkts;
    public int fiveWkts;


    public CricketLeagueDAO(BatsmanDetails batsmanDetails) {
        pos = batsmanDetails.pos;
        player = batsmanDetails.player;
        matches = batsmanDetails.matches;
        inns = batsmanDetails.inns;
        no = batsmanDetails.no;
        runs = batsmanDetails.runs;
        hs = batsmanDetails.hs;
        avg = batsmanDetails.avg;
        bf = batsmanDetails.bf;
        sr = batsmanDetails.sr;
        century = batsmanDetails.century;
        halfCentury = batsmanDetails.halfCentury;
        four = batsmanDetails.four;
        six = batsmanDetails.six;
    }

    public CricketLeagueDAO(BowlersDetails bowlersDetails) {
        pos = bowlersDetails.pos;
        player = bowlersDetails.player;
        matches = bowlersDetails.matches;
        inns = bowlersDetails.inns;
        runs = bowlersDetails.runs;
        avg = bowlersDetails.avg;
        sr = bowlersDetails.sr;
        overs = bowlersDetails.overs;
        wkts = bowlersDetails.wkts;
        bestBowlerInn = bowlersDetails.bestBowlerInn;
        econ = bowlersDetails.econ;
        fourWkts = bowlersDetails.fourWkts;
        fiveWkts = bowlersDetails.fiveWkts;
    }

    @Override
    public String toString() {
        return "CricketLeagueDAO{" +
                "pos=" + pos +
                ", player='" + player + '\'' +
                ", matches=" + matches +
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
                ", overs=" + overs +
                ", wkts=" + wkts +
                ", bestBowlerInn=" + bestBowlerInn +
                ", econ=" + econ +
                ", fourWkts=" + fourWkts +
                ", fiveWkts=" + fiveWkts +
                '}';
    }
}



