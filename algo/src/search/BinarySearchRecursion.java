package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 二分查找递归实现
 * @author 唐龙
 */
public class BinarySearchRecursion {
	final static int N = 100;//数据数目
	final static int R = 1000;//数据范围
	final static int CNT = 100;//操作次数
	public static void main(String[] args) {
		//初始化数据
		List<Integer> searchTable = new ArrayList<Integer>();
		Random random = new Random();
		for(int i=1;i<N+1;i++){
			searchTable.add(random.nextInt(R));
		}
		//从小到大排序
		Collections.sort(searchTable);;
		System.out.println("查找表：");
		searchTable.forEach(s->System.out.print(s+" "));
		System.out.println();
		int key;//目标数据
		boolean is;//数据是否存在(true:存在)
		int avg=0;//平均查找时间
		long start;//开始时间
		long end;//结束时间
		String choose;
		for(int i=0;i<CNT;i++){
			key = searchTable.get(random.nextInt(N));
			start = System.nanoTime();//记录开始时间
			is = binarySearchRec(searchTable,key);
			end = System.nanoTime();//记录结束时间
			avg+= end-start;
			choose = is ? "" : "不";
			System.out.println("目标数据"+key+choose+"存在");
		}
		System.out.printf("%d次查找的平均查找时间是%dns",CNT,avg/CNT);
	}

	/**
	 * 二分查找算法
	 * 使用递归实现
	 * @param searchTable
	 * @param key
	 * @return 返回目标数据是否存在
	 */
	static boolean binarySearchRec(List<Integer> searchTable,int key){
		int len = searchTable.size();
		if(1 == len){
			return searchTable.get(0) == key ? true : false;
		}
		int mid = len/2;
		if(searchTable.get(mid) == key){
			return true;
		}else if(searchTable.get(mid)>key){
			return binarySearchRec(searchTable.subList(0,mid),key);
		}else{
			return binarySearchRec(searchTable.subList(mid+1,len),key);
		}
	}
}