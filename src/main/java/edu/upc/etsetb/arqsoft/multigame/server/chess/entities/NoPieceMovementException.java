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
public class NoPieceMovementException extends Exception {

    public NoPieceMovementException(String string) {
        super(string);
    }
    
    public Exception NoPieceMovementException(String pawn_can_not_move_more_than_2_cells) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
