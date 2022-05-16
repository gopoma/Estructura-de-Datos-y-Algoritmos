import java.util.Scanner;

public class Exercise2A {
  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);

    while(true) {
      int n = sc.nextInt(), suma;
      int[] a = new int[n];

      for(int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }

      suma = sc.nextInt();

      System.out.println(esSubconjuntoSuma(a, a.length, suma));
      System.out.flush();
    }
  }

  public static boolean esSubconjuntoSuma(int[] conjunto, int n, int suma) {
    if(suma == 0)
      return true;
    if(n == 0) {
      return false;
    }
    return esSubconjuntoSuma(conjunto, n - 1, suma) ||
    esSubconjuntoSuma(conjunto, n - 1, suma - conjunto[n - 1]);
  }
}
