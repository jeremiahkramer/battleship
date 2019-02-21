package controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs361.battleships.models.Game;

public class MoveFleetGameAction {

    @JsonProperty private Game game;
    @JsonProperty private int d;

    public Game getGame() {
        return game;
    }

    public int getActionDirection() { return d; }
}
