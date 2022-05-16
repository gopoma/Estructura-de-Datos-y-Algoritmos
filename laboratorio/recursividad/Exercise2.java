import java.util.Scanner;

public class Exercise2 {

	public static void main(final String[] args) {

		Exercise2 obj = new Exercise2();
		Scanner sc = new Scanner(System.in);
		while (true) {

			int n = sc.nextInt(), suma;
			int a[] = new int[n];

			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}

			suma = sc.nextInt();

			System.out.println(obj.esSubconjuntoSumaExt(a, suma));
		}
	}

	public boolean esSubconjuntoSumaExt(int a[], int suma) {
		return isSubsetSumExtreme(a, a.length, suma);
	}

  public static boolean isSubsetSumExtreme(int[] conjunto, int n, int suma) {
    if(suma == 0)
      return true;
    if(n == 0)
      return false;

    int incrementCase1 = ((n == conjunto.length && conjunto[n - 1] % 7 == 0) || (conjunto[n - 1] % 7 == 0 && conjunto[n] != 1))? conjunto[n - 1] : 0;
    int incrementCase2 = (n != conjunto.length && conjunto[n - 1] % 7 == 0 && conjunto[n] == 1)? conjunto[n - 1] : 0;

    return isSubsetSumExtreme(conjunto, n - 1, suma - incrementCase1) ||
    isSubsetSumExtreme(conjunto, n - 1, suma - conjunto[n - 1] + incrementCase2);
  }
}
