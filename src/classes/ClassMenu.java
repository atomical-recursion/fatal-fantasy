package classes;
import enums.*;

/**
 * Displays a menu allowing the player to select a character class.
 * 
 * <p> This menu presents three predefined options: Mage, Rogue, and Warrior.
 * It can also accept a custom header for context-specific prompts. </p>
 * 
 * <p> This class extends the {@code Menu} superclass and sets up a simple list of
 * class choices, each corresponding to a {@link ClassName} enum. </p>
 */
public class ClassMenu extends Menu {

    /**
     * Constructs a default {@code ClassMenu} with the header "Choose A Class".
     * Initializes the menu options as Mage, Rogue, and Warrior, and their
     * descriptions.
     */
    public ClassMenu() {
        header = "Choose A Class";
        optionAmount = 3;
        options.add(ClassName.MAGE.toString() + "\n" + " >  " + ClassDescription.MAGE.toString());
        options.add(ClassName.ROGUE.toString() + "\n" + " >  " + ClassDescription.ROGUE.toString());
        options.add(ClassName.WARRIOR.toString() + "\n" + " >  " + ClassDescription.WARRIOR.toString());
    }

    /**
     * Constructs a {@code ClassMenu} with a custom header.
     * Useful when displaying the class selection in different contexts (like in edit mode).
     *
     * @param header the header text to be displayed above the options.
     */
    public ClassMenu(String header) {
        this.header = header;
        optionAmount = 3;
        options.add(ClassName.MAGE.toString() + "\n" + " >  " + ClassDescription.MAGE.toString());
        options.add(ClassName.ROGUE.toString() + "\n" + " >  " + ClassDescription.ROGUE.toString());
        options.add(ClassName.WARRIOR.toString() + "\n" + " >  " + ClassDescription.WARRIOR.toString());
    }
}
