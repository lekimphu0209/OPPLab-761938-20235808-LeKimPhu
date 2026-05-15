package hust.soict.dsai.aims.controller;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {
    @FXML
    private TableView<Media> cartTableView;
    
    @FXML
    private TableColumn<Media, Integer> idColumn;
    
    @FXML
    private TableColumn<Media, String> titleColumn;
    
    @FXML
    private TableColumn<Media, String> categoryColumn;
    
    @FXML
    private TableColumn<Media, Float> costColumn;
    
    @FXML
    private TextField filterTextField;
    
    @FXML
    private RadioButton filterByIdRadio;
    
    @FXML
    private RadioButton filterByTitleRadio;
    
    @FXML
    private Button playButton;
    
    @FXML
    private Button removeButton;

    @FXML
    private Button viewStoreButton;
    
    @FXML
    private Label totalCostLabel;
    
    private Cart cart;
    private ObservableList<Media> observableCart;
    private FilteredList<Media> filteredCart;
    
    public CartController() {
        // Default constructor for FXML
    }
    
    public CartController(Cart cart) {
        this.cart = cart;
    }
    
    public void setData(Cart cart) {
        this.cart = cart;
        setupTableView();
        setupFilter();
        setupSelectionListener();
        updateTotalCost();
    }
    
    @FXML
    public void initialize() {
        // Data will be set via setData() after FXML loading
    }
    
    private void setupTableView() {
        // Create observable list from cart items
        observableCart = FXCollections.observableArrayList(cart.getItemsOrdered());
        filteredCart = new FilteredList<>(observableCart, p -> true);
        
        // Setup columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        
        // Set data
        cartTableView.setItems(filteredCart);
    }
    
    private void setupFilter() {
        // Set up radio buttons
        ToggleGroup filterGroup = new ToggleGroup();
        filterByIdRadio.setToggleGroup(filterGroup);
        filterByTitleRadio.setToggleGroup(filterGroup);
        filterByIdRadio.setSelected(true);
        
        // Add listener to filter text field
        filterTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            applyFilter();
        });
        
        // Add listener to radio buttons
        filterGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            applyFilter();
        });
    }
    
    private void applyFilter() {
        String filterText = filterTextField.getText().toLowerCase();
        boolean filterById = filterByIdRadio.isSelected();
        
        filteredCart.setPredicate(media -> {
            if (filterText == null || filterText.isEmpty()) {
                return true;
            }
            
            if (filterById) {
                return String.valueOf(media.getId()).toLowerCase().contains(filterText);
            } else {
                return media.getTitle().toLowerCase().contains(filterText);
            }
        });
    }
    
    private void setupSelectionListener() {
        cartTableView.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                boolean hasSelection = newValue != null;
                playButton.setDisable(!hasSelection || !(newValue instanceof Playable));
                removeButton.setDisable(!hasSelection);
            }
        );
    }
    
    private void updateTotalCost() {
        float total = cart.totalCost();
        totalCostLabel.setText(String.format("Total Cost: $%.2f", total));
    }
    
    @FXML
    public void viewStore() {
        try {
            // Load View Store screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/fxml/ViewStore.fxml"));
            Parent root = loader.load();
            
            // Set controller data
            ViewStoreController controller = loader.getController();
            controller.setData(hust.soict.dsai.aims.Aims.getStore(), hust.soict.dsai.aims.Aims.getCart());
            
            // Get current stage and switch scene
            Stage stage = (Stage) viewStoreButton.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
            stage.setTitle("AIMS - Store");
            
        } catch (IOException e) {
            showAlert("Navigation Error", "Cannot load store screen: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    @FXML
    public void playMedia() {
        Media selectedMedia = cartTableView.getSelectionModel().getSelectedItem();
        if (selectedMedia instanceof Playable) {
            ((Playable) selectedMedia).play();
        }
    }
    
    @FXML
    public void removeMedia() {
        Media selectedMedia = cartTableView.getSelectionModel().getSelectedItem();
        if (selectedMedia != null) {
            cart.removeMedia(selectedMedia);
            observableCart.remove(selectedMedia);
            updateTotalCost();
        }
    }
    
    @FXML
    public void placeOrder() {
        if (cart.getItemsOrdered().isEmpty()) {
            showAlert("Order Error", "Cart is empty!", Alert.AlertType.WARNING);
            return;
        }
        
        // Place order logic
        float totalCost = cart.totalCost();
        
        // Create order summary
        StringBuilder orderSummary = new StringBuilder();
        orderSummary.append("Order Summary:\n\n");
        orderSummary.append("Items:\n");
        for (Media media : cart.getItemsOrdered()) {
            orderSummary.append("- ").append(media.getTitle())
                      .append(" ($").append(String.format("%.2f", media.getCost())).append(")\n");
        }
        orderSummary.append("\nTotal Cost: $").append(String.format("%.2f", totalCost));
        
        // Show order confirmation
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm Order");
        confirmAlert.setHeaderText("Place Order");
        confirmAlert.setContentText(orderSummary.toString());
        
        if (confirmAlert.showAndWait().get() == ButtonType.OK) {
            // Process order
            cart.getItemsOrdered().clear();
            observableCart.clear();
            updateTotalCost();
            
            showAlert("Order Successful", 
                     "Your order has been placed successfully!\nTotal: $" + String.format("%.2f", totalCost), 
                     Alert.AlertType.INFORMATION);
        }
    }
    
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
