package poker_solitaire;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import poker_solitaire.ps.PsLogic;
import poker_solitaire.cardutils.Pile;
import poker_solitaire.cardutils.Card;

public class PsUserInterface {
    private Scanner scanner;
    private PsLogic game;

    public PsUserInterface() {
        scanner = new Scanner(System.in);
        game = new PsLogic();
    }

    public void run() {
        String input;
        char command;
        do {
            printMenu();
            input = scanner.nextLine();
            command = input.toUpperCase().charAt(0);
            switch (command) {
                case 'N':
                    newGame();
                case 'X':
                    System.out.println("Bye Bye !!!");
                    break; 
                default: 
                    System.out.println("Unknown command.");
            }
        } while (command != 'X');
    }
    public void newGame() {
        String input;
        int pileIndex;
        System.out.println("Initializing a new game...");
        game.initNewGame();
        System.out.println("Ready");

        while(!game.isGameOver()) {
            printGamePanel();
            System.out.println("Next card: " + game.pickNextCard().toShortString());
            do {
                System.out.println("Select a pile, index[0...4]: ");
                input = scanner.nextLine();
                if (input.toUpperCase().charAt(0) == 'X')   return;

                pileIndex = Integer.parseInt(input);
            } while(pileIndex >= 5);
            game.addCardToPile(pileIndex);
        }
        System.out.println("Game is over!");
        System.out.println("You got " + game.getPoints() + " points.");
    }
    public void printMenu() {
        System.out.print("\n------MENU-----\n\n" + 
                         "N to start a new game\n\n" + 
                         "X to EXIT\n\n" + 
                         "----------------\n\n");
    }
    public void printGamePanel() {
        List<Pile> copy = game.getPiles();
        System.out.println();
        for(Pile p : copy) {
            System.out.println(p.toString());
        }
        System.out.println();
    }   

}