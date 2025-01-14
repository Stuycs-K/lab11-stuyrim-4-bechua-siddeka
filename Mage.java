import java.util.ArrayList;

public class Mage extends Adventurer {
  private int attackMin = 6;
  private int attackMax = 9;
  private int supportMin = 4;
  private int supportMax = 6;
  private int special;
  private int specialMax;
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

  public void setSpecial(int n){
    special = n;
  }

  public String getSpecialMax(){
    return specialMax;
  }

  public int getMagicPoints() {
    return magicPoints;
  }

  public void setMagicPoints(int points) {
    magicPoints = points;
  }

  public String attack(Adventurer other) {
    int damage = (int) (Math.random() * (attackMax - attackMin + 1)) + attackMin;

    if (this.getReduction()) {
      damage = (int) (damage * 0.95);
    }

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

<<<<<<< HEAD
  public String support() {
    return null;
  }


=======
  public abstract String support(){
    return
  }

>>>>>>> 0de724835675b1c50c6313cea333f86ec7b2de53
  public String specialAttack(Adventurer other) {
    if (magicPoints >= MAGIC_THRESHOLD && !specialUsed) {
      specialUsed = true;
      return getName() + " casts " + getSpecialName() + " and skips " + other.getName() + " next turn!";
    } else if (specialUsed) {
      return getName() + " has already used the special attack";
    } else {
      return getName() + " does not have enough magic points to use the special attack.";
    }
  }

  public String specialAttack(ArrayList<Adventurer> others) {
    if (magicPoints >= MAGIC_THRESHOLD && !specialUsed) {
      specialUsed = true;
      String result = getName() + " casts " + getSpecialName() + " and skips the next turns of ";
      for (Adventurer target : others) {
        result += target.getName() + ", ";
      }
      return result + "and skips their turns!";
    } else if (specialUsed) {
      return getName() + " has already used the special attack";
      } else {
        return getName() + " does not have enough magic points to use the special attack.";
      }
    }
}
