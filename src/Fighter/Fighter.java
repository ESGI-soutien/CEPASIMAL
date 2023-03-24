package Fighter;

import Attack.Attack;
import Player.AttackResult;

import java.util.List;
import java.util.Random;

public abstract class Fighter implements IFighter {

  protected String name = null;
  protected int HP = 100;
  protected List<Attack> attacks = List.of();
  protected float attackBonus = 0f;
  protected float defense = 0f;
  protected int speed = 0;
  protected int remainingPotionQuantity = 1;

  public Fighter(String name, int hp, List<Attack> attacks, float attackBonus, float defense, int speed) {
    this.name = name;
    this.HP = hp;
    this.attacks = attacks;
    this.attackBonus = attackBonus;
    this.defense = defense;
    this.speed = speed;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb
      .append("Name: ").append(getName()).append("\n")
      .append("HP: ").append(getHP()).append("\n");

    for (int i = 0; i < getAttacks().size(); i++) {
      sb
        .append("Attack ").append(i + 1).append(": ")
        .append(getAttacks().get(i).getName()).append("\n");
    }

    return sb.toString();
  }

  public int getHP() {
    return HP;
  }

  public void setHP(final int HP) {
    this.HP = HP;
  }

  public String getName() {
    return name;
  }

  public List<Attack> getAttacks() {
    return attacks;
  }

  public int getRemainingPotionQuantity() {
    return remainingPotionQuantity;
  }

  public int getSpeed() {
    return speed;
  }

  public AttackResult attack(final Fighter attacker, final String choice, final Fighter victim) {
    if (victim == null) return AttackResult.IMPOSSIBLE;
    if (victim.getHP() <= 0) return AttackResult.IMPOSSIBLE;
    if (hasFailed()) return AttackResult.FAILURE;

    final boolean isCriticalAttack = isCriticalAttack();

    final int victimHP = computeVictimHP(attacker, choice, isCriticalAttack, victim);
    victim.setHP(victimHP);

    if (isCriticalAttack) return AttackResult.CRITICAL;

    return AttackResult.NORMAL;
  }

  public int computeVictimHP(final Fighter attacker, final String choice, final boolean isCriticalAttack, final Fighter victim) {
    int attackDamage = 0;
    for (Attack attack : attacker.getAttacks()) {
      if (attack.getName().equalsIgnoreCase(choice)) attackDamage = attack.getDamage();
    }

    if (isCriticalAttack) attackDamage *= 2;

    final int victimHP = victim.getHP() - Math.round(attackDamage * attacker.getAttackBonus() * victim.getDefense());

    return Math.max(0, victimHP);
  }

  public Boolean hasFailed() {
    final int rate = new Random().nextInt(0, 100 + 1);

    return rate > 0 && rate <= 10;
  }

  public Boolean isCriticalAttack() {
    final int rate = new Random().nextInt(0, 100 + 1);

    return rate > 0 && rate <= 10;
  }

  public void drinkPotion() {
    if (this.remainingPotionQuantity <= 0) return;

    final int HPAfterDrinking = Math.min(this.HP + 50, 100);

    setHP(HPAfterDrinking);
    this.remainingPotionQuantity--;
  }

}
