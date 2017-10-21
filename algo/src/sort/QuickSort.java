/**
 * 平均时间复杂度O(NlogN)，最坏时间复杂度O(N2)，空间复杂度O(logN)
 */

package sort;

import java.util.Random;

public class QuickSort {
	private static int sum=0;//统计操作次数
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
		//快速排序
		quickSort(intArr,0,intArr.length-1);
		long end = System.nanoTime();
		System.out.printf("快速排序共耗时%f纳秒%n",(end-begin)/1.0);
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
		int low = start;//低位
		int high = end;//高位
		int key=intArr[start];//以第一个数为参考值
		while (low < high) {
			//从高位开始遍历比较
			//跳过大于等于参考值的数据
			while(low<high && intArr[high]>=key) {
				high--;
			}
			//小于key的值移动到key左边
			intArr[low]=intArr[high];
			//跳过小于等于参考值的数据
			while(low<high && intArr[low]<=key) {
				low++;
			}
			//大于key的值移动到key右边
			intArr[high]=intArr[low];
		}
		//将参考值放回
		intArr[low]=key;
		//显示每次排序的结果
		sum++;
		System.out.printf("第%d次操作结果:%n",sum);
		for(int v : intArr){
			System.out.print(v+" ");
		}
		System.out.println("");
		//递归操作
		//左半部分
		if(low>start) {
			quickSort(intArr, start, low-1);
		}
		//右半部分
		if(high<end) {
			quickSort(intArr, low+1, end);
		}
	}
}