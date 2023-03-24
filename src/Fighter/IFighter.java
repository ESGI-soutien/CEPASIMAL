package Fighter;

import Attack.Attack;
import Player.AttackResult;
import Player.Player;

import java.util.List;

public interface IFighter {
  String name = null;
  int HP = 100;
  List<Attack> attacks = List.of();
  float attackBonus = 0f;
  float defense = 0f;
  int speed = 0;
  int remainingPotionQuantity = 1;

  public abstract String toString();

  public abstract int getHP();

  public abstract void setHP(final int HP);

  public abstract String getName();

  public float getAttackBonus();

  public float getDefense();

  public abstract List<Attack> getAttacks();

  public abstract int getRemainingPotionQuantity();

  public abstract int getSpeed();

  public abstract AttackResult attack(final Player attacker, final String choice, final Player victim);

  public abstract int computeVictimHP(final Player attacker, final String choice, final boolean isCriticalAttack, final Player victim);

  public abstract Boolean hasFailed();

  public abstract Boolean isCriticalAttack();

  public abstract void drinkPotion();

  public abstract String makeDecision() throws InterruptedException;
}
