package math;

import recursion.Factorial;

/**
 * 组合计算
 * @author 唐龙
 */
public class Combination {
	public static void main(String[] args) {
		int m=2;
		int n=5;
		System.out.println(calCombination(m,n));
	}

	/**
	 * 组合Cm,n计算
	 * @param m
	 * @param n
	 * @return
	 */
	public static long calCombination(int m,int n){
		if(m>n || m<0 || n<0){
			return -1;
		}
		if(m == n){
			return 1;
		}
		long s=1;
		for(int i=n;i>=n-m+1;i--){
			s*=i;
		}
		return s/Factorial.facIterator(m);
	}
}