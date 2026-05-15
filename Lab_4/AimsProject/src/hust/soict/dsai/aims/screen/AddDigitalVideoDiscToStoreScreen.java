package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD to Store");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2, 10, 10));
        
        // Title
        center.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        center.add(tfTitle);
        
        // Category
        center.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        center.add(tfCategory);
        
        // Cost
        center.add(new JLabel("Cost:"));
        tfCost = new JTextField();
        center.add(tfCost);
        
        // Director
        center.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        center.add(tfDirector);
        
        // Length
        center.add(new JLabel("Length:"));
        tfLength = new JTextField();
        center.add(tfLength);
        
        // Add button
        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String title = tfTitle.getText().trim();
                    String category = tfCategory.getText().trim();
                    float cost = Float.parseFloat(tfCost.getText().trim());
                    String director = tfDirector.getText().trim();
                    int length = Integer.parseInt(tfLength.getText().trim());
                    
                    if (title.isEmpty() || category.isEmpty() || director.isEmpty()) {
                        JOptionPane.showMessageDialog(AddDigitalVideoDiscToStoreScreen.this,
                            "Please fill in all required fields!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    // Create DVD with auto-generated ID
                    DigitalVideoDisc dvd = new DigitalVideoDisc(
                        store.getItemsInStore().size() + 1,
                        title,
                        category,
                        cost,
                        director,
                        length
                    );
                    
                    addMediaToStore(dvd);
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AddDigitalVideoDiscToStoreScreen.this,
                        "Invalid cost or length format!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        center.add(new JLabel()); // Empty cell
        center.add(addButton);
        
        return center;
    }
}
