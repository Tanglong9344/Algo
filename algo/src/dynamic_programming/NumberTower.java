/**
 * 数塔问题，计算从塔顶到塔底，使经过的各层数字之和最大
 */

package dynamic_programming;

public class NumberTower {
	static final int N=3;
	static final int RANGE=10;
	public static void main(String [] args){
		int numTower[][]=new int[N][N];
		//Initialization Array
		int i,j;
		for(i=0;i<N;i++){
			for(j=0;j<N;j++){
				if(i>=j) {
					numTower[i][j]=(int)(Math.random()*RANGE+1);
					//print the value of number tower
					System.out.print(numTower[i][j]+" ");
				}
			}
			System.out.println();
		}
		//calculate number tower
		numberTowerCal(numTower);
	}

	/**
	 * Calculate number tower
	 * @param tower
	 */
	static void numberTowerCal(int numTower[][]){
		int height=numTower.length;//height of number tower
		int i,j;
		for(i=height-2;i>=0;i--){
			for(j=0;j<=i;j++){
				numTower[i][j]=numTower[i][j]+Math.max(numTower[i+1][j],numTower[i+1][j+1]);
			}
		}
		//print result
		System.out.println("Maximum Result:"+numTower[0][0]);
	}
}