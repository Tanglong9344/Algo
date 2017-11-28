package recursion;

/**
 * 阶乘计算
 * 1，递归方式
 * 2，迭代方式
 */
public class Factorial {
	static final int N = 10;
	static final int RANGE = 20;//the most range of long
	public static void main(String[] args) {
		int num;
		for(int i=0;i<N;i++){
			num = (int)(Math.random()*RANGE);
			System.out.printf("递归,%d的阶乘:%d%n",num,facRecursion(num));
			System.out.printf("迭代,%d的阶乘:%d%n",num,facIterator(num));
		}
	}

	//calculate factorial(recursion)
	static long facRecursion(int num){
		if(num<0){
			return -1;
		}
		//减枝
		if(0 == num || 1 == num){
			return 1;
		}
		return num == 2 ? 2 : num*facRecursion(num-1);
	}

	//calculate factorial(Iterator)
	public static long facIterator(int num){
		if(num<0){
			return -1;
		}
		long fac = 1;
		for(int i=2;i<=num;i++){
			fac*=i;
		}
		return fac;
	}
}