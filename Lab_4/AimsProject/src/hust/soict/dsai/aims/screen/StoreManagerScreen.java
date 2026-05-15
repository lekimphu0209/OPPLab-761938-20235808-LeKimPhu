package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Media;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreManagerScreen extends JFrame {
    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;
        
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("AIMS - Store Manager");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
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
                // Already on store view
            }
        });
        viewMenu.add(viewStoreItem);
        
        // Update menu
        JMenu updateMenu = new JMenu("Update Store");
        JMenuItem addBookItem = new JMenuItem("Add Book");
        JMenuItem addCDItem = new JMenuItem("Add CD");
        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        
        addBookItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current window
                new AddBookToStoreScreen(store);
            }
        });
        
        addCDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current window
                new AddCompactDiscToStoreScreen(store);
            }
        });
        
        addDVDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current window
                new AddDigitalVideoDiscToStoreScreen(store);
            }
        });
        
        updateMenu.add(addBookItem);
        updateMenu.add(addCDItem);
        updateMenu.add(addDVDItem);
        
        menuBar.add(viewMenu);
        menuBar.add(updateMenu);
        
        // Header
        JLabel header = new JLabel("AIMS - Store Manager", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        
        north.add(menuBar, BorderLayout.NORTH);
        north.add(header, BorderLayout.CENTER);
        
        return north;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(0, 3, 5, 5));
        
        for (Media media : store.getItemsInStore()) {
            MediaStore mediaStore = new MediaStore(media);
            center.add(mediaStore);
        }
        
        return center;
    }

    public static void main(String[] args) {
        // Create a test store
        Store store = new Store();
        // Add some test media items
        // store.addMedia(new Media(...));
        
        SwingUtilities.invokeLater(() -> new StoreManagerScreen(store));
    }
}
