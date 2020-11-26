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
public class PawnTest {

    private ChessPiece instance;

    public PawnTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("[INFO] ...start of the tests for class Pawn.");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("[INFO] ...end of the tests for class Pawn.");
    }

    @Before
    public void setUp() {
        this.instance = new Pawn(0, ChessColour.BLACK);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isPieceMovement method, of class Pawn.
     */
    @Test
    public void testIsPieceMovement() throws Exception {
        System.out.println("isPieceMovement");
        int ro = 7;
        int co = 0;
        int rd = ro - 1;
        int cd = co;
        instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementrm2c0OK() throws Exception {
        System.out.println("testIsPieceMovementrm2c0OK");
        int ro = 7;
        int co = 0;
        int rd = ro - 2;
        int cd = co;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementrm1cOK() throws Exception {
        System.out.println("testIsPieceMovementrm1cOK");
        int ro = 7;
        int co = 0;
        int rd = ro - 1;
        int cd = co;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementrm1c1OK() throws Exception {
        System.out.println("testIsPieceMovementrm1c1OK");
        int ro = 7;
        int co = 0;
        int rd = ro - 1;
        int cd = co + 1;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementrm1cm1OK() throws Exception {
        System.out.println("testIsPieceMovementrm1cm1OK");
        int ro = 7;
        int co = 0;
        int rd = ro - 1;
        int cd = co - 1;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test(expected = NoPieceMovementException.class)
    public void testIsPieceMovementrm2c1KO() throws Exception {
        System.out.println("testIsPieceMovementrm2c1KO");
        int ro = 7;
        int co = 0;
        int rd = ro - 2;
        int cd = co + 1;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test(expected = NoPieceMovementException.class)
    public void testIsPieceMovementr1c0KO() throws Exception {
        System.out.println("testIsPieceMovementr1c0KO");
        int ro = 7;
        int co = 0;
        int rd = ro + 1;
        int cd = co;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test(expected = NoPieceMovementException.class)
    public void testIsPieceMovementrm3c0KO() throws Exception {
        System.out.println("testIsPieceMovementrm3c0KO");
        int ro = 7;
        int co = 0;
        int rd = ro - 3;
        int cd = co;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test(expected = NoPieceMovementException.class)
    public void testIsPieceMovementrm2c0_NotInitialKO() throws Exception {
        System.out.println("testIsPieceMovementrm2c0_NotInitialKO");
        int ro = 4;
        int co = 0;
        int rd = ro - 2;
        int cd = co;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @Test
    public void testConstructorAndGetColorOK() throws Exception {
        System.out.println("[INFO[ ...Testing constructor and getColor(): OK");
        Assert.assertEquals(ChessColour.BLACK, this.instance.getColor());
    }

    /**
     * Test of isPathFree method, of class Pawn.
     */
    @Test
    public void testIsPathFree() throws Exception {
        System.out.println("isPathFree");
        int ro = 0;
        int co = 0;
        int rd = 0;
        int cd = 0;
        ChessBoard board = null;
        Pawn instance = null;
        instance.isPathFree(ro, co, rd, cd, board);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
