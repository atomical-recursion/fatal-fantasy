package views;

import javax.swing.*;
import java.awt.*;

// Colors Are For Testing!!!

public class MenuView extends JFrame {

    public MenuView() {
        JPanel northMargin = new JPanel();
        JPanel eastMargin = new JPanel();
        JPanel southMargin = new JPanel();
        JPanel westMargin = new JPanel();

        JLabel titleLabel = new JLabel();
        JPanel centerPanel = new JPanel();
        
        JPanel buttonPanel = new JPanel();
        JButton gameButton = new JButton();
        JButton manageButton = new JButton();
        JButton ruleButton = new JButton();
        JButton exitButton = new JButton();

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

        titleLabel.setPreferredSize(new Dimension(100, 100));
        titleLabel.setText("Fatal Fantasy: Tactics");
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 72));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBackground(Color.CYAN);
        titleLabel.setOpaque(true);

        buttonPanel.setLayout(new GridLayout(1, 4, 25, 25));
        buttonPanel.setBackground(Color.BLACK);

        gameButton.setFocusable(false);
        gameButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.PINK, 5), BorderFactory.createLoweredBevelBorder()));
        gameButton.setText("Battle");
        gameButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        manageButton.setFocusable(false);
        manageButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.PINK, 5), BorderFactory.createLoweredBevelBorder()));
        manageButton.setText("<html><center>" + "Manage" + "<br>" + "Characters" + "</center></html>");
        manageButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        ruleButton.setFocusable(false);
        ruleButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.PINK, 5), BorderFactory.createLoweredBevelBorder()));
        ruleButton.setText("<html><center>" + "How To " + "<br>" + "Play" + "</center></html>");
        ruleButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        
        exitButton.setFocusable(false);
        exitButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.PINK, 5), BorderFactory.createLoweredBevelBorder()));
        exitButton.setText("Exit");
        exitButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        buttonPanel.add(gameButton);
        buttonPanel.add(manageButton);
        buttonPanel.add(ruleButton);
        buttonPanel.add(exitButton);

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
