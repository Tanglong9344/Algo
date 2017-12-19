package string_matching;

/**
 * 朴素的字符串匹配(模式匹配)算法2
 *
 * @author 唐龙
 *
 */
public class StringMatching2 {
	public static void main(String[] args) {
		String is = stringMatching(CommonString.source,CommonString.dest)?"":"不";
		System.out.println(CommonString.source+is+"包含 "+CommonString.dest);
	}

	// String Matching in a simple way
	static boolean stringMatching(String source,String dest){
		int dLen=dest.length();
		int sLen=source.length();
		//减枝
		if(sLen<dLen){
			return false;
		}
		//判断
		int i=0,j=0;//初始比较位置
		//如果双方的某个字 符相等则双方继续比较下一个字符
		//否则dest返回并继续和source的下一个字符比较
		while(i<sLen && j<dLen){
			if(source.charAt(i) == dest.charAt(j)){
				i++;
				j++;
			}else{
				j=0;
				i=i-j+1;
			}
		}
		return j >= dLen;
	}
}