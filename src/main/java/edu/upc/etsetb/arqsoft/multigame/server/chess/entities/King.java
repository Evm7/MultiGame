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
        
        if ((dist_ro*dist_col !=1) && (this.hasMoved)){
            throw new NoPieceMovementException("King can move more than one cell");
        }
        
        // CHECK ENROCKE FALTA ACABARRRRRR
        if (((dist_ro != 0) && (dist_col != 0)) || ((dist_ro == 0) && (dist_col == 0))) {
                if (this.hasMoved) {
                    //
                }
            }
{
            throw new NoPieceMovementException("Rook has to move linearly, without diagonals");
        }
    }

    @Override
    public void isPathFree(int ro, int co, int rd, int cd, ChessBoard board) throws NoPathFreeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
