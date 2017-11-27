package recursion;

import java.util.Scanner;

/**
 * 经典递归问题-汉诺塔问题
 */
public class HanoiTower {
	public static void main(String[] args) {
		int n;
		long start,end;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入需要移动的卡片数目：");
		n = scanner.nextInt();
		start = System.currentTimeMillis();
		hanoi(n,'F','P','T');
		end = System.currentTimeMillis();
		System.out.printf("移动%d个圆盘需要时间%dms%n",n,(end-start));
		scanner.close();
	}

	/**
	 * 汉诺塔移动操作
	 */
	static void hanoi(int n,char from,char tmp,char to){
		if(1 == n){
			System.out.printf("%c Move %d To %c%n",from,n,to);
		}else{
			hanoi(n-1,from,to,tmp);
			System.out.printf("%c Move %d To %c%n",from,n,to);
			hanoi(n-1,tmp,from,to);
		}
	}
}