package sort;

import java.util.Random;

public class ShellSort {
	public static void main(String[] args) {
		final int LENGTH=10;//数组长度
		final int RANGE =100;//数据范围
		int [] intArr = new int [LENGTH];
		//数据初始化
		Random rd = new Random();
		for(int i=0;i<LENGTH;i++){
			intArr[i]=rd.nextInt(RANGE);
		}
		//排序前
		System.out.println("排序前:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();
		long begin = System.nanoTime();
		//希尔排序
		shellSort(intArr);
		long end = System.nanoTime();
		System.out.printf("希尔排序共耗时%f纳秒%n",(end-begin)/10.0);
		//希尔排序后
		System.out.println("希尔排序后:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	//希尔排序实现方法
	static void shellSort(int[] intArr){
		int i,j,k;
		int len=intArr.length;
		double len2 = intArr.length;
		len2=Math.ceil(len2);
		int tmp;
		//分组长度为1时终止操作
		while(1 != (len=(int)len2)){
			len2=Math.ceil(len2/2);
			//各个分组使用插入排序
			for(k=0;k<len;k++){
				for(i=k+len;i<intArr.length;i+=len){
					tmp=intArr[i];
					for(j=i-len;j>=0&&tmp<intArr[j];j-=len){
						intArr[j+len]=intArr[j];
					}
					intArr[j+len]=tmp;
					//显示每次操作的结果
					System.out.printf("第%d类分组排序结果：%n",len);
					for(int v : intArr){
						System.out.print(v+" ");
					}
					System.out.println();
				}
			}
		}
	}
}