package string_matching;

public class StringMatchSubString {
	public static void main(String[] args) {
		String is = stringMatching(CommonString.source,CommonString.dest)?"":"不";
		System.out.println(CommonString.source+is+"包含 "+CommonString.dest);
	}

	// String Matching with the help of subString
	static boolean stringMatching(String source,String dest){
		int dLen=dest.length();
		int sLen=source.length();
		//减枝
		if(sLen<dLen){
			return false;
		}
		//判断
		//source匹配
		for(int i=0;i<sLen-dLen+1;i++){
			//dest匹配
			if(dest.equals(source.substring(i,i+dLen))){
				return true;
			}
		}
		return false;
	}
}