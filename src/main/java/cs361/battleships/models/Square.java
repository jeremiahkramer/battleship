package cs361.battleships.models;

@SuppressWarnings("unused")
public class Square {

	protected int row;
	protected char column;
	protected boolean is_captain;
	protected int num_hits;
	protected boolean submerged;

	public Square(int row, char column) {

		this.row = row;
		this.column = column;
		is_captain = false;
		submerged = false;
	}
	public Square(){}
	public char getColumn() {
		return column;
	}

	public void setColumn(char column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public boolean getis_captain(){
		return is_captain;
	}

	public void setis_captain(){
		is_captain = true;
	}
	public void setIs_captainfalse(){
		is_captain = false;
	}

	public int getnum_hits(){
		return num_hits;
	}
	public void setnum_hits(){
		num_hits++;
	}

	public boolean getSubmerged(){
		return submerged;
	}
	public void setSubmerged(){	submerged = true; }
}