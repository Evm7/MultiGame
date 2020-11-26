/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.multigame.server.chess.entities;

import junit.framework.Assert;
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
public class BishopTest {

    private ChessPiece instance;

    public BishopTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("[INFO] ...start of the tests for class Bishop.");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("[INFO] ...end of the tests for class Bishop.");
    }

    @Before
    public void setUp() {
        this.instance = new Bishop(0, ChessColour.BLACK);

    }

    @After
    public void tearDown() {

    }

    /**
     * Test of isPieceMovement method, of class Bishop.
     */
    @org.junit.Test
    public void testIsPieceMovement() throws Exception {
        System.out.println("isPieceMovement");
        int ro = 8;
        int co = 3;
        int rd = 3;
        int cd = 8;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementr2c2OK() throws Exception {
        System.out.println("testIsPieceMovementr2c2OK");
        int ro = 8;
        int co = 3;
        int rd = ro + 2;
        int cd = co + 2;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementrm2cm2OK() throws Exception {
        System.out.println("testIsPieceMovementrm2cm2OK");
        int ro = 8;
        int co = 3;
        int rd = ro - 2;
        int cd = co - 2;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementrm2c2OK() throws Exception {
        System.out.println("testIsPieceMovementrm2c2OK");
        int ro = 8;
        int co = 3;
        int rd = ro - 2;
        int cd = co + 2;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementr2cm2OK() throws Exception {
        System.out.println("testIsPieceMovementr2cm2OK");
        int ro = 8;
        int co = 3;
        int rd = ro + 2;
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

    @Test
    public void testConstructorAndGetColorOK() throws Exception {
        System.out.println("[INFO[ ...Testing constructor and getColor(): OK");
        Assert.assertEquals(ChessColour.BLACK, this.instance.getColor());
    }

    /**
     * Test of isPathFree method, of class Bishop.
     */
    @org.junit.Test
    public void testIsPathFree() throws Exception {
        System.out.println("isPathFree");
        int ro = 0;
        int co = 0;
        int rd = 0;
        int cd = 0;
        ChessBoard board = null;
        Bishop instance = null;
        instance.isPathFree(ro, co, rd, cd, board);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
