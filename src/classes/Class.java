package src.classes;
import src.enums.*;

import java.util.*;

/**
 * Represents a character class in Fatal Fantasy: Tactics, such as Mage, Rogue, or Warrior.
 * Each class has a unique set of abilities and an associated description.
 * 
 * <p> This class initializes its list of abilities depending on the {@link ClassName} given.
 * It supports retrieving and removing abilities, and is used during character creation. </p>
 */
public class Class {
    /** The name of the class (Mage, Rogue, Warrior). */
    final private ClassName name;

    /** The list of abilities associated with this class. */
    private ArrayList<Ability> abilities;
    
    /**
     * Constructs a {@code Class} and populates its ability list based on the given class name.
     * 
     * @param name the class type (Mage, Rogue, Warrior).
     */
    public Class(ClassName name) {
        abilities = new ArrayList<Ability>();
        this.name = name;
        
        if (name == ClassName.MAGE) {
            abilities.add(new Ability(AbilityName.ARCANE_BOLT, AbilityDescription.ARCANE_BOLT, 5, 20, 0));
            abilities.add(new Ability(AbilityName.ARCANE_BLAST, AbilityDescription.ARCANE_BLAST, 30, 65, 0));
            abilities.add(new Ability(AbilityName.MANA_CHANNEL, AbilityDescription.MANA_CHANNEL, 0, 0, 15));
            abilities.add(new Ability(AbilityName.LESSER_HEAL, AbilityDescription.LESSER_HEAL, 15, 40, 0));
            abilities.add(new Ability(AbilityName.ARCANE_SHIELD, AbilityDescription.ARCANE_SHIELD, 12, 0, 0));
        } else if (name == ClassName.ROGUE) {
            abilities.add(new Ability(AbilityName.SHIV, AbilityDescription.SHIV, 5, 20, 0));
            abilities.add(new Ability(AbilityName.BACKSTAB, AbilityDescription.BACKSTAB, 15, 35, 0));
            abilities.add(new Ability(AbilityName.FOCUS, AbilityDescription.FOCUS, 0, 0, 10));
            abilities.add(new Ability(AbilityName.SMOKE_BOMB, AbilityDescription.SMOKE_BOMB, 15, 0, 0));
            abilities.add(new Ability(AbilityName.SNEAK_ATTACK, AbilityDescription.SNEAK_ATTACK, 25, 45, 0));
        } else {
            abilities.add(new Ability(AbilityName.CLEAVE, AbilityDescription.CLEAVE, 5, 20, 0));
            abilities.add(new Ability(AbilityName.SHIELD_BASH, AbilityDescription.SHIELD_BASH, 15, 35, 0));
            abilities.add(new Ability(AbilityName.IRONCLAD_DEFENSE, AbilityDescription.IRONCLAD_DEFENSE, 15, 0, 0));
            abilities.add(new Ability(AbilityName.BLOODLUST, AbilityDescription.BLOODLUST, 12, 30, 0));
            abilities.add(new Ability(AbilityName.RALLYING_CRY, AbilityDescription.RALLYING_CRY, 0, 0, 12));
        }
    }

    public String getName() {
        return name.toString();
    }
    
    /**
     * Returns the ability at the specified index in the ability list.
     *
     * @param index the index of the ability to retrieve.
     * @return the {@link Ability} at the specified index.
     */
    public Ability getAbility(int index) {
        return abilities.get(index);
    }

    /**
     * Removes and returns the ability at the specified index in the ability list.
     * 
     * @param index the index of the ability to remove.
     * @return the removed {@link Ability}.
     */
    public Ability removeAbility(int index) {
        Ability pickedAbility = abilities.get(index);
        abilities.remove(index);

        return pickedAbility;
    }
}
