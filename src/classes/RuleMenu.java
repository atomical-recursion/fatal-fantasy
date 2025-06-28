package src.classes;
import src.enums.*;

/**
 * Displays the different sections of the game rules. It allows players to read
 * about how to win, the battle flow, character structure, class descriptions,
 * and ability types.
 *
 * <p> This menu enhances user understanding of the game mechanics and is accessible
 * through the main menu. </p>
 *
 * This class extends {@link Menu}, utilizing inherited display and input features.
 */
public class RuleMenu extends Menu {
    
    /**
     * Constructs a {@code RuleMenu} and initializes the menu options.
     */
    public RuleMenu() {
        optionAmount = 6;
        options.add("How To Win");
        options.add("Battle Flow");
        options.add("Characters");
        options.add("Classes");
        options.add("Abilities");
        options.add("Return to Main Menu");
    }

    /**
     * Displays the "How to Win" section and waits for the user to return.
     */
    private void howToWinTab() {
        do {
            System.out.println("{Rules}");
            System.out.println("(1) How To Win");

            System.out.println(" >  Get the other character to 0 HP after a round to win.\n" +
                               " -  A draw will happen when both of the characters reach 0 HP after a round.\n");

            System.out.println("[1] Return to the Rules Menu");
            System.out.print("Enter Choice: ");
            askChoice();

            if (!choice.equals("1")) {
                System.out.println("(!) INVALID INPUT!");
                pauseScreen(1);
                clearScreen();
            } else {
                clearScreen();
            }
        } while (!choice.equals("1"));
    }

    /**
     * Displays the "Battle Flow" section and waits for the user to return.
     */
    private void battleFlowTab() {
        do {
            System.out.println("{Rules}");
            System.out.println("(2) Battle Flow");

            System.out.println(" >  At the start of every round, each character regenerates 5 EP.\n" +
                               " >  Player 1's character is prompted on what ability they will do.\n" +
                               " -  It will check if the character has enough EP to execute the ability.\n" +
                               " >  Player 2's character will be prompted the same.\n" +
                               " >  The abilities will be applied in the order of defensive, offensive, then reflexive abilities.\n" +
                               " -  At the end of each round, it will detail what ability each character did and its effects.\n");

            System.out.println("[1] Return to Rules Menu");
            System.out.print("Enter Choice: ");
            askChoice();

            if (!choice.equals("1")) {
                System.out.println("(!) INVALID INPUT!");
                pauseScreen(1);
                clearScreen();
            } else {
                clearScreen();
            }
        } while (!choice.equals("1"));
    }


    /**
     * Displays the "Characters" section and waits for the user to return.
     */
    private void charactersTab() {
        do {
            System.out.println("{Rules}");
            System.out.println("(3) Characters");

            System.out.println(" >  Each player can have at most 6 characters of varying classes and with varying abilites.\n" +
                               " -  Characters can only be named once to make sure that their names are unique.\n" +
                               " -  Characters can have at most 3 chosen abilites from their chosen class, with an additional 2 abilites that are common to all characters.\n" +
                               " >  Characters have a maximum of 50 Energy Points (EP) and 100 Health Points (HP).\n" +
                               " -  EP enables a character to execute an ability, whereas HP enables a character to keep battling.\n");

            System.out.println("[1] Return to Rules Menu");
            System.out.print("Enter Choice: ");
            askChoice();

            if (!choice.equals("1")) {
                System.out.println("(!) INVALID INPUT!");
                pauseScreen(1);
                clearScreen();
            } else {
                clearScreen();
            }
        } while (!choice.equals("1"));
    }


    /**
     * Displays the "Classes" section and waits for the user to return.
     */
    private void classesTab() {
        do {
            System.out.println("{Rules}");
            System.out.println("(4) Classes");

            System.out.println(" >  Mage Class\n" +
                               " -  " + ClassDescription.MAGE.toString() + "\n" +
                               " >  Rouge Class\n" +
                               " -  " + ClassDescription.ROGUE.toString() + "\n" +
                               " >  Warrior Class\n" +
                               " -  " + ClassDescription.WARRIOR.toString() + "\n");

            System.out.println("[1] Return to Rules Menu");
            System.out.print("Enter Choice: ");
            askChoice();

            if (!choice.equals("1")) {
                System.out.println("(!) INVALID INPUT!");
                pauseScreen(1);
                clearScreen();
            } else {
                clearScreen();
            }
        } while (!choice.equals("1"));
    }

    /**
     * Displays the "Abilities" section and waits for the user to return.
     */
    private void abilitesTab() {
        do {
            System.out.println("{Rules}");
            System.out.println("(5) Abilities");

            System.out.println(" >  Defensive Abilites\n" +
                               " -  Arcane Shield (Mage)\n" +
                               " -  Smoke Bomb (Rogue)\n" +
                               " -  Sneak Attack (Rogue)\n" +
                               " -  Ironclad Defense (Warrior)\n" +
                               " -  Defend\n" +
                               " >  Offensive Abilites\n" +
                               " -  Arcane Bolt (Mage)\n" +
                               " -  Arcane Blast (Mage)\n" +
                               " -  Shiv (Rogue)\n" +
                               " -  Backstab (Rogue)\n" +
                               " -  Sneak Attack (Rogue)\n" +
                               " -  Cleave (Warrior)\n" +
                               " -  Shield Bash (Warrior)\n" +
                               " >  Reflexive Abilities\n" +
                               " -  Mana Channel (Mage)\n" +
                               " -  Lesser Heal (Mage)\n" +
                               " -  Focus (Rogue)\n" +
                               " -  Bloodlust (Warrior)\n" +
                               " -  Rallying Cry (Warrior)\n" +
                               " -  Recharge\n");

            System.out.println("[1] Return to Rules Menu");
            System.out.print("Enter Choice: ");
            askChoice();

            if (!choice.equals("1")) {
                System.out.println("(!) INVALID INPUT!");
                pauseScreen(1);
                clearScreen();
            } else {
                clearScreen();
            }
        } while (!choice.equals("1"));
    }

    /**
     * Displays the rule menu and navigates to the selected rule tab.
     */
    @Override public void display() {
        int i;

        do {
            System.out.println("{Rules}");

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
                clearScreen();
                howToWinTab();
            } else if (choice.equals("2")) {
                clearScreen();
                battleFlowTab();
            } else if (choice.equals("3")) {
                clearScreen();
                charactersTab();
            } else if (choice.equals("4")) {
                clearScreen();
                classesTab();
            } else if (choice.equals("5")) {
                clearScreen();
                abilitesTab();
            } else {
                clearScreen();
            }
        } while (!choice.equals("6"));
    }

}
