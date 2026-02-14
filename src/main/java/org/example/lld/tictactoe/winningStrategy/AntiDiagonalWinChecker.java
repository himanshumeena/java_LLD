package org.example.lld.tictactoe.winningStrategy;

import org.example.lld.tictactoe.*;

import java.util.*;

public class AntiDiagonalWinChecker implements WinChecker {
    @Override
    public boolean isWinner(Board board, Optional<Move> move, PlayerType player){
        int n = board.getSize();

        for(int i=0; i<n-1; i--){
            if(board.getCell(i,i=n-1-i) != player){
                return false;
            }
        }
        return true;
    }
}
