package net.competition.domain;

/**
 * Created by Korisnik on 7/23/2015.
 */
public class Match {

    private Competitor home;
    private Competitor away;
    private Result result;

    public Match(Competitor home, Competitor away, Result result) {
        this.home = home;
        this.away = away;
    }

    public Competitor getHome() {
        return home;
    }

    public Competitor getAway() {
        return away;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
