package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import hust.soict.dsai.aims.media.*;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media m) {
        itemsOrdered.add(m);
        System.out.println("Added to cart");
    }

    public void removeMedia(Media m) {
        itemsOrdered.remove(m);
        System.out.println("Removed from cart");
    }

    public float totalCost() {
        float sum = 0;
        for (Media m : itemsOrdered) {
            sum += m.getCost();
        }
        return sum;
    }

    public void print() {
        System.out.println("\nCART:");
        for (Media m : itemsOrdered) {
            System.out.println(m);
        }
        System.out.println("Total: " + totalCost());
    }


    public void searchByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found: " + m);
                return;
            }
        }
        System.out.println("Not found!");
    }


    public void sortByTitle() {
        Collections.sort(itemsOrdered, new Comparator<Media>() {
            public int compare(Media m1, Media m2) {
                return m1.getTitle().compareToIgnoreCase(m2.getTitle());
            }
        });
    }


    public void removeByTitle(String title) {
        Media toRemove = null;

        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                toRemove = m;
                break;
            }
        }

        if (toRemove != null) {
            itemsOrdered.remove(toRemove);
            System.out.println("Removed!");
        } else {
            System.out.println("Not found!");
        }
    }


    public void playByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                if (m instanceof Playable) {
                    ((Playable) m).play();
                } else {
                    System.out.println("Cannot play!");
                }
                return;
            }
        }
        System.out.println("Not found!");
    }

    public void clear() {
        itemsOrdered.clear();
        System.out.println("Cart is now empty");
    }
}