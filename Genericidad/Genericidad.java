// package Genericidad;
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

// class Pair<T> {
//   private T a;
//   private T b;

//   public Pair(T a, T b) {
//     this.a = a;
//     this.b = b;
//   }

//   public void swap() {
//     T aux = this.a;
//     this.a = this.b;
//     this.b = aux;
//   }
//   public Pair<T> getSwapped() {
//     return new Pair(this.b, this.a);
//   }
//   public String toString() {
//     return String.format("%s %s", a, b);
//   }

//   public static void main(final String[] args) {
//     // Pair<Integer> p = new Pair<Integer>(1, 2);
//     // System.out.println(p);
//     // Pair<Integer> pSwapped = p.getSwapped();
//     // System.out.println(pSwapped);
//     // p.swap();
//     // System.out.println(p);

//     // Pair<String> p2 = new Pair<String>("*", ".");
//     // System.out.println(p2);
//     // Pair<String> p2Swapped = p2.getSwapped();
//     // System.out.println(p2Swapped);
//   }
// }


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

abstract class Vehiculo {
  protected double hp;
  protected boolean esAcuatico;
  protected String inventor;

  protected Vehiculo() { this.inventor = "Luigui"; }

  public abstract double calcularPotencia();
}

abstract class Terreste extends Vehiculo {
  protected int cantidadRuedas;
}

class Toyota extends Terreste {
  public Toyota() {
    this.cantidadRuedas = 10;
    this.hp = 375;
    this.esAcuatico = false;
  }

  public double calcularPotencia() {
    return this.cantidadRuedas * this.cantidadRuedas + this.hp * this.hp * this.hp;
  }
}
class Audi extends Terreste {
  public Audi() {
    this.cantidadRuedas = 12;
    this.hp = 245.75;
    this.esAcuatico = false;
  }

  public double calcularPotencia() {
    return this.cantidadRuedas * this.hp * this.hp;
  }
}

class Garaje<V extends Vehiculo> {
  private int numPlazas;
  private ArrayList<V> plazas;

  public Garaje(int numPlazas) {
    this.numPlazas = numPlazas;
    this.plazas = new ArrayList<V>(numPlazas);
  }

  public static void main(final String[] args) {
    // Garaje<Integer> f = new Garaje<Integer>(10); // Error!
    Garaje<Vehiculo> v = new Garaje<Vehiculo>(100);
    Garaje<Terreste> vT = new Garaje<Terreste>(11);
    Garaje<Toyota> vTT = new Garaje<Toyota>(12);
    Garaje<Audi> vTA = new Garaje<Audi>(13);
  }
}

class Pair<T extends Comparable<T>> {
  private T a;
  private T b;

  public Pair(T a, T b) {
    this.a = a;
    this.b = b;
  }

  public T max() {
    return ((this.a.compareTo(this.b) > 0)? a : b);
  }
  // public T max() { // doesn't work!
  //   return (this.a > this.b)? a : b;
  // }

  public static void main(final String[] args) {
    Pair p = new Pair(256, 79);
    System.out.println(p.max());
  }
}

abstract class Figure implements Comparable<Figure> {
  protected String name;

  public Figure(String name) { this.name = name; }

  public abstract double calcArea();

  final public double compArea(Figure b) {
    return this.calcArea() - b.calcArea();
  }

  public int compareTo(Figure f) {
    if(compArea(f) < 0) return -1;
    if(compArea(f) > 0) return 1;
    return 0;
  }
  public String toString() {
    return String.format("My name is: %s", name);
  }
}

class Circle extends Figure {
  protected double radius; // sus

  public Circle(String name, double radius) {
    super(name);
    this.radius = radius;
  }

  public double calcArea() {
    return Math.PI * this.radius * this.radius;
  }
}

class Rectangle extends Figure {
  protected double width;
  protected double height;

  public Rectangle(String name, double width, double height) {
    super(name);
    this.width = width;
    this.height = height;
  }

  public double calcArea() {
    return this.width * this.height;
  }
}

class FigureAplication {
  public static void main(final String[] args) {
    Figure r = new Circle("Circulo", 5);
    Figure s = new Rectangle("Rectangulo", 3, 4);

    Pair<Figure> p = new Pair(r, s);
    System.out.println("Max Area: " + p.max());
  }
}

class ContainerAplication {
  public static <T extends Comparable<T>> T min(T[] arr) {
    T eleMin = arr[0];
    for(int i = 0; i < arr.length; i++) {
      if(eleMin.compareTo(arr[i]) > 0)
        eleMin = arr[i];
    }
    return eleMin;
  }

  public static void main(final String[] args) {
    // Mínimo del array int[] a
    int[] a = {1, 2, 3, 4, 5, 6, 7, -1, 9, 10};
    int eleMin = a[0];
    for(int i = 0; i < a.length; i++) {
      if(eleMin > a[i])
        eleMin = a[i];
    }
    System.out.println("eleMin: "+eleMin);

    Figure[] f = {
      new Rectangle("R1", 2, 3),
      new Circle("C1", 1),
      new Rectangle("R2", 10, 2),
      new Circle("C2", 4)
    };
    System.out.println("Minimum: "+min(f));

    // Compilation Error!
    // Figure fMin = f[0];
    // for(int i = 0; i < f.length; i++) {
    //   if(fMin > f[i])
    //     fMin = f[i];
    // }
    // System.out.println("fMin: "+fMin);

    String cadenas [] = new String [3];
    cadenas[0] = new String("Wuisa");
    cadenas[1] = new String("Tulio");
    cadenas[2] = new String("Rosa");
    System.out.println("La cadena menor es "+ min(cadenas));
  }
}
