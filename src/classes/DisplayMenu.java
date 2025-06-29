package classes;

/**
 * Displays a menu listing all of a player's characters and their brief details.
 * 
 * <p> Each character entry shows the character's name, class, and their three selected abilities.
 * The player can choose to view more detailed information using the {@link DetailMenu},
 * or return to the character Mmenu. </p>
 * 
 * <p> This class extends {@link Menu} and dynamically sets the number of options
 * based on the current number of characters. </p>
 */
public class DisplayMenu extends Menu {
    /** The player whose characters will be listed. */
    private Player player;

    /**
     * Constructs a DisplayMenu for the specified player.
     * Sets the number of menu options based on the player's character list.
     *
     * @param player the player whose characters are being displayed.
     */
    public DisplayMenu(Player player) {
        this.player = player;
        optionAmount = player.getCharacterAmount() + 1;
    }

    /**
     * Displays the list of the player's characters with summary info.
     * 
     * <p> Allows the player to select a character to view in detail
     * (using {@link DetailMenu}), or return to the Character Menu.
     * Input is validated before proceeding. </p>
     */
    @Override public void display() {
        DetailMenu detailMenu;
        boolean exit = false;

        do {
            System.out.println("{Character Details}");
            
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
                detailMenu = new DetailMenu(player.getCharacter(Integer.parseInt(choice) - 1));
                detailMenu.display();
            } else {
                clearScreen();

                if (choice.equals(Integer.toString(optionAmount)))
                    exit = true;
            }
        } while (!exit);
    }
}
