public class Boss extends Adventurer{
  private int attackMin = 10;
  private int attackMax = 12;
  private int supportMin = 7;
  private int supportMax = 9;
  private int specialResource;
  private int specialMax = 100;

  public Boss(String name) {
    super(name, 75);
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
    other.applyDamage(damage);
    return getName() + " attacks " + other.getName() + " dealing " + damage + " damage.";
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
