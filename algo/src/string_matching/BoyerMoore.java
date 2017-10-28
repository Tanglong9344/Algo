/**
 * Boyer-Moore算法
 * 对目标字符串进行倒序比较
 * http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
 */

package string_matching;

public class BoyerMoore {
	public static void main(String[] args) {
		//This is a test
		if(stringMatching(CommonString.source,CommonString.dest)){
			System.out.println(CommonString.source+" 包含 "+CommonString.dest);
		}else{
			System.out.println(CommonString.source+" 不包含 "+CommonString.dest);
		}
	}

	// String Matching(Boyer-Moore算法)
	static boolean stringMatching(String source,String dest){
		//减枝
		if(source.length()<dest.length()){
			return false;
		}
		return true;
	}
}