package sort;

import java.util.Random;

public class QuickSort {
	private static int sum=0;//统计操作次数
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
		//快速排序
		quickSort(intArr,0,intArr.length-1);
		long end = System.nanoTime();
		System.out.printf("快速排序共耗时%f纳秒%n",(end-begin)/10.0);
		//快速排序后
		System.out.println("快速排序后:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	//快速排序实现方法
	//采用递归思想
	static void quickSort(int[] intArr,int start,int end){
		//结束标志
		if(start>=end){
			return;
		}
		//具体操作
		int l = start;//低位
		int h = end;//高位
		int key=intArr[start];//以第一个数为参考值
		int swap;
		while (l < h) {
			//从高位开始遍历比较
			//跳过大于等于参考值的数据
			while(l<h && intArr[h]>=key) {
				h--;
			}
			if (l<h) {
				swap=intArr[h];
				intArr[h]=intArr[l];
				intArr[l]=swap;
				l++;
			}

			//跳过小于等于参考值的数据
			while(l<h && intArr[l]<=key) {
				l++;
			}
			if(l<h){
				swap=intArr[l];
				intArr[l]=intArr[h];
				intArr[h]=swap;
				h--;
			}
		}
		sum++;
		System.out.printf("第%d次操作结果:%n",sum);
		for(int v : intArr){
			System.out.print(v+" ");
		}
		System.out.println("");
		//继续操作
		if(l>start) {
			quickSort(intArr, start, l-1);
		}
		if(h<end) {
			quickSort(intArr, l+1, end);
		}
	}
}