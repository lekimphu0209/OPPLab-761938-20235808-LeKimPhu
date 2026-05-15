package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.CompactDisc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfArtist;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD to Store");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(7, 2, 10, 10));
        
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
        
        // Artist
        center.add(new JLabel("Artist:"));
        tfArtist = new JTextField();
        center.add(tfArtist);
        
        // Add button
        JButton addButton = new JButton("Add CD");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String title = tfTitle.getText().trim();
                    String category = tfCategory.getText().trim();
                    float cost = Float.parseFloat(tfCost.getText().trim());
                    String director = tfDirector.getText().trim();
                    int length = Integer.parseInt(tfLength.getText().trim());
                    String artist = tfArtist.getText().trim();
                    
                    if (title.isEmpty() || category.isEmpty() || director.isEmpty() || artist.isEmpty()) {
                        JOptionPane.showMessageDialog(AddCompactDiscToStoreScreen.this,
                            "Please fill in all required fields!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    // Create CD with auto-generated ID
                    CompactDisc cd = new CompactDisc(
                        store.getItemsInStore().size() + 1,
                        title,
                        category,
                        cost,
                        director,
                        length,
                        artist
                    );
                    
                    addMediaToStore(cd);
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AddCompactDiscToStoreScreen.this,
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
