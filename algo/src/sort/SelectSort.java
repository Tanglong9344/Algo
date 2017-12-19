package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 选择排序
 *
 * 时间复杂度O(n2),空间复杂度O(1)
 *
 * @author 唐龙
 *
 */
public class SelectSort {
	public static void main(String[] args) {
		int [] intArr = new int [CommonFinal.LENGTH];
		//数据初始化
		Random rd = new Random();
		for(int i=0;i<CommonFinal.LENGTH;i++){
			intArr[i]=rd.nextInt(CommonFinal.RANGE);
		}
		//排序前
		System.out.println("排序前:"+Arrays.toString(intArr));
		long begin = System.nanoTime();
		//选择排序
		selectSort(intArr);
		long end = System.nanoTime();
		System.out.printf("选择排序共耗时%f纳秒%n",(end-begin)/1.0);
		//选择排序后
		System.out.println("选择排序后:"+Arrays.toString(intArr));
	}
	//选择排序实现方法
	private static void selectSort(int [] intArr){
		//进行n-1趟操作
		for(int i=0,j,swap,l=intArr.length,minPos;i<l-1;i++){
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
			//显示每趟操作的结果
			System.out.printf("第%2d趟操作:%s%n",i+1,Arrays.toString(intArr));
		}
	}
}