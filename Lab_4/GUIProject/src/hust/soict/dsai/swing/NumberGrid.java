package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGrid extends JFrame {
    private final JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete;
    private JButton btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        tfDisplay = new JTextField("0");
        tfDisplay.setEditable(false);
        tfDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
        cp.add(tfDisplay, BorderLayout.NORTH);

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(4, 3, 2, 2));
        cp.add(panelButtons, BorderLayout.CENTER);

        addButtons(panelButtons);

        setTitle("Number Grid");
        setSize(360, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addButtons(JPanel panelButtons) {
        ButtonListener listener = new ButtonListener();

        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            btnNumbers[i].addActionListener(listener);
            panelButtons.add(btnNumbers[i]);
        }

        btnDelete = new JButton("DEL");
        btnDelete.addActionListener(listener);
        panelButtons.add(btnDelete);

        btnNumbers[0] = new JButton("0");
        btnNumbers[0].addActionListener(listener);
        panelButtons.add(btnNumbers[0]);

        btnReset = new JButton("C");
        btnReset.addActionListener(listener);
        panelButtons.add(btnReset);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object src = e.getSource();
            String display = tfDisplay.getText();

            // Digit buttons
            for (int i = 0; i <= 9; i++) {
                if (src == btnNumbers[i]) {
                    if ("0".equals(display)) display = "";
                    tfDisplay.setText(display + i);
                    return;
                }
            }

            // DEL button: delete last digit
            if (src == btnDelete) {
                if (display == null || display.isEmpty() || "0".equals(display)) {
                    tfDisplay.setText("0");
                    return;
                }
                String next = display.substring(0, display.length() - 1);
                tfDisplay.setText(next.isEmpty() ? "0" : next);
                return;
            }

            // C button: clear all
            if (src == btnReset) {
                tfDisplay.setText("0");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NumberGrid::new);
    }
}

