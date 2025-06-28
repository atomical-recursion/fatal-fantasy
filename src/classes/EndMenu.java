package src.classes;

/**
 * Handles the display and logic for the final screen of a battle.
 * 
 * <p> After a battle concludes, it announces the winner (or if it was a draw),
 * and provides the player with options to either restart the game or return to the main menu. </p>
 * 
 * <p> This class extends {@link Menu}, inheriting screen handling and input validation features. </p>
 */
public class EndMenu extends Menu {
    /** The first character that participated in the battle. */
    private Character characterOne;
    
    /** The second character that participated in the battle. */
    private Character characterTwo;

    /**
     * Constructs an {@code EndMenu} with references to the two characters that were in battle.
     *
     * @param characterOne the first character.
     * @param characterTwo the second character.
     */
    public EndMenu(Character characterOne, Character characterTwo) {
        this.characterOne = characterOne;
        this.characterTwo = characterTwo;
        
        optionAmount = 2;
        options.add("Restart Game");
        options.add("Return to Main Menu");
    }

    /**
     * Displays the end game menu.
     *
     * <p> Announces the winner based on each character's health and allows the user to
     * choose to restart the game or return to the main menu. Input is validated before proceeding.</p>
     */
    @Override public void display() {
        int i;

        do {
            System.out.println("{Main Game}");

            if (!characterOne.hasHealth() && !characterTwo.hasHealth())
                System.out.println("(&) Its A Draw!");
            else if (!characterOne.hasHealth())
                System.out.println("(&) " + characterTwo.getName() + " Won!");
            else if (!characterTwo.hasHealth())
                System.out.println("(&) " + characterOne.getName() + " Won!");

            for (i = 0; i < optionAmount; i++) {
                System.out.println("[" + (i + 1) + "] " + options.get(i));
            }

            System.out.print("Enter Choice: ");
            askChoice();

            if (!isValidChoice) {
                System.out.println("(!) INVALID INPUT!");
                pauseScreen(1);
                clearScreen();
            } else if (choice.equals("1")) {
                System.out.println("(*) RESTARTING");
                pauseScreen(1);
                clearScreen();
            } else {
                clearScreen();
            }
        } while (!isValidChoice);

    }
}
