package recursion;

/**
 * Common recursion vs Tail recursion
 *
 * @author tanglong
 *
 */
public class TailRecursion {
	public static void main(String[] args) {
		int n = (int)(Math.random() * 15 + 5);
		long start, end;
		long result = -1;

		start = System.nanoTime();
		result = commonRecursion(n);
		end = System.nanoTime();
		System.out.println("Common Recursion: " + n);
		System.out.println("Result: " + result + "\nTime: " + (end - start));

		start = System.nanoTime();
		result = tailRecursion(n, 1);
		end = System.nanoTime();
		System.out.println("Tail   Recursion: " + n);
		System.out.println("Result: " + result + "\nTime: " + (end - start));
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
	private static long tailRecursion(int n, long a) {
		if(n<0) {
			return -1;
		}
		return n==0? a : tailRecursion(n-1, n * a);
	}
}