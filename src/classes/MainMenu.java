package src.classes;

/**
 * Represents the main menu of the game "Fatal Fantasy: Tactics".
 * 
 * <p> This menu is the entry point for the player and provides the following options:
 * <ul>
 *   <li> Start Game </li>
 *   <li> Manage Characters </li>
 *   <li> Rules </li>
 *   <li> Exit Game </li>
 * </ul>
 * 
 * <p> This class extends {@link Menu} and sets a custom header for the main menu interface. </p>
 */
public class MainMenu extends Menu {
    
    /**
     * Constructs a {@code MainMenu} with four predefined options and a header title.
     */
    public MainMenu() {
        header = "Fatal Fantasy: Tactics";
        optionAmount = 4;
        options.add("Start Game");
        options.add("Manage Characters");
        options.add("Rules");
        options.add("Exit Game");
    }
}