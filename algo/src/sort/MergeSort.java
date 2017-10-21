/**
 * 时间复杂度O(NlogN),空间复杂度O(N)
 */

package sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
	static int cnt = 0;//记录操作次数
	public static void main(String[] args) {
		int [] intArr = new int [CommonFinal.LENGTH];
		//数据初始化
		Random rd = new Random();
		for(int i=0;i<CommonFinal.LENGTH;i++){
			intArr[i]=rd.nextInt(CommonFinal.RANGE);
		}
		//排序前
		System.out.println("排序前    ："+Arrays.toString(intArr));
		long begin = System.nanoTime();
		//归并排序
		mergeSort(intArr,0,intArr.length-1);
		long end = System.nanoTime();
		System.out.printf("归并排序共耗时%f纳秒%n",(end-begin)/1.0);
		//归并排序后
		System.out.println("归并排序后："+Arrays.toString(intArr));
	}

	//递归实现归并排序
	public static void mergeSort(int[] data,int left,int right) {
		if(left<right){
			//二分
			int center=(left+right)/2;
			//左递归
			mergeSort(data,left,center);
			//右递归
			mergeSort(data,center+1,right);
			//左右合并
			merge(data,left,center,right);
		}
	}
	public static void merge(int[] data,int left,int center,int right) {
		int [] mergeArr=new int[data.length];//合并数组
		int rightStart=center+1;//右边数组起始位置
		int index=left;//合并数组起始索引
		int iniPos=left;//记录原数组待排序部分的起始位置
		while(left<=center&&rightStart<=right){
			//从两个数组中取出最小的放入中间数组
			mergeArr[index++]=data[left]<=data[rightStart]?data[left++]:data[rightStart++];
		}
		//剩余部分依次放入中间数组
		//左边数据
		while(left<=center){
			mergeArr[index++]=data[left++];
		}
		//右边数据
		while(rightStart<=right){
			mergeArr[index++]=data[rightStart++];
		}
		//将合并数组中的内容复制回原数组
		while(iniPos<=right){
			data[iniPos]=mergeArr[iniPos++];
		}
		//显示每次操作的结果
		cnt++;
		System.out.printf("第%2d操作：%s%n",cnt,Arrays.toString(data));
	}
}