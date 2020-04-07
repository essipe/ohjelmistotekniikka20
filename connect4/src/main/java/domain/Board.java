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

    int rows = 7;
    int columns = 6;
    int[][] board = new int[rows + 1][columns + 1];
    int turn = 1;

    public Board() {
    }

    public int drop(int row) {
        int col = 0;
        for (int i = 6; i > 0; i--) {
            if (board[row][i] == 0) {
                board[row][i] = turn;
                col = i;
                System.out.println("Dropped disk in " + row + ", " + col);
                break;
            } else if (board[row][1] != 0) {
                System.out.println("Full!");
                break;
            }
        }
        changeTurn();
        return col;
    }
    public void changeTurn() {
        if (turn == 1) {
            turn = 2;
        } else if (turn == 2) {
            turn = 1;
        }
    }
    public int getValue(int row, int column) {
        return board[row][column];
    }

    public int getTurn() {
        return turn;
    }
    
}
