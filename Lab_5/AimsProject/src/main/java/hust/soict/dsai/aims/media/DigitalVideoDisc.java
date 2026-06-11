package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(int id, String title, String category,
                            float cost, String director, int length) {
        super(id, title, category, cost, director, length);
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("DVD length is non-positive!");
        }
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("Length: " + getLength());
    }
}
