package com.rock_paper_scissors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Stack;

@RequestMapping("api")
@RestController
public class GameController {

    private final GameLogic service;

    public GameController(GameLogic service) {
        this.service = service;
    }

    @PostMapping("game")
    public ResponseEntity<?> play(@RequestBody MoveTally move) {
        MoveTally winner = service.addMove(move);
        if(winner == null) {
            return new ResponseEntity<String>("Move added to the game, wait for next player.", HttpStatus.OK);
        }

        return new ResponseEntity<String>(winner.toString() + " won the game.", HttpStatus.OK);
    }

    @GetMapping("game")
    @ResponseStatus(HttpStatus.OK)
    public Stack<MoveTally> play() {
        return service.getAllMoves();
    }
}
