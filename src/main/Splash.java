package main;

import javax.swing.*;
import java.awt.*;

public class Splash {
    private static final int FRAME_WIDTH = 960;
    private static final int FRAME_HEIGHT = 540;
    private static final String FRAME_TITLE = "Welcome!";
    private static final String ICON_PATH = "src/main/assets/schoolicon.png";
    private static final String LEFT_IMAGE_PATH = "src/main/assets/leftimage.png";
    private static final Color BACKGROUND_COLOR = Color.decode("#212121");
    private static final Color FOREGROUND_COLOR = Color.decode("#e1e1e1");
    private static final Dimension TEXT_FIELD_SIZE = new Dimension(500, 25);

    private JFrame frame = new JFrame();

    public Splash() {
        setupFrame();
        JPanel panel1 = setupPanel1();
        JPanel panel2 = setupPanel2();
        frame.add(panel1);
        frame.add(panel2);
        frame.setVisible(true);
    }

    private void setupFrame() {
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setResizable(false);
        frame.setTitle(FRAME_TITLE);
        ImageIcon icon = new ImageIcon(ICON_PATH);
        frame.setIconImage(icon.getImage());
        frame.setLayout(new GridLayout(1, 2));
    }

    private JPanel setupPanel1() {
        JPanel panel1 = new JPanel();
        panel1.setBackground(BACKGROUND_COLOR);
        ImageIcon leftImage = new ImageIcon(LEFT_IMAGE_PATH);
        JLabel imageLabel = new JLabel(leftImage);
        panel1.add(imageLabel);
        return panel1;
    }

    private JPanel setupPanel2() {
        JPanel panel2 = new JPanel();
        panel2.setBackground(BACKGROUND_COLOR);
        panel2.setLayout(new GridBagLayout());

        JPanel contentPanel = setupContentPanel();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        panel2.add(contentPanel, gbc);

        return panel2;
    }

    private JPanel setupContentPanel() {
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(BACKGROUND_COLOR);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        addLabel(contentPanel, "Welcome back, Admin", Font.BOLD, 24);
        addGap(contentPanel, 20);
        addLabel(contentPanel, "Username", Font.PLAIN, 16);
        addGap(contentPanel, 10);
        addTextField(contentPanel);
        addGap(contentPanel, 10);
        addLabel(contentPanel, "Password", Font.PLAIN, 16);
        addGap(contentPanel, 10);
        addTextField(contentPanel);
        addGap(contentPanel, 20);
        addButton(contentPanel, "Submit");

        return contentPanel;
    }

    private void addLabel(JPanel panel, String text, int fontStyle, int fontSize) {
        JLabel label = new JLabel(text);
        label.setForeground(FOREGROUND_COLOR);
        label.setFont(new Font("Arial", fontStyle, fontSize));
        label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(label);
    }

    private void addTextField(JPanel panel) {
        JTextField textField = new JTextField();
        textField.setMaximumSize(TEXT_FIELD_SIZE);
        textField.setAlignmentX(JTextField.CENTER_ALIGNMENT);
        panel.add(textField);
    }

    private void addButton(JPanel panel, String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        panel.add(button);
    }

    private void addGap(JPanel panel, int size) {
        panel.add(Box.createVerticalStrut(size));
    }
}