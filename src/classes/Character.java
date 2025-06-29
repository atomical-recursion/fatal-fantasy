package classes;
import enums.*;

import java.util.*;

/**
 * Represents a game character with a name, class, stats (health and energy),
 * and a set of chosen abilities. This class provides methods to manage a character's
 * status during the game, such as checking and modifying health and energy levels.
 * 
 * <p> Characters begin with full health (100 HP) and full energy (50 EP) and can use
 * their abilities during battles. </p>
 */
public class Character {
    /** The name of the character. */
    final private String name;

    /** The current energy points of the character (0 to 50). */
    private int energy;

    /** The current health points of the character (0 to 100). */
    private int health;

    /** The class type of the character (Mage, Rogue, Warrior). */
    private ClassName chosenClass;

    /** The list of chosen abilities assigned to the character. */
    private ArrayList<Ability> chosenAbilities;

    /**
     * Constructs a {@code Character} with the specified class, abilities, and name.
     * Initializes the HP to 100 and EP to 50.
     *
     * @param chosenClass     the class of the character (Mage, Rogue, Warrior).
     * @param chosenAbilities the list of abilities chosen for this character.
     * @param name            the name of the character.
     */
    public Character(ClassName chosenClass, ArrayList<Ability> chosenAbilities, String name) {
        this.chosenClass = chosenClass;
        this.chosenAbilities = chosenAbilities;
        this.name = name;
        energy = 50;
        health = 100;
        chosenAbilities.add(new Ability(AbilityName.DEFEND, AbilityDescription.DEFEND, 5, 0, 0));
        chosenAbilities.add(new Ability(AbilityName.RECHARGE, AbilityDescription.RECHARGE, 0, 0, 5));
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHealth() {
        return health;
    }

    public ClassName getChosenClass() {
        return chosenClass;
    }

    /**
     * Gets one of the character's chosen abilities by index.
     *
     * @param index the index of the desired ability.
     * @return the corresponding {@link Ability}.
     */
    public Ability getChosenAbility(int index) {
        return chosenAbilities.get(index);
    }

    /**
     * Fully restores the character's health and energy to default values (100 HP, 50 EP).
     */
    public void restoreStats() {
        this.energy = 50;
        this.health = 100;
    }

    /**
     * Increases the character's health by a given amount, up to a maximum of 100.
     *
     * @param increase the amount to increase health.
     */
    public void increaseHealth(int increase) {
        int total = health + increase;

        if (total >= 100)
            health = 100;
        else
            health = total;
    }

    /**
     * Decreases the character's health by a given amount, down to a minimum of 0.
     *
     * @param decrease the amount to decrease health.
     */
    public void decreaseHealth(int decrease) {
        int total = health - decrease;

        if (total <= 0)
            health = 0;
        else
            health = total;
    }

    /**
     * Increases the character's energy by a given amount, up to a maximum of 50.
     *
     * @param increase the amount to increase energy.
     */
    public void increaseEnergy(int increase) {
        int total = energy + increase;

        if (total >= 50)
            energy = 50;
        else
            energy = total;
    }

    /**
     * Decreases the character's energy by a given amount, down to a minimum of 0.
     *
     * @param decrease the amount to decrease energy.
     */
    public void decreaseEnergy(int decrease) {
        int total = energy - decrease;

        if (total <= 0)
            energy = 0;
        else
            energy = total;
    }

    /**
     * Checks if the character still has any health left.
     *
     * @return {@code true} if their health is above 0, otherwise {@code false}.
     */
    public boolean hasHealth() {
        return health > 0;
    }

    /**
     * Displays the character's details including name, class, and abilities.
     */
    public void displayDetails() {
        int i = 1;
        
        System.out.println("Name: " + name);
        System.out.println("Class: " + chosenClass.toString());

        System.out.println("Abilities: ");
        for (Ability ability : chosenAbilities) {
            if (ability.getEpCost() > 0)
                System.out.println("(" + (i++) + ") " + ability.getName() + " (Costs " + ability.getEpCost() + " EP)");
            else
                System.out.println("(" + (i++) + ") " + ability.getName() + " (Free)");

            System.out.println(" >  " + ability.getDescription());
        }
    }
}
