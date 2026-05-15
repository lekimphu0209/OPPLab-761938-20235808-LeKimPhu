package hust.soict.dsai.aims.media;

public class Disc extends Media {
    protected String director;
    protected int length;

    public Disc(int id, String title, String category, float cost,
                String director, int length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public String getDirector() { return director; }
    public int getLength() { return length; }
}