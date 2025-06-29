package classes;
import enums.*;

/**
 * Represents a special ability that a character can use during battle.
 * An ability has a name, description, energy cost (EP), and effects on 
 * health (HP) and energy (EP) that can be applied to either the user or a target.
 * 
 * <p> This class is part of the battle mechanics for the game and is
 * typically used by characters to affect themselves or others during combat. </p>
 */
public class Ability {
    /** The name of the ability. */
    final private AbilityName name;

    /** The description of what the ability does. */
    final private AbilityDescription description;

    /** The energy cost to execute this ability. */
    final private int epCost;

    /** The effect on health (HP) when this ability is used. */
    final private int hpEffect;

    /** The effect on energy (EP) when this ability is used. */
    final private int epEffect;

    /**
     * Constructs an {@code Ability} with the specified parameters.
     * 
     * @param name        the name of the ability.
     * @param description the description of what the ability does.
     * @param epCost      the energy cost to execute this ability.
     * @param hpEffect    the effect on health (HP) when this ability is used.
     * @param epEffect    the effect on energy (EP) when this ability is used.
     */
    public Ability(AbilityName name, AbilityDescription description, int epCost, int hpEffect, int epEffect) {
        this.name = name;
        this.description = description;
        this.epCost = epCost;
        this.hpEffect = hpEffect;
        this.epEffect = epEffect;
    }

    public String getName() {
        return name.toString();
    }

    public String getDescription () {
        return description.toString();
    }

    public int getEpCost() {
        return epCost;
    }

    public int getHpEffect() {
        return hpEffect;
    }

    public int getEpEffect() {
        return epEffect;
    }

    /**
     * Checks if an ability negates an attack from another character.
     * 
     * @return {@code true} if it is a defensive ability and {@code false} is not.
     */
    public boolean checkIfDefensive() {
        String nameString = name.toString();

        return nameString.equals(AbilityName.ARCANE_SHIELD.toString()) ||
               nameString.equals(AbilityName.SMOKE_BOMB.toString()) ||
               nameString.equals(AbilityName.SNEAK_ATTACK.toString()) ||
               nameString.equals(AbilityName.IRONCLAD_DEFENSE.toString()) ||
               nameString.equals(AbilityName.DEFEND.toString());
    }

    /**
     * Checks if an ability decreases another character's HP.
     * 
     * @return {@code true} if it is an offensive ability and {@code false} is not.
     */
    public boolean checkIfOffensive() {
        String nameString = name.toString();

        return nameString.equals(AbilityName.ARCANE_BOLT.toString()) ||
               nameString.equals(AbilityName.ARCANE_BLAST.toString()) ||
               nameString.equals(AbilityName.SHIV.toString()) ||
               nameString.equals(AbilityName.BACKSTAB.toString()) ||
               nameString.equals(AbilityName.SNEAK_ATTACK.toString()) ||
               nameString.equals(AbilityName.CLEAVE.toString()) ||
               nameString.equals(AbilityName.SHIELD_BASH.toString());
    }

    /**
     * Checks if an ability increases a character's own health or energy.
     * 
     * @return {@code true} if it is a reflexive ability and {@code false} is not.
     */
    public boolean checkIfReflexive() {
        String nameString = name.toString();

        return nameString.equals(AbilityName.MANA_CHANNEL.toString()) ||
               nameString.equals(AbilityName.LESSER_HEAL.toString()) ||
               nameString.equals(AbilityName.FOCUS.toString()) ||
               nameString.equals(AbilityName.BLOODLUST.toString()) ||
               nameString.equals(AbilityName.RALLYING_CRY.toString()) ||
               nameString.equals(AbilityName.RECHARGE.toString());
    }
}