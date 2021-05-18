package fruit;

public class Apple extends Fruit{

  private String taste;
  private String texture;

  public Apple() {
    taste = "";
    texture = "";
  }

  public Apple(String taste, String texture, String color, boolean rotten) {
    super(color, rotten);
    this.taste = taste;
    this.texture = texture;
  }

  public String getTaste() {
    return taste;
  }

  public void setTaste(String taste) {
    this.taste = taste;
  }

  public String getTexture() {
    return texture;
  }

  public void setTexture(String texture) {
    this.texture = texture;
  }

  public String toString() {
    return "Apple object:" + super.toString().split
            (":", 2)[1] + ", taste is " + taste + ", texture is " + texture;
  }

  public boolean equals(Object apple) {
    if (apple instanceof Apple)
      return this.taste.equals(((Apple)apple).taste)
              && this.texture.equals(((Apple)apple).texture)
              && this.getColor().equals(((Apple)apple).getColor())
              && this.isRotten() == ((Apple)apple).isRotten();
    else return false;
  }

  public static void main(String[] args) {
    Apple a1 = new Apple("bad", "mushy", "yellow", false);
    Apple a2 = new Apple("good", "tart", "red", false);
    Apple a3 = null;
    System.out.println(a1.equals(a3));
  }
}
