package org.example;

import java.util.ArrayList;
import java.util.List;

public class ConwayGameOfLife {
    private static final int BOARD_SIZE = 200;

    public static void main(String[] args) {
    }

    public static List<List<int[]>> simulate(List<int[]> initialLiveCells) {
        boolean[][] board = new boolean[BOARD_SIZE][BOARD_SIZE];
        List<List<int[]>> states = new ArrayList<>();

        // Set initial live cells
        for (int[] cell : initialLiveCells) {
            board[cell[0]][cell[1]] = true;
        }

        // Simulate 100 iterations
        for (int iteration = 0; iteration < 100; iteration++) {
            List<int[]> liveCells = new ArrayList<>();
            boolean[][] nextBoard = new boolean[BOARD_SIZE][BOARD_SIZE];

            // Update each cell based on the rules
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    int liveNeighbors = countLiveNeighbors(board, i, j);
                    if (board[i][j]) {
                        if (liveNeighbors < 2 || liveNeighbors > 3) {
                            nextBoard[i][j] = false; // cell dies
                        } else {
                            nextBoard[i][j] = true; // cell lives
                            liveCells.add(new int[]{i, j});
                        }
                    } else {
                        if (liveNeighbors == 3) {
                            nextBoard[i][j] = true; // cell becomes alive
                            liveCells.add(new int[]{i, j});
                        }
                    }
                }
            }

            board = nextBoard;
            if (!liveCells.isEmpty()) {
                states.add(liveCells);
            }

        }
        return states;
    }
    private static int countLiveNeighbors(boolean[][] board, int x, int y) {
        int count = 0;
        int[][] neighbors = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int[] neighbor : neighbors) {
            int newX = x + neighbor[0];
            int newY = y + neighbor[1];
            if (newX >= 0 && newX < BOARD_SIZE && newY >= 0 && newY < BOARD_SIZE && board[newX][newY]) {
                count++;
            }
        }
        return count;
    }
}
