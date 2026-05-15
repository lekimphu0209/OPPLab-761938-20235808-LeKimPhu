package hust.soict.dsai.aims.controller;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.IOException;

public class ViewStoreController {
    @FXML
    private GridPane mediaGridPane;

    @FXML
    private Button viewCartButton;
    
    private Store store;
    private Cart cart;
    
    public ViewStoreController() {
        // Default constructor for FXML
    }
    
    public ViewStoreController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }
    
    public void setData(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        loadMediaItems();
    }
    
    @FXML
    public void initialize() {
        // Data will be set via setData() after FXML loading
    }
    
    private void loadMediaItems() {
        int column = 0;
        int row = 0;
        
        for (Media media : store.getItemsInStore()) {
            try {
                // Load the MediaItem.fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/fxml/MediaItem.fxml"));
                AnchorPane mediaItemPane = loader.load();
                
                // Get the controller and set data
                MediaItemController controller = loader.getController();
                controller.setData(media, cart);
                
                // Add to grid
                mediaGridPane.add(mediaItemPane, column, row);
                
                // Update grid position
                column++;
                if (column >= 3) {
                    column = 0;
                    row++;
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    @FXML
    public void viewCart() {
        try {
            // Load Cart screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/fxml/Cart.fxml"));
            Parent root = loader.load();
            
            // Set controller data
            CartController controller = loader.getController();
            controller.setData(cart);
            
            // Get current stage and switch scene
            Stage stage = (Stage) viewCartButton.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
            stage.setTitle("AIMS - Cart");
            
        } catch (IOException e) {
            System.err.println("Cannot load cart screen: " + e.getMessage());
            // Show error dialog
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Navigation Error");
            errorAlert.setHeaderText("Cannot Load Cart Screen");
            errorAlert.setContentText("An error occurred while loading the cart screen: " + e.getMessage());
            errorAlert.showAndWait();
        }
    }
}
