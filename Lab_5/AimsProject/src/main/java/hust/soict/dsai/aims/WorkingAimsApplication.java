package hust.soict.dsai.aims;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

class WorkingSimpleMedia {
    private int id;
    private String title;
    private String category;
    private float cost;
    
    public WorkingSimpleMedia(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCost() { return cost; }
    
    @Override
    public String toString() {
        return title + " - " + category + " - $" + String.format("%.2f", cost);
    }
}

class SimpleStore {
    private List<WorkingSimpleMedia> items = new ArrayList<>();
    
    public void addMedia(WorkingSimpleMedia media) {
        items.add(media);
        System.out.println("Added to store: " + media.getTitle());
    }
    
    public List<WorkingSimpleMedia> getItemsInStore() {
        return items;
    }
}

class SimpleCart {
    private List<WorkingSimpleMedia> items = new ArrayList<>();
    
    public void addMedia(WorkingSimpleMedia media) {
        items.add(media);
        System.out.println("Added to cart: " + media.getTitle());
    }
    
    public List<WorkingSimpleMedia> getItemsOrdered() {
        return items;
    }
    
    public float totalCost() {
        float total = 0;
        for (WorkingSimpleMedia media : items) {
            total += media.getCost();
        }
        return total;
    }
    
    public void clear() {
        items.clear();
        System.out.println("Cart cleared");
    }
}

public class WorkingAimsApplication extends Application {
    private static SimpleStore store;
    private static SimpleCart cart;
    
    @Override
    public void start(Stage primaryStage) {
        initializeData();
        
        BorderPane root = new BorderPane();
        
        Label headerLabel = new Label("AIMS - JavaFX Store Management");
        headerLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #2E86AB;");
        
        HBox headerBox = new HBox(headerLabel);
        headerBox.setStyle("-fx-padding: 20px; -fx-alignment: center; -fx-background-color: #f0f0f0;");
        root.setTop(headerBox);
        
        VBox storeContent = new VBox(15);
        storeContent.setStyle("-fx-padding: 20px;");
        
        Label storeTitle = new Label("Store Items");
        storeTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        
        ListView<String> storeListView = new ListView<>();
        for (WorkingSimpleMedia media : store.getItemsInStore()) {
            storeListView.getItems().add(media.toString());
        }
        
        Button addToCartButton = new Button("Add Selected to Cart");
        addToCartButton.setStyle("-fx-font-size: 14px; -fx-background-color: #4CAF50; -fx-text-fill: white;");
        addToCartButton.setOnAction(e -> {
            int selectedIndex = storeListView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                WorkingSimpleMedia selectedMedia = store.getItemsInStore().get(selectedIndex);
                cart.addMedia(selectedMedia);
                showAlert("Success", "Added to cart: " + selectedMedia.getTitle(), Alert.AlertType.INFORMATION);
            } else {
                showAlert("Warning", "Please select an item from store", Alert.AlertType.WARNING);
            }
        });
        
        storeContent.getChildren().addAll(storeTitle, storeListView, addToCartButton);
        root.setCenter(storeContent);
        
        VBox cartContent = new VBox(15);
        cartContent.setStyle("-fx-padding: 20px; -fx-background-color: #f9f9f9;");
        
        Label cartTitle = new Label("Shopping Cart");
        cartTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        
        ListView<String> cartListView = new ListView<>();
        updateCartDisplay(cartListView);
        
        Label totalLabel = new Label();
        updateTotalDisplay(totalLabel);
        
        HBox cartButtons = new HBox(10);
        cartButtons.setStyle("-fx-alignment: center;");
        
        Button placeOrderButton = new Button("Place Order");
        placeOrderButton.setStyle("-fx-font-size: 14px; -fx-background-color: #FF9800; -fx-text-fill: white;");
        placeOrderButton.setOnAction(e -> {
            if (cart.getItemsOrdered().isEmpty()) {
                showAlert("Warning", "Cart is empty!", Alert.AlertType.WARNING);
            } else {
                showAlert("Order Placed", "Order placed successfully!\nTotal: $" + String.format("%.2f", cart.totalCost()), Alert.AlertType.INFORMATION);
                cart.clear();
                updateCartDisplay(cartListView);
                updateTotalDisplay(totalLabel);
            }
        });
        
        Button clearCartButton = new Button("Clear Cart");
        clearCartButton.setStyle("-fx-font-size: 14px; -fx-background-color: #f44336; -fx-text-fill: white;");
        clearCartButton.setOnAction(e -> {
            cart.clear();
            updateCartDisplay(cartListView);
            updateTotalDisplay(totalLabel);
            showAlert("Info", "Cart cleared!", Alert.AlertType.INFORMATION);
        });
        
        cartButtons.getChildren().addAll(placeOrderButton, clearCartButton);
        cartContent.getChildren().addAll(cartTitle, cartListView, totalLabel, cartButtons);
        root.setRight(cartContent);
        
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("AIMS - JavaFX Working Application");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        System.out.println("✅ AIMS JavaFX Application Started!");
        System.out.println("✅ Store loaded with " + store.getItemsInStore().size() + " items");
    }
    
    private void initializeData() {
        store = new SimpleStore();
        cart = new SimpleCart();
        
        store.addMedia(new WorkingSimpleMedia(1, "The Great Gatsby", "Fiction", 12.99f));
        store.addMedia(new WorkingSimpleMedia(2, "Thriller", "Music", 15.99f));
        store.addMedia(new WorkingSimpleMedia(3, "The Matrix", "Sci-Fi", 19.99f));
        store.addMedia(new WorkingSimpleMedia(4, "Clean Code", "Programming", 45.00f));
        store.addMedia(new WorkingSimpleMedia(5, "Java Programming", "Education", 35.50f));
        
        System.out.println("Store initialized with sample data");
    }
    
    private void updateCartDisplay(ListView<String> cartListView) {
        cartListView.getItems().clear();
        for (WorkingSimpleMedia media : cart.getItemsOrdered()) {
            cartListView.getItems().add(media.toString());
        }
    }
    
    private void updateTotalDisplay(Label totalLabel) {
        totalLabel.setText("Total: $" + String.format("%.2f", cart.totalCost()));
        totalLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #4CAF50;");
    }
    
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
