package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用递归进行回文数判断
 */
public class PalindromeRecursion {
	public static void main(String[] args) {
		//测试内容
		List<String> list = new ArrayList<String>();
		list.add("level");
		list.add("eye");
		list.add("Tanglong");
		list.add("3456543");
		list.add("q23qwqwd");

		//测试
		list.forEach(str->test(str));
	}

	//回文数判断
	static void test(String str){
		String is = palindromeJudgeRec(str) ? "" : "不";
		System.out.printf("%8s%s是回文数%n",str,is);
	}

	// palindrome Judgement(head to tail)
	static boolean palindromeJudgeRec(String str){
		// 空串或单字符串一定是回文
		int len = str.length();
		if(len<=1){
			return true;
		}
		//归纳(转化为更简单的子问题)
		if(str.charAt(0) == str.charAt(len-1)){
			return palindromeJudgeRec(str.substring(1,len-1));
		}
		return false;
	}
}