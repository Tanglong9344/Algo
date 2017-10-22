/**
 * 阶乘计算
 * 1，递归方式
 * 2，循环相乘
 */

package math;

public class Factorial {
	static final int N = 10000;
	static final int RANGE = 20;//the most range of long
	public static void main(String[] args) {
		int num;
		for(int i=0;i<N;i++){
			num = (int)(Math.random()*RANGE);
			System.out.println("Factorial(recursion) of " + num + " is " + countFactorialRecursion(num));
			System.out.println("Factorial(loop) of " + num + " is " + countFactorialLoop(num));
		}
	}

	//calculate factorial(recursion)
	static long countFactorialRecursion(int num){
		if(num>1) {
			return (num*(countFactorialRecursion(num-1)));
		}
		return 1;
	}

	//calculate factorial(loop)
	static long countFactorialLoop(int num){
		long fac = 1;
		for(int i=2;i<=num;i++){
			fac*=i;
		}
		return fac;
	}
}