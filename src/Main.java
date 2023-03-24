import Attack.Attack;
import Bot.HardBot;
import Fighter.Fighter;
import Game.Game;
import Player.Player;

import java.util.List;

import static UI.UI.printNoFight;

public class Main {
  public static void main(String[] args) {
    final Player mario = new Player(
      "Mario",
      100,
      List.of(
        new Attack("Punch", 94),
        new Attack("Slap", 40)
      ),
      1.6f,
      0.3f,
      50
    );

//    final Player luigi = new Player(
//      "Luigi",
//      100,
//      List.of(
//        new Attack("Punch", 25),
//        new Attack("Headbutt", 15)
//      ),
//      1.3f,
//      0.5f,
//      70
//    );

//    final Fighter bot = new EasyBot(
//            "EasyBot",
//      100,
//      List.of(),
//      1.3f,
//      0.5f,
//      1
//    );

//    final Fighter bot = new NormalBot(
//      "NormalBot",
//      100,
//      List.of(
//        new Attack("Punch", 25),
//        new Attack("Slap", 10)
//      ),
//      1.3f,
//      0.5f,
//      1
//    );

    final Fighter bot = new HardBot(
      "HardBot",
      100,
      List.of(
        new Attack("Punch", 25),
        new Attack("Slap", 10)
      ),
      1.3f,
      0.5f,
      1
    );

    final Game game = new Game();
    final boolean hasFightStarted = game.fightBetween(mario, bot);
    if (!hasFightStarted) printNoFight();
  }

}