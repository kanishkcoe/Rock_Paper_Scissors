package com.rock_paper_scissors;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Stack;

@Repository
public class MoveTallyRepository {

    private Stack<MoveTally> moves;
    private Stack<MoveTally> currentSessionMoves;

    public int getSize() {
        return this.currentSessionMoves.size();
    }
    public MoveTallyRepository() {
        this.moves = new Stack<>();
        currentSessionMoves = new Stack<>();
    }

    public boolean addMove(MoveTally move) {
        this.moves.push(move);
        this.currentSessionMoves.push(move);
        System.out.println(move + " added to the tally");
        return true;
    }

    public MoveTally getLastMove() {
        System.out.println("currentSessionMoves = " + currentSessionMoves);
        return  this.currentSessionMoves.peek();
    }

    public boolean reset() {
        this.currentSessionMoves.clear();
        return true;
    }

    public Stack<MoveTally> getAllMoves() {
        return this.moves;
    }

    public MoveTally getSecondLastMove() {
        this.currentSessionMoves.pop();
        return this.currentSessionMoves.peek();
    }
}
