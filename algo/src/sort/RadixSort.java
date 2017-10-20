package sort;

import java.util.Random;

public class RadixSort {
	public static void main(String[] args) {
		int [] intArr = new int [CommonFinal.LENGTH];
		//数据初始化
		Random rd = new Random();
		for(int i=0;i<CommonFinal.LENGTH;i++){
			intArr[i]=rd.nextInt(CommonFinal.RANGE);
		}
		//排序前
		System.out.println("排序前:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();
		long begin = System.nanoTime();
		//基数排序
		radixSort(intArr);
		long end = System.nanoTime();
		System.out.printf("基数排序共耗时%f纳秒%n",(end-begin)/1.0);
		//基数排序后
		System.out.println("基数排序后:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();
	}

	private static void radixSort(int[] intArr) {
		// TODO Auto-generated method stub

	}
}