/**
 * 时间复杂度O(n2),空间复杂度O(1)
 * 相比于一般插入排序，减少了比较次数，移动次数不变。
 */

package sort;

import java.util.Random;

public class BinaryInsertSort {
	public static void main(String[] args) {
		int [] intArr = new int [CommonFinal.LENGTH];
		//折半插入排序
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
		//折半插入排序
		binaryInsertSort(intArr);
		long end = System.nanoTime();
		System.out.printf("折半插入排序共耗时%f纳秒%n",(end-begin)/1.0);
		//折半插入排序后
		System.out.println("折半插入排序后:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	//折半折半插入排序实现方法
	static void binaryInsertSort(int[] intArr){
		int i,j;
		int len=intArr.length;
		int tmp,low,high,mid;
		for(i=1;i<len;i++){
			tmp=intArr[i];
			low = 0;
			high = i-1;
			//折半查找插入位置
			while(low<=high){
				mid = (low+high)/2;
				if(tmp<intArr[mid]){
					high = mid-1;
				}else{
					low = mid+1;
				}
			}
			//数据移动
			for(j=i-1;j>=high+1;j--){
				intArr[j+1]=intArr[j];
			}
			intArr[high+1]=tmp;
			//显示每次操作的结果
			System.out.printf("第%d次操作：%n",i);
			for(int v : intArr){
				System.out.print(v+" ");
			}
			System.out.println();
		}
	}
}