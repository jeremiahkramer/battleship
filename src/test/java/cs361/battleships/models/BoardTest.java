package cs361.battleships.models;

import controllers.AttackGameAction;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class BoardTest {

    @Test
    public void testMinesweeperGoodPlaceHorizontal() {
        Board board = new Board();
        assertTrue(board.placeShip(new Ship("MINESWEEPER"), 5, 'C', false));
    }

    @Test
    public void testMinesweeperGoodPlaceVertical() {
        Board board = new Board();
        assertTrue(board.placeShip(new Ship("MINESWEEPER"), 5, 'C', true));
    }

    @Test
    public void testMinesweeperBadYPlaceVertical() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("MINESWEEPER"), 5, 'Z', true));
    }

    @Test
    public void testMinesweeperBadYPlaceHorizontal() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("MINESWEEPER"), 5, 'Z', false));
    }

    @Test
    public void testMinesweeperBadXPlaceVertical() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("MINESWEEPER"), 99, 'A', true));
    }

    @Test
    public void testMinesweeperBadXPlaceHorizontal() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("MINESWEEPER"), 99, 'A', false));
    }

    @Test
    public void testMinesweeperBadPlaceVertical() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("MINESWEEPER"), 23, 'z', true));
    }

    @Test
    public void testMinesweeperBadPlaceHorizontal() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("MINESWEEPER"), -8, 'Y', false));
    }

    ////////////////////PLACESHIP - DESTROYER///////////////////////////////////////////

    @Test
    public void testDestroyerGoodPlaceHorizontal() {
        Board board = new Board();
        assertTrue(board.placeShip(new Ship("DESTROYER"), 5, 'C', false));
    }

    @Test
    public void testDestroyerGoodPlaceVertical() {
        Board board = new Board();
        assertTrue(board.placeShip(new Ship("DESTROYER"), 5, 'C', true));
    }

    @Test
    public void testDestroyerBadYPlaceVertical() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("DESTROYER"), 5, 'Z', true));
    }

    @Test
    public void testDestroyerBadYPlaceHorizontal() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("DESTROYER"), 5, 'Z', false));
    }

    @Test
    public void testDestroyerBadXPlaceVertical() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("DESTROYER"), 99, 'A', true));
    }

    @Test
    public void testDestroyerBadXPlaceHorizontal() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("DESTROYER"), 99, 'A', false));
    }

    @Test
    public void testDestroyerBadPlaceVertical() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("DESTROYER"), 23, 'z', true));
    }

    @Test
    public void testDestroyerBadPlaceHorizontal() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("DESTROYER"), -8, 'Y', false));
    }

    ////////////////////////PLACESHIP - BATTLESHIP//////////////

    @Test
    public void testBattleshipGoodPlaceHorizontal() {
        Board board = new Board();
        assertTrue(board.placeShip(new Ship("BATTLESHIP"), 5, 'C', false));
    }

    @Test
    public void testBattleshipGoodPlaceVertical() {
        Board board = new Board();
        assertTrue(board.placeShip(new Ship("BATTLESHIP"), 5, 'C', true));
    }

    @Test
    public void testBattleshipBadYPlaceVertical() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("BATTLESHIP"), 5, 'Z', true));
    }

    @Test
    public void testBattleshipBadYPlaceHorizontal() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("BATTLESHIP"), 5, 'Z', false));
    }

    @Test
    public void testBattleshipBadXPlaceVertical() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("BATTLESHIP"), 99, 'A', true));
    }

    @Test
    public void testBattleshipBadXPlaceHorizontal() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("BATTLESHIP"), 99, 'A', false));
    }

    @Test
    public void testBattleshipBadPlaceVertical() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("BATTLESHIP"), 23, 'z', true));
    }

    @Test
    public void testBattleshipBadPlaceHorizontal() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("BATTLESHIP"), -8, 'Y', false));
    }
    //END BATTLESHIP////


    @Test
    public void testDuplicateShip() {
        Board board = new Board();
        board.placeShip(new Ship("BATTLESHIP"), 10, 'A', false);
        board.placeShip(new Ship("MINESWEEPER"), 9, 'A', false);
        assertFalse(board.placeShip(new Ship("MINESWEEPER"), 8, 'A', false));
    }

    @Test
    public void testStackedShips() {
        Board board = new Board();
        board.placeShip(new Ship("BATTLESHIP"), 10, 'A', false);
        board.placeShip(new Ship("MINESWEEPER"), 9, 'A', false);
        assertFalse(board.placeShip(new Ship("DESTROYER"), 10, 'A', false));
    }

    @Test
    public void testTooManyShips() {
        Board board = new Board();
        List<Ship> curr_shipList = new ArrayList<Ship>();
        curr_shipList.add(new Ship("MINESWEEPER"));
        curr_shipList.add(new Ship("MINESWEEPER"));
        curr_shipList.add(new Ship("MINESWEEPER"));
        curr_shipList.add(new Ship("MINESWEEPER"));
        board.setShips(curr_shipList);
        assertFalse(board.placeShip(new Ship("DESTROYER"), 5, 'C', false));
    }

    @Test
    public void testInvalidShipPlace() {
        Board board = new Board();
        assertFalse(board.placeShip(new Ship("INVALIDSHIP"), 3, 'D', false));
    }

    //////END - PLACESHIP/////////////////

    @Test
    public void testAttackHit() {
        Board board = new Board();
        assertTrue(board.placeShip(new Ship("DESTROYER"), 3, 'C', true));
        Result result = board.attack(3, 'C');
        assertTrue(result.getResult() == AtackStatus.HIT);
    }
    @Test
    public void testAttackCaptainsQuarterFirstHit() {
        Board board = new Board();
        assertTrue(board.placeShip(new Ship("DESTROYER"), 3, 'C', true));
        Result result = board.attack(4, 'C');
        assertTrue(result.getResult() == AtackStatus.MISS);
    }

    @Test
    public void testAttackCaptainsQuarterSecondHitNoWin() {
        Board board = new Board();
        assertTrue(board.placeShip(new Ship("DESTROYER"), 3, 'C', false));
        assertTrue(board.placeShip(new Ship("BATTLESHIP"), 1, 'A', true));
        Result result_first_hit_to_CQ = board.attack(3, 'D');
        assertTrue(result_first_hit_to_CQ.getResult() == AtackStatus.MISS);
        Result result_second_hit_to_CQ = board.attack(3, 'D');
        assertTrue(result_second_hit_to_CQ.getResult() == AtackStatus.SUNK);
    }

    @Test
    public void testAttackCaptainsQuarterSecondHitToWin() {
        Board board = new Board();
        assertTrue(board.placeShip(new Ship("DESTROYER"), 3, 'C', false));
        Result result_first_hit_to_CQ = board.attack(3, 'D');
        assertTrue(result_first_hit_to_CQ.getResult() == AtackStatus.MISS);
        Result result_second_hit_to_CQ = board.attack(3, 'D');
        System.out.println(result_second_hit_to_CQ.getResult());
        assertTrue(result_second_hit_to_CQ.getResult() == AtackStatus.SURRENDER);
    }

    @Test
    public void testAttackMiss() {
        Board board = new Board();
        Result result = new Result();
        Result second_result = new Result();
        assertTrue(board.placeShip(new Ship("DESTROYER"), 3, 'C', true));
        result = board.attack(8, 'C');
        assertTrue(result.getResult() == AtackStatus.MISS);
    }

    @Test
    public void testAttackSink() {
        Board board = new Board();
        Result result = new Result();
        Result second_result = new Result();
        assertTrue(board.placeShip(new Ship("MINESWEEPER"), 3, 'C', true));
        assertTrue(board.placeShip(new Ship("DESTROYER"), 10, 'A', false));
        board.attack(3, 'C');
        result = board.attack(3, 'C');
        assertTrue(result.getResult() == AtackStatus.SUNK);
    }

    @Test
    public void testAttackSurrender() {
        Board board = new Board();
        Result result = new Result();
        assertTrue(board.placeShip(new Ship("MINESWEEPER"), 2, 'A', false));
        result = board.attack(2, 'B');
        assertTrue(result.getResult() == AtackStatus.HIT);
        Result result2 = new Result();
        result2 = board.attack(2, 'A');
        assertTrue(result2.getResult() == AtackStatus.MISS);
        result2 = board.attack(2, 'A');
        assertTrue(result2.getResult() == AtackStatus.SURRENDER);
    }

    @Test
    public void testAttackOutOfBoundsX() {
        Board board = new Board();
        Result result = new Result();
        result = board.attack(55, 'C');
        assertTrue(result.getResult() == AtackStatus.INVALID);
    }

    @Test
    public void testAttackOutOfBoundsY() {
        Board board = new Board();
        Result result = new Result();
        result = board.attack(5, 'Y');
        assertTrue(result.getResult() == AtackStatus.INVALID);
    }

    @Test
    public void testDuplicateAttackMiss() {
        Board board = new Board();
        Result result = new Result();
        board.attack(5, 'A');
        result = board.attack(5, 'A');
        assertTrue(result.getResult() == AtackStatus.INVALID);
    }

    @Test
    public void testGetShips() {
        Board board = new Board();
        Ship s = new Ship("MINESWEEPER");
        board.getShips().add(s);
        assertTrue(board.getShips().get(0).equals(s));
    }

    @Test
    public void testSetShips() {
        Board board = new Board();
        List<Ship> curr_shipList = new ArrayList<Ship>();
        curr_shipList.add(new Ship("MINESWEEPER"));

        board.setShips(curr_shipList);
        assertTrue(board.getShips().get(0).equals(curr_shipList.get(0)));
    }
    
    @Test
    public void testGetShipsCopy() {
        Board board = new Board();
        Ship s = new Ship("MINESWEEPER");
        board.getShipsCopy().add(s);
        assertTrue(board.getShipsCopy().get(0).equals(s));
    }

    @Test
    public void testSetShipsCopy() {
        Board board = new Board();
        List<Ship> curr_shipList = new ArrayList<Ship>();
        curr_shipList.add(new Ship("MINESWEEPER"));

        board.setShipsCopy(curr_shipList);
        assertTrue(board.getShipsCopy().get(0).equals(curr_shipList.get(0)));
    }


    @Test
    public void testGetAttacks() {
        Board board = new Board();
        Result r = new Result();
        r.setResult(AtackStatus.HIT);
        board.getAttacks().add(r);
        assertTrue(board.getAttacks().get(0).equals(r));
    }


    @Test
    public void testSetAttacks() {
        Board board = new Board();
        Result r = new Result();
        r.setResult(AtackStatus.HIT);
        List<Result> attackLog = new ArrayList<>();
        attackLog.add(r);
        board.setAttacks(attackLog);
        assertTrue(board.getAttacks().get(0).equals(attackLog.get(0)));
    }

    @Test
    public void testGetSonarSquares() {
        Board board = new Board();
        Square s = new Square(6, 'E');
        board.getSonarSquares().add(s);
        assertTrue(board.getSonarSquares().get(0).equals(s));
    }

    @Test
    public void testSetSonarSquares() {
        Board board = new Board();
        Square s = new Square(3, 'A');
        List<Square> sonarSquares = new ArrayList<>();
        sonarSquares.add(s);
        board.setSonarSquares(sonarSquares);
        assertTrue(board.getSonarSquares().get(0).equals(sonarSquares.get(0)));
    }

    @Test
    public void testSonarAttackFalse() {
        Board board = new Board();
        assertFalse(board.sonar_attack(12, 'Z'));
    }

    @Test
    public void testSonarAttackTrue() {
        Board board = new Board();
        assertTrue(board.sonar_attack(2, 'C'));
    }

    @Test
    public void testCheckOverlapFalse() {
        Board board = new Board();
        board.placeShip(new Ship("MINESWEEPER"), 1, 'A', false);
        board.placeShip(new Ship("DESTROYER"), 2, 'A', false);
        assertFalse(board.check_overlap(new Square(1, 'A'), "DESTROYER", false));
    }

    @Test
    public void testCheckOverlapUnderTrue() {
        Board board = new Board();
        board.placeShip(new Ship("MINESWEEPER"), 1, 'A', false);
        board.placeShip(new Ship("SUBMARINE"), 3, 'A', false);
        assertTrue(board.check_overlap(new Square(1, 'A'), "SUBMARINE", true));
    }

    @Test
    public void testMoveFleetUpTrue() {
        Board board = new Board();
        board.placeShip(new Ship("MINESWEEPER"), 10, 'A', false);
        board.placeShip(new Ship("DESTROYER"), 2, 'A', false);
        board.placeShip(new Ship("BATTLESHIP"), 1, 'A', false);
        board.placeShip(new Ship("SUBMARINE"), 10, 'E', false);
        assertTrue(board.move_fleet(1));
    }

    @Test
    public void testMoveFleetRightTrue() {
        Board board = new Board();
        board.placeShip(new Ship("MINESWEEPER"), 1, 'B', true);
        board.placeShip(new Ship("DESTROYER"), 1, 'A', true);
        board.placeShip(new Ship("BATTLESHIP"), 1, 'J', true);
        board.placeShip(new Ship("SUBMARINE"), 10, 'C', false);
        assertTrue(board.move_fleet(2));
    }

    @Test
    public void testMoveFleetDownTrue() {
        Board board = new Board();
        board.placeShip(new Ship("MINESWEEPER"), 10, 'A', false);
        board.placeShip(new Ship("DESTROYER"), 2, 'A', false);
        board.placeShip(new Ship("BATTLESHIP"), 1, 'A', false);
        board.placeShip(new Ship("SUBMARINE"), 10, 'E', false);
        assertTrue(board.move_fleet(3));
    }

    @Test
    public void testMoveFleetLeftTrue() {
        Board board = new Board();
        board.placeShip(new Ship("MINESWEEPER"), 10, 'A', false);
        board.placeShip(new Ship("DESTROYER"), 2, 'A', false);
        board.placeShip(new Ship("BATTLESHIP"), 1, 'A', false);
        board.placeShip(new Ship("SUBMARINE"), 10, 'E', false);
        assertTrue(board.move_fleet(4));
    }

}
