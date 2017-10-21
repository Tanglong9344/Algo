/**
 * 在最坏情况下，时间复杂度O(NlogN)，空间复杂度O(1)
 *
 * 实施过程：
 * 1，新建堆
 * 2，重建堆
 */

package sort;

import java.util.Arrays;
import java.util.Random;

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
		int len=arr.length;
		//循环建堆
		for(int i=1;i<len;i++){
			//建堆
			buildMaxHeap(arr,len-i);
			//交换堆顶和最后一个元素
			swap(arr,0,len-i);
			System.out.printf("第%2d次建立大顶堆:%s%n",i,Arrays.toString(arr));
		}
	}
	//对数组从0到lastIndex建大顶堆
	private static void buildMaxHeap(int[]arr, int lastIndex) {
		//从lastIndex处节点（最后一个节点）的父节点开始
		int i,k,biggerIndex;
		for(i=(lastIndex-1)/2;i>=0;i--){
			//k保存正在判断的节点
			k=i;
			//如果当前k节点的子节点存在
			while(k*2+1<=lastIndex){
				//k节点的左子节点的索引
				biggerIndex=2*k+1;
				//如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
				if(biggerIndex<lastIndex){
					//若果右子节点的值较大
					if(arr[biggerIndex]<arr[biggerIndex+1]){
						//biggerIndex总是记录较大子节点的索引
						biggerIndex++;
					}
				}
				//如果k节点的值小于其较大的子节点的值
				if(arr[k]<arr[biggerIndex]){
					//交换他们
					swap(arr,k,biggerIndex);
					//将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
					k=biggerIndex;
				}else{
					break;
				}
			}
		}
	}

	//交换操作
	private static  void swap(int[] arr, int i, int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
}