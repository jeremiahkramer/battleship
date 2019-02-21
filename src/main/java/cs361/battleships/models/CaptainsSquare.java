package cs361.battleships.models;

public class CaptainsSquare extends Square {

    public CaptainsSquare(int row, char column) {
        this.row = row;
        this.column = column;
        is_captain = true;
        num_hits = 0;
    }

    public CaptainsSquare() {
        is_captain = true;
        num_hits = 0;
    }
}