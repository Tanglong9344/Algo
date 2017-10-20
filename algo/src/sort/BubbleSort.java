/**
 * 时间复杂度O(n2)
 */

package sort;

import java.util.Random;

public class BubbleSort {
	public static void main(String[] args) {
		int [] intArr = new int [CommonFinal.LENGTH];
		//冒泡排序1
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
		//冒泡排序1
		bubbleSort1(intArr);
		long end = System.nanoTime();
		System.out.printf("冒泡排序1共耗时%f纳秒%n",(end-begin)/10.0);
		//冒泡排序1排序后后
		System.out.println("冒泡排序1后:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();

		//冒泡排序2
		//数据初始化
		for(int i=0;i<CommonFinal.LENGTH;i++){
			intArr[i]=rd.nextInt(CommonFinal.RANGE);
		}
		//排序前
		System.out.println("排序前:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();
		begin = System.nanoTime();
		//冒泡排序2
		bubbleSort2(intArr);
		end = System.nanoTime();
		System.out.printf("冒泡排序2共耗时%f纳秒%n",(end-begin)/10.0);
		//冒泡排序2排序后后
		System.out.println("冒泡排序2后:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	//冒泡排序实现方法1
	static void bubbleSort1(int [] intArr){
		int i,j;
		int len=intArr.length;
		boolean stop = false;//如果已经有序则停止操作
		//进行n-1趟操作
		for(i=0;i<len-1&&!stop;i++){
			stop=true;
			for(j=len-1;j>i;j--){
				//升序
				if(intArr[j]<intArr[j-1]){
					swap(intArr,j,j-1);//交换
					stop=false;
				}
			}
		}
		System.out.printf("共进行%d趟操作%n",i);
	}

	//冒泡排序实现方法2
	static void bubbleSort2(int [] intArr){
		int i,j;
		int len=intArr.length;
		boolean stop = false;//如果已经有序则停止操作
		//进行n-1趟操作
		for(i=0;i<len-1&&!stop;i++){
			stop=true;
			for(j=0;j<len-i-1;j++){
				//升序
				if(intArr[j]>intArr[j+1]){
					swap(intArr,j,j+1);//交换
					stop=false;
				}
			}
		}
		System.out.printf("共进行%d趟操作%n",i);
	}

	// 交换方法
	static void swap(int[] arr,int i,int j){
		int tmp;
		tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
}