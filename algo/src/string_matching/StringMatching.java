package string_matching;

/**
 * 朴素的字符串匹配(模式匹配)算法
 *
 * @author 唐龙
 *
 */
public class StringMatching {
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
		//source匹配
		for(int i=0, index, j;i<sLen-dLen+1;i++){
			index=i;
			//dest匹配
			for(j=0;j<dLen;j++) {
				if(source.charAt(index++)!=dest.charAt(j)){
					break;
				}
			}
			if(j>=dLen) {
				return true;
			}
		}
		return false;
	}
}