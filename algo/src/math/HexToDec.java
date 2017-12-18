package math;

/**
 * Hex to decimal
 *
 * @author 唐龙
 *
 */
public class HexToDec {
	public static void main(String[] args) {
		System.out.println(hexToDec("bb"));
		System.out.println(hexToDec("-a"));
		System.out.println(hexToDec("ff"));
		System.out.println(hexToDec("12"));
		System.out.println(hexToDec("34"));
		System.out.println(hexToDec("56"));
	}

	/**Hex to decimal*/
	static int hexToDec(String hex){
		int result = 0;
		int len = hex.length();
		int start = 0;
		if(hex.charAt(0) == '-'){
			start = 1;
		}
		for(int i = len-1;i>=start;i--){
			char ch = hex.charAt(i);
			int tmp;
			switch(ch){
			case 'a':
			case 'A':
				tmp = 10;
				break;
			case 'b':
			case 'B':
				tmp = 11;
				break;
			case 'c':
			case 'C':
				tmp = 12;
				break;
			case 'd':
			case 'D':
				tmp = 13;
				break;
			case 'e':
			case 'E':
				tmp = 14;
				break;
			case 'f':
			case 'F':
				tmp = 15;
				break;
			default:
				tmp = Integer.valueOf(ch+"");
			}
			result += tmp * Math.pow(16, len - i - 1);
		}
		return start == 1 ? -result : result;
	}
}