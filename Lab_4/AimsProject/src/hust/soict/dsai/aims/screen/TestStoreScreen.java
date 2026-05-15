package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

import javax.swing.SwingUtilities;

public class TestStoreScreen {
    public static void main(String[] args) {
        // Create a test store
        Store store = new Store();
        
        // Add some test media items
        Book book = new Book(1, "The Great Gatsby", "Fiction", 12.99f);
        book.addAuthor("F. Scott Fitzgerald");
        store.addMedia(book);
        
        CompactDisc cd = new CompactDisc(2, "Thriller", "Pop", 15.99f, "Michael Jackson", 42, "Michael Jackson");
        store.addMedia(cd);
        
        DigitalVideoDisc dvd = new DigitalVideoDisc(3, "The Matrix", "Sci-Fi", 19.99f, "The Wachowskis", 136);
        store.addMedia(dvd);
        
        // Launch the GUI
        SwingUtilities.invokeLater(() -> new StoreManagerScreen(store));
    }
}
