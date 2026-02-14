package org.example.lld.tictactoe;

import java.util.*;

public class TicTacToe {
    Board board;
    int boardSize;
    Deque<PlayerType> deque;
    final Scanner scanner = new Scanner(System.in);
    GameState gameState;

    TicTacToe(){
    }

    public void initialize(int size){
        this.boardSize = size;
        this.board = new Board(size);

        this.deque.add(PlayerType.X);
        this.deque.add(PlayerType.O);

        this.gameState = GameState.INITIALIZED;
        this.deque = new ArrayDeque<>();

    }

    public void start(){
        this.gameState = GameState.IN_PROGRESS;

        while(true){
            PlayerType player = deque.poll();
            while(true){
                Optional<Move> move = makeMove(player);
                if(!move.isPresent()){
                    continue;
                }

                board.printBoard();

                // check winner
                boolean hasWinner = board.checkWinner(player, move);
                if(hasWinner){
                    System.out.println("We have winner!: "+ player);
                    this.gameState = GameState.END;
                    return;
                }

                if(board.isFull()){
                    System.out.println("It's a tie!");
                    return;
                }

                deque.add(player);
                break;
            }
        }
    }

    private Optional<Move> makeMove(PlayerType player){
        System.out.print("Player: " + player + " Enter row,column: ");

        String input = scanner.nextLine();
        String parts[] = input.split(",");

        int row, col;
        row = Integer.parseInt(parts[0]);
        col = Integer.parseInt(parts[1]);

        // validate move
        if(!board.isValidBoardMove(row,col)){
            System.out.println("Invalid move");
            return Optional.empty();
        }

        // update board
        board.updateCell(player, row, col);

        return Optional.of(new Move(row,col));
    }
}
