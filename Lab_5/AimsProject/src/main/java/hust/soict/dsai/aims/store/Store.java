package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.List;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public List<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void addMedia(Media m) {
        itemsInStore.add(m);
        System.out.println("Added to store");
    }

    public void removeMedia(Media m) {
        itemsInStore.remove(m);
        System.out.println("Removed from store");
    }

    public Media findByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

    public void print() {
        System.out.println("\nSTORE:");
        for (Media m : itemsInStore) {
            System.out.println(m);
        }
    }
}
