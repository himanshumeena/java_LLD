package org.example.lld.tictactoe.winningStrategy;

import org.example.lld.tictactoe.*;

import java.util.*;

public interface WinChecker {
    public boolean isWinner(Board board, Optional<Move> move, PlayerType player);
}
