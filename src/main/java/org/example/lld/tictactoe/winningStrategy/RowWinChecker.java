package org.example.lld.tictactoe.winningStrategy;

import org.example.lld.tictactoe.*;

import java.util.*;

public class RowWinChecker implements WinChecker {
    @Override
    public boolean isWinner(Board board, Optional<Move> move, PlayerType player){
        int row = move.get().getX();
        for(int i=0; i< board.getSize(); i++){
            if(board.getCell(row,i) != player){
                return false;
            }
        }
        return true;
    }
}
