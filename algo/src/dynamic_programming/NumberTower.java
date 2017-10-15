package dynamic_programming;

public class NumberTower {
	static final int N=10;
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
		int width=numTower[height-1].length;//width of the last floor of number tower
		int[][] tower = new int[height][width];
		//copy the data
		int i,j;
		//Initialization the last floor
		for(i=0;i<height;i++){
			tower[height-1][i]=numTower[height-1][i];
		}
		int[] path=new int[height];//记录最大结果的路径
		for(i=height-2;i>=0;i--){
			for(j=0;j<=i;j++){
				//tower[i][j]=numTower[i][j]+Math.max(tower[i+1][j],tower[i+1][j+1]);
				//path[i]=tower[i+1][j]>tower[i+1][j+1]?j:j+1;
				if(tower[i+1][j]>tower[i+1][j+1]){
					tower[i][j]=numTower[i][j]+tower[i+1][j];
					path[i]=j;
				}else{
					tower[i][j]=numTower[i][j]+tower[i+1][j+1];
					path[i]=j+1;
				}
			}
		}
		//print result
		System.out.println("Maximum Result:"+tower[0][0]);
		//print path
		System.out.print("Path："+numTower[0][0]);
		j=0;
		for(i=1;i<height;i++){
			System.out.print("->"+numTower[i][path[j++]]);
		}
		System.out.println();
	}
}