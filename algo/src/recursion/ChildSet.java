package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用递归和二叉树求一个集合的所有子集
 * 集合的每个元素有两种状态：
 * 1.属于子集
 * 2.不属于子集
 * 任意一个元素数目为n的集合其子集个数为2^n
 * @author 唐龙
 */
public class ChildSet {
	final static int N = 5;//集合元素数目
	public static void main(String[] args) {
		List<String> set = new ArrayList<String>();
		//初始化
		for(int i=0;i<N;i++){
			set.add("E"+i);
		}
		System.out.println("集合:\n"+set);
		List<String> setResult = new ArrayList<String>();
		System.out.println("集合的所有子集:");
		getChildSet(set,setResult,0);
	}

	/**
	 * 集合子集的求解
	 * @param set 待求解集合
	 * @param setResult 子集结果
	 * @param pos
	 */
	static <T> void getChildSet(List<T> set,List<T> setResult,int pos){
		T x;
		if(pos>=set.size()){
			System.out.println(setResult);
		}else{
			x = (T) set.get(pos);
			//选择元素
			setResult.add(x);
			getChildSet(set,setResult,pos+1);
			//不选择元素
			setResult.remove(x);
			getChildSet(set,setResult,pos+1);
		}
	}
}