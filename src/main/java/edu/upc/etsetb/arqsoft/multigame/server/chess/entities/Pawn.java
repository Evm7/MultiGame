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
public class Pawn extends ChessPiece {

    private int id;  // To identify which number of pawn. Corresponds to original column

    public Pawn(int id, ChessColour colour) {
        this.id = id;
        this.color=colour;
        this.isAlive=Boolean.TRUE;
        this.col = id;
        if (this.color == ChessColour.WHITE) {
            this.row=2;
        }
        else{
            this.row=7;
        }
    }

    @Override
    public void isPieceMovement(int ro, int co, int rd, int cd) throws NoPieceMovementException {
        if ((this.color == ChessColour.WHITE) && (ro > rd)) {
            throw new NoPieceMovementException("Pawn can not move backwards");
        } else if ((this.color == ChessColour.BLACK) && (ro < rd)) {
            throw new NoPieceMovementException("Pawn can not move backwards");
        } else {
            int dist_ro = Math.abs(rd - ro);
            if (co != cd) {
                if (dist_ro != 1) {
                    throw new NoPieceMovementException("Pawn can not move more than 2 cells when killing");
                }
            }
            if (dist_ro > 2) {
                throw new NoPieceMovementException("Pawn can not move more than 2 cells");
            } else if (dist_ro == 2) {
                // If the Piece is White
                if ((this.color == ChessColour.WHITE) && (ro != 2)) {
                    // THe White piece can move two positions forward when located in the initial position
                    throw new NoPieceMovementException("Pawn can not move 2 cells if no placed in original position");
                } else if (this.color == ChessColour.BLACK && (ro != 7)) {
                    throw new NoPieceMovementException("Pawn can not move 2 cells if no placed in original position");
                }
            } else if (dist_ro < 1) {
                throw new NoPieceMovementException("Pawn can not move 0 rows");
            }
        }
    }

    @Override
    public void isPathFree(int ro, int co, int rd, int cd, ChessBoard board) throws NoPathFreeException {
        int dist_ro = Math.abs(rd - ro);
        int dist_col = Math.abs(cd - co);
        if(!board.canMoveTo(cd, rd, this.color)){
                throw new  NoPathFreeException("Movement is not allowed as there is a piece in [" + rd + "," + cd + "]");
        }
        int sign_col = (int) Math.signum(cd-co);
            // Not attacking, then can move 1 or two positions forward
        if(dist_col==2 && !board.isEmpty(ro, co+sign_col)){
            throw new  NoPathFreeException("Movement is not allowed as there is a piece in [" + rd + "," + cd + "]");
        }
    }

}
