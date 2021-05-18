package fruit;

public class Fruit {

  private String color;
  private boolean rotten;
  private static int next_id = 1;
  private int id;

  public Fruit() {
    color = "";
    rotten = false;
    id = next_id;
    next_id++;
  }

  public Fruit(String color, boolean rotten) {
    this();
    this.color = color;
    this.rotten = rotten;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public boolean isRotten() {
    return rotten;
  }

  public void setRotten(boolean rotten) {
    this.rotten = rotten;
  }

  public int getId() {
    return id;
  }

  public String toString() {
    return  "Fruit object: id is " + Integer.toString(id)
            + ", color is " + color + ", rotten is " + Boolean.toString(rotten);
  }
}
