package sort;

import java.util.Random;

public class InsertSort {
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
		//插入排序
		insertSort(intArr);
		long end = System.nanoTime();
		System.out.printf("插入排序共耗时%f纳秒%n",(end-begin)/10.0);
		//插入排序后
		System.out.println("插入排序后:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	//插入排序实现方法
	static void insertSort(int[] intArr){
		int i,j;
		int l=intArr.length;
		int tmp;
		for(i=1;i<l;i++){
			tmp=intArr[i];
			//数据移动
			for(j=i-1;j>=0&&intArr[j]>tmp;j--){
				intArr[j+1]=intArr[j];
			}
			intArr[j+1]=tmp;
			//显示每次操作的结果
			System.out.printf("第%d次操作：%n",i);
			for(int v : intArr){
				System.out.print(v+" ");
			}
			System.out.println();
		}
	}
}