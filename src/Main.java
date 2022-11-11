import Attack.Attack;
import Player.Player;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    List<Attack> marioAttacks = new ArrayList<>();
    marioAttacks.add(new Attack("Punch", 25));
    marioAttacks.add(new Attack("Slap", 10));
    final Player mario = new Player("Mario", 10, marioAttacks);

    List<Attack> luigiAttacks = new ArrayList<>();
    luigiAttacks.add(new Attack("Punch", 25));
    luigiAttacks.add(new Attack("Headbutt", 15));
    final Player luigi = new Player("Luigi", 100, luigiAttacks);

    Boolean hasFightStarted = startFight(mario, luigi);
    if (!hasFightStarted) System.out.println("❌ Fight impossible.");
  }

  static Player getWinner(Player p1, Player p2) {
    if (p1.getHP() <= 0 && p2.getHP() > 0) return p2;
    if (p2.getHP() <= 0 && p1.getHP() > 0) return p1;

    return null;
  }

  static void printPlayersInfo(List<Player> players) {
    System.out.println("""
      --------------------------------
      📊 Current players' state:""");

    for (Player player : players) {
      System.out.println(player.getName() + ": " + player.getHP() + " HP");
    }

    System.out.println("--------------------------------\n");
  }

  static void printInvalidChoice(Player currentPlayer) {
    System.out.println("Error: " + currentPlayer.getName() + " needs to make a valid choice!\n");
  }

  static void printActions(Player currentPlayer, List<String> actions) {
    System.out.println("➡️ " + currentPlayer.getName() + " is ready to do something...");

    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < actions.size(); i++) {
      sb.append(i + ": " + actions.get(i) + " \n");
    }

    System.out.println(sb);
  }

  static void printPlayerAttacks(Player player) {
    StringBuilder attackSb = new StringBuilder();

    if (player.getAttacks().size() == 0) {
      attackSb.append("🤷🏼No attacks available. Next turn...\n");
    }

    for (int i = 0; i < player.getAttacks().size(); i++) {
      attackSb.append((i + 1) + ": " + player.getAttacks().get(i).getName()
        + " (" + player.getAttacks().get(i).getDamage() + " damage(s))" + "\n");
    }

    System.out.println(attackSb);
  }

  static void printPlayerInfo(Player player) {
    System.out.println(player.toString());
  }

  static void printWinner(Player winner) {
    if (winner == null) {
      System.out.println("🙅🏻There is no winner.");
      return;
    }

    System.out.println("🎉 The winner is: " + winner.getName() + "!\n");
  }

//  static void printAttackStrings(Player attacker, Player victim) {
//    System.out.println(attacker.getName() + " attacks " + victim.getName() + " with " + attacker.getAttack().getName() + "!");
//
//    final int attackDamage = attacker.getAttack().getDamage();
//    final int absoluteAttackDamage = attackDamage >= 0 ? attackDamage : -1 * attackDamage;
//    System.out.println("It deals " + absoluteAttackDamage + " damages!" + "\n");
//  }

  static Boolean startFight(Player p1, Player p2) {
    if (p1 == null || p2 == null) return false;
    if (p1.getHP() <= 0 || p2.getHP() <= 0) return false;

    Boolean isAnyPlayerDead = p1.getHP() <= 0 || p2.getHP() <= 0;
    Boolean isGameOver = isAnyPlayerDead;
    int turnCounter = 1;
    Player currentPlayer;
    Player otherPlayer;
    final List<String> actions = new ArrayList<>() {
      {
        add("Flee");
        add("Analyze");
        add("Attack");
      }
    };
    final List<Player> players = new ArrayList<>() {
      {
        add(p1);
        add(p2);
      }
    };

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
          return true;
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
        System.out.println("An error occurred: " + e.getMessage() + "\n");
      }

      isAnyPlayerDead = currentPlayer.getHP() <= 0 || otherPlayer.getHP() <= 0;
      isGameOver = isAnyPlayerDead;

      if (isAnyPlayerDead) {
        winner = getWinner(currentPlayer, otherPlayer);
      }
    }

    printWinner(winner);
    return true;
  }

}