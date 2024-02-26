package TikTakToe;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        TikTakToeGame game = new TikTakToeGame();
        Scanner sc = new Scanner(System.in);

        System.out.println("What size board do you want?");
        int boardSize = sc.nextInt();
        
        System.out.println("Name your first player: ");
        String name1 = sc.next();
        System.out.println(name1 + ", enter your sign: ");
        String piece1 = sc.next();

        System.out.println("Name your second player: ");
        String name2 = sc.next();
        System.out.println(name2 + ", enter your sign: ");
        String piece2 = sc.next();
        
        game.initializeGame(boardSize, name1, piece1, name2, piece2);
        
        System.out.println("Game winner is: " + game.startGame());
        
        sc.close();
    }
}
