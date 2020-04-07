/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Board;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author essip
 */
public class Connect4Test {

    Board board;

    public Connect4Test() {
        board = new Board();
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
}
