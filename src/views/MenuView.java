package views;

import javax.swing.*;
import java.awt.*;

// Colors Are For Testing!!!

public class MenuView {

    public MenuView() {
        JFrame window = new JFrame();

        JPanel northMargin = new JPanel();
        JPanel eastMargin = new JPanel();
        JPanel southMargin = new JPanel();
        JPanel westMargin = new JPanel();

        JLabel titleLabel = new JLabel();

        JPanel centerPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JButton gameButton = new JButton("Battle");
        JButton manageButton = new JButton("Manage Characters");
        JButton ruleButton = new JButton("How To Play");
        JButton exitButton = new JButton("Exit");

        window.setSize(940, 540);
        window.setTitle("Fatal Fantasy: Tactics");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout(25, 25));

        northMargin.setPreferredSize(new Dimension(50, 50));
        northMargin.setBackground(Color.PINK);

        eastMargin.setPreferredSize(new Dimension(50, 50));
        eastMargin.setBackground(Color.RED);

        southMargin.setPreferredSize(new Dimension(50, 50));
        southMargin.setBackground(Color.ORANGE);

        westMargin.setPreferredSize(new Dimension(50, 50));
        westMargin.setBackground(Color.GREEN);

        titleLabel.setPreferredSize(new Dimension(100, 100));
        titleLabel.setText("Fatal Fantasy: Tactics");
        titleLabel.setFont(new Font("JMH Cthulumbus Arcade UG", Font.PLAIN, 72));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBackground(Color.CYAN);
        titleLabel.setOpaque(true);

        buttonPanel.setLayout(new GridLayout(1, 4, 25, 25));
        buttonPanel.setBackground(Color.BLACK); // For Testing

        buttonPanel.add(gameButton);
        buttonPanel.add(manageButton);
        buttonPanel.add(ruleButton);
        buttonPanel.add(exitButton);

        centerPanel.setLayout(new BorderLayout(25, 25));
        centerPanel.add(titleLabel, BorderLayout.NORTH);
        centerPanel.add(buttonPanel, BorderLayout.CENTER);

        window.add(northMargin, BorderLayout.NORTH);
        window.add(eastMargin, BorderLayout.EAST);
        window.add(southMargin, BorderLayout.SOUTH);
        window.add(westMargin, BorderLayout.WEST);
        window.add(centerPanel, BorderLayout.CENTER);

        window.setVisible(true);
        window.setResizable(false);
    }
}
