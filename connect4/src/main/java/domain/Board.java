/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author essip
 */
public class Board {

    int cols = 7;
    int rows = 6;
    int[][] board = new int[cols + 1][rows + 1];
    int turn = 1;
    boolean win = false;

    public Board() {
    }

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

    public void changeTurn() {
        if (turn == 1) {
            turn = 2;
        } else if (turn == 2) {
            turn = 1;
        }
    }

    public boolean checkWin(int col, int row) {
        checkHorizontal(col, row);
        checkVertical(col, row);
        //checkDiagonal(col, row);
        return win;
    }

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
    //doesn't work yet
    /*    public void checkDiagonal(int col, int row) {
    int adjacent1 = 0;
    int adjacent2 = 0;
    for (int i = 0; i < 6; i++) {
    if (board[col - Math.min(3, col - 1) + i][row - Math.min(3, row - 1) + i] == turn) {
    adjacent1++;
    } else {
    adjacent1 = 0;
    }
    if (adjacent1 == 4 || adjacent2 == 4) {
    System.out.println("You won!");
    win = true;
    break;
    }
    if (row - Math.min(3, row - 1) + i == rows) {
    break;
    }
    }
    }*/

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
