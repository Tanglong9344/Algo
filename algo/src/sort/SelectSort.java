/**
 * 时间复杂度O(n2),空间复杂度O(1)
 */

package sort;

import java.util.Random;

public class SelectSort {
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
		//选择排序
		selectSort(intArr);
		long end = System.nanoTime();
		System.out.printf("选择排序共耗时%f纳秒%n",(end-begin)/1.0);
		//选择排序后
		System.out.println("选择排序后:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	//选择排序实现方法
	static void selectSort(int [] intArr){
		int i,j,swap;
		int l=intArr.length;
		int minPos;//记录某一趟操作下的最小值位置
		//进行n-1趟操作
		for(i=0;i<l-1;i++){
			minPos=i;
			for(j=i+1;j<l;j++){
				//升序
				if(intArr[j]<intArr[minPos]){
					minPos=j;
				}
			}
			//是否需要交换
			if(minPos != i){
				swap=intArr[i];
				intArr[i]=intArr[minPos];
				intArr[minPos]=swap;
			}
		}
		System.out.printf("共进行%d趟操作%n",i);
	}
}