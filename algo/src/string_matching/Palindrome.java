/**
 * 回文数判断
 */

package string_matching;

public class Palindrome {
	public static void main(String[] args) {
		String str="12qwertrewq21";
		//回文数判断
		String is = palindromeJudge(str)?"":"不";
		System.out.println(str+is+"是回文数。");
	}

	//palindrome Judgement
	static boolean palindromeJudge(String str){
		int len = str.length();
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