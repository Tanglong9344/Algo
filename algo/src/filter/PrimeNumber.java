/**
 * 判断一个数是否是质数(Prime Number)
 */

package filter;

public class PrimeNumber {
	static final int N =10;//The number of numbers to judge
	static final int RANGE =100;//The range of numbers
	public static void main(String[] args) {
		PrimeNumber pn = new PrimeNumber();
		for(int i=0;i<N;i++){
			pn.primeNumberJudge((int)(Math.random()*RANGE));
		}
	}

	//prime number judge
	void primeNumberJudge(int num){
		int x = (int) Math.sqrt(num);//optimize
		int i;
		//loop for divisor
		for(i=2;i<=x && (num%i != 0);i++){}
		//result
		if(i>x && 0 != x && 1 != x){
			System.out.printf("%d is prime number.%n",num);
		}else{
			System.out.printf("%d is not prime number.%n",num);
		}
	}
}