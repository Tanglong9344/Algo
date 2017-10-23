/**
 * 特殊的数
 * i+1<i(例如：int型数据i=2^23时)
 * 源于符号位变化
 */

package math;

public class SpecialNumber {
	public static void main(String[] args) {
		System.out.println("2^23=  "+(int)Math.pow(2, 31));
		System.out.println("2^23+1="+(int)Math.pow(2, 31)+1);
		System.out.print("2^23+1<2^23:");
		System.out.println((int)Math.pow(2, 31)+1<(int)Math.pow(2, 31));
	}
}