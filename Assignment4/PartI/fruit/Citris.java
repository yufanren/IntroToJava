package fruit;

public class Citris extends Fruit{

  private String taste;

  public Citris() {
    taste = "";
  }

  public Citris(String taste, String color, boolean rotten) {
    super(color, rotten);
    this.taste = taste;
  }

  public String getTaste() {
    return taste;
  }

  public void setTaste(String taste) {
    this.taste = taste;
  }

  public String toString() {
    return "Citris object:" + super.toString().split(
            ":", 2)[1] + ", taste is " + taste;
  }
}
