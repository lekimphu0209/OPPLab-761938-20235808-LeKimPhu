package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Jungle", 10);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Cinderella", 12);

        swap(dvd1, dvd2);

        System.out.println(dvd1.getTitle()); // vẫn Jungle
    }
}