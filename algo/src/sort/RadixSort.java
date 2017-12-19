package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 基数排序
 * 时间复杂度O(d(N+rd))=O(d.N),空间复杂度O(rd)
 * d:关键字数目，rd关键字取值范围
 *
 * 基本操作过程:数据分配，数据收集。
 *
 * @author 唐龙
 *
 */
public class RadixSort {
	public static void main(String[] args) {
		int [] intArr = new int [CommonFinal.LENGTH];
		//数据初始化
		Random rd = new Random();
		for(int i=0;i<CommonFinal.LENGTH;i++){
			intArr[i]=rd.nextInt(CommonFinal.RANGE);
		}
		//排序前
		System.out.println("排序前        ："+Arrays.toString(intArr));
		long begin = System.nanoTime();
		//基数排序
		radixSort(intArr);
		long end = System.nanoTime();
		System.out.printf("基数排序共耗时%f纳秒%n",(end-begin)/1.0);
		//基数排序后
		System.out.println("基数排序后："+Arrays.toString(intArr));
	}

	//基数排序实现方法
	public static void radixSort(int[] arr){
		//首先确定排序的趟数;
		//找出最大值
		int max=arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		int time=0;//记录数据最大位数
		//位数统计;
		while(max>0){
			max/=10;
			time++;
		}
		//建立10个队列，分别用于存储各个位数数字为0-9的数据
		List<ArrayList<Integer>> lists=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = null;//用于暂存数据
		for(int i=0;i<10;i++){
			list=new ArrayList<Integer>();
			lists.add(list);
		}
		//进行time次分配和收集;
		for(int i=1,j,x,k,cnt;i<=time;i++){
			//分配数组元素;
			for(j=0;j<arr.length;j++){
				//得到数字的第time位数;
				x=(arr[j]%(int)Math.pow(10,i))/(int)Math.pow(10,i-1);
				list=lists.get(x);
				list.add(arr[j]);
			}
			//显示每次操作结果
			System.out.printf("第%2d操作：%s%n",i,lists);
			cnt=0;//元素计数器;
			//收集队列元素;
			for(k=0;k<10;k++){
				list=lists.get(k);
				while(list.size()>0){
					arr[cnt]=list.get(0);
					list.remove(0);
					cnt++;
				}
			}
		}
	}
}