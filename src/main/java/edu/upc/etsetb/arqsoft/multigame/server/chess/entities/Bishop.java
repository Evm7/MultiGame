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
public class Bishop extends ChessPiece {

    private int id;  // To identify which type of 

    public Bishop(int id, ChessColour colour) {
        this.id = id;
        this.color = colour;
        this.isAlive = Boolean.TRUE;
        if (this.color == ChessColour.WHITE) {
            this.row = 1;
        } else {
            this.row = 8;
        }
        if (this.id == 0) {
            this.col = 3;
        } else {
            this.col = 5;
        }
    }

    @Override
    public void isPieceMovement(int ro, int co, int rd, int cd) throws NoPieceMovementException {
        int dist_ro = Math.abs(rd - ro);
        int dist_col = Math.abs(cd - co);
        if ((dist_ro != dist_col) || ((dist_ro == 0) && (dist_col == 0))) {
            throw new NoPieceMovementException("Bishop has to move diagonally");
        }

    }

    @Override
    public void isPathFree(int ro, int co, int rd, int cd, ChessBoard board) throws NoPathFreeException {
        int dist_row = (int) Math.signum(ro - rd);
        int dist_col = (int) Math.signum(co - cd);
        for (int c = co; c != cd; c = c + dist_col) {
            for (int r = ro; r != rd; r = r + dist_row) {
                if ((c != co) && (r != ro) && (!board.isEmpty(c, r))) {
                    throw new NoPathFreeException("Movement is not allowed as there is a piece in [" + r + "," + c + "]");
                }
            }
        }
    }

}
