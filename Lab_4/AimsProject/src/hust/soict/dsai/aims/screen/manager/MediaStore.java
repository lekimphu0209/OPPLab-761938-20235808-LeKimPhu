package hust.soict.dsai.aims.screen.manager;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private final Media media;

    public MediaStore(Media media) {
        this.media = media;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 18));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(String.format("%.2f $", media.getCost()));
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER));
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(e -> showPlayDialog());
            container.add(playButton);
        }

        add(Box.createVerticalGlue());
        add(title);
        add(cost);
        add(container);
        add(Box.createVerticalGlue());
    }

    private void showPlayDialog() {
        String message;

        if (media instanceof DigitalVideoDisc) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) media;
            message = "Playing DVD: " + dvd.getTitle()
                    + "\nDirector: " + dvd.getDirector()
                    + "\nLength: " + dvd.getLength();
        } else if (media instanceof CompactDisc) {
            CompactDisc cd = (CompactDisc) media;
            message = "Playing CD: " + cd.getTitle()
                    + "\nArtist: " + cd.getArtist()
                    + "\nTotal length: " + cd.getLength();
        } else {
            message = "Playing: " + media.getTitle();
        }

        JDialog dialog = new JDialog(SwingUtilities.getWindowAncestor(this), "Play media", Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea(message);
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton close = new JButton("Close");
        close.addActionListener(e -> dialog.dispose());

        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        south.add(close);

        dialog.add(textArea, BorderLayout.CENTER);
        dialog.add(south, BorderLayout.SOUTH);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
}

