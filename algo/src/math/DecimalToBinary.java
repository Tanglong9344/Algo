/**
 * 使用栈实现十进制转换为二进制
 */

package math;

import java.util.Stack;

public class DecimalToBinary {
	static final int N = 10;//the number of numbers
	static final int RANGE = 100;//the range of numbers
	public static void main(String[] args) {
		int num;
		for(int i=0;i<N;i++){
			num = (int)(Math.random()*RANGE);
			System.out.println(num + " 的二进制数："+ decimalToBianry(num));
		}
	}

	//Decimal converses to Binary
	static int decimalToBianry(int d){
		//使用栈保存余数
		Stack<Integer> stack = new Stack<Integer>();
		while(d!=0){
			stack.add(d%2);
			d/=2;
		}
		//get the result
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		return Integer.valueOf(sb.toString());
	}
}