package hust.soict.dsai.aims.screen.manager;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class StoreManagerScreen extends JFrame {
    private final Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("AIMS - Store Manager");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStoreItem = new JMenuItem("View Store");
        viewStoreItem.addActionListener(e -> {
            dispose();
            new StoreManagerScreen(store);
        });
        menu.add(viewStoreItem);

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> {
            dispose();
            new AddBookToStoreScreen(store);
        });
        smUpdateStore.add(addBookItem);

        JMenuItem addCdItem = new JMenuItem("Add CD");
        addCdItem.addActionListener(e -> {
            dispose();
            new AddCompactDiscToStoreScreen(store);
        });
        smUpdateStore.add(addCdItem);

        JMenuItem addDvdItem = new JMenuItem("Add DVD");
        addDvdItem.addActionListener(e -> {
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store);
        });
        smUpdateStore.add(addDvdItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        menuBar.add(smUpdateStore);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        return header;
    }

    JPanel createCenter() {
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(0, 3, 2, 2));
        for (Media media : store.getItemsInStore()) {
            grid.add(new MediaStore(media));
        }

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(new JScrollPane(grid,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
        return wrapper;
    }

    public static void main(String[] args) {
        Store store = new Store();

        store.addMedia(new DigitalVideoDisc(1, "Lion King", "Animation", 19.95f, "Disney", 90));
        store.addMedia(new Book(2, "Clean Code", "Education", 45.0f));

        CompactDisc cd = new CompactDisc(3, "Best Hits", "Music", 25.0f, "Unknown", 0, "Artist");
        cd.addTrack(new Track("Song1", 200));
        cd.addTrack(new Track("Song2", 180));
        store.addMedia(cd);

        SwingUtilities.invokeLater(() -> new StoreManagerScreen(store));
    }
}

