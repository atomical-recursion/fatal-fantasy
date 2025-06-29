package classes;

/**
 * Handles the transition from the main menu to the battle menu.
 * It allows both players to select their characters. If a player has no characters,
 * they are redirected to create one.
 *
 * <p> Once both players have selected or created their characters, the battle menu
 * is launched. </p>
 *
 * This class is a subclass of {@link Menu}, inheriting its display and input functionality.
 */
public class SplashMenu extends Menu {
    /** The first player participating in the battle. */
    private Player playerOne;

    /** The second player participating in the battle. */
    private Player playerTwo;

    /** The character creation menu invoked if a player has no characters. */
    private CreateMenu createMenu;

    /** The battle menu that handles the fight between the two selected characters. */
    private BattleMenu battleMenu;

    /** The character selected by Player 1. */
    private Character characterOne;

    /** The character selected by Player 2. */
    private Character characterTwo;

    /**
     * Constructs a {@code SplashMenu} with the given players.
     *
     * @param playerOne the first player's character.
     * @param playerTwo the second player's character.
     */
    public SplashMenu(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this. playerTwo = playerTwo;
    }

    /**
     * Gets the character selected by Player 1.
     *
     * @return the first selected character.
     */
    public Character getCharacterOne() {
        return characterOne;
    }

    /**
     * Gets the character selected by Player 2.
     *
     * @return the second selected character.
     */
    public Character getCharacterTwo() {
        return characterTwo;
    }

    /**
     * Allows the given player to select a character for battle.
     * If the player has no characters, they are prompted to create one.
     *
     * @param player       the player selecting a character.
     * @param playerNumber the identifier of the player ("1" or "2").
     * @return             the selected {@link Character}.
     */
    private Character pickCharacter (Player player, String playerNumber) {
        Character character = null;

        if (player.getCharacterAmount() == 0) {
            System.out.println("{Main Game}");
            

            if (playerNumber.equals("1"))
                System.out.println("(!) Player 1 Has No Characters!");
            else if (playerNumber.equals("2"))
                System.out.println("(!) Player 2 Has No Characters!");

            pauseScreen(1);
            System.out.println("(*) ALLOCATING CHARACTER CREATION");
            pauseScreen(1);
            clearScreen();
            
            createMenu = new CreateMenu(player);
            createMenu.display();
            character = player.getCharacter(0);
        } else {
            do {
                System.out.println("{Main Game}");
                System.out.println("(Player " + playerNumber + "'s Characters)");
                optionAmount = player.getCharacterAmount();
                
                player.displayCharacters();
                System.out.print("Enter Character To Battle With: ");
                askChoice();

                if (!isValidChoice) {
                    System.out.println("(!) INVALID INPUT!");
                    pauseScreen(1);
                    clearScreen();
                } else {
                    clearScreen();

                    character = player.getCharacter(Integer.parseInt(choice) - 1);
                }
            } while (!isValidChoice);
        }

        return character;
    }
    
    /**
     * Starts the splash menu flow, allowing both players to select characters
     * and then launching the battle menu.
     */
    @Override public void display() {

        characterOne = pickCharacter(playerOne, "1");
        characterTwo = pickCharacter(playerTwo, "2");

        System.out.println("{Main Game}");
        System.out.println("(*) PREPARING A BATTLE BETWEEN "+ characterOne.getName().toUpperCase() +" VS " + characterTwo.getName().toUpperCase());
        pauseScreen(1);
        clearScreen();

        battleMenu = new BattleMenu(characterOne, characterTwo);
        battleMenu.display();
    }
}