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
public class King extends ChessPiece {

    private boolean hasMoved;

    public King(ChessColour colour) {
        this.color = colour;
        this.isAlive = Boolean.TRUE;
        this.col = 5;
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

        if ((dist_ro>1 || dist_col >1) && (this.hasMoved)) {
            throw new NoPieceMovementException("King can move more than one cell");
        }

        // CHECK ENROCKE 
        if ((!this.hasMoved) && !((dist_ro == 0) && ((dist_col == 3) || (dist_col == 4) || (dist_col == 1))) && !((dist_ro == 1 || dist_col<2)))  {
            throw new NoPieceMovementException("Rook has to move linearly, without diagonals");
        }
    }

    @Override
    public void isPathFree(int ro, int co, int rd, int cd, ChessBoard board) throws NoPathFreeException {
        int dist_ro = Math.abs(rd - ro);
        int dist_col = Math.abs(cd - co);
        if ((dist_ro * dist_col != 1) && (this.hasMoved)) {
            if (!board.canMoveTo(cd, rd, this.color)) {
                throw new NoPathFreeException("Movement is not allowed as there is a piece in [" + rd + "," + cd + "]");
            }
        }

        // CHECK ENROCKE 
        if (!((!this.hasMoved) && ((dist_col == 3) || (dist_col == 4)))) {
            for (int i = Math.min(co, cd); i < Math.max(co, cd); i++) {
                if ((i != co) && (i != cd) && (!board.isEmpty(cd, rd))) {
                    throw new NoPathFreeException("Movement is not allowed as there is a piece in [" + ro + "," + i + "]");
                }
            }
        }
    }
}
