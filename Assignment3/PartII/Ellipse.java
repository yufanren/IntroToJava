
public class Ellipse {

	private static int nextId = 1;
	private int id;
	private double semiMajorAxis;
	private double semiMinorAxis;

  public Ellipse() {
    semiMajorAxis = 2.0;
    semiMinorAxis = 1.0;
    id = nextId;
    nextId++;
  }

  public Ellipse(double a, double b) {
    semiMajorAxis = Math.max(a, b);
    semiMinorAxis = Math.min(a, b);
    id = nextId;
    nextId++;
  }

  public double getSemiMajorAxis() {
    return semiMajorAxis;
  }

  public double getSemiMinorAxis() {
    return semiMinorAxis;
  }

  public double getArea() {
    return semiMajorAxis * semiMinorAxis * Math.PI;
  }

  public double getId() {
    return (double) id;
  }
}
