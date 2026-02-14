package org.example.lld.tictactoe;

public class TicTacToeRunner {
    public static void runme(){
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.initialize(3);
        ticTacToe.start();
    }
}
