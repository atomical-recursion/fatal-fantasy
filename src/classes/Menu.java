package classes;

import java.util.*;

/**
 * Represents a generic menu used for displaying options and capturing user input.
 * 
 * <p> This abstract base class provides standard functionality for all menu types,
 * including displaying headers, options, input validation, screen clearing, and pausing.
 * All other menu classes in the game extend this base class to customize their behavior. </p>
 * 
 * <p> Menus can dynamically set their number of options and respond to user choices
 * via the {@link #display()} method. </p>
 */
public class Menu {
    /** The title or label shown at the top of the menu. */
    protected String header;

    /** The number of available options for the current menu. */
    protected int optionAmount;

    /** The list of option strings to be displayed. */
    protected ArrayList<String> options = new ArrayList<String>();

    /** Scanner used to accept user input. */
    protected Scanner input = new Scanner(System.in);

    /** The option chosen by the user. */
    protected String choice;

    /** Flag indicating whether the current input is valid. */
    protected boolean isValidChoice;

    public String getChoice() {
        return choice;
    }

    /**
     * Pauses the program for a given number of seconds.
     *
     * @param seconds the number of seconds to pause.
     */
    public void pauseScreen(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Clears the terminal screen.
     */
    public void clearScreen() {  
        String osName = System.getProperty("os.name");

        try {
            if (osName.startsWith("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.print("\033[H\033[2J");  
            System.out.flush();
        }
    }

    /**
     * Captures user input and validates whether it corresponds to one of the options.
     */
    public void askChoice() {
        choice = input.nextLine();
        int i, valid = 0;

        for (i = 0; i < optionAmount; i++) {
            if (choice.equals(String.valueOf(i + 1))) {
                valid++;
            }
        }

        if (valid == 1)
            isValidChoice = true;
        else
            isValidChoice = false;
    }

    /**
     * Displays the menu header and options, then prompts the user until a valid input is given.
     */
    public void display() {
        int i;

        do {
            System.out.println("{" + header + "}");

            for (i = 0; i < optionAmount; i++) {
                System.out.println("[" + (i + 1) + "] " + options.get(i));
            }

            System.out.print("Enter Choice: ");
            askChoice();

            if (!isValidChoice) {
                System.out.println("(!) INVALID INPUT!");
                pauseScreen(1);
                clearScreen();
            } else {
                clearScreen();
            }
        } while (!isValidChoice);
    }
}