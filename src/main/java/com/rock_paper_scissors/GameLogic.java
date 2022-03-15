package com.rock_paper_scissors;

import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class GameLogic {

    private final MoveTallyRepository moveTallyRepository;

    public GameLogic(MoveTallyRepository moveTallyRepository) {
        this.moveTallyRepository = moveTallyRepository;
    }

    public Stack<MoveTally> getAllMoves() {
        return this.moveTallyRepository.getAllMoves();
    }

    public MoveTally addMove(MoveTally move) {
        System.out.println(move);
        if (validateRequest(move)) {
            System.out.println("received valid move");
            if (hasFirstPlayerPlayed(move)) {
                System.out.println("first player has played");
                moveTallyRepository.addMove(move);
                return getWinner(move);
            } else {
                moveTallyRepository.addMove(move);
            }
        }
        return null;
    }

    private boolean hasFirstPlayerPlayed(MoveTally player) {
        if (moveTallyRepository.getSize() == 0 || moveTallyRepository.getLastMove().id == player.id) {
            return false;
        }
        return true;
    }

    private Boolean validateRequest(MoveTally player) {
        if (player.move.equalsIgnoreCase("rock")) {
            return true;
        } else if (player.move.equalsIgnoreCase("scissor")) {
            return true;
        } else if (player.move.equalsIgnoreCase("paper")) {
            return true;
        }

        return false;
    }

    private MoveTally getWinner(MoveTally secondPlayer) {
        MoveTally firstPlayer = moveTallyRepository.getSecondLastMove();
        System.out.println("firstPlayer = " + firstPlayer);
        System.out.println("secondPlayer = " + secondPlayer);
        MoveTally winner = null;
        if (firstPlayer.move.equalsIgnoreCase("rock") && secondPlayer.move.equalsIgnoreCase("scissor")) {
            //rock wins over scissor
            winner = firstPlayer;
        }
        if (firstPlayer.move.equalsIgnoreCase("scissor") && secondPlayer.move.equalsIgnoreCase("rock")) {
            //rock wins over scissor
            winner = secondPlayer;
        }
        if (firstPlayer.move.equalsIgnoreCase("rock") && secondPlayer.move.equalsIgnoreCase("paper")) {
            //rock wins over scissor
            winner = secondPlayer;
        }
        if (firstPlayer.move.equalsIgnoreCase("paper") && secondPlayer.move.equalsIgnoreCase("rock")) {
            //rock wins over scissor
            winner = firstPlayer;
        }
        if (firstPlayer.move.equalsIgnoreCase("paper") && secondPlayer.move.equalsIgnoreCase("scissor")) {
            //rock wins over scissor
            winner = secondPlayer;
        }
        if (firstPlayer.move.equalsIgnoreCase("scissor") && secondPlayer.move.equalsIgnoreCase("paper")) {
            //rock wins over scissor
            winner = firstPlayer;
        }
        this.moveTallyRepository.reset();
        return winner;
    }
}
