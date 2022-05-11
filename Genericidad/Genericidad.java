package Genericidad;
import java.util.ArrayList;

class Box <T> {
  private T data;
    
  public Box() { super(); }

  public void put(T x) { this.data = x; };
  public T get() { return this.data; }

  public static <T> void putInTheBox(T item, Box<T> b) { // Without the <T>: Cannot make a static reference to the non-static type T
    b.put(item);
  }

  public static void main(final String[] args) {
    // Box<Integer> b = new Box<Integer>();
    // b.put(20);
    // Integer data = b.get();
    // System.out.println(data);
    
    // b.put("Gustavo"); // Compilation Error
    // Integer data2 = (String) b.get(); // Compilation Error: Cannot cast from Integer to String
    // String data3 = b.get(); // Type mismatch: cannot convert from Integer to String

    Box<Integer> b = new Box<Integer>();
    Box.putInTheBox(45, b);
    System.out.println(b.get());
  }
}

class Pair<T> {
  private T a;
  private T b;

  public Pair(T a, T b) {
    this.a = a;
    this.b = b;
  }

  public void swap() {
    T aux = this.a;
    this.a = this.b;
    this.b = aux;
  }
  public Pair<T> getSwapped() {
    return new Pair(this.b, this.a);
  }
  public String toString() {
    return String.format("%s %s", a, b);
  }

  public static void main(final String[] args) {
    // Pair<Integer> p = new Pair<Integer>(1, 2);
    // System.out.println(p);
    // Pair<Integer> pSwapped = p.getSwapped();
    // System.out.println(pSwapped);
    // p.swap();
    // System.out.println(p);

    // Pair<String> p2 = new Pair<String>("*", ".");
    // System.out.println(p2);
    // Pair<String> p2Swapped = p2.getSwapped();
    // System.out.println(p2Swapped);
  }
}


class Operations {
  public static <T> void showArray(ArrayList<T> a) {
    for(T item : a) {
      System.out.println(item);
    }
  }

  public static void main(final String[] args) {
    ArrayList<String> list = new ArrayList<String>();
    list.add("Gustavo");
    list.add("Teófilo");
    Operations.showArray(list);
    System.out.println();
    list.add(0, "Juan");
    Operations.showArray(list);

    System.out.println();
    ArrayList<Integer> nums = new ArrayList<Integer>();
    nums.add(1);
    nums.add(13);
    nums.add(25);
    Operations.showArray(nums);
  } 
}

class Caja<T> {
  protected T dato;
  public Caja() { super(); }
  public T dame() { return this.dato; }
  public void pon(T x) { this.dato = x; }
}
class Manzana {
  private int sabor;
  public Manzana(int sabor) { this.sabor = sabor; }
  public int obtenerSabor() { return this.sabor; }
}
class Mandarina {
  private String color;
  public Mandarina(String color) { this.color = color; }
  public String getColor() { return this.color; }
}
class CajaManzanas extends Caja<Manzana> {
  public int getSabor() {
    return this.dato.obtenerSabor();
  }

  public static void main(final String[] args) {
    CajaManzanas cm = new CajaManzanas();
    cm.pon(new Manzana(23));
    int sabor = cm.getSabor();
    System.out.println(sabor);
  }
}
class CajaMandarinas extends Caja<Mandarina> {
  public String getColor() {
    return this.dato.getColor();
  }

  public static void main(final String[] args) {
    CajaMandarinas cm = new CajaMandarinas();
    cm.pon(new Mandarina("dulce"));
    System.out.println(cm.getColor());
  }
}