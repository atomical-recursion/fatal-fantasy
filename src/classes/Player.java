package src.classes;
import src.enums.*;

import java.util.*;

/**
 * Represents a player in the game who manages a roster of characters.
 * 
 * <p> This class enables the creation, editing, deleting, and retrieval of characters.
 * It also enforces name uniqueness via a shared {@code nameRepository} list. </p>
 * 
 * <p> This class serves as the backbone for character management operations
 * across menus like {@link CreateMenu}, {@link EditMenu}, and {@link DeleteMenu}. </p>
 */
public class Player {
    /** The list of characters currently owned by the player. */
    private ArrayList<Character> characters;

    /**
     * A static list storing all character names across all players
     * to ensure that names are unique.
     */
    static private ArrayList<String> nameRepository;

    /**
     * Constructs a {@code Player} with an empty character list
     * and initializes the static name repository.
     */
    public Player() {
        characters = new ArrayList<Character>();
        nameRepository = new ArrayList<String>();
    }

    /**
     * Retrieves a character at the specified index.
     *
     * @param index the index of the character in the list.
     * @return the {@link Character} at the given index.
     */
    public Character getCharacter(int index) {
        return characters.get(index);
    }

    /**
     * Returns the total number of characters owned by the player.
     *
     * @return the number of characters.
     */
    public int getCharacterAmount() {
        return characters.size();
    }

    /**
     * Creates and adds a new character to the player's list.
     * Also registers the name to the global name repository.
     *
     * @param chosenClass     the class of the new character.
     * @param chosenAbilities the 3 selected abilities for the character.
     * @param name            the unique name for the new character.
     */
    public void createCharacter(ClassName chosenClass, ArrayList<Ability> chosenAbilities, String name) {
        characters.add(new Character(chosenClass, chosenAbilities, name));
        nameRepository.add(name);
    }

    /**
     * Replaces a character at the specified index with a new one, preserving the original name.
     *
     * @param chosenClass     the new class for the character.
     * @param chosenAbilities the new set of abilities.
     * @param index           the index of the character to replace.
     */
    public void editCharacter(ClassName chosenClass, ArrayList<Ability> chosenAbilities, int index) {
        characters.set(index, new Character(chosenClass, chosenAbilities, nameRepository.get(index)));
    }

    /**
     * Deletes the character at the specified index from the list and removes its name from the repository.
     *
     * @param index the index of the character to delete.
     */
    public void deleteCharacter(int index) {
        characters.remove(index);
        nameRepository.remove(index);
    }

    /**
     * Checks if a given character name already exists in the name repository.
     *
     * @param name the character name to check.
     * @return {@code true} if the name exists, {@code false} otherwise.
     */
    public boolean isNameExisting(String name) {
        ArrayList<String> lowercases = new ArrayList<String>();
        int i = 0;
        
        lowercases.addAll(nameRepository);
        
        for (String copyName : lowercases) {
            lowercases.set(i, copyName.toLowerCase());
            i++;
        }

        return lowercases.contains(name.toLowerCase());
    }

    /**
     * Displays a player's characters with their class and 3 chosen abilities.
     */
    public void displayCharacters() {
        int i = 0;

        for (Character character : characters) {
            System.out.println("[" + (i + 1) + "] " + character.getName() + " (" + character.getChosenClass() + ")");
            System.out.println(" >  " + character.getChosenAbility(0).getName() + ", " + character.getChosenAbility(1).getName() + " & " + character.getChosenAbility(2).getName());
            i++;
        }
    }
}
