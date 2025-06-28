package src.classes;

/**
 * Represents a confirmation menu for exiting the game and for deleting a
 * character.
 * 
 * <p> Sets a custom header ("Confirm Exit") and extends the {@link Menu} superclass. </p>
 */
public class ConfirmMenu extends Menu {
    /** The player whose character will be successfully deleted. */
    private Player player;

    /**
     * Constructs an {@code ConfirmMenu} with predefined options to either exit the game
     * or return to the main menu.
     */
    public ConfirmMenu() {
        optionAmount = 2;
        options.add("Exit Game");
        options.add("Return to Main Menu");
    }

    /**
     * Constructs an {@code ConfirmMenu} with predefined options to either delete a
     * character or return to the character menu.
     */
    public ConfirmMenu(String name, Player player) {
        optionAmount = 2;
        options.add("Delete " + name);
        options.add("Return to Character Menu");

        this.player = player;
    }

    /**
     * Displays the confirmation screen when exiting the game.
     * Confirming the action will exit the game, otherwise it will
     * return to the main menu.
     */
    public void exitDisplay() {
        int i;

        do {
            System.out.println("{Confirm Exit}");

            for (i = 0; i < optionAmount; i++) {
                System.out.println("[" + (i + 1) + "] " + options.get(i));
            }

            System.out.print("Enter Choice: ");
            askChoice();

            if (!isValidChoice) {
                System.out.println("(!) INVALID INPUT!");
                pauseScreen(1);
                clearScreen();
            } else  if (choice.equals("1")) {
                System.out.println("(*) EXITING GAME");
                pauseScreen(1);
                clearScreen();
            } else {
                clearScreen();
            }
        } while (!isValidChoice);
    }

    /**
     * Displays the confirmation screen when deleting a character.
     * Confirming the action will delete the player, otherwise it will
     * return to the character menu.
     */
    public void deleteDisplay() {
        int i;

        do {
            System.out.println("{Confirm Delete}");

            for (i = 0; i < optionAmount; i++) {
                System.out.println("[" + (i + 1) + "] " + options.get(i));
            }

            System.out.print("Enter Choice: ");
            askChoice();

            if (!isValidChoice) {
                System.out.println("(!) INVALID INPUT!");
                pauseScreen(1);
                clearScreen();
            } else if (choice.equals("1")) {
                System.out.println("(*) DELETING " + player.getCharacter(Integer.parseInt(choice) - 1).getName().toUpperCase());
                player.deleteCharacter(Integer.parseInt(choice) - 1);
                pauseScreen(1);
                System.out.println("(&) Character Deleted!");
                pauseScreen(1);
                clearScreen();
            } else {
                clearScreen();
            }
        } while (!isValidChoice);
    }
}
