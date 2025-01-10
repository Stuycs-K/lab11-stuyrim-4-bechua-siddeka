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
}
