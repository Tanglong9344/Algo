/**
 * 菲波那切数列
 * Formula:F(n|n>2)=F(n-1)+F(n-2)
 * F(1)=1,F(2)=1
 */

package recursion;

import java.util.Random;

public class FibonacciSequence {
	static final int N = 100;//循环次数
	static final int RANGE = 30;//数据范围
	static final int[] init = new int[]{-1,1,1,2,3,5,8,13,21,34,55};
	public static void main(String[] args) {
		int n = 0;
		Random random = new Random();
		int avg;//平均计算时间
		long start,end;
		//分别测试两个方法
		int loop = 2;
		String choose = null;
		while(loop-->0){
			avg = 0;
			for(int i=0;i<N;i++){
				n = random.nextInt(RANGE);
				start = System.nanoTime();
				if(1 == loop){
					Fabonacci(n);
					choose = "直接    递归";
				}
				if(0 == loop){
					FabonacciPre(n);
					choose = "预处理递归";
				}
				end = System.nanoTime();
				avg += end-start;
			}
			System.out.printf("%d次循环，%s平均计算时间：%dms%n",N,choose,avg/N);
		}
	}

	/**
	 * get Fabonacci Sequence result in recursion
	 */
	static int Fabonacci(int n){
		if(n<=0){
			return -1;
		}
		return (1 == n || 2 == n) ? 1 : (Fabonacci(n-1) + Fabonacci(n-2));
	}

	/**
	 * get Fabonacci Sequence with the help of preprocessor
	 * 初始化前10个数，缩短计算时间
	 * 声明为全局静态数组init
	 * static final int[] init = new int[]{-1,1,1,2,3,5,8,13,21,34,55};
	 */
	static int FabonacciPre(int n){
		return n<=10 ? init[n] : FabonacciPre(n-1) + FabonacciPre(n-2);
	}
}