package src;
import src.classes.*;

public class Driver {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        Player playerOne = new Player(), playerTwo = new Player();

        SplashMenu splashMenu = new SplashMenu(playerOne, playerTwo);
        EndMenu endMenu;

        PlayerMenu playerMenu = new PlayerMenu();
        CharacterMenu characterMenu;
        DisplayMenu displayMenu;
        CreateMenu createMenu;
        EditMenu editMenu;
        DeleteMenu deleteMenu;

        RuleMenu ruleMenu = new RuleMenu();
        
        ConfirmMenu confirmMenu = new ConfirmMenu();
        String choiceMM, choiceEndM, choicePM, choiceCM, choiceConfirmM;
        String sentinel = null;
        boolean exit = false;
        
        while(!exit) {
            mainMenu.clearScreen();
            mainMenu.display();
            choiceMM = mainMenu.getChoice();

            if (choiceMM.equals("1")) {
                do {
                    splashMenu.display();

                    endMenu = new EndMenu(splashMenu.getCharacterOne(), splashMenu.getCharacterTwo());
                    endMenu.display();
                    choiceEndM = endMenu.getChoice();
                } while (!choiceEndM.equals("2"));

            } else if (choiceMM.equals("2")) {
                do {
                    playerMenu.display();
                    choicePM = playerMenu.getChoice();
                    
                    if (choicePM.equals("1")) {
                        do {
                            characterMenu = new CharacterMenu(playerOne, choicePM);
                            displayMenu = new DisplayMenu(playerOne);
                            createMenu = new CreateMenu(playerOne);
                            editMenu = new EditMenu(playerOne);
                            deleteMenu = new DeleteMenu(playerOne);

                            characterMenu.display();
                            choiceCM = characterMenu.getChoice();

                            if (playerOne.getCharacterAmount() == 0) {
                                sentinel = "2";

                                if (choiceCM.equals("1")) {
                                    createMenu.display();
                                }
                            } else if (playerOne.getCharacterAmount() == 6) {
                                sentinel = "4";

                                if (choiceCM.equals("1"))
                                    displayMenu.display();
                                else if (choiceCM.equals("2"))
                                    editMenu.display();
                                else if (choiceCM.equals("3"))
                                    deleteMenu.display();
                            } else {
                                sentinel = "5";

                                if (choiceCM.equals("1"))
                                    displayMenu.display();
                                else if (choiceCM.equals("2"))
                                    createMenu.display();
                                else if (choiceCM.equals("3"))
                                    editMenu.display();
                                else if (choiceCM.equals("4"))
                                    deleteMenu.display();
                            }
                        } while (!choiceCM.equals(sentinel));
                    } else if (choicePM.equals("2")) {
                        do {
                            characterMenu = new CharacterMenu(playerTwo, choicePM);
                            displayMenu = new DisplayMenu(playerTwo);
                            createMenu = new CreateMenu(playerTwo);
                            editMenu = new EditMenu(playerTwo);
                            deleteMenu = new DeleteMenu(playerTwo);

                            characterMenu.display();
                            choiceCM = characterMenu.getChoice();

                            if (playerTwo.getCharacterAmount() == 0) {
                                sentinel = "2";

                                if (choiceCM.equals("1")) {
                                    createMenu.display();
                                }
                            } else if (playerTwo.getCharacterAmount() == 6) {
                                sentinel = "4";

                                if (choiceCM.equals("1"))
                                    displayMenu.display();
                                else if (choiceCM.equals("2"))
                                    editMenu.display();
                                else if (choiceCM.equals("3"))
                                    deleteMenu.display();
                            } else {
                                sentinel = "5";

                                if (choiceCM.equals("1"))
                                    displayMenu.display();
                                else if (choiceCM.equals("2"))
                                    createMenu.display();
                                else if (choiceCM.equals("3"))
                                    editMenu.display();
                                else if (choiceCM.equals("4"))
                                    deleteMenu.display();
                            }
                        } while (!choiceCM.equals(sentinel));
                    }
                } while (!choicePM.equals("3"));
            } else if (choiceMM.equals("3")) {
                ruleMenu.display();
            } else if (choiceMM.equals("4")) {
                confirmMenu.exitDisplay();
                choiceConfirmM = confirmMenu.getChoice();

                if (choiceConfirmM.equals("1"))
                    exit = true;
            }
        }
    }
}