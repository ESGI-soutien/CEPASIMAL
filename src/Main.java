import Player.Player;

public class Main {
  public static void main(String[] args) {

    final Player mario = new Player("Mario", 100, "Punch", 25);
    final Player luigi = new Player("Luigi", 100, "Punch", 25);

    printToString(mario);
    printToString(luigi);

    mario.attack(luigi);

    printToString(luigi);
  }

  static void printToString(Player player) {
    System.out.println(player.toString());
  }

}