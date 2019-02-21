package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

import static cs361.battleships.models.AtackStatus.*;

public class Game {

    @JsonProperty private Board playersBoard = new Board();
    @JsonProperty private Board opponentsBoard = new Board();

    /*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
    public boolean placeShip(Ship ship, int x, char y, boolean isVertical) {

        boolean successful = playersBoard.placeShip(ship, x, y, isVertical);
        if (!successful)
            return false;

        boolean opponentPlacedSuccessfully;
        do {
//            // AI places random ships, so it might try and place overlapping ships
//            // let it try until it gets it right
//            opponentPlacedSuccessfully = opponentsBoard.placeShip(ship, x, y, isVertical);
            opponentPlacedSuccessfully = opponentsBoard.placeShip(ship, randRow(), randCol(), randVertical());
        } while (!opponentPlacedSuccessfully);

//        System.out.println("In AI PLACE SHIP");

        return true;
    }

    //Placing a Submarine underwater
    public boolean place_sub(Ship ship, int x, char y, boolean isUnder, boolean isVertical) {

        boolean successful = playersBoard.place_under(ship, x, y, isUnder, isVertical);
        if (!successful)
            return false;

        boolean opponentPlacedSuccessfully;
        do {
            System.out.println("AI IS IN SUB SHIT");
//            // AI places random ships, so it might try and place overlapping ships
//            // let it try until it gets it right
            opponentPlacedSuccessfully = opponentsBoard.place_under(ship, randRow(), randCol(), true, randVertical());
//            opponentPlacedSuccessfully = opponentsBoard.place_under(ship, x, y, true, isVertical);
        } while (!opponentPlacedSuccessfully);

//        System.out.println("In AI PLACE SHIP");

        return true;

    }
    //Done Placing Submarine
    /*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
    public boolean attack(int x, char y) {
        Result playerAttack = opponentsBoard.attack(x, y);
        if (playerAttack.getResult() == INVALID) {
            return false;
        }

        Result opponentAttackResult;
        //if the opponent is ALSO eligible to attack with lasers
        if(playersBoard.getShips().size() < 4){ //it has killed 1 of our ships and is automatically put into laser mode
            do {
                System.out.println("AI IN LASER BEFORE PLAYER!");
                //            // AI does random attacks, so it might attack the same spot twice
                //            // let it try until it gets it right
                opponentAttackResult = playersBoard.laser_attack(randRow(), randCol());
            } while (opponentAttackResult.getResult() == INVALID); //Changed from != to ==
        }
        else {
            do {
                //            // AI does random attacks, so it might attack the same spot twice
                //            // let it try until it gets it right
                opponentAttackResult = playersBoard.attack(randRow(), randCol());
            } while (opponentAttackResult.getResult() == INVALID); //Changed from != to ==
        }
        return true;
    }

    public boolean laser_attack(int x, char y) {
        Result playerAttack = opponentsBoard.laser_attack(x, y);
        if (playerAttack.getResult() == INVALID) {
            return false;
        }

        Result opponentAttackResult;
        //if the opponent is ALSO eligible to attack with lasers
        if(playersBoard.getShips().size() < 4){ //it has killed 1 of our ships and is automatically put into laser mode
            do {
                System.out.println("IN LASER AI AFTER PLAYER");
                //            // AI does random attacks, so it might attack the same spot twice
                //            // let it try until it gets it right
                opponentAttackResult = playersBoard.laser_attack(randRow(), randCol());
            } while (opponentAttackResult.getResult() == INVALID); //Changed from != to ==
        }
        else{ //else if they havent sunk any ships....they get a regular attack
            do {
                //            // AI does random attacks, so it might attack the same spot twice
                //            // let it try until it gets it right
                opponentAttackResult = playersBoard.attack(randRow(), randCol());
            } while (opponentAttackResult.getResult() == INVALID); //Changed from != to ==
        }
        return true;
    }

    // call sonar_attack on opponents board
    public boolean sonar_attack (int x, char y) {
        return opponentsBoard.sonar_attack(x, y);
    }
	
    // call move fleet for user
    public boolean move_fleet(int d) { 
	return playersBoard.move_fleet(d);
    }

    private char randCol() {
        Random rand = new Random();
        int randNum = rand.nextInt(10);
        randNum = randNum + 65;
        char randChar = (char)randNum;
        return randChar;
    }

    private int randRow() {
        Random rand = new Random();
        int randNum = rand.nextInt(10);
        return randNum+1;
    }

    private boolean randVertical() {
        Random rand = new Random();
        return rand.nextBoolean();
    }
//    private boolean randUnder(){
////        Random rand = new Random();
////        if(rand.nextBoolean()){
////            System.out.println("IS UNDERWATER");
////        }
////        return rand.nextBoolean();
//        System.out.println("IS UNDERWATER");
//        return true;
//    }
}
