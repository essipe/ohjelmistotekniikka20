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
public class BoardService {
    int rows = 7;
    int columns = 6;
    int[][] board = new int[rows+1][columns+1];
    
    public BoardService() {
    }
    
    public int drop(int row) {
        int col = 0;
        for (int i = 6; i > 0; i--) {
            if (board[row][i] == 0) {
                board[row][i] = 1;
                col = i;
                System.out.println("Dropped disk in " + row + ", " + col);
                break;
            } else if (board[row][1] == 1) {
                System.out.println("Full!");
                break;
            }
        }
        return col;
    }
    public int getValue(int row, int column) {
        return board[row][column];
    }
}
