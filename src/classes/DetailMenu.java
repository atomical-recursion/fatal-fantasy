package src.classes;

/**
 * Displays detailed information about a single character.
 * 
 * <p> This menu shows the character’s name, class, and selected abilities,
 * and includes a single option to return to the character list. </p>
 * 
 * <p> This class extends the {@link Menu} class and uses the
 * {@link Character#displayDetails()} method to present the character data. </p>
 */
public class DetailMenu extends Menu {
    /** The character whose details are being displayed. */
    Character character;

    /**
     * Constructs a {@code DetailMenu} for the specified character.
     * Sets a single option: "Return to Character List".
     *
     * @param character the character whose details will be shown.
     */
    public DetailMenu(Character character) {
        this.character = character;
        optionAmount = 1;
        options.add("Return to Character List");
    }

    /**
     * Displays the character's detailed information including name, class, and abilities.
     * 
     * <p>Continues to prompt the user until a valid choice is entered
     * to return to the character list.</p>
     */
    @Override public void display() {
        do {
            System.out.println("{" + character.getName() + " Details}");

            character.displayDetails();
            System.out.println("[1] " + options.get(0));
            System.out.print("Enter Choice: ");
            askChoice();

            if (!isValidChoice) {
                System.out.println("(!) INVALID INPUT!");
                pauseScreen(1);
                clearScreen();
            } else {
                clearScreen();
            }
        } while (!isValidChoice);
    }
}
