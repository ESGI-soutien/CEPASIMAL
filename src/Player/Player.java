package Player;

import Attack.Attack;

import java.util.List;
import java.util.Random;

public class Player {

  private final String name;
  private int HP;
  private final List<Attack> attacks;
  private final float attackBonus;
  private final float defense;
  private final int speed;
  private int remainingPotionQuantity = 1;

  public Player(
    final String name,
    final int HP,
    final List<Attack> attacks,
    final float attackBonus,
    final float defense,
    final int speed
  ) {
    this.name = name;
    this.HP = HP;
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

  public AttackResult attack(final Player attacker, final String choice, final Player victim) {
    if (victim == null) return AttackResult.IMPOSSIBLE;
    if (victim.getHP() <= 0) return AttackResult.IMPOSSIBLE;
    if (hasFailed()) return AttackResult.FAILURE;

    final boolean isCriticalAttack = isCriticalAttack();

    final int victimHP = computeVictimHP(attacker, choice, isCriticalAttack, victim);
    victim.setHP(victimHP);

    if (isCriticalAttack) return AttackResult.CRITICAL;

    return AttackResult.NORMAL;
  }

  public int computeVictimHP(final Player attacker, final String choice, final boolean isCriticalAttack, final Player victim) {
//    int attackDamage = attacker.getAttacks().get(choice - 1).getDamage();
    int attackDamage = 0;
    for (Attack attack : attacker.getAttacks()) {
      if (attack.getName().equalsIgnoreCase(choice)) attackDamage = attack.getDamage();
    }
      
    if (isCriticalAttack) attackDamage *= 2;

    final int victimHP = victim.getHP() - Math.round(attackDamage * attacker.attackBonus * victim.defense);

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
