package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序
 * 时间复杂度O(n2),空间复杂度O(1)
 */
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
		System.out.println("排序前:"+Arrays.toString(intArr));

		long begin = System.nanoTime();
		//冒泡排序1
		bubbleSort1(intArr);
		long end = System.nanoTime();
		System.out.printf("冒泡排序1共耗时%f纳秒%n",(end-begin)/1.0);
		//冒泡排序1排序后后
		System.out.println("冒泡排序1后:"+Arrays.toString(intArr));

		//冒泡排序2
		//数据初始化
		for(int i=0;i<CommonFinal.LENGTH;i++){
			intArr[i]=rd.nextInt(CommonFinal.RANGE);
		}
		//排序前
		System.out.println("排序前:"+Arrays.toString(intArr));
		begin = System.nanoTime();
		//冒泡排序2
		bubbleSort2(intArr);
		end = System.nanoTime();
		System.out.printf("冒泡排序2共耗时%f纳秒%n",(end-begin)/10.0);
		//冒泡排序2排序后后
		System.out.println("冒泡排序2后:"+Arrays.toString(intArr));
	}
	//冒泡排序实现方法1
	static void bubbleSort1(int [] intArr){
		//进行n-1趟操作
		for(int i=0,j,len=intArr.length;i<len-1;i++){
			for(j=len-1;j>i;j--){
				//升序
				if(intArr[j]<intArr[j-1]){
					swap(intArr,j,j-1);//交换
				}
			}
			//显示每趟操作的结果
			System.out.printf("第%2d趟操作:%s%n",i+1,Arrays.toString(intArr));
		}
	}

	//冒泡排序实现方法2，在实现方法1的基础加上有序判断
	static void bubbleSort2(int [] intArr){
		boolean stop = false;//如果已经有序则停止操作
		//进行n-1趟操作
		for(int i=0,j,len=intArr.length;i<len-1&&!stop;i++){
			stop=true;
			for(j=0;j<len-i-1;j++){
				//升序
				if(intArr[j]>intArr[j+1]){
					swap(intArr,j,j+1);//交换
					stop=false;
				}
			}
			//显示每趟操作的结果
			System.out.printf("第%2d趟操作:%s%n",i+1,Arrays.toString(intArr));
		}
	}

	// 交换方法
	static void swap(int[] arr,int i,int j){
		int tmp;
		tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
}