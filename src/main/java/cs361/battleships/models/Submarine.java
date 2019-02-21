package cs361.battleships.models;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Submarine extends Ship{
    public Submarine(){
        occupiedSquares = new ArrayList<>();
        type = "SUBMARINE";
        size = 5;
    }
    //the rest of the functions are inherited from Ship
}