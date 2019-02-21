package cs361.battleships.models;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Battleship extends Ship{
    public Battleship(){
        occupiedSquares = new ArrayList<>();
        type = "BATTLESHIP";
        size = 4;
    }
    //the rest of the functions are inherited from Ship
}