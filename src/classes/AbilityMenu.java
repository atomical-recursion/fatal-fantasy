package classes;
import enums.*;

import java.util.*;

/**
 * Represents the menu interface for selecting abilities based on the character's chosen class.
 * Players can choose 3 out of 5 abilities presented from their selected class.
 * 
 * <p> This class is a subclass of {@link Menu} and supports both normal and editing modes. </p>
 */
public class AbilityMenu extends Menu {
    /** the class selected by the player (Mage, Rogue, Warrior). */
    private Class chosenClass;

    /** The list of abilities selected by the player. */
    private ArrayList<Ability> chosenAbilities;
    
    /** Indicates whether this menu is used for editing an existing character. */
    private boolean editingMode;

    /**
     * Constructs an {@code AbilityMenu} for the specified class.
     * Initializes 5 ability options based on the chosen class.
     *
     * @param chosenClass the class selected by the player (Mage, Rogue, Warrior).
     */
    public AbilityMenu(ClassName chosenClass) {
        int i;
        optionAmount = 5;

        if (chosenClass == ClassName.MAGE)
            this.chosenClass = new Class(ClassName.MAGE);
        else if (chosenClass == ClassName.ROGUE)
            this.chosenClass = new Class(ClassName.ROGUE);
        else if (chosenClass == ClassName.WARRIOR)
            this.chosenClass = new Class(ClassName.WARRIOR);

        for (i = 0; i < 5; i++) {
            Ability ability = this.chosenClass.getAbility(i);
            options.add(ability.getName() + " (Costs " + ability.getEpCost() + " EP)\n >  " + ability.getDescription());
        }
        
        chosenAbilities = new ArrayList<Ability>();
    }

    /**
     * Constructs an {@code AbilityMenu} for the specified class in editing mode.
     * This allows the player to save their chosen abilities.
     *
     * @param chosenClass the class selected by the player (Mage, Rogue, Warrior).
     * @param editingMode the flag if it is in editing mode or not.
     */
    public AbilityMenu(ClassName chosenClass, boolean editingMode) {
        this(chosenClass);
        this.editingMode = editingMode;
    }
    
    public ArrayList<Ability> getChosenAbilities() {
        return chosenAbilities;
    }

    /**
     * Displays the ability selection menu, allowing the player to choose 3 abilities.
     * Also handles user input validation and clears the screen after each selection.
     */
    @Override public void display() {
        int i, index, abilities = 0;

        while (abilities != 3) {
            System.out.println("{Choose 3 " + this.chosenClass.getName() + " Abilites}");

            for (i = 0; i < optionAmount; i++) {
                System.out.println("[" + (i + 1) + "] " + options.get(i));
            }

            switch (abilities) {
                case 0:
                    System.out.print("Enter 1st Ability: ");
                    break;
                case 1:
                    System.out.print("Enter 2nd Ability: ");
                    break;
                case 2:
                    System.out.print("Enter 3rd Ability: ");
                    break;
            }

            askChoice();

            if (!isValidChoice) {
                System.out.println("(!) INVALID INPUT!");
                pauseScreen(1);
                clearScreen();
            } else {
                index = Integer.parseInt(choice) - 1;

                chosenAbilities.add(chosenClass.getAbility(index));
                options.remove(index);
                chosenClass.removeAbility(index);
                optionAmount = (optionAmount - 1);
                abilities++;

                if (editingMode == true && chosenAbilities.size() == 3) {
                    System.out.println("(*) SAVING");
                    pauseScreen(1);
                    System.out.print("(&) Successfully Saved!");
                    pauseScreen(1);
                    clearScreen();
                } else {
                    clearScreen();
                }
            }
        }
    }
}
