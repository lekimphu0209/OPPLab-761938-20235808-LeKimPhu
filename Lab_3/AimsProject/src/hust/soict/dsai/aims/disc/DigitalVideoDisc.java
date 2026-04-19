package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0;

    private int id;
    private String title;
    private float cost;

    public DigitalVideoDisc(String title, float cost) {
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public String getTitle() { return title; }
    public float getCost() { return cost; }
    public int getId() { return id; }

    public boolean isMatch(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }

    public String toString() {
        return "DVD - " + title + " - " + cost + " $";
    }
}