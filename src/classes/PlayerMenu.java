package src.classes;

/**
 * Represents the menu that allows users to manage characters for both players.
 * 
 * <p> This menu provides three options:
 * <ul>
 *   <li> Manage Player 1's Characters </li>
 *   <li> Manage Player 2's CCharacters </li>
 *   <li> Return to the Main Menu </li>
 * </ul>
 * 
 * <p> This class extends the {@link Menu} superclass and sets the
 * menu header and option labels on construction. </p>
 */
public class PlayerMenu extends Menu {

    /**
     * Constructs a {@code PlayerMenu} with predefined options for managing two players' characters.
     */
    public PlayerMenu() {
        header = "Player Menu";
        optionAmount = 3;
        options.add("Characters of Player 1");
        options.add("Character of Player 2");
        options.add("Return to Main Menu");
    }
}
