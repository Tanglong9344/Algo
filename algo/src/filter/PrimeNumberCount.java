package filter;

import java.util.Random;

/**
 * Preprocess to count  the number
 * of  <strong>prime number</strong>
 * between 0-N
 */

public class PrimeNumberCount {
	static final int N = 10000;
	static int[] intArr = new int[N];
	//Preprocess
	public PrimeNumberCount(){
		int i,j;
		//initialization
		for(i=2;i<N;i++){
			intArr[i]=0;
		}
		//filter
		for(i=2;i<(N/2);i++){
			if(0 == intArr[i]){
				for(j=i+i;j<N;j+=i){
					intArr[j]=1;
				}
			}
		}
	}
	public static void main(String[] args) {
		PrimeNumberCount pnc = new PrimeNumberCount();//preprocess
		int countNum = 100;//count times
		Random random = new Random();
		for(int i=0;i<countNum;i++){
			pnc.countPrimeNumber(random.nextInt(10000));
		}
	}
	//count the number of prime number
	void countPrimeNumber(int num){
		int count = 0;
		for(int i=2;i<num;i++){
			if(0 == intArr[i]){
				count++;
			}
		}
		System.out.printf("The number of prime number between 0-%d is %d%n",num,count);
	}
}