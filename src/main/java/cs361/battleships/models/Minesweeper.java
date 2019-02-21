package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.ArrayList;

public class Minesweeper extends Ship {
    public Minesweeper(){
        occupiedSquares = new ArrayList<>();
        type = "MINESWEEPER";
        size = 2;
    }
    //the rest of the functions are inherited from Ship


}