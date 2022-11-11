package Player;

import Attack.Attack;

import java.util.List;

public class Player {

  private final String name;
  private int HP;
  private final List<Attack> attacks;

  public Player(String name, int HP, List<Attack> attacks) {
    this.name = name;
    this.HP = HP;
    this.attacks = attacks;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: " + getName() + "\n" +
      "HP: " + getHP() + "\n");

    for (int i = 0; i < getAttacks().size(); i++) {
      sb.append("Attack " + (i + 1) + ": " + getAttacks().get(i).getName() + "\n");
    }

    return sb.toString();
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

  public List<Attack> getAttacks() {
    return attacks;
  }

  public void attack(Player victim, Attack attack) {
    if (victim == null) return;
    if (victim.getHP() <= 0) return;

    victim.setHP(victim.getHP() - attack.getDamage());
    if (victim.getHP() < 0) victim.setHP(0);
  }

}
