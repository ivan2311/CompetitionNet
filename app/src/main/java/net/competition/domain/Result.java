package net.competition.domain;

/**
 * Created by Korisnik on 7/24/2015.
 */
public class Result {

    private boolean winnerHome;
    private String description;

    public Result(boolean winnerHome, String description) {
        this.winnerHome = winnerHome;
        this.description = description;
    }

    public boolean isWinnerHome() {
        return winnerHome;
    }

    public String getDescription() {
        return description;
    }
}
