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

    int damages = attacker.getAttack().getDamage();
    int absoluteDamages = damages > 0 ? damages : -1 * damages;
    System.out.println("It deals " + absoluteDamages + " damages!" + "\n");
  }

}