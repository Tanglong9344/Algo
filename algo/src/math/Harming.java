package math;

/**题目来源：http://www.dadio.xyz/content/xyz/train
 *
 * 汉明数是(2^i)(3^j)(5^k)形式的正整数，其中i，j，k是非负整数。
 *
 * 具体来说：
 * 第一个最小的汉明数是1 = (2^0)(3^0)(5^0)
 * 第二个最小的汉明数是2 = (2^1)(3^0)(5^0)
 * 第三个最小的汉明数是3 = (2^0)(3^1)(5^0)
 * 第四个最小的汉明数是4 = (2^2)(3^0)(5^0)
 * 第五个最小的汉明数是5 = (2^0)(3^0)(5^1)
 *
 * 求第n个汉明数
 *
 * @author 唐龙
 *
 */
public class Harming {
	public static void main(String[] args) {
		for(int i=1;i<=1000;i++){
			System.out.printf("Harming(%d)=%d%n", i, hamming(i));
		}
	}

	/**Compute the harming(n)*/
	public static long hamming(int n) {
		long[] arr = new long[n+1];
		arr[1] = 1;//The first Harming number is 1
		if(n == 1) {
			return arr[1];
		}
		int i,i2=1,i3=1,i5=1;
		for(i=2;i<=n;i++){
			arr[i] = min(arr[i2]*2,arr[i3]*3,arr[i5]*5);
			if(arr[i] == arr[i2]*2){
				i2++;
			}
			if(arr[i] == arr[i3]*3){
				i3++;
			}
			if(arr[i] == arr[i5]*5){
				i5++;
			}
		}
		return arr[n];
	}

	/**compare three number and return the minimum one*/
	private static long min(long a, long b, long c){
		return Math.min(Math.min(a, b), c);
	}
}