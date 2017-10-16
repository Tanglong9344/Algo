package dynamic_programming;

public class NumberTowerPath {
	static final int N=16;
	static final int RANGE=36;
	public static void main(String [] args){
		int numTower[][]=new int[N][N];
		//Initialization Array
		int i,j;
		for(i=0;i<N;i++){
			for(j=0;j<N;j++){
				if(i>=j) {
					numTower[i][j]=(int)(Math.random()*RANGE+1);
					//print the value of number tower
					System.out.printf("%2d ",numTower[i][j]);
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
		int[][] tower=new int[height][width];//copy the data
		int [][] path=new int[height][width];//record the path
		int i,j;
		//Initialization the last floor
		for(i=0;i<height;i++){
			tower[height-1][i]=numTower[height-1][i];
		}
		for(i=height-2;i>=0;i--){
			for(j=0;j<=i;j++){
				//tower[i][j]=numTower[i][j]+Math.max(tower[i+1][j],tower[i+1][j+1]);
				//path[i][j]=tower[i+1][j]>tower[i+1][j+1]?j:j+1;
				if(tower[i+1][j]>tower[i+1][j+1]){
					tower[i][j]=numTower[i][j]+tower[i+1][j];
					path[i][j]=j;
				}else{
					tower[i][j]=numTower[i][j]+tower[i+1][j+1];
					path[i][j]=j+1;
				}
			}
		}
		//print result
		System.out.println("Maximum Result:"+tower[0][0]);
		//print path
		System.out.printf("Path:[0][0]%2d",numTower[0][0]);
		j=path[0][0];
		for(i=1;i<height;i++){
			System.out.printf("->[%2d][%2d]%2d",i,j,numTower[i][j]);
			j=path[i][j];
			if(0 == i%5){
				System.out.println();
				System.out.print("\t     ");
			}
		}
		System.out.println();
	}
}