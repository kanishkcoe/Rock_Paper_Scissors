package com.rock_paper_scissors;

public class MoveTally {
    long id;
    String playerName;
    String move;

    @Override
    public String toString() {
        return "MoveTally{" +
                "id=" + id +
                ", playerName='" + playerName + '\'' +
                ", move='" + move + '\'' +
                '}';
    }

    public long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public MoveTally(String playerName, String move) {
        this.playerName = playerName;
        this.move = move;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }
}
