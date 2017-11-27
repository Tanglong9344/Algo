package recursion;
import math.Combination;

/**
 * N个元素进栈出栈所有可能的组合顺序数
 * 1.递归实现(公式：StackRushPop.png)
 * 2.组合公式(组合公式.jpg)
 * @author 唐龙
 */
public class StackPushPop {
	public static void main(String[] args) {
		int n = 5;
		//递归计算
		System.out.println(n+"个元素进栈出栈所有组合："+calStack(n));
		//组合公式计算
		System.out.println(n+"个元素进栈出栈所有组合："+Combination.calCombination(n,2*n)/(n+1));
	}

	/**
	 * 计算n个元素进栈出栈所有可能的组合顺序数
	 * @param num
	 * @return
	 */
	static int calStack(int n){
		//等于0或1时一个结果
		if(0 == n || 1 == n){
			return 1;
		}
		//等于2时两个结果
		if(2 == n){
			return 2;
		}
		int cnt=0;
		for(int i=0;i<n;i++){
			cnt+=calStack(i)*calStack(n-i-1);
		}
		return cnt;
	}
}