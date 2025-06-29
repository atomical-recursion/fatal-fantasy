package classes;

/**
 * Handles the character management interface for a player and dynamically
 * builds the options based on how many characters the player has.
 * 
 * <p> This class extends the {@link Menu} class and supports displaying: </p>
 * <ul>
 *   <li> Create A Character (via {@link CreateMenu}) </li>
 *   <li> View Character List (via {@link DisplayMenu}) </li>
 *   <li> Edit Character (via {@link EditMenu}) </li>
 *   <li> Delete Character (via {@link DeleteMenu}) </li>
 * </ul>
 * 
 * <p> The options are context-sensitive based on the number of characters owned. </p>
 */
public class CharacterMenu extends Menu {
    /** The number of characters the player currently has. */
    private int characterAmount;

    /** The label indicating which player this menu belongs to ("1" or "2"). */
    private String playerNumber;

    /**
     * Constructs a {@code CharacterMenu} instance for the given player.
     * Initializes the menu options based on how many characters the player has.
     *
     * @param player       the player whose characters are being managed.
     * @param playerNumber a label identifying the player (1" or "2").
     */
    public CharacterMenu(Player player, String playerNumber) {
        characterAmount = player.getCharacterAmount();
        this.playerNumber = playerNumber;

        if (characterAmount == 0) {
            optionAmount = 2;
            options.add("Create A Character");
            options.add("Return to Player Menu");
        } else if (characterAmount == 6) {
            optionAmount = 4;
            options.add("Display Characters");
            options.add("Edit A Character");
            options.add("Delete A Character");
            options.add("Return to Player Menu");
        } else {
            optionAmount = 5;

            if (characterAmount == 1) {
                options.add("Display Character");
            } else {
                options.add("Display Characters");
            }

            options.add("Create A Character");
            options.add("Edit A Character");
            options.add("Delete A Character");
            options.add("Return to Player Menu");   
        }
    }
    
    /**
     * Displays the character menu interface for the player.
     * Continues prompting the user until a valid choice is entered.
     * Invalid input triggers an error message and screen refresh.
     */
    @Override public void display() {
        int i;

        do {
            System.out.println("{Player " + playerNumber + "'s Characters}");
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
