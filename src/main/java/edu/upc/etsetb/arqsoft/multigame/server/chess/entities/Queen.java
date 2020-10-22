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
public class Queen extends ChessPiece {

    public Queen(ChessColour colour) {
        this.color = colour;
        this.isAlive = Boolean.TRUE;
        this.col = 4;
        if (this.color == ChessColour.WHITE) {
            this.row = 1;
        } else {
            this.row = 8;
        }
    }

    @Override
    public void isPieceMovement(int ro, int co, int rd, int cd) throws NoPieceMovementException {
        int dist_ro = Math.abs(rd - ro);
        int dist_col = Math.abs(cd - co);
        if ((dist_ro == 0) && (dist_col == 0)) {
            throw new NoPieceMovementException("Queen movement has to implie displacement");
        } else if ((dist_col != dist_ro) && (dist_ro != 0) || (dist_col != 0)) {
            throw new NoPieceMovementException("Queen movement has to implie linear displacement");
        }

    }

    @Override
    public void isPathFree(int ro, int co, int rd, int cd, ChessBoard board) throws NoPathFreeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
