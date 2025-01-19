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
}
