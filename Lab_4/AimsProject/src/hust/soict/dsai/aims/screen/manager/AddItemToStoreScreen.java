package hust.soict.dsai.aims.screen.manager;

import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected final Store store;

    protected JTextField tfId;
    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    protected AddItemToStoreScreen(Store store, String screenTitle) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle(screenTitle);
        setSize(720, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    protected JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    protected JMenuBar createMenuBar() {
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

    protected JPanel createHeader() {
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

    protected JPanel createCenter() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        tfId = new JTextField(20);
        tfTitle = new JTextField(20);
        tfCategory = new JTextField(20);
        tfCost = new JTextField(20);

        int row = 0;
        row = addRow(form, gbc, row, "ID", tfId);
        row = addRow(form, gbc, row, "Title", tfTitle);
        row = addRow(form, gbc, row, "Category", tfCategory);
        row = addRow(form, gbc, row, "Cost", tfCost);

        row = addSpecificFields(form, gbc, row);

        JButton addBtn = new JButton("Add to store");
        addBtn.addActionListener(e -> onAdd());

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(e -> {
            dispose();
            new StoreManagerScreen(store);
        });

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        actions.add(backBtn);
        actions.add(addBtn);

        panel.add(form, BorderLayout.CENTER);
        panel.add(actions, BorderLayout.SOUTH);
        return panel;
    }

    protected int addRow(JPanel form, GridBagConstraints gbc, int row, String label, JComponent field) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0.0;
        form.add(new JLabel(label), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        form.add(field, gbc);

        return row + 1;
    }

    protected abstract int addSpecificFields(JPanel form, GridBagConstraints gbc, int startRow);

    protected abstract void onAdd();

    protected int readId() {
        return Integer.parseInt(tfId.getText().trim());
    }

    protected String readTitle() {
        return tfTitle.getText().trim();
    }

    protected String readCategory() {
        return tfCategory.getText().trim();
    }

    protected float readCost() {
        return Float.parseFloat(tfCost.getText().trim());
    }

    protected void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    protected void showInfo(String message) {
        JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}

