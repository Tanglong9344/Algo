package java_test;

/**
 * String测试
 * @author 唐龙
 */
public class StringTest {
	public static void main(String[] args) {
		String str = "Hello Java!";
		int len = str.length();
		System.out.println("元字符串："+str);
		//转为大写
		StringBuilder sbUpperCase = new StringBuilder();
		StringBuilder sbLowerCase = new StringBuilder();
		for(int i=0;i<len;i++){
			sbUpperCase.append(Character.toUpperCase(str.charAt(i)));
			sbLowerCase.append(Character.toLowerCase(str.charAt(i)));
		}
		System.out.println("大写："+sbUpperCase);
		System.out.println("大写："+str.toUpperCase());
		System.out.println("小写："+sbLowerCase);
		System.out.println("小写："+str.toLowerCase());
	}
}