package Game;

import Bot.Bot;
import Fighter.Fighter;
import Player.AttackResult;
import Player.Player;
import Player.PlayerAction;
import Utils.Utils;

import java.util.List;

import static UI.UI.*;

public class Game {

  private Fighter getWinner(Fighter p1, Fighter p2) {
    if (p1.getHP() <= 0 && p2.getHP() > 0) return p2;
    if (p2.getHP() <= 0 && p1.getHP() > 0) return p1;

    return null;
  }

  public boolean fightBetween(Fighter p1, Fighter p2) {
    if (p1 == null || p2 == null) return false;
    if (getWinner(p1, p2) != null) return false;

    handleTurns(p1, p2);
    return true;
  }

  private void handleTurns(Fighter p1, Fighter p2) {
//    boolean isAnyPlayerDead = p1.getHP() <= 0 || p2.getHP() <= 0;

    Fighter currentPlayer = p1.getSpeed() >= p2.getSpeed() ? p1 : p2;
    Fighter otherPlayer = currentPlayer == p1 ? p2 : p1;
    Fighter tempPlayer;
    Fighter winner = null;
    final List<String> actions = List.of(
      PlayerAction.FLEE.getAction(),
      PlayerAction.ANALYZE.getAction(),
      PlayerAction.ATTACK.getAction(),
      PlayerAction.HEAL.getAction(),
      PlayerAction.PASS.getAction()
    );

    boolean isGameOver = false;
    while (!isGameOver) {
      printPlayersInfo(List.of(p1, p2));

      String choice = "";

      try {
        printActions(currentPlayer, actions);

//        String choice = scanner.next().trim();
        choice = currentPlayer.makeDecision();
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
        } else if (choice.equalsIgnoreCase(PlayerAction.PASS.toString())) {
          printFighterDoesNothing();
          tempPlayer = currentPlayer;
          currentPlayer = otherPlayer;
          otherPlayer = tempPlayer;
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

        if (currentPlayer instanceof Player) {
          choice = Utils.scanner.next().trim();
        } else if (currentPlayer instanceof Bot) {
          choice = ((Bot) currentPlayer).chooseAttack();
          System.out.println(choice);
        }


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