package cs361.battleships.models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ResultTest {

    @Test
    public void testGetResult() {
        Result r = new Result();
        r.setResult(AtackStatus.INVALID);
        assertTrue(r.getResult().equals(AtackStatus.INVALID));
    }

    @Test
    public void testSetResult() {
        Result r = new Result();
        r.setResult(AtackStatus.INVALID);
        assertTrue(r.getResult().equals(AtackStatus.INVALID));
    }

    @Test
    public void testGetShip() {
        Result r = new Result();
        Ship s = new Ship("DESTROYER");
        r.setShip(s);
        assertTrue(r.getShip() == s);
    }

    @Test
    public void testSetShip() {
        Result r = new Result();
        Ship s = new Ship("DESTROYER");
        r.setShip(s);
        assertTrue(r.getShip() == s);
    }

    @Test
    public void testGetLocation() {
        Result r = new Result();
        Square l = new Square(2, 'B');
        r.setLocation(l);
        assertTrue(r.getLocation().getRow() == 2 && r.getLocation().getColumn() == 'B');
    }

    @Test
    public void testSetLocation() {
        Result r = new Result();
        Square l = new Square(4, 'C');
        r.setLocation(l);
        assertTrue(r.getLocation().getRow() == 4 && r.getLocation().getColumn() == 'C');
    }

}
