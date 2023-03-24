package Bot;

import Attack.Attack;
import Player.AttackResult;
import Player.Player;
import Player.PlayerAction;

import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class HardBot extends Bot {

  private int initialHP;

  public HardBot(
    final String name,
    final int HP,
    final List<Attack> attacks,
    final float attackBonus,
    final float defense,
    final int speed
  ) {
    super(name, HP, attacks, attackBonus, defense, speed);
    initialHP = HP;
  }

  @Override
  public float getAttackBonus() {
    return attackBonus;
  }

  @Override
  public float getDefense() {
    return defense;
  }

  @Override
  public int computeVictimHP(Player attacker, String choice, boolean isCriticalAttack, Player victim) {
    return 0;
  }

  @Override
  public AttackResult attack(Player attacker, String choice, Player victim) {
    return null;
  }

  @Override
  public String makeDecision() throws InterruptedException {
    sleep(1000);

    if (this.remainingPotionQuantity >= 1) {
      if ((double) getHP() <= (double) initialHP * 25 / 100) {
        return PlayerAction.HEAL.toString();
      }
    }

    return PlayerAction.ATTACK.toString();
  }

  @Override
  public String chooseAttack() throws InterruptedException {
    sleep(1000);
    final int index = new Random().nextInt(0, attacks.size());

    return attacks.get(index).getName();
  }

}

