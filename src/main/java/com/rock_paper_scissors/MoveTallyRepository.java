package com.rock_paper_scissors;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Stack;

@Repository
public class MoveTallyRepository {

    private Stack<MoveTally> moves;
    private Stack<MoveTally> currentSessionMoves;

    public int getSize() {
        return this.moves.size();
    }
    public MoveTallyRepository() {
        this.moves = new Stack<>();
        currentSessionMoves = new Stack<>();
    }

    public boolean addMove(MoveTally move) {
        this.moves.push(move);
        this.currentSessionMoves.push(move);
        return true;
    }

    public MoveTally getLastMove() {
        return  this.currentSessionMoves.pop();
    }

    public boolean reset() {
        this.currentSessionMoves.clear();
        return true;
    }

    public Stack<MoveTally> getAllMoves() {
        return this.moves;
    }
}
