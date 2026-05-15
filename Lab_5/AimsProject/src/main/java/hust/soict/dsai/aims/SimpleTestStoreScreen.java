package hust.soict.dsai.aims;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimpleTestStoreScreen extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create simple UI to test JavaFX
        Label titleLabel = new Label("AIMS - JavaFX Test");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        
        Label statusLabel = new Label("JavaFX Application Running Successfully!");
        statusLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: green;");
        
        Label infoLabel = new Label("This is a simple test to verify JavaFX works on your IDE.");
        infoLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #666;");
        
        VBox root = new VBox(20, titleLabel, statusLabel, infoLabel);
        root.setStyle("-fx-padding: 40px; -fx-alignment: center;");
        
        Scene scene = new Scene(root, 400, 300);
        
        primaryStage.setTitle("Simple JavaFX Test");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        System.out.println("✅ JavaFX Application Started Successfully!");
        System.out.println("✅ UI Components Loaded!");
        System.out.println("✅ Stage and Scene Working!");
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
