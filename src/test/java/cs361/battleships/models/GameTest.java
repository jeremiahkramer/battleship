package cs361.battleships.models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class GameTest {

    @Test
    public void testPlaceShipSuccessfulVerticalMinesweeper() {
        Game g = new Game();
        Ship s = new Ship("MINESWEEPER");
        assertTrue(g.placeShip(s, 1, 'A', true));
    }

    @Test
    public void testPlaceShipUnsuccessfulXVerticalMinesweeper() {
        Game g = new Game();
        Ship s = new Ship("MINESWEEPER");
        assertFalse(g.placeShip(s, 10, 'J', true));
    }

    @Test
    public void testPlaceShipUnsuccessfulYVerticalMinesweeper() {
        Game g = new Game();
        Ship s = new Ship("MINESWEEPER");
        assertFalse(g.placeShip(s, 3, 'Z', true));
    }

    @Test
    public void testPlaceShipUnsuccessfulVerticalMinesweeper() {
        Game g = new Game();
        Ship s = new Ship("MINESWEEPER");
        assertFalse(g.placeShip(s, 55, 'Y', true));
    }

    @Test
    public void testPlaceShipSuccessfulHorizontalMinesweeper() {
        Game g = new Game();
        Ship s = new Ship("MINESWEEPER");
        assertTrue(g.placeShip(s, 1, 'A', false));
    }

    @Test
    public void testPlaceShipUnsuccessfulXHorizontalMinesweeper() {
        Game g = new Game();
        Ship s = new Ship("MINESWEEPER");
        assertFalse(g.placeShip(s, 10, 'J', false));
    }

    @Test
    public void testPlaceShipUnsuccessfulYHorizontalMinesweeper() {
        Game g = new Game();
        Ship s = new Ship("MINESWEEPER");
        assertFalse(g.placeShip(s, 3, 'Z', false));
    }

    @Test
    public void testPlaceShipUnsuccessfulHorizontalMinesweeper() {
        Game g = new Game();
        Ship s = new Ship("MINESWEEPER");
        assertFalse(g.placeShip(s, 55, 'Y', false));
    }

    //////////MINESWEEPER tested Place ship

    @Test
    public void testPlaceShipSuccessfulVerticalDestroyer() {
        Game g = new Game();
        Ship s = new Ship("DESTROYER");
        assertTrue(g.placeShip(s, 1, 'A', true));
    }

    @Test
    public void testPlaceShipUnsuccessfulXVerticalDestroyer() {
        Game g = new Game();
        Ship s = new Ship("DESTROYER");
        assertFalse(g.placeShip(s, 10, 'J', true));
    }

    @Test
    public void testPlaceShipUnsuccessfulYVerticalDestroyer() {
        Game g = new Game();
        Ship s = new Ship("DESTROYER");
        assertFalse(g.placeShip(s, 3, 'Z', true));
    }

    @Test
    public void testPlaceShipUnsuccessfulVerticalDestroyer() {
        Game g = new Game();
        Ship s = new Ship("DESTROYER");
        assertFalse(g.placeShip(s, 55, 'Y', true));
    }

    @Test
    public void testPlaceShipSuccessfulHorizontalDestroyer() {
        Game g = new Game();
        Ship s = new Ship("DESTROYER");
        assertTrue(g.placeShip(s, 1, 'A', false));
    }

    @Test
    public void testPlaceShipUnsuccessfulXHorizontalDestroyer() {
        Game g = new Game();
        Ship s = new Ship("DESTROYER");
        assertFalse(g.placeShip(s, 10, 'J', false));
    }

    @Test
    public void testPlaceShipUnsuccessfulYHorizontalDestroyer() {
        Game g = new Game();
        Ship s = new Ship("DESTROYER");
        assertFalse(g.placeShip(s, 3, 'Z', false));
    }

    @Test
    public void testPlaceShipUnsuccessfulHorizontalDestroyer() {
        Game g = new Game();
        Ship s = new Ship("DESTROYER");
        assertFalse(g.placeShip(s, 55, 'Y', false));
    }

    //////////////DESTROYER tested Place ship

    @Test
    public void testPlaceShipSuccessfulVerticalBattleship() {
        Game g = new Game();
        Ship s = new Ship("BATTLESHIP");
        assertTrue(g.placeShip(s, 1, 'A', true));
    }

    @Test
    public void testPlaceShipUnsuccessfulXVerticalBattleship() {
        Game g = new Game();
        Ship s = new Ship("BATTLESHIP");
        assertFalse(g.placeShip(s, 10, 'J', true));
    }

    @Test
    public void testPlaceShipUnsuccessfulYVerticalBattleship() {
        Game g = new Game();
        Ship s = new Ship("BATTLESHIP");
        assertFalse(g.placeShip(s, 3, 'Z', true));
    }

    @Test
    public void testPlaceShipUnsuccessfulVerticalBattleship() {
        Game g = new Game();
        Ship s = new Ship("BATTLESHIP");
        assertFalse(g.placeShip(s, 55, 'Y', true));
    }

    @Test
    public void testPlaceShipSuccessfulHorizontalBattleship() {
        Game g = new Game();
        Ship s = new Ship("BATTLESHIP");
        assertTrue(g.placeShip(s, 1, 'A', false));
    }

    @Test
    public void testPlaceShipUnsuccessfulXHorizontalBattleship() {
        Game g = new Game();
        Ship s = new Ship("BATTLESHIP");
        assertFalse(g.placeShip(s, 10, 'J', false));
    }

    @Test
    public void testPlaceShipUnsuccessfulYHorizontalBattleship() {
        Game g = new Game();
        Ship s = new Ship("BATTLESHIP");
        assertFalse(g.placeShip(s, 3, 'Z', false));
    }

    @Test
    public void testPlaceShipUnsuccessfulHorizontalBattleship() {
        Game g = new Game();
        Ship s = new Ship("BATTLESHIP");
        assertFalse(g.placeShip(s, 55, 'Y', false));
    }

    //////////BATTLESHIP tested Place ship

    ///SUB BEGIN/////////

    @Test
    public void testPlaceShipSuccessfulVerticalSubmarine() {
        Game g = new Game();
        Ship s = new Ship("SUBMARINE");
        assertTrue(g.placeShip(s, 1, 'A', true));
    }

    @Test
    public void testPlaceShipUnsuccessfulXVerticalSubmarine() {
        Game g = new Game();
        Ship s = new Ship("SUBMARINE");
        assertFalse(g.placeShip(s, 10, 'J', true));
    }

    @Test
    public void testPlaceShipUnsuccessfulYVerticalSubmarine() {
        Game g = new Game();
        Ship s = new Ship("SUBMARINE");
        assertFalse(g.placeShip(s, 3, 'Z', true));
    }

    @Test
    public void testPlaceShipUnsuccessfulVerticalSubmarine() {
        Game g = new Game();
        Ship s = new Ship("SUBMARINE");
        assertFalse(g.placeShip(s, 55, 'Y', true));
    }

    @Test
    public void testPlaceShipSuccessfulHorizontalSubmarine() {
        Game g = new Game();
        Ship s = new Ship("SUBMARINE");
        assertTrue(g.placeShip(s, 2, 'A', false));
    }

    @Test
    public void testPlaceShipUnsuccessfulXHorizontalSubmarine() {
        Game g = new Game();
        Ship s = new Ship("SUBMARINE");
        assertFalse(g.placeShip(s, 10, 'J', false));
    }

    @Test
    public void testPlaceShipUnsuccessfulYHorizontalSubmarine() {
        Game g = new Game();
        Ship s = new Ship("SUBMARINE");
        assertFalse(g.placeShip(s, 3, 'Z', false));
    }

    @Test
    public void testPlaceShipUnsuccessfulHorizontalSubmarine() {
        Game g = new Game();
        Ship s = new Ship("SUBMARINE");
        assertFalse(g.placeShip(s, 55, 'Y', false));
    }
                //underwater
                @Test
                public void testPlaceShipSuccessfulVerticalSubmarineUnderwater() {
                    Game g = new Game();
                    Ship s = new Ship("SUBMARINE");
                    assertTrue(g.place_sub(s, 1, 'A', true, true));
                }
    @Test
    public void testPlaceShipSuccessfulVerticalSubmarineUnderAnotherShip() {
        Game g = new Game();
        Ship s = new Ship("SUBMARINE");
        Ship b = new Ship("BATTLESHIP");
        g.placeShip(b, 1, 'A', true);
        assertTrue(g.place_sub(s, 1, 'A', true, true));
    }
    @Test
    public void testPlaceShipSuccessfulVerticalSubmarineUnderAnotherTwoShip() {
        Game g = new Game();
        Ship s = new Ship("SUBMARINE");
        Ship b = new Ship("BATTLESHIP");
        Ship d = new Ship("DESTROYER");
        g.placeShip(d, 1, 'A', true);
        g.placeShip(b, 1, 'B', true);
        assertTrue(g.place_sub(s, 2, 'A', true, false));
    }

    @Test
    public void testPlaceShipUnsuccessfulXVerticalSubmarineUnderwater() {
        Game g = new Game();
        Ship s = new Ship("SUBMARINE");
        assertFalse(g.place_sub(s, 10, 'J', true, true));
    }

    @Test
    public void testPlaceShipUnsuccessfulYVerticalSubmarineUnderwater() {
        Game g = new Game();
        Ship s = new Ship("SUBMARINE");
        assertFalse(g.place_sub(s, 3, 'Z', true, true));
    }

    @Test
    public void testPlaceShipUnsuccessfulVerticalSubmarineUnderwater() {
        Game g = new Game();
        Ship s = new Ship("SUBMARINE");
        assertFalse(g.place_sub(s, 55, 'Y', true, true));
    }

    @Test
    public void testPlaceShipSuccessfulHorizontalSubmarineUnderwater() {
        Game g = new Game();
        Ship s = new Ship("SUBMARINE");
        assertTrue(g.place_sub(s, 2, 'A', true, false));
    }

    @Test
    public void testPlaceShipUnsuccessfulXHorizontalSubmarineUnderwater() {
        Game g = new Game();
        Ship s = new Ship("SUBMARINE");
        assertFalse(g.place_sub(s, 10, 'J', true, false));
    }

    @Test
    public void testPlaceShipUnsuccessfulYHorizontalSubmarineUnderwater() {
        Game g = new Game();
        Ship s = new Ship("SUBMARINE");
        assertFalse(g.place_sub(s, 3, 'Z', true, false));
    }

    @Test
    public void testPlaceShipUnsuccessfulHorizontalSubmarineUnderwater() {
        Game g = new Game();
        Ship s = new Ship("SUBMARINE");
        assertFalse(g.place_sub(s, 55, 'Y', true, false));
    }


    //end underwater
    ////SUB END//////////

    @Test
    public void testAttackSuccessfulMinesweeper() {
        Game g = new Game();
        Ship s = new Ship("MINESWEEPER");
        assertTrue(g.attack(1, 'A'));
    }

    @Test
    public void testAttackUnsuccessfulXMinesweeper() {
        Game g = new Game();
        Ship s = new Ship("MINESWEEPER");
        assertFalse(g.attack(100, 'J'));
    }

    @Test
    public void testAttackUnsuccessfulYMinesweeper() {
        Game g = new Game();
        Ship s = new Ship("MINESWEEPER");
        assertFalse(g.attack(3, 'Z'));
    }

    @Test
    public void testAttackUnsuccessfulMinesweeper() {
        Game g = new Game();
        Ship s = new Ship("MINESWEEPER");
        assertFalse(g.attack(55, 'Y'));
    }

    //////////MINESWEEPER tested Attack

    @Test
    public void testAttackSuccessfulDestroyer() {
        Game g = new Game();
        Ship s = new Ship("DESTROYER");
        g.placeShip(s, 1, 'A', true);
        assertTrue(g.attack(1, 'A'));
    }

    @Test
    public void testAttackUnsuccessfulXDestroyer() {
        Game g = new Game();
        Ship s = new Ship("DESTROYER");
        g.placeShip(s, 1, 'A', true);
        assertFalse(g.attack(100, 'J'));
    }

    @Test
    public void testAttackUnsuccessfulYDestroyer() {
        Game g = new Game();
        Ship s = new Ship("DESTROYER");
        g.placeShip(s, 1, 'A', true);
        assertFalse(g.attack(3, 'Z'));
    }

    @Test
    public void testAttackUnsuccessfulDestroyer() {
        Game g = new Game();
        Ship s = new Ship("DESTROYER");
        g.placeShip(s, 1, 'A', true);
        assertFalse(g.attack(55, 'Y'));
    }

    //////////////DESTROYER tested Attack

    @Test
    public void testAttackSuccessfulBattleship() {
        Game g = new Game();
        Ship s = new Ship("BATTLESHIP");
        g.placeShip(s, 1, 'A', true);
        assertTrue(g.attack(1, 'A'));
    }

    @Test
    public void testAttackUnsuccessfulXBattleship() {
        Game g = new Game();
        Ship s = new Ship("BATTLESHIP");
        g.placeShip(s, 1, 'A', true);
        assertFalse(g.attack(100, 'J'));
    }

    @Test
    public void testAttackUnsuccessfulYBattleship() {
        Game g = new Game();
        Ship s = new Ship("BATTLESHIP");
        g.placeShip(s, 1, 'A', true);
        assertFalse(g.attack(3, 'Z'));
    }

    @Test
    public void testAttackUnsuccessfulBattleship() {
        Game g = new Game();
        Ship s = new Ship("BATTLESHIP");
        assertFalse(g.attack(55, 'Y'));
    }

    @Test
    public void testSonarAttackFalse() {
        Game g = new Game();
        assertFalse(g.sonar_attack(67, 'S'));
    }

    @Test
    public void testSonarAttackTrue() {
        Game g = new Game();
        assertTrue(g.sonar_attack(6, 'E'));
    }
    
    @Test
    public void testMoveFleetTrue() {
        Game g = new Game();
        assertTrue(g.move_fleet(1));
    }

    @Test
    public void testLaserAttackOnUnderwaterSubmarineBeneathAShip(){
        Game g = new Game();
        Ship b = new Ship("BATTLESHIP");
        Ship d = new Ship("DESTROYER");
        Ship s = new Ship("SUBMARINE");
        g.placeShip(d, 1, 'A', true);
        g.placeShip(b, 1, 'B', true);
        g.place_sub(s, 1, 'A', true, true);
        assertFalse(g.laser_attack(66, 'E'));
        assertTrue(g.laser_attack(1, 'B')); //regular hit
        assertFalse(g.laser_attack(1, 'B')); //regular hit again, 'invalid'
        //assertFalse(g.laser_attack(1, 'D')); //regular miss
        assertTrue(g.laser_attack(1, 'A')); //regular hit underwater submarine
        assertFalse(g.laser_attack(1, 'A')); //regular hit underwater submarine again, 'invalid'
        assertTrue(g.laser_attack(4, 'A')); //CQ hit underwater submarine
        //assertTrue(g.laser_attack(4, 'A')); //CQ hit underwater submarine again
    }
    
}
