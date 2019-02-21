package cs361.battleships.models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SquareTest {

    @Test
    public void testGetColumn() {
        Square s = new Square(5, 'A');
        assertTrue(s.getColumn() == 'A');
    }

    @Test
    public void testSetColumn() {
        Square s = new Square(5, 'B');
        char desiredColumn = 'A';
        s.setColumn(desiredColumn);
        assertTrue(s.getColumn() == desiredColumn);
    }

    @Test
    public void testGetRow() {
        Square s = new Square(5, 'A');
        assertTrue(s.getRow() == 5);
    }

    @Test
    public void testSetRow() {
        Square s = new Square(5, 'B');
        char desiredRow = 6;
        s.setRow(desiredRow);
        assertTrue(s.getRow() == desiredRow);
    }

    @Test
    public void testGetis_captain(){
        Square s = new Square(5, 'B');
        s.setis_captain();
        assertTrue(s.getis_captain() == true);
    }

    @Test
    public void testSetis_captain(){
        Square s = new Square(2, 'A');
        s.setis_captain();
        assertTrue(s.getis_captain() == true);
    }

    @Test
    public void testSetIs_captainfalse(){
        Square s = new Square(9, 'C');
        s.setIs_captainfalse();
        assertTrue(s.getis_captain() == false);
    }

    @Test
    public void testGetnum_hits(){
        Square s = new Square(7, 'C');
        for(int i =0; i<5;i++) {
            s.setnum_hits();
        }
        assertTrue(s.getnum_hits() == 5);
    }

    @Test
    public void testSetnum_hits(){
        Square s = new Square(8, 'D');
        for(int i =0; i<7;i++) {
            s.setnum_hits();
        }
        assertTrue(s.getnum_hits() == 7);
    }

}
