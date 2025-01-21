import java.util.Random;
public class Enemy extends Adventurer {
  private String name;
  private int HP;
  private int maxHP;
  private int special;
  private int specialMax;
  private String specialName;

  public Enemy(String name, int maxHP, int special, String specialName){
    super(name, maxHP);
    this.specialMax = 30;
    this.special = special;
    this.specialName = specialName;
    this.HP = maxHP;
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
      return this.special;
    }

    public int getSpecialMax() {
      return this.specialMax;
    }

    public String getSpecialName() {
      return this.specialName;
    }

    public void setSpecial(int n) {
      if (n > this.specialMax){
        this.special = this.specialMax;
      } else {
        this.special = n;
      }
    }

    public String attack(Adventurer other) {
      Random rng = new Random();
      int damage = rng.nextInt(5) + 5;
      other.applyDamage(damage);
      return this.name + " attacks " + other.getName() + " for " + damage + " damage!";
    }

    public String support() {
      this.setHP(this.getHP() + 5);
        return this.getName() + " supports themself with 5 HP";
    }

    public String support(Adventurer other) {
      other.setHP(other.getHP() + 5);
      return this.getName() + " supports " + other.getName() + " with 5 HP";
    }

    public String specialAttack(Adventurer other) {
      Random rng = new Random();
      int specialDamage = rng.nextInt(10) + 10;
      other.applyDamage(specialDamage);
        this.setSpecial(this.getSpecial() - 10);
        return this.getName() + " uses " + this.getSpecialName() + " on " + other.getName() + " for " + specialDamage + " damage";
    }
}
