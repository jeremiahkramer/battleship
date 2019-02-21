package cs361.battleships.models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CaptainsSquareTest {

    @Test
    public void testCaptainsSquareNonDefaultConstructor() {
        int row = 5;
        char column = 'B';
        CaptainsSquare cs = new CaptainsSquare(row, column);
        assertTrue(cs.getRow() == 5 && cs.getColumn() == 'B'
        && cs.getis_captain() && cs.getnum_hits() ==0);
    }
    @Test
    public void testCaptainsSquareDefaultConstructor() {
        CaptainsSquare cs = new CaptainsSquare();
        assertTrue(cs.getis_captain() && cs.getnum_hits() ==0);
    }
}
