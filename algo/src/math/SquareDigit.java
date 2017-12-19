package math;

/**
 * Square each digit in a number
 *
 * @author 唐龙
 *
 */
public class SquareDigit {
	public static void main(String[] args) {
		System.out.println(squareDigits(12));
		System.out.println(squareDigits(38972));
	}

	/**Square digits*/
	static int squareDigits(int n){
		String str = String.valueOf(n);
		StringBuilder sb = new StringBuilder();
		for(int i=0, len = str.length();i<len;i++){
			int tmp = Integer.valueOf(str.charAt(i) + "");
			sb.append(tmp * tmp + "");
		}
		return Integer.valueOf(sb.toString());
	}
}