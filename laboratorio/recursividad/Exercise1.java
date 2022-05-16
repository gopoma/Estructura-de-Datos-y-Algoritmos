import java.util.Scanner;

public class Exercise1 {

	public static void main(final String[] args) {

		Exercise1 obj = new Exercise1();
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			System.out.println(obj.esCuadradoPerfecto(n));
		}
	}

	public boolean esCuadradoPerfecto(int numero) {
		return (numero > 0)? isSquarePerfectFromAStart(numero, 0) : false; // Indirect Recursion
    // numero can't be lower than 0 for math's rule and not cero because of the condition
	}

  public boolean isSquarePerfectFromAStart(int num, int start) {
    if(num == start * start) // base case
      return true;

    return (start < num)? isSquarePerfectFromAStart(num, start + 1) : false;
    // If start is lower than num, we continue recursing, else we finish to avoid a wrong answer
  }
}
