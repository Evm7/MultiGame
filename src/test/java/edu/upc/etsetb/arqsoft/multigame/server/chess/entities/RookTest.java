/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.multigame.server.chess.entities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author estev
 */
public class RookTest {

    private ChessPiece instance;

    public RookTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("[INFO] ...start of the tests for class Rook.");

    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("[INFO] ...end of the tests for class Rook.");

    }

    @Before
    public void setUp() {
        this.instance = new Rook(0, ChessColour.BLACK);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isPieceMovement method, of class Rook.
     */
    @Test
    public void testIsPieceMovement() throws Exception {
        System.out.println("isPieceMovement");
        int ro = 0;
        int co = 0;
        int rd = 1;
        int cd = 0;
        instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementr2c0OK() throws Exception {
        System.out.println("testIsPieceMovementr2c0OK");
        int ro = 8;
        int co = 3;
        int rd = ro + 2;
        int cd = co;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementrm2c0OK() throws Exception {
        System.out.println("testIsPieceMovementrm2c0OK");
        int ro = 8;
        int co = 3;
        int rd = ro - 2;
        int cd = co;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementr0c2OK() throws Exception {
        System.out.println("testIsPieceMovementr0c2OK");
        int ro = 8;
        int co = 3;
        int rd = ro;
        int cd = co + 2;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementr0cm2OK() throws Exception {
        System.out.println("testIsPieceMovementr0cm2OK");
        int ro = 8;
        int co = 3;
        int rd = ro;
        int cd = co - 2;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test(expected = NoPieceMovementException.class)
    public void testIsPieceMovementr2c1KO() throws Exception {
        System.out.println("testIsPieceMovementr2c1KO");
        int ro = 8;
        int co = 3;
        int rd = ro + 2;
        int cd = co + 1;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }
    
    @org.junit.Test(expected = NoPieceMovementException.class)
    public void testIsPieceMovementr2c2KO() throws Exception {
        System.out.println("testIsPieceMovementr2c2KO");
        int ro = 8;
        int co = 3;
        int rd = ro + 2;
        int cd = co + 2;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }
    /**
     * Test of isPathFree method, of class Rook.
     */
    @Test
    public void testIsPathFree() throws Exception {
        System.out.println("isPathFree");
        int ro = 0;
        int co = 0;
        int rd = 0;
        int cd = 0;
        ChessBoard board = null;
        Rook instance = null;
        instance.isPathFree(ro, co, rd, cd, board);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
