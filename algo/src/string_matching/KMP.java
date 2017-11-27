package string_matching;

import java.util.Arrays;

/**
 * KMP(Knuth-Morris-Pratt)字符串匹配算法
 * http://www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html
 */
public class KMP {
	static int[] next;//模式匹配next数组
	public static void main(String[] args) {
		//generate partial match next
		next = partialMatchNext(CommonString.dest);
		System.out.println(CommonString.dest+"的部分匹配表："+Arrays.toString(next));
		//String matching
		String is = stringMatching(CommonString.source,CommonString.dest)?"":"不";
		System.out.println(CommonString.source+is+"包含 "+CommonString.dest);
	}

	/**
	 * Generate Partial Match next(部分匹配表)
	 *
	 * next[j] = 0,(j=1)
	 *           Max{k|1<k<j且'P1...Pk'='Pj-k+1...Pj'}(此集合不为空)
	 *           1(其它情况)
	 */
	static int[] partialMatchNext(String dest){
		int len = dest.length();
		int[] next = new int[len];//Partial Match next
		next[0]=0;//Initialize the first value
		int i,j;
		String sub;
		for(i=1,j=0;i<len;i++){
			//获取dest的子串
			sub = dest.substring(0,i+1);
			//获取子串前缀和后缀中公共部分的最大长度值
			next[i]=0;
			//倒序比较
			for(j=i;j>0 && (next[i]==0);j--){
				if(sub.substring(0,j).equals(sub.substring(i-j+1,i+1))){
					next[i]=j;
				}
			}
		}
		return next;
	}

	// String Matching
	static boolean stringMatching(String source,String dest){
		int dLen=dest.length();
		int sLen=source.length();
		//减枝
		if(sLen<dLen){
			return false;
		}
		//判断
		int index,j,i=0;
		//source匹配
		while(i<=sLen-dLen){
			index=i;
			//dest匹配
			for(j=0;j<dLen;j++) {
				if(source.charAt(index)!=dest.charAt(j)){
					break;
				}else{
					index++;
				}
			}
			if(j>=dLen) {
				return true;
			}
			//如果匹配：后移位数=匹配位数-next[j]
			//如果不匹配则顺序后移
			i=index>i?(--index)-next[--j]:i+1;
		}
		return false;
	}
}