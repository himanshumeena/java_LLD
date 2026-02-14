package org.example.lld.tictactoe;

import org.example.lld.tictactoe.winningStrategy.*;

import java.util.*;

public class Board {
    PlayerType[][] cells;
    final RowWinChecker rowWinChecker = new RowWinChecker();
    final ColumnWinChecker columnWinChecker = new ColumnWinChecker();
    final DiagonalWinChecker diagonalWinChecker = new DiagonalWinChecker();
    final AntiDiagonalWinChecker antiDiagonalWinChecker = new AntiDiagonalWinChecker();

    Board(int size){
        this.cells = new PlayerType[size][size];
    }

    public int getSize(){
        return cells.length;
    }

    public PlayerType getCell(int row, int col){
        return cells[row][col];
    }

    public boolean isValidBoardMove(int row, int col){
        if(row<0||col<0||row>this.cells.length-1||col>this.cells.length-1){
            return false;
        }

        return cells[row][col] == null;
    }

    public void updateCell(PlayerType playerType, int row, int col){
        this.cells[row][col] = playerType;
    }

    public boolean isFull(){
        for (PlayerType[] cell : cells) {
            for (PlayerType playerType : cell) {
                if (playerType == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard(){
        for (PlayerType[] cell : cells) {
            for (PlayerType playerType : cell) {
                if (playerType != null) {
                    System.out.print(playerType);
                } else {
                    System.out.print("_");
                }
            }
            System.out.println("");
        }
    }

    public boolean checkWinner(PlayerType playerType, Optional<Move> move){
        return rowWinChecker.isWinner(this, move, playerType) || columnWinChecker.isWinner(this, move, playerType) || antiDiagonalWinChecker.isWinner(this, move, playerType) || diagonalWinChecker.isWinner(this, move, playerType);
    }

    @Override
    public String toString() {
        return "Board{" +
                "cells=" + Arrays.toString(cells) +
                '}';
    }
}
