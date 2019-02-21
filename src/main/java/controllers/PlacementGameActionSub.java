package controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import cs361.battleships.models.Game;

public class PlacementGameActionSub {

    @JsonProperty private Game game;
    @JsonProperty private String shipType;
    @JsonProperty private int x;
    @JsonProperty private char y;
    @JsonProperty private boolean isVertical;
    @JsonProperty private boolean isUnder;

    public Game getGame() {
        return game;
    }

    public int getActionRow() {
        return x;
    }

    public char getActionColumn() {
        return y;
    }

    public String getShipType() {
        return shipType;
    }
    public boolean isUnder (){return isUnder;};
    public boolean isVertical() {
        return isVertical;
    }
}
