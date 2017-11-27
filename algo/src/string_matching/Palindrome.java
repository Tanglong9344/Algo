package string_matching;

/**
 * 回文数判断
 */
public class Palindrome {
	public static void main(String[] args) {
		String str="12qwertrewq21";
		//回文数判断
		String is = palindromeJudgeHt(str) ? "" : "不";
		System.out.println(str+is+"是回文数");
	}

	// palindrome Judgement(head to tail)
	static boolean palindromeJudgeHt(String str){
		char[] chars = str.toCharArray();
		//字符串前半部分和后半部分比较
		for(int i=0,j=str.length()-1;i<j;i++,j--){
			if(chars[j] != chars[i]){
				return false;
			}
		}
		return true;
	}

	// palindrome JudgementRev(Reverse Array)
	// This is not a good method
	// just a way to other thought
	static boolean palindromeJudge2(String str){
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