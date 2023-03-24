package Player;

public enum PlayerAction {
  FLEE("Flee"),
  ANALYZE("Analyze"),
  ATTACK("Attack"),
  HEAL("Heal"),
  PASS("Pass");

  private String action;

  PlayerAction(final String action) {
    this.action = action;
  }

  public String getAction() {
    return action;
  }

  public void setAction(final String action) {
    this.action = action;
  }
}
