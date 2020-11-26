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
public class KingTest {

    private ChessPiece instance;

    public KingTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("[INFO] ...start of the tests for class King.");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("[INFO] ...end of the tests for class King.");
    }

    @Before
    public void setUp() {
        this.instance = new King(ChessColour.BLACK);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isPieceMovement method, of class King.
     */
    @Test
    public void testIsPieceMovement() throws Exception {
        System.out.println("isPieceMovement");
        int ro = 8;
        int co = 5;
        int rd = ro + 1;
        int cd = ro + 1;
        instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementr1c1OK() throws Exception {
        System.out.println("testIsPieceMovementr1c1OK");
        int ro = 8;
        int co = 5;
        int rd = ro + 1;
        int cd = co + 1;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementrm1cm1OK() throws Exception {
        System.out.println("testIsPieceMovementrm1cm1OK");
        int ro = 8;
        int co = 5;
        int rd = ro - 1;
        int cd = co - 1;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementrm1c1OK() throws Exception {
        System.out.println("testIsPieceMovementrm1c1OK");
        int ro = 8;
        int co = 5;
        int rd = ro - 1;
        int cd = co + 1;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementr1cm1OK() throws Exception {
        System.out.println("testIsPieceMovementr1cm1OK");
        int ro = 8;
        int co = 5;
        int rd = ro + 1;
        int cd = co - 1;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementr1c0OK() throws Exception {
        System.out.println("testIsPieceMovementr1c0OK");
        int ro = 8;
        int co = 5;
        int rd = ro + 1;
        int cd = co;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementrm1c0OK() throws Exception {
        System.out.println("testIsPieceMovementrm1c0OK");
        int ro = 4;
        int co = 5;
        int rd = ro - 1;
        int cd = co;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementr0c1OK() throws Exception {
        System.out.println("testIsPieceMovementr0c1OK");
        int ro = 8;
        int co = 5;
        int rd = ro;
        int cd = co + 1;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test
    public void testIsPieceMovementr0cm1OK() throws Exception {
        System.out.println("testIsPieceMovementr0cm1OK");
        int ro = 8;
        int co = 5;
        int rd = ro;
        int cd = co - 1;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    //CHECK ENROQUE
    @org.junit.Test
    public void testIsPieceMovementEnroquec3OK() throws Exception {
        System.out.println("testIsPieceMovementEnroquec3OK");
        int ro = 8;
        int co = 5;
        int rd = ro;
        int cd = co + 3;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    //CHECK ENROQUE
    @org.junit.Test
    public void testIsPieceMovementEnroquecm4OK() throws Exception {
        System.out.println("testIsPieceMovementEnroquecm4OK");
        int ro = 8;
        int co = 5;
        int rd = ro;
        int cd = co - 4;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test(expected = NoPieceMovementException.class)
    public void testIsPieceMovementr2c1KO() throws Exception {
        System.out.println("testIsPieceMovementr2c1KO");
        int ro = 8;
        int co = 5;
        int rd = ro + 2;
        int cd = co + 1;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @org.junit.Test(expected = NoPieceMovementException.class)
    public void testIsPieceMovementr3cm3KO() throws Exception {
        System.out.println("testIsPieceMovementr3cm3KO");
        int ro = 8;
        int co = 3;
        int rd = ro + 3;
        int cd = co - 3;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }
    
    @org.junit.Test(expected = NoPieceMovementException.class)
    public void testIsPieceMovementr0c2KO() throws Exception {
        System.out.println("testIsPieceMovementr0c2KO");
        int ro = 8;
        int co = 3;
        int rd = ro + 0;
        int cd = co +2;
        this.instance.isPieceMovement(ro, co, rd, cd);
    }

    @Test
    public void testConstructorAndGetColorOK() throws Exception {
        System.out.println("[INFO[ ...Testing constructor and getColor(): OK");
        Assert.assertEquals(ChessColour.BLACK, this.instance.getColor());
    }

    /**
     * Test of isPathFree method, of class King.
     */
    @Test
    public void testIsPathFree() throws Exception {
        System.out.println("isPathFree");
        int ro = 0;
        int co = 0;
        int rd = 0;
        int cd = 0;
        ChessBoard board = null;
        King instance = null;
        instance.isPathFree(ro, co, rd, cd, board);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
