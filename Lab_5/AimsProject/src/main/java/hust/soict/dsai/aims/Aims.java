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

public class Aims extends Application {
    private static Store store;
    private static Cart cart;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        // Initialize store and cart
        initializeData();
        
        // Load View Store screen
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/fxml/ViewStore.fxml"));
        Parent root = loader.load();
        
        primaryStage.setTitle("AIMS - JavaFX");
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
            store.addMedia(cd);
            
            DigitalVideoDisc dvd = new DigitalVideoDisc(3, "The Matrix", "Sci-Fi", 19.99f, "The Wachowskis", 136);
            store.addMedia(dvd);
            
        } catch (Exception e) {
            System.err.println("Error initializing data: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    // Static methods for scene switching
    public static Store getStore() {
        return store;
    }
    
    public static Cart getCart() {
        return cart;
    }
}
