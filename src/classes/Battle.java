package src.classes;
import src.enums.*;

import java.util.*;

/**
 * Handles the turn-based battle system between two characters in the game.
 * 
 * <p> A battle runs in rounds. Each character selects an ability (including defend or recharge options),
 * and both moves are executed in sequence. Combat ends when one or both characters' health reaches zero. </p>
 * 
 * <p> Characters automatically regenerate 5 EP each round. The outcome is printed after each round and 
 * at the end of battle. </p>
 */
public class Battle {
    /** Player 1's character. */
    private Character characterOne;

    /** Player 2's character. */
    private Character characterTwo;

    /** The round number of the battle. */
    private int round;

    /** Indicates which player's character's turn it is. */
    private boolean turn;

    /**
     * Constructs a {@code Battle} for two characters and sets their stats to full.
     *
     * @param characterOne the character of Player 1.
     * @param characterTwo the character of Player 2.
     */
    public Battle(Character characterOne, Character characterTwo) {
        this.characterOne = characterOne;
        this.characterTwo = characterTwo;
        round = 1;
        characterOne.restoreStats();
        characterTwo.restoreStats();
        turn = true;
    }

    public int getRound() {
        return round;
    }

    public boolean getTurn() {
        return turn;
    }

    /**
     * Gets the ability that the character will execute.
     * 
     * @param index the index of the ability the character will execute.
     * @return the {@link Ability} that the character will execute.
     */
    public Ability getMove(int index) {
        Ability move = null;
        
        if (turn == true)
            move = characterOne.getChosenAbility(index);
        else if (turn == false)
            move = characterTwo.getChosenAbility(index);

        return move;
    }

    /**
     * Checks the turn flag if it's player 1's character's or player 2's characters.
     * 
     * <p> If the flag is true, then it is player 1's character's turn and if false,
     * it is player 2's character's turn. </p>
     * 
     * @return the character that has the turn.
     */
    public Character getCharactersTurn() {
        Character charactersTurn = null;
        
        if (turn)
            charactersTurn = characterOne;
        else if (!turn)
            charactersTurn = characterTwo;
        
        return charactersTurn;
    }

    /**
     * Increments the round number by 1.
     * 
     * @return the incremented round number.
     */
    public int nextRound() {
        return round++;
    }

    /**
     * Flips the turn flag to be used by {@link #getCharactersTurn()}.
     */
    public void nextTurn() {
        turn = !turn;
    }

    /**
     * Applies the character's abilities to each other or to themselves.
     * 
     * @param moveOne the move that the first character excuted.
     * @param moveTwo the move that the second character excuted.
     */
    public void applyMoves(Ability moveOne, Ability moveTwo) {
        int damageToOne = 0, damageToTwo = 0;
        boolean oneDefended = false, oneEvaded = false, twoDefended = false, twoEvaded = false;

        characterOne.decreaseEnergy(moveOne.getEpCost());
        characterTwo.decreaseEnergy(moveTwo.getEpCost());

        if (moveOne.getName().equals(AbilityName.SNEAK_ATTACK.toString())) {
            if (!moveTwo.checkIfDefensive()) {
                damageToTwo = moveOne.getHpEffect();
                oneEvaded = true;
            }
        } else if (moveOne.checkIfDefensive()) {
            if (moveOne.getName().equals(AbilityName.DEFEND.toString()))
                oneDefended = true;
            else if (moveOne.getName().equals(AbilityName.SMOKE_BOMB.toString()))
                oneEvaded = new Random().nextBoolean();
            else
                oneEvaded = true;
        }

        if (moveTwo.getName().equals(AbilityName.SNEAK_ATTACK.toString())) {
            if (!moveOne.checkIfDefensive()) {
                damageToOne = moveTwo.getHpEffect();
                twoEvaded = true;
            }
        } else if (moveTwo.checkIfDefensive()) {
            if (moveTwo.getName().equals(AbilityName.DEFEND.toString()))
                twoDefended = true;
            else if (moveTwo.getName().equals(AbilityName.SMOKE_BOMB.toString()))
                twoEvaded = new Random().nextBoolean();
            else
                twoEvaded = true;
        }

        if (moveOne.checkIfOffensive()) {
            if (twoDefended)
                damageToTwo = (int) Math.floor(moveOne.getHpEffect() / 2.0);
            else if (!twoEvaded)
                damageToTwo = moveOne.getHpEffect();
            else if (twoEvaded)
                damageToTwo = 0;
        }

        if (moveTwo.checkIfOffensive()) {
            if (oneDefended)
                damageToOne = (int) Math.floor(moveTwo.getHpEffect() / 2.0);
            else if (!oneEvaded)
                damageToOne = moveTwo.getHpEffect();
            else if (oneEvaded)
                damageToOne = 0;
        }

        displayRoundOutcome(moveOne, moveTwo, oneEvaded, twoEvaded);

        characterOne.decreaseHealth(damageToOne);
        characterTwo.decreaseHealth(damageToTwo);

        if (moveOne.checkIfReflexive()) {
            characterOne.increaseHealth(moveOne.getHpEffect());
            characterOne.increaseEnergy(moveOne.getEpEffect());
        }

        if (moveTwo.checkIfReflexive()) {
            characterTwo.increaseHealth(moveTwo.getHpEffect());
            characterTwo.increaseEnergy(moveTwo.getEpEffect());
        }
    }

    /**
     * Displays whose turn it is.
     */
    public void displayTurn() {
        if (turn == true)
            System.out.println("(" + characterOne.getName() + "'s Turn)");
        else if (turn == false)
            System.out.println("(" + characterTwo.getName() + "'s Turn)");
    }

    /**
     * Displays the characters' current HP and EP.
     */
    public void displayStatus() {
        System.out.println(characterOne.getName() + " (HP: " + characterOne.getHealth() + "/100, EP: " + characterOne.getEnergy() + "/50)");
        System.out.println(characterTwo.getName() + " (HP: " + characterTwo.getHealth() + "/100, EP: " + characterTwo.getEnergy() + "/50)");
    }

    /**
     * Displays the ability that each character executed, and how it affected
     * themselves or the opponent.
     * 
     * @param moveOne  the move that the first character excuted.
     * @param moveTwo  the move that the second character excuted.
     * @param oneEvade the flag if the first character used the smoke bomb ability was able
     *                 to evade the opponent's attack.
     * @param twoEvade the flag if the second character used the smoke bomb ability was able
     *                 to evade the opponent's attack.
     */
    private void displayRoundOutcome(Ability moveOne, Ability moveTwo, boolean oneEvade, boolean twoEvade) {
        Menu menu = new Menu();

        if (moveOne.checkIfReflexive())
            System.out.println("(&) " + characterOne.getName() + " Used " + moveOne.getName() + " On Themselves!");
        else
            System.out.println("(&) " + characterOne.getName() + " Used " + moveOne.getName() + "!");
        
        if (moveTwo.checkIfOffensive()) {
            menu.pauseScreen(1);

            if (moveOne.getName().equals(AbilityName.SMOKE_BOMB.toString())) {
                if (oneEvade) {
                    System.out.println(" >  " + characterOne.getName() + " Was Able To Evade " + characterTwo.getName() + "'s Attack!");
                } else if (!oneEvade) {
                    System.out.println(" >  " + characterOne.getName() + " Was Not Able To Evade " + characterTwo.getName() + "'s Attack!");
                    menu.pauseScreen(1);
                    System.out.println(" >  " + characterOne.getName() + " Lost " + moveTwo.getHpEffect() + " HP!");
                }
            } else if (moveOne.getName().equals(AbilityName.DEFEND.toString())) {
                System.out.println(" >  " + characterOne.getName() + " Lost " + (int) (Math.floor(moveTwo.getHpEffect()) / 2) + " HP!");
            } else if (!moveOne.checkIfDefensive()) {
                System.out.println(" >  " + characterOne.getName() + " Lost " + moveTwo.getHpEffect() + " HP!");
            }
        }
        
        if (moveOne.checkIfReflexive()) {
            menu.pauseScreen(1);

            if (moveOne.getHpEffect() > 0)
                System.out.println(" >  " + characterOne.getName() + " Regained " + moveOne.getHpEffect() + " HP!");
            else if (moveOne.getEpEffect() > 0)
                System.out.println(" >  " + characterOne.getName() + " Regained " + moveOne.getEpEffect() + " EP!");
        }

        menu.pauseScreen(1);
        if (moveTwo.checkIfReflexive())
            System.out.println("(&) " + characterTwo.getName() + " Used " + moveTwo.getName() + " On Themselves!");
        else
            System.out.println("(&) " + characterTwo.getName() + " Used " + moveTwo.getName() + "!");
        
        if (moveOne.checkIfOffensive()) {
            menu.pauseScreen(1);

            if (moveTwo.getName().equals(AbilityName.SMOKE_BOMB.toString())) {
                if (twoEvade) {
                    System.out.println(" >  " + characterTwo.getName() + " Was Able To Evade " + characterOne.getName() + "'s Attack!");
                } else if (!twoEvade) {
                    System.out.println(" >  " + characterTwo.getName() + " Was Not Able To Evade " + characterOne.getName() + "'s Attack!");
                    menu.pauseScreen(1);
                    System.out.println(" >  " + characterTwo.getName() + " Lost " + moveOne.getHpEffect() + " HP!");
                }
            } else if (moveTwo.getName().equals(AbilityName.DEFEND.toString())) {
                System.out.println(" >  " + characterTwo.getName() + " Lost " + (int) (Math.floor(moveOne.getHpEffect()) / 2) + " HP!");
            } else if (!moveTwo.checkIfDefensive()) {
                System.out.println(" >  " + characterTwo.getName() + " Lost " + moveOne.getHpEffect() + " HP!");
            }
        }
        
        if (moveTwo.checkIfReflexive()) {
            menu.pauseScreen(1);

            if (moveTwo.getHpEffect() > 0)
                System.out.println(" >  " + characterTwo.getName() + " Regained " + moveTwo.getHpEffect() + " HP!");
            else if (moveTwo.getEpEffect() > 0)
                System.out.println(" >  " + characterTwo.getName() + " Regained " + moveTwo.getEpEffect() + " EP!");
        }

        menu.pauseScreen(2);
        menu.clearScreen();
    }
}