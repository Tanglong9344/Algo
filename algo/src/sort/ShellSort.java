/**
 * 时间复杂度<O(n2)
 */

package sort;

import java.util.Random;

public class ShellSort {
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
		//希尔排序
		shellSort(intArr);
		long end = System.nanoTime();
		System.out.printf("希尔排序共耗时%f纳秒%n",(end-begin)/10.0);
		//希尔排序后
		System.out.println("希尔排序后:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	//希尔排序实现方法
	static void shellSort(int[] intArr){
		int i,j,k;
		int len=intArr.length;
		int gap=len;//每个分组间的增量
		int tmp;
		//分组长度为1时终止操作
		while(gap>1){
			//增量减半
			gap=(int) Math.ceil(gap/2);
			//各个分组使用插入排序
			for(k=0;k<gap;k++){
				for(i=k+gap;i<intArr.length;i+=gap){
					tmp=intArr[i];
					//移动
					for(j=i-gap;j>=k&&tmp<intArr[j];j-=gap){
						intArr[j+gap]=intArr[j];
					}
					//插入
					intArr[j+gap]=tmp;
				}
			}
			//显示每次操作的结果
			System.out.printf("第%d类分组排序结果：%n",gap);
			for(int v : intArr){
				System.out.print(v+" ");
			}
			System.out.println();
		}
	}
}