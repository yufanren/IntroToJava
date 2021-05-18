public class ShapeException extends Exception {

  private String shape;

  public ShapeException(String shape) {
    super("Invalid shape " + shape);
    this.shape = shape;
  }

  public String getShape() {
    return shape;
  }
}
