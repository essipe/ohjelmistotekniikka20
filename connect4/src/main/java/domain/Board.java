/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author essip Class is in charge of the logic of the game board
 */
public class Board {

    int cols;
    int rows;
    int[][] board;
    int turn;
    boolean win;

    public Board() {
        cols = 7;
        rows = 6;
        board = new int[cols + 1][rows + 1];
        turn = 1;
        win = false;
    }

    /**
     * Method puts a disk where player has dropped it. After dropping it checks
     * if drop resulted to winning.
     *
     * @param col The column which the disk was dropped into
     * @return The row where the disk landed
     */
    public int drop(int col) {
        int row = 0;
        for (int i = 6; i > 0; i--) {
            if (board[col][i] == 0) {
                board[col][i] = turn;
                row = i;
                System.out.println("Dropped disk in " + col + ", " + row);
                break;
            } else if (board[col][1] != 0) {
                System.out.println("Full!");
                break;
            }
        }
        checkWin(col, row);
        changeTurn();
        return row;
    }

    /**
     * Ghanges player in turn
     */
    public void changeTurn() {
        if (turn == 1) {
            turn = 2;
        } else if (turn == 2) {
            turn = 1;
        }
    }

    /**
     * Checks if there's any wins using seperate methods for every direction
     *
     * @param col The column the disk has dropped into
     * @param row The row the disk has dropped into
     * @return
     */
    public boolean checkWin(int col, int row) {
        checkHorizontal(col, row);
        checkVertical(col, row);
        checkDiagonalDown(col, row);
        checkDiagonalUp(col, row);
        return win;
    }

    /**
     * Method that checks if the player has gotten a horizontal line of four
     * disks and won
     *
     * @param col The column the disk has dropped into
     * @param row The row the disk has dropped into
     */
    public void checkHorizontal(int col, int row) {
        int adjacent = 0;
        for (int i = 0; i < cols; i++) {
            if (board[col - Math.min(3, col - 1) + i][row] == turn) {
                adjacent++;
            } else {
                adjacent = 0;
            }
            if (adjacent == 4) {
                System.out.println("You won!");
                win = true;
                break;
            }
            if (col - Math.min(3, col - 1) + i == cols) {
                break;
            }
        }
    }

    /**
     * Method that checks if the player has gotten a vertical line of four disks
     * and won
     *
     * @param col The column the disk has dropped into
     * @param row The row the disk has dropped into
     */
    public void checkVertical(int col, int row) {
        int adjacent = 0;
        for (int i = 0; i < rows; i++) {
            if (board[col][row - Math.min(3, row - 1) + i] == turn) {
                adjacent++;
            } else {
                adjacent = 0;
            }
            if (adjacent == 4) {
                System.out.println("You won!");
                win = true;
                break;
            }
            if (row - Math.min(3, row - 1) + i == rows) {
                break;
            }
        }
    }

    /**
     * Method that checks if the player has gotten a diagonal line going down of
     * four disks and won
     *
     * @param col The column the disk has dropped into
     * @param row The row the disk has dropped into
     */
    public void checkDiagonalDown(int col, int row) {
        int adjacent1 = 0;
        int startCheckingFrom1 = Math.min(col, row) - 1;
        for (int i = 0; i < 6; i++) {
            if (board[col - startCheckingFrom1 + i][row - startCheckingFrom1 + i] == turn) {
                adjacent1++;
            } else {
                adjacent1 = 0;
            }
            if (adjacent1 == 4) {
                System.out.println("You won!");
                win = true;
                break;
            }
            if (row - startCheckingFrom1 + i == rows || col - startCheckingFrom1 + i == cols) {
                break;
            }
        }
    }

    /**
     * Method that checks if the player has gotten a diagonal line going up of
     * four disks and won
     *
     * @param col The column the disk has dropped into
     * @param row The row the disk has dropped into
     */
    public void checkDiagonalUp(int col, int row) {
        int adjacent2 = 0;
        int startCheckingFrom2 = Math.min(col, 7 - row) - 1;
        for (int i = 0; i < 6; i++) {
            if (board[col - startCheckingFrom2 + i][row + startCheckingFrom2 - i] == turn) {
                adjacent2++;
            } else {
                adjacent2 = 0;
            }
            if (adjacent2 == 4) {
                System.out.println("You won!");
                win = true;
                break;
            }
            if (col - startCheckingFrom2 + i == cols || row + startCheckingFrom2 - i == 1) {
                break;
            }
        }
    }

    public int getValue(int col, int row) {
        return board[col][row];
    }

    public int getTurn() {
        return turn;
    }

    public boolean isWin() {
        return win;
    }

}
