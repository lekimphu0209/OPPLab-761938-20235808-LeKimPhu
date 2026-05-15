package hust.soict.dsai.aims;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TestStoreScreen extends Application {
    private static Store store;
    private static Cart cart;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        // Initialize store and cart
        initializeData();
        
        // Load View Store screen
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/fxml/ViewStore.fxml"));
        Parent root = loader.load();
        
        primaryStage.setTitle("AIMS - JavaFX Test");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
        
        // Set controller data after scene is shown
        hust.soict.dsai.aims.controller.ViewStoreController controller = loader.getController();
        controller.setData(store, cart);
    }
    
    private void initializeData() {
        store = new Store();
        cart = new Cart();
        
        // Add sample media items
        try {
            Book book = new Book(1, "The Great Gatsby", "Fiction", 12.99f);
            book.addAuthor("F. Scott Fitzgerald");
            store.addMedia(book);
            
            CompactDisc cd = new CompactDisc(2, "Thriller", "Pop", 15.99f, "Michael Jackson", 42, "Michael Jackson");
            // Add tracks to CD to avoid length invalid error
            hust.soict.dsai.aims.media.Track track1 = new hust.soict.dsai.aims.media.Track("Billie Jean", 180);
            hust.soict.dsai.aims.media.Track track2 = new hust.soict.dsai.aims.media.Track("Beat It", 200);
            cd.addTrack(track1);
            cd.addTrack(track2);
            store.addMedia(cd);
            
            DigitalVideoDisc dvd = new DigitalVideoDisc(3, "The Matrix", "Sci-Fi", 19.99f, "The Wachowskis", 136);
            store.addMedia(dvd);
            
            System.out.println("Test data initialized successfully!");
            System.out.println("Store has " + store.getItemsInStore().size() + " items");
            
        } catch (Exception e) {
            System.err.println("Error initializing test data: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    // Static methods for data access
    public static Store getStore() {
        return store;
    }
    
    public static Cart getCart() {
        return cart;
    }
}
