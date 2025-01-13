public class Mage extends Adventurer {
  private int attackMin = 6;
  private int attackMax = 9;
  private int supportMin = 4;
  private int supportMax = 6;
  private int magicPoints;
  private final int MAGIC_THRESHOLD = 5;
  private boolean specialUsed;

  public Mage(String name) {
    super(name, 28);
    this.magicPoints = 0;
    this.specialUsed = false;
  }

  public String getSpecialName() {
    return "Skip";
  }

  public int getMagicPoints() {
    return magicPoints;
  }

  public void setMagicPoints(int points) {
    magicPoints = points;
  }

  public String attack(Adventurer other) {
    int damage = (int) (Math.random() * (attackMax - attackMin + 1)) + attackMin;
    other.applyDamage(damage);
    magicPoints += 1;
    if (magicPoints >= MAGIC_THRESHOLD && !specialUsed) {
      specialUsed = true;
    }
    return getName() + " attacks " + other.getName() + " dealing " + damage + " damage.";
  }

  public String support(Adventurer other) {
    int healing = (int) (Math.random() * (supportMax - supportMin + 1)) + supportMin;
    other.setHP(other.getHP() + healing);
    magicPoints += 1;
    if (magicPoints >= MAGIC_THRESHOLD && !specialUsed) {
      specialUsed = true;
    }
    return getName() + " heals " + other.getName() + " by " + healing + " HP.";
  }
}
