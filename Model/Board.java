package TikTakToe.Model;

import java.util.*;

public class Board {
    public int size;
    public String[][] board;

    public Board (int size) {
        this.size = size;
        board = new String[size][size];
    }

    public boolean addPiece (int row, int column, String playingPiece) {
        if (board[row][column] != null) {
            return false;
        }
        board[row][column] = playingPiece;
        return true;
    }

    public List<Pair<Integer, Integer>> getFreeCells() {
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();

        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (board[i][j] == null) {
                    Pair<Integer, Integer> rowColumn = new Pair<>(i, j);
                    freeCells.add(rowColumn);
                }
            }
        }

        return freeCells;
    }

    public void printBoard () {
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j] + " ");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
