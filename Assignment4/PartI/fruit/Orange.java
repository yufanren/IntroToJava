package fruit;

public class Orange extends Citris{

  private String type;

  public Orange() {
    type = "";
    this.setColor("orange");
  }

  public Orange(String type, String taste, boolean rotten) {
    this();
    this.type = type;
    this.setTaste(taste);
    this.setRotten(rotten);
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String toString() {
    return "Orange object:" + super.toString()
            .split(":", 2)[1] + ", type is " + type;
  }
}
