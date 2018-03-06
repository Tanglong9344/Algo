package recursion;

/**
 * Common recursion vs Tail recursion
 *
 * @author tanglong
 *
 */
public class TailRecursion {
	public static void main(String[] args) {
		int n = (int)(Math.random() * 15 + 10);
		long start, end;
		long result = -1;

		start = System.nanoTime();
		result = tailRecursion(n, 1);
		end = System.nanoTime();
		System.out.printf("Tail Recursion:%d%nResult:%d, Time: %d%n", n, result, (end - start));

		start = System.nanoTime();
		result = commonRecursion(n);
		end = System.nanoTime();
		System.out.printf("Common Recursion:%d%nResult:%d, Time: %d%n", n, result, (end - start));

	}

	/** common recursion
	 * buffer data using stack
	 */
	private static long commonRecursion(int n) {
		if(n<0) {
			return -1;
		}
		return n==0? 1 : n * commonRecursion(n-1);
	}

	/** tail recursion
	 * storage data using argument
	 */
	private static int tailRecursion(int n, int a) {
		if(n<0) {
			return -1;
		}
		return n==0? a : tailRecursion(n-1, n * a);
	}
}