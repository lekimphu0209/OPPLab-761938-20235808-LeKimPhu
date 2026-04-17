package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc items[] = new DigitalVideoDisc[100];
    private int qty = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        items[qty++] = dvd;
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < qty; i++) {
            if (items[i] == dvd) {
                for (int j = i; j < qty - 1; j++) {
                    items[j] = items[j + 1];
                }
                qty--;
                break;
            }
        }
    }
}