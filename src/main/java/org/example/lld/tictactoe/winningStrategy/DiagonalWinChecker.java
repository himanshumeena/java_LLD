package org.example.lld.tictactoe.winningStrategy;

import org.example.lld.tictactoe.*;

import java.util.*;

public class DiagonalWinChecker implements WinChecker {
    @Override
    public boolean isWinner(Board board, Optional<Move> move, PlayerType player){
        for(int i=0; i< board.getSize(); i++){
            if(board.getCell(i,i) != player){
                return false;
            }
        }
        return true;
    }
}
