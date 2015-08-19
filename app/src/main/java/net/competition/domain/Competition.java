package net.competition.domain;

/**
 * Created by Korisnik on 7/23/2015.
 */
public class Competition {

    private int id;
    private String name;

    public Competition(String name) {
        this.name = name;
    }

    public Competition(int id, String name) {
        this(name);
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
