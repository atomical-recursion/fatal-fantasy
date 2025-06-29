package classes;
import enums.*;

import java.util.*;

/**
 * Handles the character creation process, including class selection,
 * ability selection, and naming the character.
 * 
 * <p> This menu guides the player through three stages:
 * <ol>
 *   <li> Class Selection (via {@link ClassMenu}) </li>
 *   <li> Ability Selection (via {@link AbilityMenu}) </li>
 *   <li> Character Naming (with duplicate name checks via {@link Player#isNameExisting(String)}) </li>
 * </ol>
 * 
 * <p> Once all steps are completed, the new character is added to the player’s roster.</p>
 * 
 * <p> This class extends {@link Menu} to maintain a consistent menu structure. </p>
 */
public class CreateMenu extends Menu {
    /** The player creating the character. */
    private Player player;

    /** Menu used to choose a class. */
    private ClassMenu classMenu;

    /** The string value representing the class choice (1 = Mage, etc.). */
    private String classChoice;

    /** The enumerated class type chosen by the player. */
    private ClassName chosenClass;

    /** Menu used to choose class-based abilities. */
    private AbilityMenu abilityMenu;

    /** The abilities selected by the player. */
    private ArrayList<Ability> chosenAbilities;

    /** The name input by the user for the new character. */
    private String name;

    /**
     * Constructs a CreateMenu for a given player.
     * Initializes the class menu and prepares an ability list.
     *
     * @param player the player who is creating a character.
     */
    public CreateMenu(Player player) {
        this.player = player;
        classMenu = new ClassMenu();
        chosenAbilities = new ArrayList<Ability>();
    }

    /**
     * Displays the full character creation flow:
     * <ul>
     *   <li> Prompts Class Selection (via {@link ClassMenu}) </li>
     *   <li> Prompts Ability Selection (via {@link AbilityMenu}) </li>
     *   <li> Prompts for a Unique Character Name </li>
     * </ul>
     * 
     * If the name already exists, the user will be asked to enter another name.
     * After a successful creation, the character is added to the player's character list.
     */
    @Override public void display() {
        // Class Selection
        classMenu.display();
        classChoice = classMenu.choice;
        
        if (classChoice.equals("1"))
            chosenClass = ClassName.MAGE;
        else if (classChoice.equals("2"))
            chosenClass = ClassName.ROGUE;
        else
            chosenClass = ClassName.WARRIOR;

        // Ability Selection
        abilityMenu = new AbilityMenu(chosenClass);
        abilityMenu.display();
        chosenAbilities = abilityMenu.getChosenAbilities();

        // Name Input
        do {
            System.out.println("{Name The Character}");
            System.out.print("Enter A Name: ");
            name = input.nextLine().trim();
            name = name.replaceAll("\\s+", "");

            if (player.isNameExisting(name)) {
                System.out.println("(!) NAME ALREADY TAKEN!");
                pauseScreen(1);
                System.out.println("($) Try Another Name.");
                pauseScreen(1);
                clearScreen();
            } else if (name.equals("")) {
                System.out.println("(!) INVALID INPUT!");
                pauseScreen(1);
                clearScreen();
            } else {
                System.out.println("(*) CREATING " + name.toUpperCase());
                pauseScreen(1);
                clearScreen();
            }
        } while (player.isNameExisting(name) || name.equals(""));

        // Character Creation
        player.createCharacter(chosenClass, chosenAbilities, name);
    }
}
