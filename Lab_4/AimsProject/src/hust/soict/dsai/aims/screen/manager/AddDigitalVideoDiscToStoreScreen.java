package hust.soict.dsai.aims.screen.manager;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD to store");
    }

    @Override
    protected int addSpecificFields(JPanel form, GridBagConstraints gbc, int startRow) {
        tfDirector = new JTextField(20);
        tfLength = new JTextField(20);

        int row = startRow;
        row = addRow(form, gbc, row, "Director", tfDirector);
        row = addRow(form, gbc, row, "Length", tfLength);
        return row;
    }

    @Override
    protected void onAdd() {
        try {
            DigitalVideoDisc dvd = new DigitalVideoDisc(
                    readId(),
                    readTitle(),
                    readCategory(),
                    readCost(),
                    tfDirector.getText().trim(),
                    Integer.parseInt(tfLength.getText().trim())
            );
            store.addMedia(dvd);
            showInfo("Added DVD to store.");
            dispose();
            new StoreManagerScreen(store);
        } catch (Exception ex) {
            showError("Cannot add DVD. Please check inputs.");
        }
    }
}

