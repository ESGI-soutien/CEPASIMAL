package Player;

public class Player {

  private String name;
  private int HP;
  private String attackName;
  private int attackDamage;

  public Player(String name, int HP, String attackName, int attackDamage) {
    this.name = name;
    this.HP = HP;
    this.attackName = attackName;
    this.attackDamage = attackDamage;
  }

  @Override
  public String toString() {
    return "Name: " + getName() + "\n" +
      "HP: " + getHP() + "\n" +
      "Attack: " + getAttackName() + "\n";
  }

  public String getAttackName() {
    return attackName;
  }

  public int getHP() {
    return HP;
  }

  public void setHP(int HP) {
    this.HP -= HP;
  }

  public String getName() {
    return name;
  }

  public void attack(Player player) {
    player.setHP(attackDamage);
    
    printAttackString(player);
  }

  private void printAttackString(Player player){
    System.out.println(getName() + " attacks " + player.name + " with " + getAttackName() + "!");
    System.out.println("It deals " + attackDamage + " damages!" + "\n");
  }

}
