package recursion;

import java.util.Random;

public class SumCalculate {
	static final int N = 10000;
	static final int RANGE = 10000;
	public static void main(String[] args) {
		Random random = new Random();
		long start;
		long end;
		int avg;
		String choose = null;
		int k,i;
		//分别对三种方法的性能进行测试(近似比较)
		for(k=0;k<3;k++){
			avg = 0;
			for(i=0;i<N;i++){
				start = System.nanoTime();
				switch(k){
				case 0:
					add(random.nextInt(RANGE));//循环累加
					choose = "循环累加";
					break;
				case 1:
					addRecursion(random.nextInt(RANGE));//递归求和
					choose = "递归求和";
					break;
				case 2:
					addFormula(random.nextInt(RANGE));//公式求和
					choose = "公式求和";
					break;
				default:;
				}
				end = System.nanoTime();
				avg+=end-start;
			}
			System.out.printf("操作%d次，%s平均耗时：%d纳秒%n",N,choose,avg/N);
		}
	}

	/**循环累加*/
	static int add(int n){
		//n是非负数
		if(n<0) {
			return -1;
		}
		int s=1;
		for(int i=2;i<=n;i++){
			s+=i;
		}
		return s;
	}

	/**递归求和(递归会受jvm内存大小的限制，效率也较低)*/
	static int addRecursion(int n){
		//n是非负数
		if(n<0) {
			return -1;
		}
		return (1==n || 0==n)? n : (n+addRecursion(n-1));
	}

	/**公式求和 s=(n*(n+1))/2*/
	static int addFormula(int n){
		//n是非负数
		if(n<0) {
			return -1;
		}
		//防止数据溢出
		//先做除法
		int a = n % 2 == 0 ? (n/2) : n;
		int b = (n+1) % 2 == 0 ? ((n+1)/2) : (n+1);
		//再做乘法
		return a * b;
	}
}