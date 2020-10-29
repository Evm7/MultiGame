/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.multigame.server.chess.entities;

import edu.upc.etsetb.arqsoft.multigame.server.entities.Board;
import java.util.ArrayList;

/**
 *
 * @author estev
 */
public class ChessBoard implements Board {

    public static int BOARD_SIZE = 8;
    protected ChessCell[][] chessboard;
    protected ArrayList<ChessPiece> white_pieces;
    protected ArrayList<ChessPiece> black_pieces;

    public ChessBoard() {
        initializeBoard();
        this.white_pieces = new ArrayList<>();
        initializePieces(ChessColour.WHITE);
        this.black_pieces = new ArrayList<>();
        initializePieces(ChessColour.BLACK);
    }

    private void initializeBoard() {
        this.chessboard = new ChessCell[BOARD_SIZE - 1][BOARD_SIZE - 1];
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                this.chessboard[column][row] = new ChessCell(column, row);
            }
        }

    }

    private void initializePieces(ChessColour color) {
        // Initialize Pieces for Color player
        addPiece(new King(color));
        addPiece(new Queen(color));
        for(int i=0; i<2; i++){
            addPiece(new Knight(i, color));
            addPiece(new Rook(i, color));
            addPiece(new Bishop(i, color));
        }
        for(int i=0;i<BOARD_SIZE;i++){
            addPiece(new Pawn(i, color));
        }
    }
    
    private void addPiece(ChessPiece piece){
        if (piece.getColor()==ChessColour.WHITE){
            this.white_pieces.add(piece);
        }else{
            this.black_pieces.add(piece);
        }
        setPiece(piece);
    }
    
    public void setPiece(ChessPiece piece){
        (this.chessboard[piece.getCol()][piece.getRow()]).setPiece(piece);
    }
    
    public boolean isEmpty(int col, int row){
        return (this.chessboard[col][row]).isEmpty();
    }
    
    public boolean canMoveTo(int col, int row, ChessColour colour){
        //Will return True if there is a piece of the different colour to kill or nothing in the determined cell
        return (this.chessboard[col][row]).isEmpty() || colour!=(this.chessboard[col][row]).getColor();
    }
}
