/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.multigame.server.chess.entities;

import edu.upc.etsetb.arqsoft.multigame.server.entities.Cell;

/**
 *
 * @author estev
 */
public class ChessCell implements Cell {
    protected int row, col;
    protected ChessColour color;
    protected boolean isEmpty; // True for Empty and False for a piece in there
    protected ChessPiece piece;

    public ChessCell(int row, int col) {
        this.row = row;
        this.col = col;
        if (row%2==col%2){
            this.color = ChessColour.BLACK;
        }else{
            this.color = ChessColour.WHITE;
        }
        this.isEmpty=true;
    }
    
    public ChessCell(int row, int col, ChessPiece piece) {
        this.row = row;
        this.col = col;
        if (row%2==col%2){
            this.color = ChessColour.BLACK;
        }else{
            this.color = ChessColour.WHITE;
        }
        this.isEmpty=false;
        this.piece = piece;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setPiece(ChessPiece piece) {
        this.piece = piece;
        this.isEmpty = false;
    }

    public ChessColour getColor() {
        return color;
    }
    
}


