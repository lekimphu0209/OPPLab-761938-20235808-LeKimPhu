package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        // Title label
        JLabel titleLabel = new JLabel(media.getTitle());
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        
        // Category label
        JLabel categoryLabel = new JLabel(media.getCategory());
        categoryLabel.setAlignmentX(CENTER_ALIGNMENT);
        
        // Cost label
        JLabel costLabel = new JLabel(Float.toString(media.getCost()) + " $");
        costLabel.setAlignmentX(CENTER_ALIGNMENT);
        
        // Add components to panel
        this.add(Box.createVerticalGlue());
        this.add(titleLabel);
        this.add(categoryLabel);
        this.add(costLabel);
        
        // Add Play button if media is Playable
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.setAlignmentX(CENTER_ALIGNMENT);
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Create and show play dialog
                    JDialog playDialog = new JDialog();
                    playDialog.setTitle("Playing Media");
                    playDialog.setSize(300, 150);
                    playDialog.setLocationRelativeTo(null);
                    
                    JLabel messageLabel = new JLabel("Playing: " + media.getTitle(), SwingConstants.CENTER);
                    playDialog.add(messageLabel);
                    
                    // Play the media
                    ((Playable) media).play();
                    
                    playDialog.setVisible(true);
                }
            });
            this.add(playButton);
        }
        
        this.add(Box.createVerticalGlue());
        
        // Set border and preferred size
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setPreferredSize(new Dimension(200, 150));
    }
    
    public Media getMedia() {
        return media;
    }
}
