package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.ArrayList;

public class Ship {
	@JsonProperty protected List<Square> occupiedSquares;
	protected int size;
	protected String type;

	public Ship(){
		occupiedSquares = new ArrayList<>();
	}
	public Ship(String kind) {
		type = kind;
		occupiedSquares = new ArrayList<Square>();
		if(type.equals("MINESWEEPER")){
			size = 2;
		}
		else if(type.equals("DESTROYER")){
			size = 3;
		}
		else if(type.equals("BATTLESHIP")){
			size = 4;
		}
	}

	public List<Square> getOccupiedSquares() {
		return occupiedSquares;
	}

	public void setOccupiedSquares(List<Square> shipCopy) {
		for(Square s : shipCopy){
			occupiedSquares.add(s);
		}
	}
	public int getSize(){
		return size;
	}

	public void clearList(){
		occupiedSquares.clear();
	}

	public String getKind() { return this.type; }

	public void setKind( String kind) {
		type = kind;
	}


}
