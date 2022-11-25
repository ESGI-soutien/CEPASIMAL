import Attack.Attack;
import Game.Game;
import Player.Player;

import java.util.*;

import static UI.UI.*;

public class Main {
  public static void main(String[] args) {
    final Player mario = new Player("Mario", 100, List.of(
      new Attack("Punch", 25),
      new Attack("Slap", 10)
    ));
    final Player luigi = new Player("Luigi", 100, List.of(
      new Attack("Punch", 25),
      new Attack("Headbutt", 15)
    ));

    Game game = new Game();
    Boolean hasFightStarted = game.fightBetween(mario, luigi);
    if (!hasFightStarted) printNoFight();
  }

}