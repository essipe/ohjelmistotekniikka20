/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.StatsDao;
import domain.Board;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author essip
 */
public class Connect4Test {

    Board board;
    StatsDao SD;

    public Connect4Test() {
        board = new Board(7, 6);
        SD = new StatsDao("testwins.txt");
    }

    @Test
    public void emptyBoardDropTest() {
        board.drop(3);
        assertEquals(board.getValue(3, 6), 1);
    }

    @Test
    public void dropTest1() {
        board.drop(3);
        board.drop(3);
        assertEquals(board.getValue(3, 5), 2);
    }

    @Test
    public void fullColumnDoesNotDrop() {
        board.drop(3);
        board.drop(3);
        board.drop(3);
        board.drop(3);
        board.drop(3);
        board.drop(3);
        board.drop(3);
        assertEquals(board.getValue(3, 0), 0);
    }

    @Test
    public void turnChanges() {
        board.drop(2);
        assertEquals(board.getTurn(), 2);
        board.drop(2);
        assertEquals(board.getTurn(), 1);
    }

    @Test
    public void dropTest2() {
        board.drop(2);
        assertEquals(board.getValue(2, 6), 1);
        board.drop(2);
        assertEquals(board.getValue(2, 5), 2);
    }

    @Test
    public void winTestHorizontal() {
        board.drop(1);
        board.drop(1);
        board.drop(2);
        board.drop(2);
        board.drop(3);
        board.drop(3);
        board.drop(4);
        assertEquals(board.getWin(), true);
        assertEquals(board.getWinner(), 1);
    }

    @Test
    public void winTestVertical() {
        board.drop(2);
        board.drop(3);
        board.drop(2);
        board.drop(3);
        board.drop(2);
        board.drop(3);
        board.drop(2);
        assertEquals(board.getWin(), true);
    }

    @Test
    public void winTestDiagonalDown() {
        board.drop(6);
        board.drop(5);
        board.drop(5);
        board.drop(4);
        board.drop(4);
        board.drop(3);
        board.drop(4);
        board.drop(3);
        board.drop(3);
        board.drop(1);
        board.drop(3);
        assertEquals(board.getWin(), true);
    }

    @Test
    public void winTestDiagonalUp() {
        board.drop(1);
        board.drop(2);
        board.drop(2);
        board.drop(3);
        board.drop(4);
        board.drop(3);
        board.drop(3);
        board.drop(4);
        board.drop(4);
        board.drop(5);
        board.drop(4);
        assertEquals(board.getWin(), true);
    }

    @Test
    public void boardFullTest() {
        Board smallerBoard = new Board(6, 5);
        smallerBoard.drop(1);
        smallerBoard.drop(1);
        smallerBoard.drop(1);
        smallerBoard.drop(1);
        smallerBoard.drop(1);
        smallerBoard.drop(2);
        smallerBoard.drop(2);
        smallerBoard.drop(2);
        smallerBoard.drop(2);
        smallerBoard.drop(2);
        smallerBoard.drop(3);
        smallerBoard.drop(3);
        smallerBoard.drop(3);
        smallerBoard.drop(3);
        smallerBoard.drop(3);
        smallerBoard.drop(5);
        smallerBoard.drop(4);
        smallerBoard.drop(4);
        smallerBoard.drop(4);
        smallerBoard.drop(4);
        smallerBoard.drop(4);
        smallerBoard.drop(6);
        smallerBoard.drop(6);
        smallerBoard.drop(6);
        smallerBoard.drop(6);
        smallerBoard.drop(6);
        smallerBoard.drop(5);
        smallerBoard.drop(5);
        smallerBoard.drop(5);
        smallerBoard.drop(5);
        assertEquals(smallerBoard.getBoardFull(), true);
    }

    @Test
    public void textFileTest() {
        String winner = SD.getLastWinner();
        assertEquals(winner, "essi");
    }

    @Test
    public void textFileTest2() throws Exception {
        SD.writeWinner("someoneelse");
        assertEquals(SD.getLastWinner(), "someoneelse");
        SD.writeWinner("essi");
    }
}
