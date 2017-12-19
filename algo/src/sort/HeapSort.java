package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 堆排序
 * 在最坏情况下，时间复杂度O(NlogN)，空间复杂度O(1)
 *
 * 实施过程：
 * 1，新建堆
 * 2，交换元素
 * 3，重建堆
 *
 * 使用一维数组存储二叉树
 * 其中节点i的左子节点为2i+1,右子节点为2i+2
 */
public class HeapSort {
	public static void main(String[] args) {
		int [] intArr = new int [CommonFinal.LENGTH];
		//堆排序
		//数据初始化
		Random rd = new Random();
		for(int i=0;i<CommonFinal.LENGTH;i++){
			intArr[i]=rd.nextInt(CommonFinal.RANGE);
		}
		//排序前
		System.out.println("排序前:"+Arrays.toString(intArr));
		long begin = System.nanoTime();
		//堆排序
		heapSort(intArr);
		long end = System.nanoTime();
		System.out.printf("堆排序共耗时%f纳秒%n",(end-begin)/1.0);
		//堆排序排序后
		System.out.println("堆排序后:"+Arrays.toString(intArr));
	}

	public static  void heapSort(int[] arr){
		//循环建堆
		for(int i=1,len=arr.length;i<len;i++){
			//建堆
			buildMaxHeap(arr,len-i);
			System.out.printf("第%2d次建立大顶堆    :%s%n",i,Arrays.toString(arr));
			//交换堆顶和最后第i个元素
			swap(arr,0,len-i);
			System.out.printf("第%2d次交换堆顶元素:%s%n",i,Arrays.toString(arr));
		}
	}
	//对数组从0到len建大顶堆
	private static void buildMaxHeap(int[]arr, int len) {
		//从最后一个节点的父节点开始
		for(int i=(len-1)/2,k,big;i>=0;i--){
			//k保存正在判断的节点
			k=i;
			//如果当前k节点的子节点存在
			if(k*2+1<=len){
				//k节点的左子节点的索引
				big=k*2+1;
				//如果big小于len，即big+1代表的k节点的右子节点存在
				if(big<len){
					//若果右子节点的值较大
					if(arr[big]<arr[big+1]){
						//big总是记录较大子节点的索引
						big=big+1;
					}
				}
				//如果k节点的值小于其较大的子节点的值
				if(arr[k]<arr[big]){
					swap(arr,k,big);//交换
				}
			}
		}
	}

	//交换操作
	private static  void swap(int[] arr, int i,int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
}