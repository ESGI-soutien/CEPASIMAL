package Bot;

import Attack.Attack;
import Player.AttackResult;
import Player.Player;
import Player.PlayerAction;

import java.util.List;

import static java.lang.Thread.sleep;

public class EasyBot extends Bot {

  public EasyBot(
    final String name,
    final int HP,
    final List<Attack> attacks,
    final float attackBonus,
    final float defense,
    final int speed
  ) {
    super(name, HP, attacks, attackBonus, defense, speed);
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
    return PlayerAction.PASS.toString();
  }

  @Override
  public String chooseAttack() throws InterruptedException {
    return null;
  }

}
