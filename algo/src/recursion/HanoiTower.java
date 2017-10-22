/**
 * 汉诺塔问题
 * 将挂柱A上的n个卡片顺序不变的移动到挂柱C
 */

package recursion;

import java.util.Scanner;

public class HanoiTower {
	public static void main(String[] args) {
		int num;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入需要移动的卡片数目：");
		num = scanner.nextInt();
		hanoi('A','C','B',num);
	}

	/**
	 * 汉诺塔移动操作
	 */
	static void hanoi(char from,char to,char temp,int n){
		if(1 == n){
			System.out.println(from + " move to " + to);
		}else{
			hanoi(from,temp,to,n-1);
			System.out.println(from + " move to " + to);
			hanoi(temp,to,from,n-1);
		}
	}
}