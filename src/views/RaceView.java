package views;

import javax.swing.*;
import java.awt.*;

public class RaceView extends JFrame {

    public RaceView() {
        JPanel northMargin = new JPanel();
        JPanel eastMargin = new JPanel();
        JPanel southMargin = new JPanel();
        JPanel westMargin = new JPanel();

        JLabel titleLabel = new JLabel();
        JPanel centerPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

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

        titleLabel.setPreferredSize(new Dimension(50, 50));
        titleLabel.setText("Choose A Race");
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBackground(Color.CYAN);
        titleLabel.setOpaque(true);

        buttonPanel.setLayout(new GridLayout(2, 3, 25, 25));
        buttonPanel.setBackground(Color.BLACK);

        // should have the bonuses at the tooltip
        buttonPanel.add(new JButton("Race 1"));
        buttonPanel.add(new JButton("Race 2"));
        buttonPanel.add(new JButton("Race 3"));
        buttonPanel.add(new JButton("Race 4"));
        buttonPanel.add(new JButton("Race 5"));
        buttonPanel.add(new JButton("Race 6"));

        centerPanel.setLayout(new BorderLayout(25, 25));
        centerPanel.add(titleLabel, BorderLayout.NORTH);
        centerPanel.add(buttonPanel, BorderLayout.CENTER);

        this.add(northMargin, BorderLayout.NORTH);
        this.add(eastMargin, BorderLayout.EAST);
        this.add(southMargin, BorderLayout.SOUTH);
        this.add(westMargin, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);

        this.setVisible(true);
        this.setResizable(false);
    }
}
