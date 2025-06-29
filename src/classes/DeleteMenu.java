package classes;

/**
 * Represents the menu interface for deleting a character from a player's roster.
 * 
 * <p> The menu lists all existing characters along with their class and selected abilities.
 * Players can select a character to delete or choose to return to the previous menu. </p>
 * 
 * <p> This class extends {@link Menu} and uses the {@link Player}'s character list
 * to dynamically generate menu options.</p>
 */
public class DeleteMenu extends Menu {
    /** The player whose characters are being managed. */
    private Player player;

    /**
     * Constructs a {@code DeleteMenu} for the specified player.
     * Initializes the option count based on the number of characters owned.
     *
     * @param player the player whose character is to be deleted.
     */
    public DeleteMenu(Player player) {
        this.player = player;  
        optionAmount = player.getCharacterAmount() + 1;
    }

    /**
     * Displays the delete character menu.
     * 
     * <p> Lists all characters along with their class and abilities.
     * The user may select a character to delete or return to the character menu.
     * If invalid input is entered, an error message is shown and the menu is refreshed. </p>
     */
    @Override public void display() {
        int index;
        ConfirmMenu confirmMenu;

        do {
            System.out.println("{Delete A Character}");
            
            player.displayCharacters();
            System.out.println("[" + optionAmount + "] Return to Character Menu");

            System.out.print("Enter Choice: ");
            askChoice();

            if (!isValidChoice) {
                System.out.println("(!) INVALID INPUT!");
                pauseScreen(1);
                clearScreen();
            } else if (Integer.parseInt(choice) < optionAmount) {
                clearScreen();

                index = (Integer.parseInt(choice) - 1);
                confirmMenu = new ConfirmMenu(player.getCharacter(index).getName(), player);
                confirmMenu.deleteDisplay();

                if (confirmMenu.choice.equals("1"))
                    optionAmount = player.getCharacterAmount() + 1;
            } else {
                clearScreen();
            }
        } while (!isValidChoice);
    }
}
