package Bot;

import Attack.Attack;
import Fighter.Fighter;

import java.util.List;

public abstract class Bot extends Fighter {

  public Bot(
    String name,
    int hp,
    List<Attack> attacks,
    float attackBonus,
    float defense,
    int speed
  ) {
    super(name, hp, attacks, attackBonus, defense, speed);
  }

  public abstract String chooseAttack() throws InterruptedException;

}
