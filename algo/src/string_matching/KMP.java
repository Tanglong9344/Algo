/**
 * KMP(Knuth-Morris-Pratt)字符串匹配算法
 * http://www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html
 */

package string_matching;

import java.util.Arrays;

public class KMP {
	static int[] table;
	static int cnt=0;//记录比较次数
	public static void main(String[] args) {
		//generate partial match table
		table = partialMatchTable(CommonString.dest);
		System.out.println(CommonString.dest+"的部分匹配表："+Arrays.toString(table));
		//String matching
		if(stringMatching(CommonString.source,CommonString.dest)){
			System.out.println(CommonString.source+" 包含 "+CommonString.dest);
		}else{
			System.out.println(CommonString.source+" 不包含 "+CommonString.dest);
		}
		System.out.println("朴素算法比较次数："+String.valueOf(CommonString.source.length()-CommonString.dest.length()+1));
		System.out.println("KMP算法比较次数："+cnt);
	}

	//Generate Partial Match Table(部分匹配表)
	static int[] partialMatchTable(String dest){
		int len = dest.length();
		int[] table = new int[len];//Partial Match Table
		table[0]=0;
		int i,j;
		for(i=1,j=0;i<len;i++){
			//获取dest的子串
			String sub = dest.substring(0,i+1);
			//获取子串前缀和后缀中公共部分的最大长度值
			table[i]=0;
			for(j=1;j<i+1;j++){
				if(sub.substring(0,j).equals(sub.substring(i-j+1,i+1))){
					table[i]=j;
				}
			}
		}
		return table;
	}

	// String Matching
	static boolean stringMatching(String source,String dest){
		//减枝
		if(source.length()<dest.length()){
			return false;
		}
		//判断
		int index,j;
		int len=dest.length();
		//source匹配
		int i=0;
		while(i<=source.length()-dest.length()){
			cnt++;//比较次数
			index=i;
			//dest匹配
			for(j=0;j<len;j++) {
				if(source.charAt(index)!=dest.charAt(j)){
					break;
				}else{
					index++;
				}
			}
			if(j>=len) {
				return true;
			}
			//如果匹配：后移位数=匹配位数-table[j]
			//如果不匹配则顺序后移
			if(index>i){
				i=(--index)-table[--j];
			}else{
				i++;
			}
		}
		return false;
	}
}