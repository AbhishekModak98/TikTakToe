package TikTakToe;

import java.util.*;

import TikTakToe.Model.Board;
import TikTakToe.Model.Pair;
import TikTakToe.Model.PieceType;
import TikTakToe.Model.Player;
import TikTakToe.Model.PlayingPiece2;
import TikTakToe.Model.PlayingPiece1;

public class TikTakToeGame {
    Deque<Player> players;
    Board gameBoard;

    public void initializeGame(int boardSize, String name1, String piece1, String name2, String piece2) {
        // Creating 2 players
        players = new LinkedList<>();

        PlayingPiece1 playPiece1 = new PlayingPiece1(piece1);
        Player player1 = new Player(name1, playPiece1);

        PlayingPiece2 playPiece2 = new PlayingPiece2(piece2);
        Player player2 = new Player(name2, playPiece2);

        players.add(player1);
        players.add(player2);

        // Initialize Board
        gameBoard = new Board(boardSize);
    }

    @SuppressWarnings("resource")
    public String startGame() {
        boolean noWinner = true;

        while (noWinner) {
            // take out the player whose turn is and also put the player in the list back
            Player playerTurn = players.removeFirst();

            // get the free space from the board
            gameBoard.printBoard();
            List<Pair<Integer, Integer>> freeSpaces = gameBoard.getFreeCells();
            if (freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            // read the user input
            System.out.println(playerTurn.name + "(" + playerTurn.playingPiece + "): " + "Enter row, column: ");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            // place the piece
            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow, inputColumn, playerTurn.playingPiece);
            if (!pieceAddedSuccessfully) {
                // player cannot insert the piece into this cell, player has to choose another cell
                System.out.println("Invalid position choosen, choose again");
                players.addFirst(playerTurn);
                continue;
            }
            players.add(playerTurn);

            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.playingPiece);
            // sc.close();
            if (winner) {
                gameBoard.printBoard();
                return playerTurn.name;
            }
        }

        return "It's a tie";
    }

    public boolean isThereWinner (int row, int column, String pieceType) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // need to check in row
        for (int i=0; i<gameBoard.size; i++) {
            if (gameBoard.board[row][i] == null || gameBoard.board[row][i] != pieceType ) {
                rowMatch = false;
            }
        }

        // need to check in column
        for (int i=0; i<gameBoard.size; i++) {
            if (gameBoard.board[i][column] == null || gameBoard.board[i][column] != pieceType) {
                columnMatch = false;
            }
        }

        // need to check diagonals
        for (int i=0, j=0; i<gameBoard.size; i++, j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j] != pieceType) {
                diagonalMatch = false;
            }
        }

        // need to check anti diagonals
        for (int i=0, j=gameBoard.size-1; i<gameBoard.size; i++, j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j] != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
