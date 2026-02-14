package org.example.lld.tictactoe.winningStrategy;

import org.example.lld.tictactoe.*;

import java.util.*;

public class ColumnWinChecker implements WinChecker {
    @Override
    public boolean isWinner(Board board, Optional<Move> move, PlayerType player){
        int col = move.get().getY();

        for(int i=0; i< board.getSize(); i++){
            if(board.getCell(i,col) != player){
                return false;
            }
        }
        return true;
    }
}
