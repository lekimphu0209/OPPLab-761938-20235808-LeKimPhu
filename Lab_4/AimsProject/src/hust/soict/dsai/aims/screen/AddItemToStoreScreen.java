package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Media;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        
        // North panel with menu
        cp.add(createNorth(), BorderLayout.NORTH);
        
        // Center panel with form
        cp.add(createCenter(), BorderLayout.CENTER);
        
        setTitle("Add Item to Store");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BorderLayout());
        
        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        
        // View menu
        JMenu viewMenu = new JMenu("View");
        JMenuItem viewStoreItem = new JMenuItem("View Store");
        viewStoreItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current window
                new StoreManagerScreen(store); // Open store manager
            }
        });
        viewMenu.add(viewStoreItem);
        
        menuBar.add(viewMenu);
        north.add(menuBar, BorderLayout.NORTH);
        
        // Header
        JLabel header = new JLabel("Add Item to Store", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        north.add(header, BorderLayout.CENTER);
        
        return north;
    }

    abstract JPanel createCenter();
    
    protected void addMediaToStore(Media media) {
        store.addMedia(media);
        JOptionPane.showMessageDialog(this, 
            media.getTitle() + " has been added to the store!", 
            "Success", 
            JOptionPane.INFORMATION_MESSAGE);
        dispose();
        new StoreManagerScreen(store);
    }
}
