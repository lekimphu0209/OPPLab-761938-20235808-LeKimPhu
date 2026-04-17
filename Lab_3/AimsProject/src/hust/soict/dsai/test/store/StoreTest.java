package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd = new DigitalVideoDisc("Batman", 15.0f);

        store.addDVD(dvd);
        store.removeDVD(dvd);
    }
}