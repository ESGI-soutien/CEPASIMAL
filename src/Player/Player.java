package Player;

import Attack.Attack;

public class Player {

  private final String name;
  private int HP;
  private final Attack attack;

  public Player(String name, int HP) {
    this.name = name;
    this.HP = HP;
    this.attack = new Attack("Punch", 25);
  }

  @Override
  public String toString() {
    return "Name: " + getName() + "\n" +
      "HP: " + getHP() + "\n" +
      "Attack: " + getAttack().getName() + "\n";
  }

  public int getHP() {
    return HP;
  }

  public void setHP(int HP) {
    this.HP = HP;
  }

  public String getName() {
    return name;
  }

  public Attack getAttack() {
    return attack;
  }

  public void attack(Player victim) {
    if (victim == null) return;
    if (victim.getHP() <= 0) return;

    victim.setHP(victim.getHP() - attack.getDamage());
    if (victim.getHP() < 0) victim.setHP(0);
  }

}
