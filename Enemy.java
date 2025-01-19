public class Enemy {
  private String name;
  private int HP;
  private int maxHP;
  private String special;
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

    public String getSpecial() {
        return special;
    }

    public String getSpecialName() {
        return specialName;
    }
}
