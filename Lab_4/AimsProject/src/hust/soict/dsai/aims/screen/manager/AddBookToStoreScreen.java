package hust.soict.dsai.aims.screen.manager;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book to store");
    }

    @Override
    protected int addSpecificFields(JPanel form, GridBagConstraints gbc, int startRow) {
        tfAuthors = new JTextField(20);
        return addRow(form, gbc, startRow, "Authors (comma-separated)", tfAuthors);
    }

    @Override
    protected void onAdd() {
        try {
            Book book = new Book(readId(), readTitle(), readCategory(), readCost());
            String raw = tfAuthors.getText().trim();
            if (!raw.isEmpty()) {
                for (String a : raw.split(",")) {
                    String name = a.trim();
                    if (!name.isEmpty()) book.addAuthor(name);
                }
            }

            store.addMedia(book);
            showInfo("Added book to store.");
            dispose();
            new StoreManagerScreen(store);
        } catch (Exception ex) {
            showError("Cannot add book. Please check inputs.");
        }
    }
}

