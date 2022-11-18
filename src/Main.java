import Attack.Attack;
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

    Boolean hasFightStarted = fightBetween(mario, luigi);
    if (!hasFightStarted) printNoFight();
  }

  static Player getWinner(Player p1, Player p2) {
    if (p1.getHP() <= 0 && p2.getHP() > 0) return p2;
    if (p2.getHP() <= 0 && p1.getHP() > 0) return p1;

    return null;
  }

  static Boolean fightBetween(Player p1, Player p2) {
    if (p1 == null || p2 == null) return false;
    if (p1.getHP() <= 0 || p2.getHP() <= 0) return false;

    handleTurns(p1, p2);
    return true;
  }

  static void handleTurns(Player p1, Player p2) {
    Boolean isAnyPlayerDead = p1.getHP() <= 0 || p2.getHP() <= 0;
    Boolean isGameOver = isAnyPlayerDead;
    int turnCounter = 1;
    Player currentPlayer;
    Player otherPlayer;
    final List<String> actions = List.of("Flee", "Analyze", "Attack");
    final List<Player> players = List.of(p1, p2);

    Player winner = null;

    while (!isGameOver) {
      printPlayersInfo(players);

      if (turnCounter % 2 == 1) {
        currentPlayer = p1;
        otherPlayer = p2;
      } else {
        currentPlayer = p2;
        otherPlayer = p1;
      }

      final Scanner scanner = new Scanner(System.in);
      int choice;

      try {
        printActions(currentPlayer, actions);

        choice = scanner.nextInt();
        if (choice < 0 || choice >= actions.size()) {
          printInvalidChoice(currentPlayer);
          continue;
        } else if (choice == 0) {
          System.out.println("🏃 " + currentPlayer.getName() + " has run away.");
          winner = otherPlayer;
          printWinner(winner);
          return;
        } else if (choice == 1) {
          printPlayerInfo(otherPlayer);
          continue;
        }

        printPlayerAttacks(currentPlayer);

        if (currentPlayer.getAttacks().size() == 0) {
          turnCounter++;
          continue;
        }

        choice = scanner.nextInt();
        if (choice <= 0 || choice > currentPlayer.getAttacks().size()) {
          printInvalidChoice(currentPlayer);
          continue;
        }

        currentPlayer.attack(otherPlayer, currentPlayer.getAttacks().get(choice - 1));
        turnCounter++;
      } catch (Exception e) {
        printException(e);
      }

      isAnyPlayerDead = currentPlayer.getHP() <= 0 || otherPlayer.getHP() <= 0;
      isGameOver = isAnyPlayerDead;

      if (isAnyPlayerDead) {
        winner = getWinner(currentPlayer, otherPlayer);
      }
    }

    printWinner(winner);
  }

}