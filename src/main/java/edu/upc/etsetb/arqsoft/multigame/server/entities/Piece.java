/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.multigame.server.entities;

import edu.upc.etsetb.arqsoft.multigame.server.chess.entities.NoPieceMovementException;
import edu.upc.etsetb.arqsoft.multigame.server.chess.entities.NoPathFreeException;
import edu.upc.etsetb.arqsoft.multigame.server.chess.entities.ChessBoard;

/**
 *
 * @author estev
 */
public interface Piece {
 
    public void isPieceMovement(int ro, int co, int rd, int cd) throws NoPieceMovementException;
    
    public void isPathFree(int ro, int co, int rd, int cd, ChessBoard board) throws NoPathFreeException;

}
