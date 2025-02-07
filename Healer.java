import java.util.Random;

public class Healer extends Adventurer {
    private int hpHealed;
    private int specialMax = 15;

    public Healer(String name) {
        super(name, 23);
        this.hpHealed = 0;
    }

    public String getSpecialName() {
        return "Tranquil Shield";
    }

    public int getSpecial(){
        return hpHealed;
    }

    public int getSpecialMax(){
        return specialMax;
    }

    public void setSpecial(int n){
        hpHealed = n;
    }

    public String attack(Adventurer other) {
        Random random = new Random();
        int damage = random.nextInt(2) + 2;

        if (this.getReduction()) {
          damage = (int) (damage * 0.95);
        }

        other.applyDamage(damage);

        return getName() + " attacked " + other.getName() + " and dealt " + damage + " damage.";
    }

    public String support(Adventurer other) {
        Random random = new Random();
        int addedHP = random.nextInt(3) + 5;

        other.setHP(other.getHP()+addedHP);
        setSpecial(getSpecial()+addedHP);

        return getName() + " restored " + addedHP + " HP for " + other.getName() + ". They need to restore " + (15-getSpecial()) + " HP to unlock their special.";
    }

    public String support() {
        Random random = new Random();
        int addedHP = random.nextInt(3) + 5;

        setHP(getHP()+addedHP);
        setSpecial(getSpecial()+addedHP);

        return getName() + " restored " + addedHP + " HP for themself. They need to restore " + (15-getSpecial()) + " HP to unlock their special.";
    }

    public String specialAttack(Adventurer other) {
      if (getSpecial() >= 15) {
        setSpecial(getSpecial()-15);

        //implement the 5% reduction by adding a variable to Adventurer class and checking that before attack
        other.setReduction(true);

        return getName() + " has used 15 of their total HP healed to reduce the damage of " + other.getName() + "'s next attack by 5%";
      } else {
        return getName() + " still needs to heal " + (15-getSpecial()) + " HP to unlock their special. Instead " + attack(other);
      }
    }
}
