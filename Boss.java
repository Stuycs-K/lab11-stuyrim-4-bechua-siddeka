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
}
