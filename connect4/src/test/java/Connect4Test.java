/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.BoardService;
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

    BoardService board;

    public Connect4Test() {
        board = new BoardService();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void emptyboarddroptest() {
        board.drop(3);
        assertEquals(board.getValue(3, 6), 1);
    }
    @Test
    public void droptest1() {
        board.drop(3);
        board.drop(3);
        assertEquals(board.getValue(3, 5), 1);
    }
    @Test
    public void fullcolumndoesnotdrop() {
        board.drop(3);
        board.drop(3);
        board.drop(3);
        board.drop(3);
        board.drop(3);
        board.drop(3);
        board.drop(3);
        assertEquals(board.getValue(3, 0), 0);
    }
}
