package filter;

/**
 * 判断一个数是否是质数(Prime Number)
 */
public class PrimeNumber {
	//prime number judge
	public static boolean primeNumberJudge(int num){
		int x = (int) Math.sqrt(num);//optimize
		int i;
		//loop for divisor
		for(i=2;i<=x && (num%i != 0);i++){}
		//result
		return (i>x && 0 != x && 1 != x)?true:false;
	}
}