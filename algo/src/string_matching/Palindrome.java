package string_matching;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文数判断
 *
 * @author 唐龙
 *
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
		System.out.printf("%8s%s是回文数%n",str, (palindrome(str) ? "" : "不"));
		System.out.printf("%8s%s是回文数%n",str, (palindromeReverse(str) ? "" : "不"));
	}

	// palindrome Judgement(compare front half part and back half part)
	static boolean palindrome(String str){
		// 空串或单字符串一定是回文
		if(str.length()<=1){
			return true;
		}
		//字符串前半部分和后半部分比较
		for(int i=0,j=str.length()-1;i<j;i++,j--){
			if(str.charAt(j) != str.charAt(i)){
				return false;
			}
		}
		return true;
	}

	// palindrome Judgement(Reverse String)
	static boolean palindromeReverse(String str){
		return new StringBuilder(str).reverse().toString().equals(str);
	}
}