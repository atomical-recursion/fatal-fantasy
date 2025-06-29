package classes;
import enums.*;

import java.util.*;

/**
 * Represents the menu for editing an existing character in the player's roster.
 * 
 * <p> This menu allows the player to:
 * <ol>
 *   <li> Select a Character From Their List </li>
 *   <li> Choose a New Class for that Character </li>
 *   <li> Pick a New Set of 3 Abilities </li>
 * </ol>
 * 
 * <p> The character is updated using {@link Player#editCharacter(ClassName, ArrayList, int)}.
 * This class extends {@link Menu} and dynamically adjusts the option count based on
 * the player's current number of characters. </p>
 */
public class EditMenu extends Menu {
    /** The player editing one of their characters. */
    private Player player;

    /** The menu used to select a new class for the character. */
    private ClassMenu classMenu;

    /** The input of the what the new class of the character will be. */
    private String classChoice;

    /** The new class of the character. */
    private ClassName chosenClass;

    /** The menu used to select 3 new abilities from the new class. */
    private AbilityMenu abilityMenu;

    /** The new abilities of the character. */
    private ArrayList<Ability> chosenAbilities;

    /**
     * Constructs an EditMenu for a given player.
     * Initializes the class menu and sets the option count
     * based on how many characters the player has.
     *
     * @param player the player who wants to edit one of their characters.
     */
    public EditMenu(Player player) {
        this.player = player;
        optionAmount = player.getCharacterAmount() + 1;
        classMenu = new ClassMenu("Re-Choose A Class");
    }

    /**
     * Displays the character editing interface.
     * 
     * <p> Shows a list of the player’s characters. After a valid selection,
     * the menu prompts the user to select a new class and abilities.
     * Once chosen, the character is updated using the {@link Player#editCharacter} method. </p>
     */
    @Override public void display() {
        int index;

        do {
            System.out.println("{Edit A Character}");
            
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
                classMenu.display();
                classChoice = classMenu.choice;
                
                if (classChoice.equals("1"))
                    chosenClass = ClassName.MAGE;
                else if (classChoice.equals("2"))
                    chosenClass = ClassName.ROGUE;
                else if (classChoice.equals("3"))
                    chosenClass = ClassName.WARRIOR;

                abilityMenu = new AbilityMenu(chosenClass, true);
                abilityMenu.display();
                chosenAbilities = abilityMenu.getChosenAbilities();

                index = Integer.parseInt(choice) - 1;
                player.editCharacter(chosenClass, chosenAbilities, index);
            } else {
                clearScreen();
            }
        } while (!isValidChoice);
    }
}
