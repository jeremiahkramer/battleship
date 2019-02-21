package controllers;

import com.google.inject.Singleton;
import cs361.battleships.models.Game;
import cs361.battleships.models.Ship;
import ninja.Context;
import ninja.Result;
import ninja.Results;

@Singleton
public class ApplicationController {

    public Result index() {
        return Results.html();
    }

    public Result newGame() {
        Game g = new Game();
        return Results.json().render(g);
    }

    public Result placeShip(Context context, PlacementGameAction g) {
        Game game = g.getGame();
        Ship ship = new Ship(g.getShipType());
        boolean result = game.placeShip(ship, g.getActionRow(), g.getActionColumn(), g.isVertical());
        if (result) {
            return Results.json().render(game);
        } else {
            return Results.badRequest();
        }
    }

    public Result attack(Context context, AttackGameAction g) {
        Game game = g.getGame();
        boolean result = game.attack(g.getActionRow(), g.getActionColumn());
        if (result) {
            return Results.json().render(game);
        } else {
            return Results.badRequest();
        }
    }

    // same as attack mode except pass in SonarPulseGameAction controller
    public Result sonar_attack(Context context, SonarPulseGameAction g) {
        Game game = g.getGame();
        boolean result = game.sonar_attack(g.getActionRow(), g.getActionColumn());
        if (result) {
            return Results.json().render(game);
        } else {
            return Results.badRequest();
        }
    }

    public static Result place_sub(Context context, PlacementGameActionSub g) {
        Game game = g.getGame();
        Ship ship = new Ship(g.getShipType());
        boolean result = game.place_sub(ship, g.getActionRow(), g.getActionColumn(),g.isUnder(), g.isVertical());
        if (result) {
            return Results.json().render(game);
        } else {
            return Results.badRequest();
        }
    }

    public static Result laser_attack(Context context, LaserAttackGameAction g) {
        Game game = g.getGame();
        boolean result = game.laser_attack(g.getActionRow(), g.getActionColumn());
        if (result) {
            return Results.json().render(game);
        } else {
            return Results.badRequest();
        }
    }
    
    public Result move_fleet (Context context, MoveFleetGameAction g) {
        Game game = g.getGame();
        boolean result = game.move_fleet(g.getActionDirection());
        if (result) {
            return Results.json().render(game);
        } else {
            return Results.badRequest();
        }
    }
}
