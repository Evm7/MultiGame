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
public class Rook extends ChessPiece {

    private int id;  // To identify which one of the two rock is
    private boolean hasMoved;

    public Rook(int id, ChessColour colour) {
        this.id = id;
        this.color = colour;
        this.isAlive = Boolean.TRUE;
        this.hasMoved = Boolean.FALSE;
        if (this.color == ChessColour.WHITE) {
            this.row = 1;
        } else {
            this.row = 8;
        }
        if (this.id == 0) {
            this.col = 1;
        } else {
            this.col = 8;
        }
    }

    @Override
    public void isPieceMovement(int ro, int co, int rd, int cd) throws NoPieceMovementException {
        int dist_ro = Math.abs(rd - ro);
        int dist_col = Math.abs(cd - co);
        if (((dist_ro != 0) && (dist_col != 0)) || ((dist_ro == 0) && (dist_col == 0))) {
            throw new NoPieceMovementException("Rook has to move linearly, without diagonals");
        }

    }

    @Override
    public void isPathFree(int ro, int co, int rd, int cd, ChessBoard board) throws NoPathFreeException {
        int dist_ro = Math.abs(rd - ro);
        int dist_col = Math.abs(cd - co);
        int i;
        if (dist_ro != 0) {
            // User is moving towards rows
            for (i = Math.min(ro, rd); i < Math.max(ro, rd); i++) {
                if ((i!=ro) && (!board.isEmpty(co, i))) {
                    throw new NoPathFreeException("Movement is not allowed as there is a piece in [" + i + "," + co + "]");
                }
            }
        } else {
            // User is moving towards columns
            for (i = Math.min(co, cd); i < Math.max(co, cd); i++) {
                if ((i!=co) && (!board.isEmpty(i, ro))){
                    throw new NoPathFreeException("Movement is not allowed as there is a piece in [" + ro + "," + i + "]");
                }
            }
        }
    }
}
