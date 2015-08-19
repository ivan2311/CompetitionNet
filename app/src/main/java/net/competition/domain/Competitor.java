package net.competition.domain;

/**
 * Created by Korisnik on 7/23/2015.
 */
public class Competitor {

    private String name;
    private byte[] image;

    public Competitor(String name) {
        this.name = name;
    }

    public Competitor(String name, byte[] image) {
        this(name);
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
