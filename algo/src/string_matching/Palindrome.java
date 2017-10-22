package string_matching;

public class Palindrome {
	public static void main(String[] args) {
		String str="qwertrewq";
		//回文数判断
		if(palindromeJudge(str)){
			System.out.println(str+" 是回文数。");
		}else{
			System.out.println(str+" 不是回文数。");
		}
	}

	//palindrome Judgement
	static boolean palindromeJudge(String str){
		int len = str.length();
		char[] chars = str.toCharArray();
		char[] charsReverse = new char[len];
		//生成反序数组
		for(int i=0;i<chars.length;i++){
			charsReverse[i]=chars[--len];
		}
		//字符比较
		for(int i=0;i<chars.length;i++){
			if(charsReverse[i]!=chars[i]){
				return false;
			}
		}
		return true;
	}
}