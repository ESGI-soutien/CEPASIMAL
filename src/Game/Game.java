package Game;

import Player.Player;
import Player.AttackResult;

import java.util.List;
import java.util.Scanner;

import static UI.UI.*;

public class Game {

  private Player getWinner(Player p1, Player p2) {
    if (p1.getHP() <= 0 && p2.getHP() > 0) return p2;
    if (p2.getHP() <= 0 && p1.getHP() > 0) return p1;

    return null;
  }

  public Boolean fightBetween(Player p1, Player p2) {
    if (p1 == null || p2 == null) return false;
    if (p1.getHP() <= 0 || p2.getHP() <= 0) return false;

    handleTurns(p1, p2);
    return true;
  }

  private void handleTurns(Player p1, Player p2) {
    Boolean isAnyPlayerDead = p1.getHP() <= 0 || p2.getHP() <= 0;
    Boolean isGameOver = isAnyPlayerDead;

    Player currentPlayer = p1.getSpeed() >= p2.getSpeed() ? p1 : p2;
    Player otherPlayer = currentPlayer == p1 ? p2 : p1;
    Player tempPlayer;
    Player winner = null;
    final List<String> actions = List.of("Flee", "Analyze", "Attack", "Heal");

    while (!isGameOver) {
      printPlayersInfo(List.of(p1, p2));

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
        } else if (choice == 3) {
          if (currentPlayer.getRemainingPotionQuantity() <= 0) {
            printNoPotion();
          } else {
            currentPlayer.drinkPotion();
          }

          continue;
        }

        printPlayerAttacks(currentPlayer);

        if (currentPlayer.getAttacks().size() == 0) {
          tempPlayer = currentPlayer;
          currentPlayer = otherPlayer;
          otherPlayer = tempPlayer;
          continue;
        }

        choice = scanner.nextInt();
        if (choice <= 0 || choice > currentPlayer.getAttacks().size()) {
          printInvalidChoice(currentPlayer);
          continue;
        }

        AttackResult attackResult = currentPlayer.attack(currentPlayer, choice, otherPlayer);
        if (attackResult == AttackResult.CRITICAL) {
          System.out.println("Critical strike!");
        } else if (attackResult == AttackResult.FAILURE) {
          System.out.println("The attack failed.");
        }

        tempPlayer = currentPlayer;
        currentPlayer = otherPlayer;
        otherPlayer = tempPlayer;
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