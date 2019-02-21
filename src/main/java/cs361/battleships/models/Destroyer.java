package cs361.battleships.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class Destroyer extends Ship {
    public Destroyer(){
        occupiedSquares = new ArrayList<>();
        type = "DESTROYER";
        size = 3;
    }
    //the rest of the functions are inherited from Ship
}