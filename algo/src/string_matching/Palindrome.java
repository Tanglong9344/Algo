package string_matching;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文数判断
 */
public class Palindrome {
	public static void main(String[] args) {
		//测试内容
		List<String> list = new ArrayList<String>();
		list.add("level");
		list.add("eye");
		list.add("3456543");
		list.add("q23qwqwd");

		//测试
		list.forEach(str->test(str));
	}

	//回文数判断
	static void test(String str){
		String is = palindromeJudgeHt(str) ? "" : "不";
		System.out.printf("%8s%s是回文数%n",str,is);
	}

	// palindrome Judgement(head to tail)
	static boolean palindromeJudgeHt(String str){
		// 空串或单字符串一定是回文
		if(str.length()<=1){
			return true;
		}
		char[] chars = str.toCharArray();
		//字符串前半部分和后半部分比较
		for(int i=0,j=str.length()-1;i<j;i++,j--){
			if(chars[j] != chars[i]){
				return false;
			}
		}
		return true;
	}

	// palindrome Judgement(Reverse Array)
	// This is not a good method
	// just a way to other thought
	static boolean palindromeJudge2(String str){
		int len = str.length();
		// 空串或单字符串一定是回文
		if(len<=1){
			return true;
		}
		char[] chars = str.toCharArray();
		char[] charsReverse = new char[len];
		//生成反序数组
		for(int i=0;i<len;i++){
			charsReverse[i]=chars[--len];
		}
		//字符比较
		for(int i=0;i<len;i++){
			if(charsReverse[i]!=chars[i]){
				return false;
			}
		}
		return true;
	}
}