/**
 * 朴素的字符串匹配算法
 */

package string_matching;

public class StringMatching {
	public static void main(String[] args) {
		//This is a test
		if(stringMatching(CommonString.source,CommonString.dest)){
			System.out.println(CommonString.source+" 包含 "+CommonString.dest);
		}else{
			System.out.println(CommonString.source+" 不包含 "+CommonString.dest);
		}
	}

	// String Matching in a simple way
	static boolean stringMatching(String source,String dest){
		//减枝
		if(source.length()<dest.length()){
			return false;
		}
		//判断
		int index,j,len=dest.length();
		//source匹配
		for(int i=0;i<=source.length()-dest.length();i++){
			index=i;
			//dest匹配
			for(j=0;j<len;j++) {
				if(source.charAt(index++)!=dest.charAt(j)){
					break;
				}
			}
			if(j>=len) {
				return true;
			}
		}
		return false;
	}
}