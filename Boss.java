import java.util.ArrayList;
import java.util.Random;

public class Boss extends Adventurer{
  private int attackMin = 10;
  private int attackMax = 12;
  private int supportMin = 7;
  private int supportMax = 9;
  private int specialResource;
  private int specialMax = 20;

  public Boss(String name) {
    super(name, 80);
    this.specialResource = 0;
  }

  public String getSpecialName(){
    return "Rage";
  }

  public int getSpecial(){
    return specialResource;
  }

  public int getSpecialMax(){
    return specialMax;
  }

  public void setSpecial(int n){
    specialResource = n;
  }

  public String attack(Adventurer other){
    int damage = (int)(Math.random() * (attackMax - attackMin + 1)) + attackMin;

    if (this.getReduction()) {
      damage = (int) (damage * 0.95);
    }

    other.applyDamage(damage);
    setSpecial(getSpecial() + 4);
    return getName() + " attacks " + other.getName() + " dealing " + damage + " damage.";
  }

  public String support(){
    int healing = (int)(Math.random() * (supportMax - supportMin + 1)) + supportMin;
    setHP(getHP() + healing);
    return "the boss restored " + healing + " HP to themselves";
  }

  public String support(Adventurer other){
    int healing = (int)(Math.random() * (supportMax - supportMin + 1)) + supportMin;
    other.setHP(other.getHP() + healing);
    return getName() + " heals " + other.getName() + " by " + healing + " HP. ";
  }

  public String specialAttack(Adventurer other) {
    if (getSpecial() >= 20) {
      setSpecial(getSpecial() - 20);

      int totalDamage = 17;
      Random random = new Random();
      int damage = random.nextInt(totalDamage) + 1;

      other.applyDamage(damage);
      totalDamage -= damage;

      other.applyDamage(totalDamage);
      return getName() + " uses Rage on " + other.getName() + " dealing " + damage + " and " + totalDamage + " total damage.";
    } else {
      return getName() + " does not have enough Rage to use a special attack.";
    }
  }

  public String specialAttack(ArrayList<Adventurer> others) {
    if (getSpecial() >= 20) {
      setSpecial(getSpecial() - 20);
      int tdamage = 17;
      Random random = new Random();

      int[] damages = new int[others.size()];
      int remainingDamage = tdamage;
      for (int i = 0; i < others.size(); i++) {
        int damage = random.nextInt(remainingDamage / (others.size() - i)) + 1;
        damages[i] = damage;
        remainingDamage -= damage;
      }

      String result = getName() + " uses Rage to attack all enemies: ";
      for (int i = 0; i < others.size(); i++) {
        others.get(i).applyDamage(damages[i]);
        result += others.get(i).getName() + " takes " + damages[i] + " damage ";
      }

      return result;
    } else {
      return getName() + " does not have enough magic points to use Rage";
    }
  }
}
