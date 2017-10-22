/**
 * Preprocess to count the number
 * of <strong>prime number</strong>
 * between 0-N
 */

package filter;

import java.util.Random;

public class PrimeNumberCountAnother {
	static final int N = 10000;
	static int[] intArr = new int[N];
	//Test
	public static void main(String[] args) {
		new PrimeNumberCountAnother();//preprocess
		int countNum = 10000;//count times
		Random random = new Random();
		for(int i=0;i<countNum;i++){
			int num = random.nextInt(1000);
			System.out.printf("The number of prime number between 0-%d is %d%n",num,intArr[num]);
		}
	}

	//Preprocess
	public PrimeNumberCountAnother(){
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
		//storage count result
		int[] primeNumCnt = new int[N];
		for(i=0;i<N;i++){
			primeNumCnt[i]=countPrimeNumber(i);
		}
		intArr=primeNumCnt;
	}

	//count the number of prime number
	int countPrimeNumber(int num){
		int count = 0;
		for(int i=2;i<=num;i++){
			if(0 == intArr[i]){
				count++;
			}
		}
		return count;
	}
}