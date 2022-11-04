import Player.Player;

public class Main {
  public static void main(String[] args) {

    final Player mario = new Player("Mario", 100);
    final Player luigi = new Player("Luigi", 100);

    printPlayerInfo(mario);
    printPlayerInfo(luigi);

    mario.attack(luigi);
    printAttackStrings(mario, luigi);

    printPlayerInfo(luigi);
  }

  static void printPlayerInfo(Player player) {
    System.out.println(player.toString());
  }

  static void printAttackStrings(Player attacker, Player victim) {
    System.out.println(attacker.getName() + " attacks " + victim.getName() + " with " + attacker.getAttack().getName() + "!");

    final int attackDamage = attacker.getAttack().getDamage();
    final int absoluteAttackDamage = attackDamage >= 0 ? attackDamage : -1 * attackDamage;
    System.out.println("It deals " + absoluteAttackDamage + " damages!" + "\n");
  }

}