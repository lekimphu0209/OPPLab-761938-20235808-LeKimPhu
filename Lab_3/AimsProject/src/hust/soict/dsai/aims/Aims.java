package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Lion King", 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladdin", 18.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Batman", 20.0f);

        // test add
        cart.addDigitalVideoDisc(dvd1, dvd2, dvd3);

        // print cart
        cart.print();

        // search
        System.out.println("\nSearch result:");
        cart.searchByTitle("Lion");
    }
}