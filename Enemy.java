import java.util.Random;
public class Enemy extends Adventurer {
  private int rage;

  public Enemy(String name, int maxHP, String special, String specialName){
    super(name, maxHP, special, specialName);
    this.rage = 0;
  }

  public String getName(){
      return name;
    }

    public int getHP() {
      return HP;
    }

    public int getMaxHP(){
      return maxHP;
    }

    public String getSpecial() {
      return special;
    }

    public String getSpecialName() {
      return specialName;
    }

    public void attack(Adventurer target) {
      Random rng = new Random();
      int damage = rng.nextInt(5) + 5;
      System.out.println(this.name + " attacks " + target.getName() + " for " + damage + " damage!");

      target.takeDamage(damage);
    }

    public void support() {
      System.out.println(this.name + " provides support to an ally!");
    }

    public void specialAttack(Adventurer target) {
      Random rng = new Random();
      int specialDamage = rng.nextInt(10) + 10;  // Special attack does more damage
      System.out.println(this.name + " uses special attack " + this.specialName + " on " + target.getName() + " for " + specialDamage + " damage!");
      target.applyDamage(specialDamage);
    }
}
