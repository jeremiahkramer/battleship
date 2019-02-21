var isSetup = true;
var placedShips = 0;
var hasbroke1 =false;
var hasbroke2 =false;
var hasbroke3= false;
var game;
var shipType;
var vertical;
var under;
var shot_count=0;
var hit_count=0;
var ship_sunk=0;
var accuracy = 0;
var counter;
var sonar_uses = 0;
var move_fleet_uses = 0;
var isSonar = false;
var isMoveFleet = false;
var sonar_index;
var ship_looper = 0;
let ship_one = [{row:11,column:'K'},{row:11,column:'K'},{row:11,column:'K'},{row:11,column:'K'},{row:11,column:'K'}];
let ship_two = [{row:11,column:'K'},{row:11,column:'K'},{row:11,column:'K'},{row:11,column:'K'},{row:11,column:'K'}];
let ship_three = [{row:11,column:'K'},{row:11,column:'K'},{row:11,column:'K'},{row:11,column:'K'},{row:11,column:'K'}];
let ship_four = [{row:11,column:'K'},{row:11,column:'K'},{row:11,column:'K'},{row:11,column:'K'},{row:11,column:'K'}];
let ship_names = [];
let unsunked = [];
var entered_attack_mode = 0;
var sonar_clicked_down = false;
var move_fleet_clicked_down = false;
var direction = 0;
var activation_code;
var laser_mode = false;

function makeGrid(table, isPlayer) {
    for (i=0; i<10; i++) {
        let row = document.createElement('tr');
        for (j=0; j<10; j++) {
            let column = document.createElement('td');
            column.addEventListener("click", cellClick);
            row.appendChild(column);
        }
        table.appendChild(row);
    }
}

function makeAxis(table, is_x) {
    //make the x axis.
    if(is_x){
        let row = document.createElement('tr');
        for (j=0; j<11; j++) {
            //create a column for each letter.
            let column = document.createElement('td');
            if(j != 0){
                //add characters from A-J, for the upper 10 of the 11 boxes created.
                 column.innerHTML = String.fromCharCode((65+j-1));
            }
            //append this column to our 1 row (for our 1 row table).
            row.appendChild(column);
        }
        //lastly, append this 1 row to our table.
        table.appendChild(row);
    }
    //otherwise if not x, make the y axis.
    else{
        for (j=0; j<10; j++) {
            //create a new row.
            let row = document.createElement('tr');
            //append 1 column to that row to store a value.
            let column = document.createElement('td');
            //add the corresponding number.
            column.innerHTML = (j+1);
            //add this 1 column to this single row.
            row.appendChild(column);
            //append this row (with a column attached to it) to the 'table'.
            table.appendChild(row);
        }
        //this is essentially a 10x2 table with the [1] index of each row holding value.
    }
}

function markHits(board, elementId, surrenderText) {
    board.attacks.forEach((attack) => {
        let className;

        if (attack.result === "MISS"){
            className = "miss";
        }

        else if (attack.result === "HIT"){
            className = "hit";

        }
        else if (attack.result === "SUNK" || attack.result === "SURRENDER"){
             className = "hit";
             hasbroke1 = false;

             for(i = 0; i < 4; i++){
                 if(i == 0){
                    for(j =0; j <4; j++){
                       if(ship_one[j].row == attack.location.row && ship_one[j].column == attack.location.column){
                           for(k = 0; k < 5; k++){
                               if(ship_one[k].row != 11){
                                        column_sink = ship_one[k].column.charCodeAt(0);
                                        column_sink = column_sink-64;
                                        for(ship_looper =0; ship_looper < game.opponentsBoard.ships.length;ship_looper++){
                                            if(ship_names[0] == game.opponentsBoard.ships[ship_looper].kind){
                                                hasbroke1 = true;
                                            }
                                        }
                                        if(hasbroke1){
                                        break;
                                        }
                                    $('#opponent tr:nth-child(' + ship_one[k].row + ') td:nth-child(' + column_sink+ ')').addClass("sink");

                               }
                           }

                       }
                        if(hasbroke1){
                        break;
                        }
                    }

                 }

                 //DONE CHECKING SHIP ONE
                 if(i == 1){
                     for(j =0; j <4; j++){
                        if(ship_two[j].row == attack.location.row && ship_two[j].column == attack.location.column){
                            for(k = 0; k < 5; k++){
                                if(ship_two[k].row !=11){
                                   column_sink = ship_two[k].column.charCodeAt(0);
                                   column_sink = column_sink-64;
                                     for(ship_looper =0; ship_looper < game.opponentsBoard.ships.length;ship_looper++){
                                           if(ship_names[1] == game.opponentsBoard.ships[ship_looper].kind){

                                               hasbroke1 = true;
                                           }
                                       }
                                       if(hasbroke1){
                                       break;
                                       }
                                    $('#opponent tr:nth-child(' + ship_two[k].row + ') td:nth-child(' + column_sink+ ')').addClass("sink");


                                }


                            }

                        }
                         if(hasbroke1){
                            break;
                            }
                     }
                 }

                 //DONE CHECKING SHIP TWO
                 if(i == 2){
                    for(j =0; j <4; j++){
                        if(ship_three[j].row == attack.location.row && ship_three[j].column == attack.location.column){
                            for(k = 0; k < 5; k++){
                                if(ship_three[k].row != 11){
                                    column_sink = ship_three[k].column.charCodeAt(0);
                                    column_sink = column_sink-64;
                                       for(ship_looper =0; ship_looper < game.opponentsBoard.ships.length;ship_looper++){
                                           if(ship_names[2] == game.opponentsBoard.ships[ship_looper].kind){
                                               hasbroke1 = true;
                                           }
                                       }
                                       if(hasbroke1){
                                       break;
                                       }
                                    $('#opponent tr:nth-child(' + ship_three[k].row + ') td:nth-child(' + column_sink+ ')').addClass("sink");

                                }

                            }
                        }
                        if(hasbroke1){
                           break;
                           }
                    }
                 }
                //Checking last ship
                   if(i == 3){
                    for(j =0; j <4; j++){
                       if(ship_four[j].row == attack.location.row && ship_four[j].column == attack.location.column){
                           for(k = 0; k < 5; k++){
                               if(ship_four[k].row != 11){
                                        column_sink = ship_four[k].column.charCodeAt(0);
                                        column_sink = column_sink-64;
                                            for(ship_looper =0; ship_looper < game.opponentsBoard.ships.length;ship_looper++){
                                           if(ship_names[3] == game.opponentsBoard.ships[ship_looper].kind){
                                               hasbroke1 = true;
                                           }
                                       }
                                       if(hasbroke1){
                                       break;
                                       }
                                    $('#opponent tr:nth-child(' + ship_four[k].row + ') td:nth-child(' + column_sink+ ')').addClass("sink");


                               }
                           }
                       }
                       if(hasbroke1){
                          break;
                          }
                    }

                 }


             }

             if(attack.result === "SURRENDER"){
                  $("#hit_numb").text("Accuracy: " + accuracy + "%");
                  $("#sink_numb").text("Ships Sunk: " + ship_sunk );
                  $("#result_modal_box").show();
             }
        }
     document.getElementById(elementId).rows[attack.location.row-1].cells[attack.location.column.charCodeAt(0) - 'A'.charCodeAt(0)].classList.add(className);

    });
}

function redrawGrid() {
    Array.from(document.getElementById("opponent").childNodes).forEach((row) => row.remove());
    Array.from(document.getElementById("player").childNodes).forEach((row) => row.remove());
    makeGrid(document.getElementById("opponent"), false);
    makeGrid(document.getElementById("player"), true);
    if (game === undefined) {
        return;
    }

    game.playersBoard.ships.forEach((ship) => ship.occupiedSquares.forEach((square) => {
//        console.log(ship);
        document.getElementById("player").rows[square.row-1].cells[square.column.charCodeAt(0) - 'A'.charCodeAt(0)].classList.add("occupied");
    }));
 

    ///////////////// DEBUGGING ////////////////////////////////////////////////////////

    
     // used for debugging (it shows enemy ship locations)
 //    game.opponentsBoard.ships.forEach((ship) => ship.occupiedSquares.forEach((square) => {
 //        console.log(ship);

 //        document.getElementById("opponent").rows[square.row-1].cells[square.column.charCodeAt(0) - 'A'.charCodeAt(0)].classList.add("occupied");
 //    }));
    
//     // used for debugging (it shows user ship locations)
//     game.playersBoard.ships.forEach((ship) => ship.occupiedSquares.forEach((square) => {
//     //        console.log(ship);
//
//         document.getElementById("opponent").rows[square.row-1].cells[square.column.charCodeAt(0) - 'A'.charCodeAt(0)].classList.add("debug_player");
//     }));
    
    
    ///////////////// END DEBUGGING ////////////////////////////////////////////////////


    // draw in sonar squares from sonar square array
    game.opponentsBoard.sonarSquares.forEach((square) => {
//        console.log(square);

        document.getElementById("opponent").rows[square.row-1].cells[square.column.charCodeAt(0) - 'A'.charCodeAt(0)].classList.add("scanned");
    });

    // check if the sonar pulse found opponent ships
    game.opponentsBoard.ships.forEach((ship) => ship.occupiedSquares.forEach((square) => game.opponentsBoard.sonarSquares.forEach((sonarSquare) => {
        if ((square.column.charCodeAt(0) - 'A'.charCodeAt(0) === sonarSquare.column.charCodeAt(0) - 'A'.charCodeAt(0)) && square.row === sonarSquare.row){
//          console.log("highlighting ships in pulse");

            // if the square is the captains quarters, then show the ship location
            if (square.is_captain !== true){
//                console.log("not captain quarters");
                document.getElementById("opponent").rows[square.row-1].cells[square.column.charCodeAt(0) - 'A'.charCodeAt(0)].classList.remove("scanned");
                document.getElementById("opponent").rows[square.row-1].cells[square.column.charCodeAt(0) - 'A'.charCodeAt(0)].classList.add("occupied");
            }
            // otherwise, leave the captains quarters square as scanned (not shown)
        }
    })));
    if(sonar_uses == 1){
        sonar_index = game.opponentsBoard.sonarSquares.length;
    }
    markHits(game.opponentsBoard, "opponent", "You won the game");
    markHits(game.playersBoard, "player", "You lost the game");
}

//A function that refreshes the page if the user wants to play another game
function refreshPage(){
    window.location.reload();
}

// added a parameter to handle different types of boards (needed for sonar pulse hover)
var oldListener;
function registerCellListener(f, board) {
    let el = document.getElementById(board);
    if (el != undefined) {
        for (i=0; i<10; i++) {
            for (j=0; j<10; j++) {
                let cell = el.rows[i].cells[j];
                cell.removeEventListener("mouseover", oldListener);
                cell.removeEventListener("mouseout", oldListener);
                cell.addEventListener("mouseover", f);
                cell.addEventListener("mouseout", f);
            }
        }
    }
    oldListener = f;
}


function place_ship_call_back(data){
    game = data;
    redrawGrid();
    //ship has been added
    placedShips++;
    if (placedShips == 4) {
        isSetup = false;
        registerCellListener((e) => {});
    }
}

function sonar_call_back(data){
// reset isSonar variable to false again (so in normal attack mode)
    isSonar = false;
    game = data;
    redrawGrid();

    sonar_uses++;
    if (sonar_uses == 2){
        $("#sonar_button_box").hide();
    }
    else{
        //restore the button back to popped up state
        $("#sonar_button_box").css("opacity", 1);
        sonar_clicked_down = false;
    }
}

function move_fleet_call_back(data){
// reset isMoveFleet variable to false again (so in normal attack mode)
    isMoveFleet = false;
    game = data;
    redrawGrid();

    move_fleet_uses++;
    if(move_fleet_uses == 2){
        $("#move_fleet_box").hide();
    }
    else{
        //restore the button back to popped up state
        $("#up_image").css("opacity", 1);
        $("#right_image").css("opacity", 1);
        $("#down_image").css("opacity", 1);
        $("#left_image").css("opacity", 1);
        move_fleet_clicked_down = false;
    }
}

//visually handle a miss in the attack call_back
function visual_handle_miss(){
    $("#opponent_hit_feedback").hide();
    $("#opponent_sunk_feedback").hide();
    $("#opponent_feedback").show();
    $("#opponent_miss_feedback").show();
}

function visual_handle_hit(){
    $("#opponent_miss_feedback").hide();
    $("#opponent_sunk_feedback").hide();
    $("#opponent_feedback").show();
    $("#opponent_hit_feedback").show();
}

function visual_handle_sunk(){
    $("#opponent_miss_feedback").hide();
    $("#opponent_hit_feedback").hide();
    $("#opponent_feedback").show();
    $("#opponent_sunk_feedback").show();
}

function visual_handle_surrender(){

     accuracy = hit_count/shot_count;
     accuracy = accuracy * 100;
     accuracy = accuracy.toFixed(2);
     $("#end_modal_loss_message").show();
}
//handle the outcome of the attack for the player
function handle_players_post_attack(data){
   //if the opponent misses their attack
   if(data.playersBoard.attacks[(data.playersBoard.attacks.length)-1].result === "MISS"){
        visual_handle_miss();
   }
   //if the opponent hits your ship with their attack
   if(data.playersBoard.attacks[(data.playersBoard.attacks.length)-1].result === "HIT"){
        visual_handle_hit();
   }
   //if the opponent sinks your ship with their attack
   if(data.playersBoard.attacks[(data.playersBoard.attacks.length)-1].result === "SUNK"){
        visual_handle_sunk();
   }
   if(data.playersBoard.attacks[(data.playersBoard.attacks.length)-1].result === "SURRENDER"){              //If the user loses the game display the modal
        visual_handle_surrender();
   }
}

function handle_opponent_post_attack(data){
    
    if(data.opponentsBoard.attacks[(data.opponentsBoard.attacks.length)-1].result === "MISS"){      //If we just missed then we only increase our number of turns
       shot_count = data.opponentsBoard.attacks.length;
    }
    else if(data.opponentsBoard.attacks[(data.opponentsBoard.attacks.length)-1].result === "HIT") {  //If we hit them, our turns increases and our number of hits increases by 1
       shot_count = data.opponentsBoard.attacks.length;
       hit_count++;
    }
    else if(data.opponentsBoard.attacks[(data.opponentsBoard.attacks.length)-1].result === "SUNK") {    //If we sink a ship, that means we increase our hits by 1, our sunk ships by 1, and our turns by 1
        shot_count = data.opponentsBoard.attacks.length;
        hit_count++;
        ship_sunk++;
//         console.log("ship_sunk: ");
//         console.log(ship_sunk);
        if (sonar_uses < 2){
            $("#sonar_button_box").show();
        }
        if (ship_sunk > 1 && move_fleet_uses < 2){
            $("#move_fleet_box").show();
        }
        $("#code_input").show();
    }
    else if(data.opponentsBoard.attacks[(data.opponentsBoard.attacks.length)-1].result === "SURRENDER"){    //this is the situation if the user wins the game, we show the modal with the current stats
               hit_count++;
//               ship_sunk++;
//                console.log("ship_sunk: ");
//                console.log(ship_sunk);
               shot_count++;
//               console.log(shot_count);
//               console.log(hit_count);
               accuracy = hit_count/(shot_count-4);
               accuracy = accuracy * 100;
               accuracy = accuracy.toFixed(2);
               $("#end_modal_win_message").show();
    }

    if (laser_mode){
    if(data.opponentsBoard.attacks[(data.opponentsBoard.attacks.length)-2].result === "MISS"){      //If we just missed then we only increase our number of turns
           shot_count = data.opponentsBoard.attacks.length;
        }
        else if(data.opponentsBoard.attacks[(data.opponentsBoard.attacks.length)-2].result === "HIT") {  //If we hit them, our turns increases and our number of hits increases by 1
           shot_count = data.opponentsBoard.attacks.length;
           hit_count++;
        }
        else if(data.opponentsBoard.attacks[(data.opponentsBoard.attacks.length)-2].result === "SUNK") {    //If we sink a ship, that means we increase our hits by 1, our sunk ships by 1, and our turns by 1
            shot_count = data.opponentsBoard.attacks.length;
            hit_count++;
            ship_sunk++;
//             console.log("ship_sunk: ");
//             console.log(ship_sunk);
            if (sonar_uses < 2){
                $("#sonar_button_box").show();
            }
            if (ship_sunk > 1 && move_fleet_uses < 2){
                $("#move_fleet_box").show();
            }
            $("#code_input").show();
        }
        else if(data.opponentsBoard.attacks[(data.opponentsBoard.attacks.length)-2].result === "SURRENDER"){    //this is the situation if the user wins the game, we show the modal with the current stats
                   hit_count++;
                   ship_sunk++;
//                    console.log("ship_sunk: ");
//                    console.log(ship_sunk);
                   shot_count++;
//                   console.log(shot_count);
//                   console.log(hit_count);
                   accuracy = hit_count/(shot_count-4);
                   accuracy = accuracy * 100;
                   accuracy = accuracy.toFixed(2);
                   $("#end_modal_win_message").show();
        }
    }
}

function attack_call_back(data){
   game = data;
    handle_players_post_attack(data)
    handle_opponent_post_attack(data);
    redrawGrid();
}

function cellClick() {
    let row = this.parentNode.rowIndex + 1;
    let col = String.fromCharCode(this.cellIndex + 65);
    under = document.getElementById("is_under").checked;
    if (isSetup) {
        if(under){
              sendXhr("POST", "/place_sub", {game: game, shipType: shipType, x: row, y: col,isUnder: under, isVertical: vertical}, function(data) {
                    place_ship_call_back(data);
                    document.getElementById("is_under").checked = false;
                });
        }
        else{
            sendXhr("POST", "/place", {game: game, shipType: shipType, x: row, y: col, isVertical: vertical}, function(data) {
                    place_ship_call_back(data);
                });
        }

    }
    // if isSonar variable is triggered (will be triggered in sonar_attack func, when sonar mode is activated)
    else if (isSonar) {
        sendXhr("POST", "/sonar", {game: game, x: row, y: col}, function(data){
            sonar_call_back(data);
        });
    }
    // moving fleet
    else if (isMoveFleet) {
        sendXhr("POST", "/move_fleet", {game: game, d: direction}, function(data) {
            move_fleet_call_back(data);
        });
    }
    else {//is attack
        if(!laser_mode){
            sendXhr("POST", "/attack", {game: game, x: row, y: col}, function(data) {
                attack_call_back(data);
            });
        }
        else{//if laser mode is engaged!!!
            sendXhr("POST", "/laser_attack", {game: game, x: row, y: col}, function(data) {
                attack_call_back(data);
            });
        }
    }
}

function sendXhr(method, url, data, handler) {
    var req = new XMLHttpRequest();
    req.addEventListener("load", function(event) {
        if (req.status != 200) {
            if(placedShips < 4){ //placement stage
                $("#placement_error").hide();
                $("#attacking_error").hide();
                $("#placement_error").show().delay(8000).fadeOut();
            }
            else{//if 3 ships were placed: attacking phase
                $("#placement_error").hide();
                $("#attacking_error").hide();
                $("#attacking_error").show().delay(6000).fadeOut();
            }
            return;
        }
        handler(JSON.parse(req.responseText));
    });
    req.open(method, url);
    req.setRequestHeader("Content-Type", "application/json");
    req.send(JSON.stringify(data));
}

function place(size) {
    return function() {
        let row = this.parentNode.rowIndex;
        let col = this.cellIndex;
        vertical = document.getElementById("is_vertical").checked;
        let table = document.getElementById("player");
        if(size != 5){

            for (let i=0; i<size; i++) {
                let cell;
                if(vertical) {
                    let tableRow = table.rows[row+i];
                    if (tableRow === undefined) {
                        // ship is over the edge; let the back end deal with it
                        break;
                    }

                    cell = tableRow.cells[col];
                } else {
                    cell = table.rows[row].cells[col+i];
                }
                if (cell === undefined) {
                    // ship is over the edge; let the back end deal with it
                    break;
                }
                cell.classList.toggle("placed");
            }
        }
        else{
            //we know its a submarine now
            for (let i=0; i<size-1; i++) {
                let cell;
                if(vertical) {
                    let tableRow = table.rows[row+i];
                if (tableRow === undefined) {
                    // ship is over the edge; let the back end deal with it
                    break;
                }

                cell = tableRow.cells[col];
                } else {
                    cell = table.rows[row].cells[col+i];
                }
                if (cell === undefined) {
                    // ship is over the edge; let the back end deal with it
                    break;
                }
                cell.classList.toggle("placed");
            }
            // add protrusion
            let cell;
            if (vertical) {
                if (table.rows[row+2] !== undefined && table.rows[row+2].cells[col+1] !== undefined) {
                    cell = table.rows[row+2].cells[col+1];
                    cell.classList.toggle("placed");
                }
            }
            else {
                if (table.rows[row-1] !== undefined && table.rows[row-1].cells[col+2] !== undefined) {
                    cell = table.rows[row-1].cells[col+2];
                    cell.classList.toggle("placed");
                }
            }

          }
        
        
    }
}

//triggered once player clicks continue on modal (accepts moving onto the attack phase).
function set_up_player_fleet() {
       /////////SET UP FLEET ////////////////
        //Note: 'game' is global.
            //now we know we've set 3
            //initialize the players fleet using the ShipList the player has built up (in the game object).
        var submerged =0;
        for(a =0; a< game.playersBoard.ships.length; a++) {
            //assume ship is NOT submerged initially
            submerged =0;
            //for every ship lets construct a DOM element: table, to represent it.
            ship_table = document.createElement("table");
            //set the class as a ship within the fleet
            ship_table.setAttribute("class", "fleet_ship");
            //set the id to be the type of the fleet_ship that ship is (current ship in the list).
            ship_table.setAttribute("id", game.playersBoard.ships[a].kind);
             //create a 'row' for the table so we can start appending on columns, to grow the table...
            ship_table_row = document.createElement("tr");
             //begin adding columns for the size of the ship being looked at (all of its occupied squares).
            //we're assuming here that the size of the ship == # of occupied squares.
            //if the current ship we are looking at is submerged submarine
            if(game.playersBoard.ships[a].occupiedSquares[0].submerged == true){
                submerged = 1;  //added this logic for readability...
            }
             for(i =0; i< game.playersBoard.ships[a].occupiedSquares.length; i++) {
                //create a column for the current box of the ship's length...
                column = document.createElement("td");
                 //set this box's (columns on the ship 'table') coordinates so we can easily mark it upon hit.
                column.setAttribute("class", "fleet_square");
                column.setAttribute("data-row", game.playersBoard.ships[a].occupiedSquares[i].row);
                column.setAttribute("data-column", game.playersBoard.ships[a].occupiedSquares[i].column);
                column.setAttribute("data-hit", 0); //set this square as not being hit
                //if this ship has its occupied squares submerged, set all of its fleet squares to submerged
                if(submerged){
                    column.setAttribute("data-submerged", 1); //set this square as submerged
                }
                else{
                    column.setAttribute("data-submerged", 0); //set this square as submerged
                }
                ship_table_row.appendChild(column);
            }
            //take that row that we souped up, and now just tack it onto the current ship-table.
            ship_table.appendChild(ship_table_row);
             //now that this ship-table is all set up for this current ship in the fleet, lets append it to the div.
            document.getElementById('players_fleet').appendChild(ship_table);
             //make the label to go next to it.
            label_div = document.createElement("div");
            label_div.setAttribute("class", "label_div");
             //now add the label text to go inside the label's container.
            //set the label's text to be the ship's ID
            label_div.innerHTML = ship_table.id;
             //append the label
            document.getElementById('ship_labels').appendChild(label_div);
        }
}
function update_players_fleet() {
    return;
}

function showInstructions(){
    $("#how_to_play_box").show();
}

function hideInstructions(){
    $("#how_to_play_box").hide();
}

function handle_sonar_exceptions(i, j){
    if (i === 0 && j === 0 || i === 1 && j === 0 || i === 3 && j === 0 || i === 4 && j === 0){
        return 1;
    }
    // middle second and fourth row
    if (i === 0 && j === 1 || i === 4 && j === 1 || i === 0 && j === 3 || i === 4 && j === 3){
        return 1;
    }
    // bottom row
    if (i === 0 && j === 4 || i === 1 && j === 4 || i === 3 && j === 4 || i === 4 && j === 4){
        return 1;
    }

    return 0;
}

// implemented just like the place(ship) function
// just hovers over different cells
// used when sonar button is clicked
function sonar_pulse_hover() {
    return function() {
        let row = this.parentNode.rowIndex;
        let col = this.cellIndex;
        let table = document.getElementById("opponent");
        let i;
        let j;
        if(isSonar){
            // make a 5x5 grid
            for (i=0; i<5; i++) {
                for (j=0; j<5; j++){
                    // have if statements for the corners to not include on hover
                    // top row
                    if(handle_sonar_exceptions(i, j)){
                        continue;
                    }
                    let cell;
                    // check for when cursor is at edge of board
                    if (table.rows[row - 2 + j] === undefined){
                        continue;
                    }
                    if (table.rows[row - 2 + j].cells[col - 2 + i] === undefined){
                        continue;
                    }
                    // it starts hovering as if the cell is left and up two spaces, then does a 5x5 grid
                    // (that's why i and j go up to 4 above)
                    cell = table.rows[row - 2 + j].cells[col - 2 + i];
    //                console.log(cell);
                    cell.classList.toggle("placed");
                }
            }
         }
    }
}

// function for when sonar is clicked
function sonar_attack(){
    //toggle the sonar clicked down indicator
    if(!sonar_clicked_down){
        sonar_clicked_down = true;
        $("#sonar_button_box").css("opacity", 0.25);
    }
    else{
        sonar_clicked_down = false;
        $("#sonar_button_box").css("opacity", 1);
    }

    //now assess the status and react accordingly
    if(sonar_clicked_down){
        //prepare for the sonar usage DONT increment usage yet, since player can back out
        // actual functionality
        // trigger isSonar variable to enter sonar pulse mode (instead of normal attack mode)
        isSonar = true;
        // since sonar is clicked, call cell listener with specific data for sonar mode hover
        registerCellListener(sonar_pulse_hover(), "opponent");
    }
    else{
        //if the user decides to back out and they make clicked_down false
        //reverse what event handlers were potentially added
        isSonar = false;
       // removeCellListener(sonar_pulse_hover(), "opponent");
    }
}

document.getElementById("move_fleet_up").onclick = function() {move_fleet_up()};
document.getElementById("move_fleet_right").onclick = function() {move_fleet_right()};
document.getElementById("move_fleet_down").onclick = function() {move_fleet_down()};
document.getElementById("move_fleet_left").onclick = function() {move_fleet_left()};

function move_fleet_up(){

    direction = 1;

    if(!move_fleet_clicked_down){
        move_fleet_clicked_down = true;
        $("#up_image").css("opacity", 0.25);
    }
    else{
        move_fleet_clicked_down = false;
        $("#up_image").css("opacity", 1);
    }

    if(move_fleet_clicked_down){
        isMoveFleet = true;
    }
    else{
        isMoveFleet = false;
    }
}

function move_fleet_right(){

    direction = 2;

    if(!move_fleet_clicked_down){
        move_fleet_clicked_down = true;
        $("#right_image").css("opacity", 0.25);
    }
    else{
        move_fleet_clicked_down = false;
        $("#right_image").css("opacity", 1);
    }

    if(move_fleet_clicked_down){
        isMoveFleet = true;
    }
    else{
        isMoveFleet = false;
    }
}

function move_fleet_down(){

    direction = 3;

    if(!move_fleet_clicked_down){
        move_fleet_clicked_down = true;
        $("#down_image").css("opacity", 0.25);
    }
    else{
        move_fleet_clicked_down = false;
        $("#down_image").css("opacity", 1);
    }

    if(move_fleet_clicked_down){
        isMoveFleet = true;
    }
    else{
        isMoveFleet = false;
    }
}

function move_fleet_left(){

    direction = 4;

    if(!move_fleet_clicked_down){
        move_fleet_clicked_down = true;
        $("#left_image").css("opacity", 0.25);
    }
    else{
        move_fleet_clicked_down = false;
        $("#left_image").css("opacity", 1);
    }

    if(move_fleet_clicked_down){
        isMoveFleet = true;
    }
    else{
        isMoveFleet = false;
    }
}

//DONE ADDING FUNCTIONS

$("#submit_code").click(function(){
    console.log("ani");
    if($("#code_input_box").val() == activation_code){
        laser_mode = true;
        //add the placeholder
        $("#code_input_box").attr("placeholder", "CODE ACCEPTED");
        $("#code_input_box").val(''); //thought this code was effective, might delete later idk

        //POTENTIAL POPUP SHOWN HERE
    }
    else{
        $("#code_input_box").attr("placeholder", "CODE REJECTED");
        $("#code_input_box").val('');
        //POTENTIAL POPUP SHOWN HERE
    }
});

function visually_init_game(){
    //hide the opponents board upon initialization, so user can place ships on own board
   // $('#opponent').hide();
    $('#move_to_attack_mode_prompt').hide();
    $('#attack_title').hide();
    $('#opponents_title').hide();
    $('#attack_dashboard').hide();
    $('#your_fleet_label').hide();
    $("#result_modal_box").hide();
    $("#how_to_play_box").hide();
    $("#placement_error").hide();
    $("#attacking_error").hide();
    $("#end_modal_win_message").hide();
    $("#end_modal_loss_message").hide();
    $("#opponent_feedback").hide();
    $("#opponent_miss_feedback").hide();
    $("#opponent_hit_feedback").hide();
    $("#opponent_sunk_feedback").hide();
    $("#sonar_button_box").hide();
    $("#under_box").hide();
    $("#move_fleet_box").hide();
    $("#code_input").hide();
}

function move_to_attack_mode(){
    set_up_player_fleet();

    //now we know we've set 3
    $('#move_to_attack_mode_prompt').hide();
    $('#opponent').show();
    //$('#player').hide();

    //Switch the board owner's title
    $('#your_title').hide();
    $('#opponents_title').show();

    //SHOW ATTACK LABEL/BANNER NOW: ATTACK PHASE.
    $('#setup_title').hide();
    $('#attack_title').show();

    //hide placement button suite...
    $('.buttons').hide();

    //MOVE PLAYERS GRID DOWN TO REPLACE OG FLEET
    $('#player').addClass("move_player_down");
    $('#your_fleet_label').show();
}
$('#move_to_attack_mode_button').click(function(){
    move_to_attack_mode();
});

function init_ships_squares_from_board(){
     for(j=0; j< game.opponentsBoard.ships[0].occupiedSquares.length; j++){
          ship_one[j].row = game.opponentsBoard.ships[0].occupiedSquares[j].row;
           ship_one[j].column = game.opponentsBoard.ships[0].occupiedSquares[j].column;
     }

     for(j=0; j< game.opponentsBoard.ships[1].occupiedSquares.length; j++){
         ship_two[j].row = game.opponentsBoard.ships[1].occupiedSquares[j].row;
         ship_two[j].column = game.opponentsBoard.ships[1].occupiedSquares[j].column;
     }

     for(j=0; j< game.opponentsBoard.ships[2].occupiedSquares.length; j++){
           ship_three[j].row = game.opponentsBoard.ships[2].occupiedSquares[j].row;
           ship_three[j].column = game.opponentsBoard.ships[2].occupiedSquares[j].column;
     }
      for(j=0; j< game.opponentsBoard.ships[3].occupiedSquares.length; j++){
                ship_four[j].row = game.opponentsBoard.ships[3].occupiedSquares[j].row;
                ship_four[j].column = game.opponentsBoard.ships[3].occupiedSquares[j].column;
          }
}

function attack_mode(){
    if(placedShips == 4 && !entered_attack_mode){
        entered_attack_mode = 1;
        //Adding ships to initial array
           init_ships_squares_from_board();

           //SHIP ONE NAME
           if(ship_one[2].row == 11){
             ship_names[0] = "MINESWEEPER";
           }
           else if(ship_one[3].row == 11){
             ship_names[0] = "DESTROYER";
           }
           else if(ship_one[4].row == 11) {
            ship_names[0] = "BATTLESHIP";
           }
           else {
            ship_names[0] = "SUBMARINE";
           }
        //SHIP TWO NAME
        if(ship_two[2].row == 11){
         ship_names[1] = "MINESWEEPER";
         }
        else if(ship_two[3].row == 11){
         ship_names[1] = "DESTROYER";
         }
        else if(ship_two[4].row == 11) {
         ship_names[1] = "BATTLESHIP";
        }
        else {
            ship_names[1] = "SUBMARINE";
           }
        //SHIP THREE NAME
       if(ship_three[2].row == 11){
       ship_names[2] = "MINESWEEPER";
       }
       else if(ship_three[3].row == 11){
       ship_names[2] = "DESTROYER";
       }
       else if(ship_three[4].row == 11){
        ship_names[2] = "BATTLESHIP";
       }
       else {
         ship_names[2] = "SUBMARINE";
            }
       //SHIP FOUR NAME
       if(ship_four[2].row == 11){
          ship_names[3] = "MINESWEEPER";
          }
       else if(ship_four[3].row == 11){
           ship_names[3] = "DESTROYER";
       }
       else if(ship_four[4].row == 11){
        ship_names[3] = "BATTLESHIP";
       }
       else{
           ship_names[3] = "SUBMARINE";
       }

        $('#move_to_attack_mode_prompt').show();
    }
}
//function to generate random code
function makeid() {
    var text = "";
    var bank = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    for (var i = 0; i < 8; i++){
        text += bank.charAt(Math.floor(Math.random() * bank.length));
        if(i == 2 || i == 5){
            text += '-';
        }
    }
    console.log(text);
    activation_code = text;
    $("#actual_code").text("Code: " + activation_code);
}

function initGame() {
    //initialize the game visually
    visually_init_game();

    makeGrid(document.getElementById("opponent"), false);
    makeGrid(document.getElementById("player"), true);

    //create the axes
    makeAxis(document.getElementById("x_axis"), true); //x axis
    makeAxis(document.getElementById("y_axis"), false); //y axis

    document.getElementById("place_minesweeper").addEventListener("click", function(e) {
        shipType = "MINESWEEPER";
       registerCellListener(place(2), "player");
       $("#under_box").hide();
    });
    document.getElementById("place_destroyer").addEventListener("click", function(e) {
        shipType = "DESTROYER";
       registerCellListener(place(3), "player");
       $("#under_box").hide();
    });
    document.getElementById("place_battleship").addEventListener("click", function(e) {
        shipType = "BATTLESHIP";
        registerCellListener(place(4), "player");
        $("#under_box").hide();
    });
     document.getElementById("place_submarine").addEventListener("click", function(e) {
            shipType = "SUBMARINE";
           registerCellListener(place(5), "player");
           $("#under_box").show();
        });

    sendXhr("GET", "/game", {}, function(data) {
        game = data;
    });

    makeid();

    window.setInterval(attack_mode, 150);
}
