package sort;

import java.util.Random;

public class MergeSort {
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
		//归并排序
		mergeSort(intArr);
		long end = System.nanoTime();
		System.out.printf("归并排序共耗时%f纳秒%n",(end-begin)/10.0);
		//归并排序后
		System.out.println("归并排序后:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();
	}

	private static void mergeSort(int[] intArr) {
		// TODO Auto-generated method stub
	}
}