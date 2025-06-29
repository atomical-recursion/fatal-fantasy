package classes;
import enums.*;

/**
 * Represents the battle interface when battling with another character.
 * 
 * <p> During the battle, it will show the abilities of the character with the turn,
 * and will check if they have enough EP to execute it. </p>
 * 
 * <p> After every round, it will display what abilities each character executed, and
 * how it affected the opponent or themselves through {@link Battle#applyMoves(Ability, Ability)}.
 * And will also check if any of the characters have reached 0 HP, where the winner will be
 * announced in the {@link EndMenu}. </p>
 * 
 * <p> This class is a subclass of {@link Menu} and inherits screen handling and input validation features. </p>
 */
public class BattleMenu extends Menu {
    /** The Battle object representing a battle between two characters. */
    private Battle battle;

    /** The characters participating in the battle. */
    Character characterOne, characterTwo;

    /**
     * Constructs a {@code BattleMenu} with the two characters participating in
     * the battle. And within it, it will also construct a {@link Battle} object.
     * 
     * @param characterOne the first participating character.
     * @param characterTwo the second participating character.
     */
    public BattleMenu(Character characterOne, Character characterTwo) {
        battle = new Battle(characterOne, characterTwo);
        this.characterOne = characterOne;
        this.characterTwo = characterTwo;
    }

    /**
     * Displays the current round, whose turn it is, and what
     * abilities the character can execute. And will also check
     * the character's EP to see if it has enough EP to execute
     * their chosen ability and its HP to check if the battle can
     * still continue.
     */
    @Override public void display() {
        Ability moveOne = null, moveTwo = null;
        Character charactersTurn;
        int i;
        boolean successfulPick = false;

        while (characterOne.hasHealth() && characterTwo.hasHealth()) {
            if (battle.getTurn() && successfulPick) {
                characterOne.increaseEnergy(5);
                characterTwo.increaseEnergy(5);
            }

            do {
                System.out.println("{Round "+ battle.getRound() + "}");

                battle.displayTurn();
                System.out.print("\n");

                battle.displayStatus();
                charactersTurn = battle.getCharactersTurn();
                System.out.print("\n");

                optionAmount = 5;
                for (i = 0; i < optionAmount; i++) {
                    if (charactersTurn.getChosenAbility(i).getEpCost() > 0)
                        System.out.println("[" + (i + 1) + "] " + charactersTurn.getChosenAbility(i).getName() + " (Costs " + charactersTurn.getChosenAbility(i).getEpCost() + " EP)");
                    else
                        System.out.println("[" + (i + 1) + "] " + charactersTurn.getChosenAbility(i).getName() + " (Free)");

                    if (charactersTurn.getChosenAbility(i).checkIfReflexive()) {
                        if (charactersTurn.getChosenAbility(i).getHpEffect() > 0)
                            System.out.println(" >  (+" + charactersTurn.getChosenAbility(i).getHpEffect() + " HP)");
                        else if (charactersTurn.getChosenAbility(i).getEpEffect() > 0)
                            System.out.println(" >  (+" + charactersTurn.getChosenAbility(i).getEpEffect() + " EP)");
                    } else if (charactersTurn.getChosenAbility(i).checkIfDefensive()) {
                        if (charactersTurn.getChosenAbility(i).getName().equals(AbilityName.SMOKE_BOMB.toString()))
                            System.out.println(" >  (50% Chance To Evade Attack)");
                        else if (charactersTurn.getChosenAbility(i).getName().equals(AbilityName.SNEAK_ATTACK.toString()))
                            System.out.println(" >  (100% Damage Reduction, -45 HP)");
                        else if (charactersTurn.getChosenAbility(i).getName().equals(AbilityName.DEFEND.toString()))
                            System.out.println(" >  (50% Damage Reduction)");
                        else
                            System.out.println(" >  (100% Damage Reduction)");
                    } else if (charactersTurn.getChosenAbility(i).checkIfOffensive()) {
                        System.out.println(" >  (-" + charactersTurn.getChosenAbility(i).getHpEffect() + " HP)");
                    }
                }

                System.out.print("Enter Move: ");
                askChoice();

                if (!isValidChoice) {
                    System.out.println("(!) INVALID INPUT!");
                    pauseScreen(1);
                    clearScreen();
                } else {
                    if (battle.getTurn()) {
                        moveOne = battle.getMove(Integer.parseInt(choice) - 1);
                        if (moveOne.getEpCost() > characterOne.getEnergy()) {
                            successfulPick = false;

                            System.out.println("(!) NOT ENOUGH ENERGY!");
                            pauseScreen(1);
                            clearScreen();
                        } else {
                            successfulPick = true;
                        }
                    } else if (!battle.getTurn()) {
                        moveTwo = battle.getMove(Integer.parseInt(choice) - 1);

                        if (moveTwo.getEpCost() > characterTwo.getEnergy()) {
                            successfulPick = false;

                            System.out.println("(!) NOT ENOUGH ENERGY!");
                            pauseScreen(1);
                            clearScreen();
                        } else {
                            successfulPick = true;
                        }
                    }
                }

                if (!battle.getTurn() && successfulPick && isValidChoice) {
                    battle.applyMoves(moveOne, moveTwo);
                    battle.nextRound();
                }

                if (successfulPick && isValidChoice) {
                    battle.nextTurn();
                    clearScreen();
                }
            } while (!isValidChoice);
        }
    }
}