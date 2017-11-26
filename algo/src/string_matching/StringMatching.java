package string_matching;

/**
 * 朴素的字符串匹配算法
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
		//判断
		int index,j;
		//source匹配
		for(int i=0;i<sLen-dLen+1;i++){
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