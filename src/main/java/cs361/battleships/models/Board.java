package cs361.battleships.models;

//import controllers.AttackGameAction;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<Square> boardOccupiedSquares;
	private List<Ship> shipList;
	private List<Ship> shipListCopy;
	private List<Result> attackLog; //log of all attacks
	private List<Square> sonarSquares; //squares in sonar pulse

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public Board() {
		boardOccupiedSquares = new ArrayList<Square>();
		shipList = new ArrayList<Ship>();
		shipListCopy = new ArrayList<Ship>();
		attackLog = new ArrayList<Result>();//log of all attacks
		sonarSquares = new ArrayList<Square>();
	}


	///////// PLACE SHIP /////////////////////////////////////////////////////////

	// This helper function checks if ship placement is valid
	// it is called in placeShip
	public boolean placeShipIsValid(Ship ship) {
		//if shipList is already 4 then you cant add another
		if(shipList.size() == 4){
			return false;
		}

		//if invalid kind
		if(!(ship.getKind().equals("MINESWEEPER") || ship.getKind().equals("DESTROYER")
				|| ship.getKind().equals("BATTLESHIP") || ship.getKind().equals("SUBMARINE")) )
		{
			return false;
		}

		//next lets see if we've already added this type of ship (don't want duplicates)....
		for(Ship s : shipList){
			if(ship.getKind().equals(s.getKind())){
				return false;
			}
		}
		return true;
	}

	// This helper function places ships in shipCopy array if they are vertical
	// it is called in placeShip
	public boolean placeShipIsVertical(Ship ship, int x, char y, List<Square> shipCopy,boolean under) {
		Square temp_square = new Square();
		Square square_coordinate;
		CaptainsSquare captain_square_coordinate;
		//transformation to coordinates (x)
		//make sure the column is good in range
		int size;
		boolean is_submarine = false;
		if(ship.getKind().equals("SUBMARINE")){ //MIGHT HAVE TO CHANGE
			size = 4;
			is_submarine = true;
		}
		else{
			size = ship.getSize();
		}

		for(int i =0; i < size; i++) {
			if (((x + i) < 1 || (x + i) > 10) || (y > 'J' || y < 'A')) {
				return false;
			}
			if (i == 2 && is_submarine) { //in case we are checking submarine check for protrusion
				if ((char) (y + 1) > 'J' || (char) (y + 1) < 'A') {
					return false; //bad protrusion
				}
				for (Ship shiptestx : shipList) {
					for (Square sq : shiptestx.getOccupiedSquares()) { //validity
						if (sq.getColumn() == (char) (y + 1) && sq.getRow() == (x + i)) {
							//Can't place because already ship there
							if(!under) {
								return false;
							}
						}
					}
				}
			}
			// adding nested loop test
			if (!under){
				for (Ship shiptestx : shipList) {
					for (Square sq : shiptestx.getOccupiedSquares()) { //validity
						if (sq.getColumn() == y && sq.getRow() == (x + i)) {
							//Can't place because already ship there
							return false;
						}
					}
				}
			}
			// end of nested loop test
			temp_square.setRow(x);
			temp_square.setColumn(y);

			//now if this is the second to last square (ie; index is size-2),
			//then we need to make it a captains square
			if(i == size-2 && !is_submarine){ //second to last captains square exception.
				//set it to allocate a captains square
				captain_square_coordinate = new CaptainsSquare(x + i, y);
				if(under){
					captain_square_coordinate.setSubmerged();
				}
				shipCopy.add(captain_square_coordinate);
			}
			else if(i == size-1 && is_submarine){ //make it so that the captains square is added to the
				captain_square_coordinate = new CaptainsSquare(x + i, y);
				if(under){
					captain_square_coordinate.setSubmerged();
				}
				shipCopy.add(captain_square_coordinate);
			}
			else{ //regular index
				//set it to allocate a regular square
				square_coordinate = new Square(x + i, y);
				if(under){
					square_coordinate.setSubmerged();
				}
				shipCopy.add(square_coordinate);
			}
		}

		//append the protrusion (include it in the list
		//because we only iterate for size < 4 for the sub)
		if(is_submarine){
			square_coordinate = new Square((x + (size-2)), (char)(y+1));
			if(under){
				square_coordinate.setSubmerged();
			}
			shipCopy.add(square_coordinate);
		}
		return true;
	}

	// This helper function places ships in shipCopy array if they are horizontal
	// it is called in placeShip
	public boolean placeShipIsHorizontal(Ship ship, int x, char y, List<Square> shipCopy, boolean under) {
		Square temp_square = new Square();
		Square square_coordinate;
		CaptainsSquare captain_square_coordinate;
		//transformation to coordinates (x)
		//make sure the column is good in range
		int size;
		boolean is_submarine = false;
		if(ship.getKind().equals("SUBMARINE")){ //MIGHT HAVE TO CHANGE
			size = 4;
			is_submarine = true;
		}
		else{
			size = ship.getSize();
		}

		for(int i =0; i < size; i++) {
			if (((char) (y + i) < 'A' || (char) (y + i) > 'J') || (x > 10 || x < 1)) {
				return false;
			}
			if (i == 2 && is_submarine) { //in case we are checking submarine check for protrusion
				if ((x - 1) > 10 || (x - 1) < 1) {
					return false; //bad protrusion
				}
				for (Ship shiptestx : shipList) {
					for (Square sq : shiptestx.getOccupiedSquares()) { //validity
						if (sq.getColumn() == y + i && sq.getRow() == (x - 1)) {
							//Can't place because already ship there
							if(!under) {
								return false;
							}
						}
					}
				}
			}
			// nested loop for testing if any of the ships are already placed where we are trying to place
			if(!under)	{
				for (Ship shiptesty : shipList) {
					for (Square sq : shiptesty.getOccupiedSquares()) {
						if (sq.getColumn() == (char) (y + i) && sq.getRow() == x) {
							//Can't place because already ship there
							return false;
						}
					}

				}
			}
			// end of nested loop test

			temp_square.setRow(x);
			temp_square.setColumn(y);
			for(Square s : boardOccupiedSquares){
				if(s.equals(temp_square)){
					return false;
				}
			}

			//now if this is the second to last square (ie; index is size-2),
			//then we need to make it a captains square
			if(i == size-2 && !is_submarine){ //second to last captains square exception.
				//set it to allocate a captains square
				captain_square_coordinate = new CaptainsSquare(x, (char)(y+i));
				if(under){
					captain_square_coordinate.setSubmerged();
				}
				shipCopy.add(captain_square_coordinate);
			}
			else if(i == size-1 && is_submarine){ //make it so that the captains square is added to the
				captain_square_coordinate = new CaptainsSquare(x, (char)(y+i));
				if(under){
					captain_square_coordinate.setSubmerged();
				}
				shipCopy.add(captain_square_coordinate);
			}
			else{ //regular index
				//set it to allocate a regular square
				square_coordinate = new Square(x, (char)(y+i));
				if(under){
					square_coordinate.setSubmerged();
				}
				shipCopy.add(square_coordinate);
			}
		}
		//append the protrusion (include it in the list
		//because we only iterate for size < 4 for the sub)
		if(is_submarine){
			square_coordinate = new Square(x-1, (char)(y+(size-2)));
			if(under){
				square_coordinate.setSubmerged();
			}
			shipCopy.add(square_coordinate);
		}
		return true;
	}

	/*
	DO NOT change the signature of this method. It is used by the grading scripts.
	 */
	public boolean placeShip(Ship ship, int x, char y, boolean isVertical) {
		//instructions:
		//check for vertical or horizontal -> then loop through from i -> ship.size() check if square is valid and not already occupied
		//be appending to shipCopy
		//if bad at any point return false

		//if made it to the end -> transfer shipCopy's data to Ship ship's occupied array.
		//do the same copying for board occupied
		//create an arrayList<Square> of shipCopy to copy into the ships list


		List<Square> shipCopy = new ArrayList<Square>();
		Square temp_square = new Square();
		String kind = "";
		Square square_coordinate;
		CaptainsSquare captain_square_coordinate;
		Ship newShip;

		if (!placeShipIsValid(ship)) {
			return false;
		}
		//now we know that kind of ship hasn't already been places AND we haven't exceeded 3 ships...
		if (ship.getSize() == 2){
			newShip = new Minesweeper();
		}
		else if (ship.getSize() == 3){
			newShip = new Destroyer();
		}
		else if (ship.getSize()==4){
			newShip = new Battleship();
		}
		else{//if its a submarine
			newShip = new Submarine();
		}

		if(isVertical){
			// is vertical
			if (!placeShipIsVertical(ship, x, y, shipCopy,false)) {
				return false;
			}
		}

		else{
			// horizontal
			if (!placeShipIsHorizontal(ship, x, y, shipCopy, false)) {
				return false;
			}
		}

		newShip.setOccupiedSquares(shipCopy);

		//now for the boards'
		for(Square s : shipCopy) {
			boardOccupiedSquares.add(s);
		}

		shipList.add(newShip);
		shipListCopy.add(newShip);

		return true;

	}
	//////// END PLACE SHIP /////////////////////////////////////////////////////
	//Starting Place Sub under/////////
	public boolean place_under(Ship ship, int x, char y, boolean isUnder, boolean isVertical) {
		//instructions:
		//check for vertical or horizontal -> then loop through from i -> ship.size() check if square is valid and not already occupied
		//be appending to shipCopy
		//if bad at any point return false

		//if made it to the end -> transfer shipCopy's data to Ship ship's occupied array.
		//do the same copying for board occupied
		//create an arrayList<Square> of shipCopy to copy into the ships list
		List<Square> shipCopy = new ArrayList<Square>();
		Square temp_square = new Square();
		String kind = "";
		Square square_coordinate;
		CaptainsSquare captain_square_coordinate;
		Ship newShip;

		if (!placeShipIsValid(ship)) {
			System.out.println("FAILED B/C INVALID PLACESHIP");
			return false;
		}
		//now we know that kind of ship hasn't already been places AND we haven't exceeded 3 ships...

		newShip = new Submarine();


		if(isVertical){
			// is vertical
			if (!placeShipIsVertical(ship, x, y, shipCopy,true)) {
				return false;
			}
		}

		else{
			// horizontal
			if (!placeShipIsHorizontal(ship, x, y, shipCopy,true)) {
				return false;
			}
		}

		newShip.setOccupiedSquares(shipCopy);

		//now for the boards'
		for(Square s : shipCopy) {
			boardOccupiedSquares.add(s);
		}

		shipList.add(newShip);

		return true;

	}
	//Ending Place Sub Under////////

	public boolean jmikes_sub(int x, char y){
		for(Ship ship : shipList) {
			for(Square sq : ship.getOccupiedSquares()) {
				if(sq.getRow() == x && sq.getColumn() == y){
					return true;

				}
			}
		}
		return false;
	}


	///////// START RESULT ATTACK ////////////////////////////////////////////////////
	// this helper function checks to see if the attack is valid or invalid
	// it is called in attack
	public boolean attackInvalid(int x, char y, boolean is_laser) {
		Result result = new Result();
		Square location = new Square(x,y);
		AtackStatus status;
		//check if guess is on board
		if  (y < 'A' || y > 'J' || x < 1 || x > 10){
			result.setLocation(location);
			status = AtackStatus.INVALID;
			result.setResult(status);
			attackLog.add(result);
			return true;
		}
		//Now we know the guess is on the board
		//Check log now
		for(Result r : attackLog){
			//if same attack
			if(r.getLocation().getRow() == location.getRow() && r.getLocation().getColumn() == location.getColumn()){
				if(r.getLocation().getis_captain()){
					if(r.getLocation().getnum_hits() == 1){
						break;
					}
				}
				if(is_laser && jmikes_sub(x, y)){
					break;
				}

				//regular miss
				result.setLocation(location);
				status = AtackStatus.INVALID;
				result.setResult(status);
				return true;
			}
		}
		//Now we know it is a valid guess
		return false;
	}

	// this helper function returns the result for when the attack hits a captain square
	// it is called in attack
	public Result attackCaptain(Ship ship, Square sq, int loopindex, Result result, boolean islaser) {
		System.out.println("IN HERE!");
		AtackStatus status;
		Result result_cap = new Result();

		Square location_cap = result.getLocation();
		result_cap.setLocation(location_cap);
		int res_index = 0;
		//if the captain square has been hit already
		if(sq.getnum_hits() == 1){
			ship.clearList();
			if(!islaser){
				shipList.remove(loopindex);
			}

			//check if it was the last ship sunk
			if(shipList.size() == 0){
				status = AtackStatus.SURRENDER;
				result_cap.setResult(status);
				attackLog.add(result_cap);
				return result_cap;
			}
			//else mark as sunk
			status = AtackStatus.SUNK;
			result_cap.setResult(status);
			//NEED TO FIND WHICH ENTRY IN THE RESULT IT MATCHED AND SET IT TO FALSE
			for(Result res : attackLog){
				if(res.getLocation().getRow() == sq.getRow() && res.getLocation().getColumn() == sq.getColumn()){
					attackLog.get(res_index).getLocation().setIs_captainfalse();
				}
				res_index++;
			}
			//end of finding result entry
			attackLog.add(result_cap);
			return result_cap;
		}
		//if first time in captain square
		sq.setnum_hits();
		status=AtackStatus.MISS;
		result_cap.setResult(status);
		attackLog.add(result_cap);
		result_cap.getLocation().setis_captain();
		result_cap.getLocation().setnum_hits();
		return result_cap;
	}

	// this helper function returns the result for when the attack sinks a ship
	// it is called in attack
	public Result attackSinker(Result result, int loopindex, boolean onpoint) {
		AtackStatus status;
		shipList.remove(loopindex);
		shipListCopy.remove(loopindex);
		//Overwriting status as "sunk"
		status = AtackStatus.SUNK;
		result.setResult(status);
		if(shipList.size() == 0) {
			//Overwriting status as "surrender"
			status = AtackStatus.SURRENDER;
			result.setResult(status);
		}
		return result;
	}
	public Result attack(int x, char y) {
		//make a new result package and make a square that is being targeted
		//set location for result
		// check if the coordinates are valid (if invalid set attack status to invalid)
		//check if already guessed if it is assign package to invalid and return result
		//System.out.println("Attack Row: " + x + "Attack Column" + y);
		int index =0;
		int res_index = 0;
		int z =0;
		int loopindex =0;
		boolean onpoint = false;
		Result result = new Result();
		Square location = new Square(x,y);
		AtackStatus status;
		//check if attack is invalid
		if (attackInvalid(x, y, false)) {
			System.out.println("IN HERE");
			status = AtackStatus.INVALID;
			result.setResult(status);
			return result;
		}
		//okay, attack is valid
		//check if hit, surrender, or miss
		for(Ship ship : shipList){
			index=0;

			for(Square sq : ship.getOccupiedSquares()){
				//attack equals a ship location
				if (sq.getRow() == location.getRow() && sq.getColumn() == location.getColumn() && !sq.getSubmerged()){
					//mark as hit
					onpoint = true;
					result.setLocation(location);
					status = AtackStatus.HIT;
					result.setResult(status);
					//check if the ship location is a captain
					if(sq.getis_captain()){
						return attackCaptain(ship, sq, loopindex, result,false);
					}

					ship.getOccupiedSquares().remove(index);

					//Now we must check if it was a sinker
					if(ship.getOccupiedSquares().size() == 0) {
						result = attackSinker(result, loopindex, onpoint);
					}
					if (onpoint) {
						attackLog.add(result);
						return result;
					}
				}
				index++;
			}
			loopindex++;
		}

		//Now we know the shot was a miss
		result.setLocation(location);
		status = AtackStatus.MISS;
		result.setResult(status);
		attackLog.add(result);
		return result;
	}
//////////////////END LASER_ATTACK////////////////////


	/*
    DO NOT change the signature of this method. It is used by the grading scripts.
    */
	public Result laser_attack(int x, char y) {
		//make a new result package and make a square that is being targeted
		//set location for result
		// check if the coordinates are valid (if invalid set attack status to invalid)
		//check if already guessed if it is assign package to invalid and return result
		//System.out.println("Attack Row: " + x + "Attack Column" + y);
		int index =0;
		int ship_delete_index =69;
		int ship_delete_index2 =69;
		boolean wasSunk2= false;
		boolean wasSunk1 = false;
		int loopindex =0;
		int num_succ_hits = 0;
		boolean wasSunk = false;
		Result result = new Result();
		Square location = new Square(x,y);
		Square location2 = new Square(x,y);
		Result result2 = new Result();
		result2.setLocation(location2);
		result.setLocation(location);
		AtackStatus status = AtackStatus.MISS;
		//check if attack is invalid
		if (attackInvalid(x, y, true)) {
			System.out.println("In invalid");
			status = AtackStatus.INVALID;
			result.setResult(status);
			result2.setResult(status);
			System.out.println("return invalid");
			return result;
		}
		//okay, attack is valid
		//check if hit, surrender, or miss
		for(Ship ship : shipList){
			index=0;
			wasSunk =false;

			for(Square sq : ship.getOccupiedSquares()){
				//attack equals a ship location

				System.out.println("Now we back at the top!");
				if (sq.getRow() == location.getRow() && sq.getColumn() == location.getColumn()){
					//mark as hit
					num_succ_hits++;
					System.out.println("HIT - succ hits: " + num_succ_hits);
					status = AtackStatus.HIT;
					//default this attacks' status to HIT
					if(num_succ_hits == 1){
						result.setResult(status); //set the first one's to hit
					}
					else{
						result2.setResult(status);
					}

					//check if the ship location is a captain
					if(sq.getis_captain()){
						System.out.println("IS CAPTAIN");
						status = attackCaptain(ship, sq, loopindex, result,true).getResult();
						System.out.println("STATUS AFTER IS CAPTAIN: " + status);
						if(status == AtackStatus.SUNK){
							wasSunk = true;
							if(num_succ_hits == 1){
								ship_delete_index = loopindex;
								wasSunk1 =true;
							}
							else{
								ship_delete_index2 = loopindex;
								wasSunk2 = true;
							}
						}
						if(num_succ_hits == 1){
							result.setResult(status); //set the first one's to hit
						}
						else{
							result2.setResult(status);
						}

						System.out.println("Got to after if else");
					}
					//if it wasnt a miss
					System.out.println("Now we are checking if it was just a hit but we know it was a sink");
					if(status == AtackStatus.HIT){
						System.out.println("NORMAL HIT: "+status);
						if(num_succ_hits == 1){
							result.setResult(status); //set the first one's to hit
							attackLog.add(result);
						}
						else{
							result2.setResult(status);
							attackLog.add(result2);
						}
//						Result result_hit = new Result();
//						result_hit.setResult(status);
//						result_hit.setLocation(location);
//						attackLog.add(result_hit); //will never be entered from a CQ hit
						ship.getOccupiedSquares().remove(index);
						break;
					}

				}
				System.out.println("Incrementing Index!");
				if(wasSunk){
					break;
				}
				index++;
			}

			System.out.println("Still checking");
			loopindex++;

		}
		if(wasSunk1){
			if(wasSunk1){
				shipList.remove(ship_delete_index);
				if(shipList.size() == 0) {
					//Overwriting status as "surrender"
					status = AtackStatus.SURRENDER;
					result.setResult(status);
					result2.setResult(status);
					attackLog.add(result);
					attackLog.add(result2);
					return result;
				}
				result.setResult(AtackStatus.SUNK);

				if (wasSunk2) {
					shipList.remove(ship_delete_index2);
					if(shipList.size() == 0) {
						//Overwriting status as "surrender"
						status = AtackStatus.SURRENDER;
						result.setResult(status);
						result2.setResult(status);
						attackLog.add(result);
						attackLog.add(result2);
						return result;
					}

				}
			}
		}


		System.out.println("IS OUT OF LOOP: SUCC HITS" + num_succ_hits);
		if(num_succ_hits == 0){
			System.out.println("SUCC = 0");
			result.setResult(status);
			result2.setResult(status);
			attackLog.add(result);
			attackLog.add(result2);
		}
		else if (num_succ_hits == 1){
			System.out.println("SUCC = 1");
			result2.setResult(AtackStatus.MISS);
			attackLog.add(result2);
		}


		System.out.println("---------");
		System.out.println(result.getResult());
		return result;
	}
	///////// END RESULT ATTACK ////////////////////////////////////////////////


	///////// SONAR PULSE MODE /////////////////////////////////////////////////

	public boolean sonar_attack (int x, char y) {
		// check if sonar_attack is valid (if it's in the grid)
		if  (y < 'A' || y > 'J' || x < 1 || x > 10){
			return false;
		}

		List<Square> sonar_sq = new ArrayList<>();
		int i;

		// these x and y transformations represent the 13 coordinates in the sonar pulse range
		int[] transform_x = new int[]{ 0,-2,-1,-1,-1,0,0,0,0,1,1,1,2 };
		int[] transform_y = new int[]{ 0,0,-1,0,1,-2,-1,1,2,-1,0,1,0 };

		// the sonar pulse will scan 13 coordinates/squares with the exact transformations as above
		// important to have center of pulse at the first index of sonarSquares array (for adding dot image in cell)
		for (i = 0; i < transform_x.length; i++) {
			sonar_sq.add((new Square(x + transform_x[i], (char)(((int)y) + transform_y[i]) )));
		}

		// check if sonar square is in grid
		for (Square sq : sonar_sq) {
			if  ((sq.getColumn() >= 'A' && sq.getColumn() <= 'J') && (sq.getRow() >= 1 && sq.getRow() <= 10)){
				// put in final sonarSquares to display in game.js
				sonarSquares.add(sq);
			}
		}

		return true;
	}
	///////// END SONAR PULSE MODE /////////////////////////////////////////////////

	
	///////// MOVE FLEET MODE //////////////////////////////////////////////////////

	public boolean check_overlap (Square sq, String kind, boolean under) {
		int ship_index = 0;
		for (Ship s : shipListCopy) {
			// if we are checking the overlap of the same ship, break out of loop
			// compare each square that will be moved with every ship location (except itself)
			for (Square sq_iter : s.getOccupiedSquares()) {
				// if they match, return false (don't move that ship)
				if ((!shipListCopy.get(ship_index).getKind().equals(kind)) && sq_iter.getRow() == sq.getRow()
						&& sq_iter.getColumn() == sq.getColumn() && !under)
				{
					return false;
				}
			}
			ship_index++;
		}
		return true;
	}


	public boolean move_fleet (int direction) {
		// direction
		// 1, 2, 3, 4
		// N, E, S, W
		int failed = 0;
		int ship_index = 0;
		List<Square> temp_square_list = new ArrayList<Square>();
		for (Ship s : shipList){
			// flag used when adding the temp square list to occupied squares of shipList
			failed = 0;
			// reset temp square list every ship we check
			temp_square_list.clear();
			for (Square sq : s.getOccupiedSquares()){
				// up
				if(direction == 1) {
					// temp square is where the square will be moved to (new location)
					Square temp_square = new Square(sq.getRow() - 1, sq.getColumn());
					// if the new location is off the grid or if it overlaps with another ship
					if (sq.getRow() - 1 < 1 || !check_overlap(temp_square, shipList.get(ship_index).getKind()
							, shipList.get(ship_index).getOccupiedSquares().get(0).getSubmerged()))
					{

						failed = 1;
						break;

					}
					// add to temp square list (will be added if the prev check doesn't fail)
					temp_square_list.add(temp_square);

				}
				// right
				else if(direction == 2){
					// temp square is where the square will be moved to (new location)
					Square temp_square = new Square(sq.getRow(), (char)(((int)sq.getColumn()) + 1) );
					// if the new location is off the grid or if it overlaps with another ship
					if (sq.getColumn() + 1 > 'J' || !check_overlap(temp_square, shipList.get(ship_index).getKind(), shipList.get(ship_index).getOccupiedSquares().get(0).getSubmerged())){
						failed = 1;
						break;
					}
					// add to temp square list (will be added if the prev check doesn't fail)
					temp_square_list.add(temp_square);
				}
				// down
				else if(direction == 3) {
					// temp square is where the square will be moved to (new location)
					Square temp_square = new Square(sq.getRow() + 1, sq.getColumn());
					// if the new location is off the grid or if it overlaps with another ship
					if (sq.getRow() + 1 > 10 || !check_overlap(temp_square, shipList.get(ship_index).getKind(), shipList.get(ship_index).getOccupiedSquares().get(0).getSubmerged() )) {
						failed = 1;
						break;
					}
					// add to temp square list (will be added if the prev check doesn't fail)
					temp_square_list.add(temp_square);
				}
				// left
				else if(direction == 4){
					// temp square is where the square will be moved to (new location)
					Square temp_square = new Square(sq.getRow(), (char)(((int)sq.getColumn()) - 1) );
					// if the new location is off the grid or if it overlaps with another ship
					if (sq.getColumn() - 1 < 'A' || !check_overlap(temp_square, shipList.get(ship_index).getKind(), shipList.get(ship_index).getOccupiedSquares().get(0).getSubmerged() )){
						failed = 1;
						break;
					}
					// add to temp square list (will be added if the prev check doesn't fail)
					temp_square_list.add(temp_square);
				}
			}
			if (failed == 0){
				// clear prev ship square locations
				s.clearList();
				s.setOccupiedSquares(temp_square_list);
			}
			ship_index++;
		}

		// update shipListCopy with new locations
		shipListCopy = shipList;
		
		return true;
	}
	///////// END MOVE FLEET MODE //////////////////////////////////////////////////


	public List<Ship> getShips() {
		return shipList;
	}

	public void setShips(List<Ship> ships) {
		for(Ship i : ships){
			shipList.add(i); //construct our shipList
		}
	}
	
	public List<Ship> getShipsCopy() {
		return shipListCopy;
	}

	public void setShipsCopy(List<Ship> ships) {
		for(Ship i : ships){
			shipListCopy.add(i); //construct our shipListCopy
		}
	}

	public List<Result> getAttacks() {
		return attackLog;
	}

	public void setAttacks(List<Result> attacks) {
		for ( Result r : attacks)
		{
			attackLog.add(r);
		}
	}

	public List<Square> getSonarSquares() {
		return this.sonarSquares;
	}

	public void setSonarSquares(List<Square> sonarSquares) {
		for(Square s : sonarSquares){
			this.sonarSquares.add(s);
		}
	}

}
