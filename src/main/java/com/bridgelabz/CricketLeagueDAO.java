package com.bridgelabz;

public class CricketLeagueDAO {

    public int pos;
    public String player;
    public int matches;
    public int inns;
    public int no;
    public int runs;
    public int hs;
    public double batsmanAvg;
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
    public double bowlerAvg;

    public CricketLeagueDAO(BatsmanDetails batsmanDetails) {
        pos = batsmanDetails.pos;
        player = batsmanDetails.player;
        matches = batsmanDetails.matches;
        inns = batsmanDetails.inns;
        no = batsmanDetails.no;
        runs = batsmanDetails.runs;
        hs = batsmanDetails.hs;
        batsmanAvg = batsmanDetails.batsmanAvg;
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
        bowlerAvg = bowlersDetails.bowlerAvg;
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
                ", batsmanAvg=" + batsmanAvg +
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
                ", bowlerAvg=" + bowlerAvg +
                '}';
    }

    public Object getCricketDTO(CricketLeagueAnalyser.CricketerType cricketerType) {
        if (cricketerType.equals(CricketLeagueAnalyser.CricketerType.BATING))
            return new BatsmanDetails(pos,player,matches,inns,no,runs,hs,batsmanAvg,bf,sr,century,halfCentury,four,six);
        return new BowlersDetails(pos,player,matches,inns,overs,runs,wkts,bestBowlerInn,bowlerAvg ,econ,sr,fourWkts,fiveWkts);
    }
}


