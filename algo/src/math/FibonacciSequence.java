package math;

public class FibonacciSequence {
	static final int N = 10;//数组长度
	static final int RANGE = 30;//数据范围
	public static void main(String[] args) {
		int n = 0;
		for(int i=0;i<N;i++){
			n = (int)(Math.random()*RANGE + 1);
			System.out.printf("Fabonacci[%d]=%d%n",n,Fabonacci(n));
		}
	}

	/**
	 * Fabonacci
	 */
	static int Fabonacci(int n){
		if(1 == n || 2 == n) {
			return 1;
		}
		return Fabonacci(n-1) + Fabonacci(n-2);
	}
}