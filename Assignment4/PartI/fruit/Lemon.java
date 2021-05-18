package fruit;

public class Lemon extends Citris{

  private int sourness;

  public Lemon() {
    sourness = 0;
    this.setColor("yellow");
  }

  public Lemon(int sourness, String taste, boolean rotten) {
    this();
    this.sourness = sourness;
    this.setTaste(taste);
    this.setRotten(rotten);
  }

  public int getSourness() {
    return sourness;
  }

  public void setSourness(int sourness) {
    this.sourness = sourness;
  }

  public String toString() {
    return "Lemon object:" + super.toString().split(
            ":", 2)[1] + ", sourness is " + Integer.toString(sourness);
  }
}
