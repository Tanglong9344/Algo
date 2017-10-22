package math;

import java.util.Scanner;

public class AaddB {
	@SuppressWarnings("resource")
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		int a, b;
		// 连续输入两个数并输出它们的和
		while(cin.hasNextInt()){
			a = cin.nextInt();
			b = cin.nextInt();
			System.out.println(a + b);
		}
	}
}