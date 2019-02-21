package cs361.battleships.models;

public class Result {

	protected AtackStatus status;
	protected Ship s;
	protected Square location;

	public AtackStatus getResult() {
		return status;
	}

	public void setResult(AtackStatus result) {
		status = result;
	}

	public Ship getShip() {
		return s;
	}
	
	public void setShip(Ship ship) {
		s = ship;
	}

	public Square getLocation() {
		return location;
	}

	public void setLocation(Square square) { location = square; }
}