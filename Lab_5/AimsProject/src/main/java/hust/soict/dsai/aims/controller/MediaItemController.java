package hust.soict.dsai.aims.controller;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.cart.Cart;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MediaItemController {
    @FXML
    private Label titleLabel;
    
    @FXML
    private Label costLabel;
    
    @FXML
    private Button addToCartButton;
    
    @FXML
    private Button playButton;
    
    private Media media;
    private Cart cart;
    
    public void setData(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        titleLabel.setText(media.getTitle());
        costLabel.setText(String.format("$%.2f", media.getCost()));
        
        // Show play button only if media is playable
        if (media instanceof Playable) {
            playButton.setVisible(true);
        }
    }
    
    @FXML
    public void addToCart() {
        if (cart != null && media != null) {
            cart.addMedia(media);
            System.out.println("Added to cart: " + media.getTitle());
        }
    }
    
    @FXML
    public void play() {
        if (media instanceof Playable) {
            ((Playable) media).play();
        }
    }
}
