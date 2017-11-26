package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 一般插入排序
 * 时间复杂度O(n2),空间复杂度O(1)
 */
public class InsertSort {
	public static void main(String[] args) {
		int [] intArr = new int [CommonFinal.LENGTH];
		//插入排序
		//数据初始化
		Random rd = new Random();
		for(int i=0;i<CommonFinal.LENGTH;i++){
			intArr[i]=rd.nextInt(CommonFinal.RANGE);
		}
		//排序前
		System.out.println("排序前:"+Arrays.toString(intArr));
		long begin = System.nanoTime();
		//插入排序
		insertSort(intArr);
		long end = System.nanoTime();
		System.out.printf("插入排序共耗时%f纳秒%n",(end-begin)/1.0);
		//插入排序后
		System.out.println("插入排序后:"+Arrays.toString(intArr));
	}

	//插入排序实现方法
	static void insertSort(int[] intArr){
		int i,j;
		int len=intArr.length;
		int tmp;
		for(i=1;i<len;i++){
			tmp=intArr[i];
			//数据移动
			for(j=i-1;j>=0&&intArr[j]>tmp;j--){
				intArr[j+1]=intArr[j];
			}
			intArr[j+1]=tmp;
			//显示每次操作的结果
			System.out.printf("第%2d次操作：%s%n",i,Arrays.toString(intArr));
		}
	}
}