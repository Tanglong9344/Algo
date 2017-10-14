package filter;

/**
 * Filter to get
 * <strong>prime number</strong>
 * between 0-N
 */

public class PrimeNumbersBetweenN {
	static final int N = 100;
	public static void main(String[] args) {
		int[] intArr = new int[N];
		int i,j;
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
		//print
		System.out.printf("The prime number between 0-%d is:%n",N);
		for(i=2;i<N;i++){
			if(0 == intArr[i]){
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}
}