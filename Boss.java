import java.util.ArrayList;

public class Boss extends Adventurer{
  private int attackMin = 10;
  private int attackMax = 12;
  private int supportMin = 7;
  private int supportMax = 9;
  private int specialResource = 0;
  private int specialMax = 100;

  public Boss(String name) {
    super(name, 80);
    this.specialResource = 50;
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
    return getName() + " attacks " + other.getName() + " dealing " + damage + " damage.";
  }

  public String support(){
    int healing = (int)(Math.random() + 7) + 2;
    setHP(getHP + healing);
    return "the boss restored " + healing + " HP ti themselves";
  }

  public String support(Adventurer other){
    int healing = (int)(Math.random() * (supportMax - supportMin + 1)) + supportMin;
    other.setHP(other.getHP() + healing);
    return getName() + " heals " + other.getName() + " by " + damage + " HP. ";
  }

  public String support(ArrayList<Adventurer> others) {
    String result = "";
    int healing = (int)(Math.random() * 7) + 10;
    for (int i = 0; i < others.size(); i++) {
      target.setHP(getHP() + healing);
      result += getName() + " supports " + target.getName() + " by " + healing + " HP. ";
    }
    return result;
  }

  public String specialAttack(Adventurer other) {
    if (getSpecial() >= 20) {
      setSpecial(getSpecial() - 20);
      int damage = (int)(Math.random() * 10) + 15;
      other.applyDamage(damage);
      return getName() + " attacks " + other.getName() + " by " + damage + " HP. ";
    } else {
      return getName() + " does not have enough Rage to use a special attack.";
    }
  }

  public String specialAttack(ArrayList<Adventurer> others) {
    String result = "";
    if (getSpecial() >= 20) {
      setSpecial(getSpecial() - 20);
      int damage = 17;
      for (int i = 0; i < others.size(); i++) {
        target.applyDamage(damage);
        result += getName() + " unleashes a special attack on " + target.getName() + " and damages by " + damage + " hp.";
      }
      return result;
    } else {
      return getName() + " does not have enough Rage to use a special attack.";
    }
  }


}
