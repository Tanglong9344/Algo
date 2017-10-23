/**
 * 使用栈实现二进制与十进制之间的转换
 */

package math;

import java.util.Stack;

public class DecimalAndBinary {
	static final int N = 10;//the number of numbers
	static final int RANGE = 100;//the range of numbers
	public static void main(String[] args) {
		int num;
		for(int i=0;i<N;i++){
			num = (int)(Math.random()*RANGE);
			int bnum=decimalToBianry(num);
			System.out.printf("十进制数%2d的二进制数：%d%n",num,bnum);
			System.out.printf("二进制数%2d的十进制数：%d%n",bnum,bianryToDecimal(bnum));
		}
	}

	//Decimal converses to Binary
	static int decimalToBianry(int d){
		//剪枝
		if(0 == d || 1 == d){
			return d;
		}
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

	//Binary converses to Decimal
	static int bianryToDecimal(int b){
		//剪枝
		if(0 == b || 1 == b){
			return b;
		}
		int s=0;
		int m=1;
		while(b!=0){
			s+=(b%10)*m;
			b/=10;
			m*=2;
		}
		return s;
	}
}