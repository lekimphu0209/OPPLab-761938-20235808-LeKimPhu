package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfCost;
    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book to Store");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(5, 2, 10, 10));
        
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
        
        // Authors (comma separated)
        center.add(new JLabel("Authors (comma separated):"));
        tfAuthors = new JTextField();
        center.add(tfAuthors);
        
        // Add button
        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String title = tfTitle.getText().trim();
                    String category = tfCategory.getText().trim();
                    float cost = Float.parseFloat(tfCost.getText().trim());
                    String authorsText = tfAuthors.getText().trim();
                    
                    if (title.isEmpty() || category.isEmpty()) {
                        JOptionPane.showMessageDialog(AddBookToStoreScreen.this,
                            "Please fill in all required fields!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    // Create book with auto-generated ID
                    Book book = new Book(store.getItemsInStore().size() + 1, title, category, cost);
                    
                    // Add authors if provided
                    if (!authorsText.isEmpty()) {
                        String[] authors = authorsText.split(",");
                        for (String author : authors) {
                            book.addAuthor(author.trim());
                        }
                    }
                    
                    addMediaToStore(book);
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AddBookToStoreScreen.this,
                        "Invalid cost format!",
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
