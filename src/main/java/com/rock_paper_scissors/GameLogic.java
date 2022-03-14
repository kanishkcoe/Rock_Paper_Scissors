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
        if (validateRequest(move)) {
            if (hasFirstPlayerPlayed(move)) {
                moveTallyRepository.addMove(move);
                return getWinner(move);
            } else {
                move.setId(1L);
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
        if (!player.move.equalsIgnoreCase("rock") || !player.move.equalsIgnoreCase("scissor") || !player.move.equalsIgnoreCase("paper")) {
            //invalid move
            return false;
        }

        return true;
    }

    private MoveTally getWinner(MoveTally secondPlayer) {
        MoveTally firstPlayer = moveTallyRepository.getLastMove();
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
