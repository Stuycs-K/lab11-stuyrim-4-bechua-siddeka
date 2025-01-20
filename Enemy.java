import java.util.Random;
public class Enemy extends Adventurer {
  private String name;
  private int HP;
  private int maxHP;
  private int special;
  private int specialMax;
  private String specialName;

  public Enemy(String name, int maxHP, String special, String specialName){
    this.name = name;
    this.maxHP = maxHP;
    this.HP = maxHP;
    this.special = special;
    this.specialName = specialName;
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

    public int getSpecial() {
      return special;
    }

    public int getSpecialMax() {
      return specialMax;
    }

    public String getSpecialName() {
      return specialName;
    }

    public void attack(Adventurer other) {
      Random rng = new Random();
      int damage = rng.nextInt(5) + 5;
      System.out.println(this.name + " attacks " + other.getName() + " for " + damage + " damage!");

      other.applyDamage(damage);
    }

    public void support() {
      System.out.println(this.name + " provides support to an ally!");
    }

    public void specialAttack(Adventurer other) {
      Random rng = new Random();
      int specialDamage = rng.nextInt(10) + 10;
      System.out.println(this.name + " uses special attack " + this.specialName + " on " + other.getName() + " for " + specialDamage + " damage!");
      other.applyDamage(specialDamage);
    }
}
