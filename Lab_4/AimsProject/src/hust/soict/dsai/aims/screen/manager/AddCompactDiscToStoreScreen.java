package hust.soict.dsai.aims.screen.manager;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfArtist;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add CD to store");
    }

    @Override
    protected int addSpecificFields(JPanel form, GridBagConstraints gbc, int startRow) {
        tfDirector = new JTextField(20);
        tfLength = new JTextField(20);
        tfArtist = new JTextField(20);

        int row = startRow;
        row = addRow(form, gbc, row, "Director", tfDirector);
        row = addRow(form, gbc, row, "Length", tfLength);
        row = addRow(form, gbc, row, "Artist", tfArtist);
        return row;
    }

    @Override
    protected void onAdd() {
        try {
            CompactDisc cd = new CompactDisc(
                    readId(),
                    readTitle(),
                    readCategory(),
                    readCost(),
                    tfDirector.getText().trim(),
                    Integer.parseInt(tfLength.getText().trim()),
                    tfArtist.getText().trim()
            );
            store.addMedia(cd);
            showInfo("Added CD to store.");
            dispose();
            new StoreManagerScreen(store);
        } catch (Exception ex) {
            showError("Cannot add CD. Please check inputs.");
        }
    }
}

