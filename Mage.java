public class Mage extends Adventurer {
  private int attackMin = 6;
  private int attackMax = 9;
  private int supportMin = 4;
  private int supportMax = 6;
  private int magicPoints;
  private boolean specialUsed;

  public Mage(String name) {
    super(name, 28);
    this.magicPoints = 0;
    this.specialUsed = false;
  }
}
