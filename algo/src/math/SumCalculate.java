package math;

public class SumCalculate {
	static final int N = 10;
	static final int RANGE = 30000;
	public static void main(String[] args) {
		int num;
		long start;
		long end;
		for(int i=0;i<N;i++){
			num=(int)(Math.random()*RANGE);
			start = System.nanoTime();
			System.out.print(num+"循环累加结果："+add(num)+"\t");
			end = System.nanoTime();
			System.out.println("所用时间："+(end-start)+"ns");

			start = System.nanoTime();
			System.out.print(num+"递归求和结果："+addRecursion(num)+"\t");
			end = System.nanoTime();
			System.out.println("所用时间："+(end-start)+"ns");

			start = System.nanoTime();
			System.out.print(num+"公式求和结果："+addFormula(num)+"\t");
			end = System.nanoTime();
			System.out.println("所用时间："+(end-start)+"ns");
		}
	}

	//循环累加
	static int add(int n){
		//n必须大于等于0
		if(n<0) {
			return -1;
		}
		int s=0;
		for(int i=1;i<=n;i++){
			s+=i;
		}
		return s;
	}

	//递归求和(递归会受jvm内存大小的限制)
	static int addRecursion(int n){
		//n必须大于等于0
		if(n<0) {
			return -1;
		}
		if(1==n || 0==n){
			return n;
		}
		return (n+addRecursion(n-1));
	}
	//公式求和 s=(n*(n+1))/2
	static int addFormula(int n){
		//n必须大于等于0
		if(n<0) {
			return -1;
		}
		//防止数据溢出
		//先做除法
		int a = n%2==0?(n/2):n;
		int b = (n+1)%2==0?((n+1)/2):(n+1);
		//再做乘法
		return a*b;
	}
}