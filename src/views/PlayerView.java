package views;

import javax.swing.*;
import java.awt.*;

public class PlayerView extends JFrame {

    public PlayerView() {
        JPanel northMargin = new JPanel();
        JPanel eastMargin = new JPanel();
        JPanel southMargin = new JPanel();
        JPanel westMargin = new JPanel();

        JLabel titleLabel = new JLabel();
        JPanel centerPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        JPanel smallEastMargin = new JPanel();
        JPanel smallSouthMargin = new JPanel();
        JPanel smallWestMargin = new JPanel();

        this.setSize(940, 540);
        this.setTitle("Fatal Fantasy: Tactics");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(25, 25));

        northMargin.setPreferredSize(new Dimension(50, 50));
        northMargin.setBackground(Color.PINK);

        eastMargin.setPreferredSize(new Dimension(50, 50));
        eastMargin.setBackground(Color.RED);

        southMargin.setPreferredSize(new Dimension(50, 50));
        southMargin.setBackground(Color.ORANGE);

        westMargin.setPreferredSize(new Dimension(50, 50));
        westMargin.setBackground(Color.GREEN);
        westMargin.setLayout(new BorderLayout(25, 25));
        westMargin.add(new JButton("<"), BorderLayout.CENTER);

        titleLabel.setPreferredSize(new Dimension(50, 50));
        titleLabel.setText("Player's Characters To Manage");
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBackground(Color.CYAN);
        titleLabel.setOpaque(true);

        buttonPanel.setLayout(new GridLayout(1, 2, 25, 25));
        buttonPanel.setBackground(Color.BLACK);

        // character amount at tooltip?
        buttonPanel.add(new JButton("Player 1"));
        buttonPanel.add(new JButton("Player 2"));

        smallEastMargin.setPreferredSize(new Dimension(50, 50));
        smallEastMargin.setBackground(Color.RED);

        smallSouthMargin.setPreferredSize(new Dimension(50, 50));
        smallSouthMargin.setBackground(Color.ORANGE);

        smallWestMargin.setPreferredSize(new Dimension(50, 50));
        smallWestMargin.setBackground(Color.GREEN);

        centerPanel.setLayout(new BorderLayout(25, 25));
        centerPanel.add(titleLabel, BorderLayout.NORTH);
        centerPanel.add(buttonPanel, BorderLayout.CENTER);
        centerPanel.add(smallSouthMargin, BorderLayout.SOUTH);
        centerPanel.add(smallEastMargin, BorderLayout.EAST);
        centerPanel.add(smallWestMargin, BorderLayout.WEST);

        this.add(northMargin, BorderLayout.NORTH);
        this.add(eastMargin, BorderLayout.EAST);
        this.add(southMargin, BorderLayout.SOUTH);
        this.add(westMargin, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);

        this.setVisible(true);
        this.setResizable(false);
    }

}
