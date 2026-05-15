package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String name) {
        if (!authors.contains(name)) authors.add(name);
    }

    public void removeAuthor(String name) {
        authors.remove(name);
    }
}