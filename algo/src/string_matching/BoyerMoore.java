package string_matching;

/**
 * Boyer-Moore算法
 * 对目标字符串进行倒序比较
 * http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
 *
 * @author 唐龙
 *
 */
public class BoyerMoore {
	public static void main(String[] args) {
		String is = stringMatching(CommonString.source,CommonString.dest)?"":"不";
		System.out.println(CommonString.source+is+"包含 "+CommonString.dest);
	}

	// String Matching(Boyer-Moore算法)
	static boolean stringMatching(String source,String dest){
		int dLen=dest.length();
		int sLen=source.length();
		//减枝
		if(sLen<dLen){
			return false;
		}
		return true;
	}
}