package UI;

import Player.Player;

import java.util.List;

public class UI {

  public static void printActions(final Player currentPlayer, final List<String> actions) {
    System.out.println("➡️ " + currentPlayer.getName() + " is ready to do something...");

    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < actions.size(); i++) {
      sb.append(i + ": " + actions.get(i) + " \n");
    }

    System.out.println(sb);
  }

//  public static void printAttackStrings(Player attacker, Player victim) {
//    System.out.println(attacker.getName() + " attacks " + victim.getName() + " with " + attacker.getAttack().getName() + "!");
//
//    final int attackDamage = attacker.getAttack().getDamage();
//    final int absoluteAttackDamage = attackDamage >= 0 ? attackDamage : -1 * attackDamage;
//    System.out.println("It deals " + absoluteAttackDamage + " damages!" + "\n");
//  }

  public static void printInvalidChoice(final Player currentPlayer) {
    System.out.println("Error: " + currentPlayer.getName() + " needs to make a valid choice!\n");
  }

  public static void printNoFight() {
    System.out.println("❌ Fight impossible.");
  }

  public static void printNoPotion() {
    System.out.println("No more potions.\n");
  }

  public static void printPlayerAttacks(final Player player) {
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

  public static void printPlayerInfo(final Player player) {
    System.out.println(player.toString());
  }

  public static void printPlayersInfo(final List<Player> players) {
    System.out.println("""
      --------------------------------
      📊 Current players' state:""");

    for (Player player : players) {
      System.out.println(player.getName() + ": " + player.getHP() + " HP");
    }

    System.out.println("--------------------------------\n");
  }

  public static void printWinner(final Player winner) {
    if (winner == null) {
      System.out.println("🙅🏻There is no winner.");
      return;
    }

    System.out.println("🎉 The winner is: " + winner.getName() + "!\n");
  }

  public static void printException(final Exception ex) {
    System.out.println("An error occurred: " + ex.getMessage() + "\n");
  }

}
