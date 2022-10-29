package Attack;

public class Attack {
  private final String name;
  private final int damage;

  public Attack(String attackName, int attackDamage) {
    this.name = attackName;
    this.damage = attackDamage;
  }

  public String getName() {
    return name;
  }

  public int getDamage() {
    return damage;
  }

}
