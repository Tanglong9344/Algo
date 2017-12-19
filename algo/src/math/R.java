package math;

/***问题来源：http://www.dadio.xyz/content/xyz/normal/1
 * 描述：
 * 将字符串中的单词的末尾的所有感叹号删除。单词在字符串中用空格分开。
 * 例子：
 * remove("Hi!") === "Hi"
 * remove("Hi!!!") === "Hi"
 * remove("!Hi") === "!Hi"
 * remove("!Hi!") === "!Hi"
 * remove("Hi! Hi!") === "Hi Hi"
 * remove("!!!Hi !!hi!!! !hi") === "!!!Hi !!hi !hi"
 *
 * @author 唐龙
 *
 */
public class R {
	public static void main(String[] args) {
		String str = "!!!Hi! !!hi!!! !hi!!!";
		System.out.println(R.removeBang(str));
		System.out.println(R.removeBangRegExp(str));
	}

	/**Remove exclamation point using regular expression*/
	public static String removeBangRegExp(String str) {
		str = str.replaceAll("\\!+\\s", " ");//remove words' except the last word's '!' in the String
		return str.replaceAll("\\!+$", "");//remove the last word's '!'
	}

	/**Remove exclamation point in a low efficiency way*/
	public static String removeBang(String str) {
		String[] strs = str.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i=0, len = strs.length;i<len;i++){
			int l = strs[i].length();
			if(l>0) {
				while(strs[i].charAt(l-1) == '!'){
					l--;
				}
			}
			sb.append(strs[i].substring(0, l));
			if(i<len-1){
				sb.append(" ");
			}
		}
		return sb.toString();
	}
}