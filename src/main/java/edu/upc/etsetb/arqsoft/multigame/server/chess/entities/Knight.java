/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.multigame.server.chess.entities;

/**
 *
 * @author estev
 */
public class Knight extends ChessPiece {
    private int id;  // To identify which type of 

    public Knight(int id, ChessColour colour) {
        this.color = colour;
        this.isAlive = Boolean.TRUE;
        this.col = 5;
        if (this.color == ChessColour.WHITE) {
            this.row = 1;
        } else {
            this.row = 8;
        }
        if (this.id == 0) {
            this.col = 2;
        } else {
            this.col = 7;
        }
    }

    @Override
    public void isPieceMovement(int ro, int co, int rd, int cd) throws NoPieceMovementException {
        int dist_ro = Math.abs(rd - ro);
        int dist_col = Math.abs(cd - co);
        
        if (dist_ro*dist_col !=2){
            throw new NoPieceMovementException("Knight can just move as an L");
        }
    }

    @Override
    public void isPathFree(int ro, int co, int rd, int cd, ChessBoard board) throws NoPathFreeException {
        if (!board.canMoveTo(cd, rd, this.color)){
            throw new NoPathFreeException("Movement is not allowed as there is a piece in [" + rd + "," + cd + "]");
        }
    }
}