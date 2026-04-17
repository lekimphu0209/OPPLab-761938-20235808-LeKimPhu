package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX = 20;
    private DigitalVideoDisc items[] = new DigitalVideoDisc[MAX];
    private int qty = 0;

    // add 1 DVD
    public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
        if (qty < MAX) {
            items[qty++] = dvd;
            System.out.println("Added: " + dvd.getTitle());
        }
    }


    // add 2 DVD
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    // varargs
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            addDigitalVideoDisc(dvd);
        }
    }

    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < qty; i++) {
            sum += items[i].getCost();
        }
        return sum;
    }

    public void print() {
        System.out.println("CART:");
        for (int i = 0; i < qty; i++) {
            System.out.println(items[i]);
        }
        System.out.println("Total: " + totalCost());
    }

    public void searchByTitle(String title) {
        for (int i = 0; i < qty; i++) {
            if (items[i].isMatch(title)) {
                System.out.println(items[i]);
            }
        }
    }
}