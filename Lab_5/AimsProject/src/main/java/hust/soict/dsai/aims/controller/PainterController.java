package hust.soict.dsai.aims.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    @FXML
    private Pane canvasPane;
    
    @FXML
    private RadioButton penRadio;
    
    @FXML
    private RadioButton eraserRadio;
    
    @FXML
    private Button clearButton;
    
    @FXML
    private ToggleGroup toolGroup;
    
    @FXML
    public void handleMousePressed(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        
        if (toolGroup.getSelectedToggle() == penRadio) {
            // Draw with pen (black circle)
            Circle circle = new Circle(x, y, 5, Color.BLACK);
            canvasPane.getChildren().add(circle);
        } else if (toolGroup.getSelectedToggle() == eraserRadio) {
            // Erase (white circle - same color as background)
            Circle circle = new Circle(x, y, 10, Color.WHITE);
            canvasPane.getChildren().add(circle);
        }
    }
    
    @FXML
    public void clearCanvas() {
        canvasPane.getChildren().clear();
    }
}
