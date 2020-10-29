/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.multigame.server.chess.entities;

import edu.upc.etsetb.arqsoft.multigame.server.entities.Piece;

/**
 *
 * @author estev
 */
public abstract class ChessPiece implements Piece {
    protected int row, col;
    protected ChessColour color;
    protected boolean isAlive; // True for Alive and False for Dead

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public ChessColour getColor() {
        return color;
    }
    
    @Override
    public abstract void isPieceMovement(int ro, int co, int rd, int cd) throws NoPieceMovementException;
    
    @Override
    public abstract void isPathFree(int ro, int co, int rd, int cd, ChessBoard board) throws NoPathFreeException;
    
    
}
