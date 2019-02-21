package cs361.battleships.models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



public class ShipTest {

    @Test
    public void testGetOccupiedMinesweeper() {
        Ship ship = new Ship("MINESWEEPER");
        Square sq = new Square(5,'C');
        ship.getOccupiedSquares().add(sq);
        assertTrue(ship.getOccupiedSquares().get(0).equals(sq));
    }

    @Test
    public void testGetOccupiedBattleship() {

        Ship ship = new Ship("BATTLESHIP");
        Square sq = new Square(2,'D');
        ship.getOccupiedSquares().add(sq);
        assertTrue(ship.getOccupiedSquares().get(0).equals(sq));
    }

    @Test
    public void testGetOccupiedDestroyer() {

        Ship ship = new Ship("DESTROYER");
        Square sq = new Square(4,'G');
        ship.getOccupiedSquares().add(sq);
        assertTrue(ship.getOccupiedSquares().get(0).equals(sq));
    }

    @Test
    public void testSetOccupiedMinesweeper() {

        Ship ship = new Ship("MINESWEEPER");
        Square sq = new Square(4,'C');
        List<Square> occupied_list = new ArrayList<Square>();
        occupied_list.add(sq);
        ship.setOccupiedSquares(occupied_list);
        assertTrue(ship.getOccupiedSquares().get(0).equals(sq));


    }

    @Test
    public void testSetOccupiedBattleship() {

        Ship ship = new Ship("BATTLESHIP");
        Square sq = new Square(5,'F');
        List<Square> occupied_list = new ArrayList<Square>();
        occupied_list.add(sq);
        ship.setOccupiedSquares(occupied_list);
        assertTrue(ship.getOccupiedSquares().get(0).equals(sq));


    }


    @Test
    public void testSetOccupiedDestroyer() {

        Ship ship = new Ship("DESTROYER");
        Square sq = new Square(2,'B');
        List<Square> occupied_list = new ArrayList<Square>();
        occupied_list.add(sq);
        ship.setOccupiedSquares(occupied_list);
        assertTrue(ship.getOccupiedSquares().get(0).equals(sq));
    }

    @Test
    public void testGetSizeMinesweeper() {

        Ship ship = new Ship("MINESWEEPER");
        assertFalse(ship.getSize() == 3);
        assertTrue(ship.getSize() == 2);

    }

    @Test
    public void testGetSizeBattleship() {

        Ship ship = new Ship("BATTLESHIP");
        assertFalse(ship.getSize() == 2);
        assertTrue(ship.getSize() == 4);

    }

    @Test
    public void testGetSizeDestroyer() {

        Ship ship = new Ship("DESTROYER");

        assertFalse(ship.getSize() == 5);
        assertTrue(ship.getSize() == 3);

    }

    @Test
    public void testClearListMinesweeper() {

        Ship ship = new Ship("MINESWEEPER");
        Square sq = new Square(4,'C');
        List<Square> occupied_list = new ArrayList<Square>();
        occupied_list.add(sq);
        ship.setOccupiedSquares(occupied_list);
        ship.clearList();
        assertTrue(ship.getOccupiedSquares().size() == 0);


    }


    @Test
    public void testClearListDestroyer() {

        Ship ship = new Ship("DESTROYER");
        Square sq = new Square(2,'B');
        List<Square> occupied_list = new ArrayList<Square>();
        occupied_list.add(sq);
        ship.setOccupiedSquares(occupied_list);
        ship.clearList();
        assertTrue(ship.getOccupiedSquares().size() == 0);

    }

    @Test
    public void testClearListBattleship() {

        Ship ship = new Ship("BATTLESHIP");
        Square sq = new Square(2,'G');
        List<Square> occupied_list = new ArrayList<Square>();
        occupied_list.add(sq);
        ship.setOccupiedSquares(occupied_list);
        ship.clearList();
        assertTrue(ship.getOccupiedSquares().size() == 0);


    }

    @Test
    public void testgetKindBattleship() {

        Ship ship = new Ship("BATTLESHIP");
        assertTrue(ship.getKind() == "BATTLESHIP");

    }

    @Test
    public void testgetKindMinesweeper() {

        Ship ship = new Ship("MINESWEEPER");
        assertTrue(ship.getKind() == "MINESWEEPER");

    }

    @Test
    public void testgetKindDestroyer() {

        Ship ship = new Ship("DESTROYER");
        assertTrue(ship.getKind() == "DESTROYER");

    }

    @Test
    public void testsetKindMinesweeper() {

        Ship ship = new Ship("BATTLESHIP");
        ship.setKind("MINESWEEPER");
        assertTrue(ship.getKind() == "MINESWEEPER");

    }

    @Test
    public void testsetKindDestroyer() {

        Ship ship = new Ship();
        ship.setKind("DESTROYER");
        assertTrue(ship.getKind() == "DESTROYER");

    }

    @Test
    public void testsetKindBattleship() {

        Ship ship = new Ship("MINESWEEPER");
        ship.setKind("BATTLESHIP");
        assertTrue(ship.getKind() == "BATTLESHIP");

    }

}
