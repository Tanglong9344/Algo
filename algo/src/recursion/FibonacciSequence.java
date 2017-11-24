/**
 * 菲波那切数列
 * Formula:F(n|n>2)=F(n-1)+F(n-2)
 * F(1)=1,F(2)=1
 */

package recursion;

import java.util.Random;

public class FibonacciSequence {
	static final int N = 30;//循环次数
	static final int RANGE = 30;//数据范围
	public static void main(String[] args) {
		int n = 0;
		Random random = new Random();
		int avg=0;//平均计算时间
		long start,end;
		int tmp;
		System.out.println("----------方法1-----------");
		for(int i=0;i<N;i++){
			n = random.nextInt(RANGE);
			start = System.nanoTime();
			tmp = Fabonacci1(n);
			end = System.nanoTime();
			avg+= end-start;
			System.out.printf("Fabonacci[%d]=%d%n",n,tmp);
		}
		System.out.println(N+"此循环，平均计算时间："+avg/N+"纳秒");
		System.out.println("----------方法2-----------");
		avg = 0;
		for(int i=0;i<N;i++){
			n = random.nextInt(RANGE);
			start = System.nanoTime();
			tmp = Fabonacci1(n);
			end = System.nanoTime();
			avg+= end-start;
			System.out.printf("Fabonacci[%d]=%d%n",n,tmp);
		}
		System.out.println(N+"此循环，平均计算时间："+avg/N+"纳秒");
	}

	/**
	 * get Fabonacci Sequence result in method1
	 */
	static int Fabonacci1(int n){
		if(n<=0){
			return -1;
		}
		return (1 == n || 2 == n) ? 1 : (Fabonacci1(n-1) + Fabonacci1(n-2));
	}

	/**
	 * get Fabonacci Sequence result in method2
	 * 初始化前10个数，缩短计算时间
	 */
	static int Fabonacci2(int n){
		int[] init = new int[]{-1,1,1,2,3,5,8,13,21,34,55};
		if(n<=10){
			return init[n];
		}
		return Fabonacci2(n-1) + Fabonacci2(n-2);
	}
}