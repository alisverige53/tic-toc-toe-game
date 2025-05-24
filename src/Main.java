package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] _unused) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Player 1 name: ");
        Player player1 = new Player(scanner.nextLine(), "X");
        System.out.print("Enter Player 2 name: ");
        Player player2 = new Player(scanner.nextLine(), "O");

        boolean playAgain = true;

        while (playAgain) {
            Board board = new Board();
            Player currentPlayer = Player.chooseStartingPlayer(player1, player2);
            System.out.println(currentPlayer.getName() + " starts first!");

            boolean gameFinished = false;

            while (!gameFinished) {
                board.printBoard();
                System.out.println(currentPlayer.getName() + " (" + currentPlayer.getMarker() + "), it's your turn!");
                System.out.print("Enter position (1-9): ");
                String move = scanner.nextLine();

                if (!board.makeMove(move, currentPlayer.getMarker())) {
                    continue;
                }

                if (board.checkWin(currentPlayer.getMarker())) {
                    board.printBoard();
                    System.out.println(currentPlayer.getName() + " wins!");
                    gameFinished = true;
                } else if (board.isDraw()) {
                    board.printBoard();
                    System.out.println("It's a draw!");
                    gameFinished = true;
                } else {
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (!answer.equals("yes") && !answer.equals("y")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing!");
    }
}
