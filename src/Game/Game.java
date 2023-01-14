package Game;

import Player.Player;
import Player.AttackResult;
import Player.PlayerAction;

import java.util.List;
import java.util.Scanner;

import static UI.UI.*;

public class Game {

  private Player getWinner(Player p1, Player p2) {
    if (p1.getHP() <= 0 && p2.getHP() > 0) return p2;
    if (p2.getHP() <= 0 && p1.getHP() > 0) return p1;

    return null;
  }

  public boolean fightBetween(Player p1, Player p2) {
    if (p1 == null || p2 == null) return false;
    if (getWinner(p1, p2) != null) return false;

    handleTurns(p1, p2);
    return true;
  }

  private void handleTurns(Player p1, Player p2) {
//    boolean isAnyPlayerDead = p1.getHP() <= 0 || p2.getHP() <= 0;

    Player currentPlayer = p1.getSpeed() >= p2.getSpeed() ? p1 : p2;
    Player otherPlayer = currentPlayer == p1 ? p2 : p1;
    Player tempPlayer;
    Player winner = null;
    final List<String> actions = List.of(
      PlayerAction.FLEE.getAction(),
      PlayerAction.ANALYZE.getAction(),
      PlayerAction.ATTACK.getAction(),
      PlayerAction.HEAL.getAction()
    );

    boolean isGameOver = false;
    while (!isGameOver) {
      printPlayersInfo(List.of(p1, p2));

      final Scanner scanner = new Scanner(System.in);

      try {
        printActions(currentPlayer, actions);

        String choice = scanner.next().trim();
        if (actions.stream().noneMatch(choice::equalsIgnoreCase)) {
          printInvalidChoice(currentPlayer);
          continue;
        } else if (choice.equalsIgnoreCase(PlayerAction.FLEE.toString())) {
          System.out.println("🏃 " + currentPlayer.getName() + " has run away.");
          winner = otherPlayer;
          printWinner(winner);
          return;
        } else if (choice.equalsIgnoreCase(PlayerAction.ANALYZE.toString())) {
          printPlayerInfo(otherPlayer);
          continue;
        } else if (choice.equalsIgnoreCase(PlayerAction.HEAL.toString())) {
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

        choice = scanner.next().trim();
        final String attackChoice = choice;
        if (currentPlayer.getAttacks().stream().noneMatch((attack) -> attack.getName().equalsIgnoreCase(attackChoice))) {
          printInvalidChoice(currentPlayer);
          continue;
        }

        final AttackResult attackResult = currentPlayer.attack(currentPlayer, choice, otherPlayer);
        if (attackResult == AttackResult.CRITICAL) {
          printCriticalStrike();
        } else if (attackResult == AttackResult.FAILURE) {
          printFailedAttack();
        }

        tempPlayer = currentPlayer;
        currentPlayer = otherPlayer;
        otherPlayer = tempPlayer;
      } catch (Exception e) {
        printException(e);
      }

      isGameOver = currentPlayer.getHP() <= 0 || otherPlayer.getHP() <= 0;
      if (isGameOver) {
        winner = getWinner(currentPlayer, otherPlayer);
      }
    }

    printWinner(winner);
  }

}