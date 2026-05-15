public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int lenght;
    private float cost;

    public int getLenght() {
        return lenght;
    }
    public String getDirector() {
        return director;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }

    public DigitalVideoDisc(String title) {
        this.title = title;
    }
    public DigitalVideoDisc( String category, String title, float cost ) {
        this.category = category;
        this.title = title;
        this.cost = cost;
    }
    public DigitalVideoDisc(String director, String category, String title, float cost ) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }
    public DigitalVideoDisc(String title, String category, String director, int length , float cost ) {
        this.title = title;
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

}
