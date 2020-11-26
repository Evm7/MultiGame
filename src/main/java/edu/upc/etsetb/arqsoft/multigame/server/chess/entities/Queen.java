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
        } else if ((dist_col != dist_ro) && ((dist_ro != 0) && (dist_col != 0))) {
            throw new NoPieceMovementException("Queen movement has to implie linear displacement");
        }

    }

    @Override
    public void isPathFree(int ro, int co, int rd, int cd, ChessBoard board) throws NoPathFreeException {
        int dist_ro = Math.abs(rd - ro);
        int dist_col = Math.abs(cd - co);
        if ((dist_ro == 0) || (dist_col == 0)) {
            // Moving as a Rook
            int i;

            if (dist_ro != 0) {
                // User is moving towards rows
                for (i = Math.min(ro, rd); i < Math.max(ro, rd); i++) {
                    if ((i != ro) && (!board.isEmpty(co, i))) {
                        throw new NoPathFreeException("Movement is not allowed as there is a piece in [" + i + "," + co + "]");
                    }
                }
            } else {
                // User is moving towards columns
                for (i = Math.min(co, cd); i < Math.max(co, cd); i++) {
                    if ((i != co) && (!board.isEmpty(i, ro))) {
                        throw new NoPathFreeException("Movement is not allowed as there is a piece in [" + ro + "," + i + "]");
                    }
                }
            }
        } else {
            // Moving as a Bishop
            int sign_row = (int) Math.signum(ro - rd);
            int sign_col = (int) Math.signum(co - cd);
            for (int c = co; c != cd; c = c + sign_col) {
                for (int r = ro; r != rd; r = r + sign_row) {
                    if ((c != co) && (r != ro) && (!board.isEmpty(c, r))) {
                        throw new NoPathFreeException("Movement is not allowed as there is a piece in [" + r + "," + c + "]");
                    }
                }
            }
        }
    }
}
