package hust.soict.dsai.aims;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

// Simple Media class for testing
class SimpleMedia {
    private String title;
    private String category;
    private float cost;
    private boolean playable;
    
    public SimpleMedia(String title, String category, float cost, boolean playable) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.playable = playable;
    }
    
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCost() { return cost; }
    public boolean isPlayable() { return playable; }
    
    public void play() {
        System.out.println("Playing: " + title);
    }
}

public class SimpleMediaItemController {
    @FXML
    private Label titleLabel;
    
    @FXML
    private Label costLabel;
    
    @FXML
    private Button addToCartButton;
    
    @FXML
    private Button playButton;
    
    private SimpleMedia media;
    
    public void setData(SimpleMedia media) {
        this.media = media;
        titleLabel.setText(media.getTitle());
        costLabel.setText(String.format("$%.2f", media.getCost()));
        
        // Show play button only if media is playable
        if (media.isPlayable()) {
            playButton.setVisible(true);
        } else {
            playButton.setVisible(false);
        }
    }
    
    @FXML
    public void addToCart() {
        if (media != null) {
            System.out.println("Added to cart: " + media.getTitle());
            // Add to cart logic would require access to cart instance
        }
    }
    
    @FXML
    public void play() {
        if (media != null && media.isPlayable()) {
            try {
                media.play();
            } catch (Exception e) {
                System.err.println("Cannot play media: " + e.getMessage());
                javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
                alert.setTitle("Playback Error");
                alert.setHeaderText(null);
                alert.setContentText("Cannot play media: " + e.getMessage());
                alert.showAndWait();
            }
        }
    }
}
