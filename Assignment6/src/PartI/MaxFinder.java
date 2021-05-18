package PartI;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class MaxFinder<T extends Number> {

  private T max;

  public MaxFinder() {
    max = null;
  }

  public void add(T t) {
    if (max == null) {
      max = t;
      return;
    }
    if (t != null && t.doubleValue() > max.doubleValue())
      max = t;
  }

  public void add(ArrayList<? extends T> al) {
    if (al != null) {
      if (max == null && al.size() > 0) {
        for (T i : al)
          if (i != null) {
            max = i;
            break;
          }
      }
      for (T i : al)
        if (max != null && i != null && i.doubleValue() > max.doubleValue())
          max = i;
    }
  }

  public T max() {
    return this.max;
  }

  public static void main(String[] args) {
    MaxFinder<Integer> f1 = new MaxFinder<>();
    f1.add(new ArrayList<Integer>(Arrays.asList(100, -99, 23, 7)));
    System.out.println("Max in f1 is " + f1.max());

    MaxFinder<Number> f2 = new MaxFinder<>();
    f2.add(0);
    f2.add(new ArrayList<Number>(Arrays.asList(null, -108, 92, 3F, -30)));
    f2.add(new ArrayList<Double>(Arrays.asList(3D, 6.3, -73.2111, 88D)));
    f2.add(new ArrayList<BigDecimal>(Arrays.asList(BigDecimal.valueOf(-235353.235), BigDecimal.valueOf(3245235.346))));
    System.out.println("Max in f2 is " + f2.max());
  }
}
