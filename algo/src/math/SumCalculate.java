package math;

public class SumCalculate {
	static final int N = 10;
	static final int RANGE = 30000;
	public static void main(String[] args) {
		int num;
		long start;
		long end;
		for(int i=0;i<N;i++){
			num=(int)(Math.random()*RANGE);
			start = System.nanoTime();
			System.out.print(num+"ѭ���ۼӽ����"+add(num)+"\t");
			end = System.nanoTime();
			System.out.println("����ʱ�䣺"+(end-start)+"ns");

			start = System.nanoTime();
			System.out.print(num+"�ݹ���ͽ����"+addRecursion(num)+"\t");
			end = System.nanoTime();
			System.out.println("����ʱ�䣺"+(end-start)+"ns");

			start = System.nanoTime();
			System.out.print(num+"��ʽ��ͽ����"+addFormula(num)+"\t");
			end = System.nanoTime();
			System.out.println("����ʱ�䣺"+(end-start)+"ns");
		}
	}

	//ѭ���ۼ�
	static int add(int n){
		//n������ڵ���0
		if(n<0) {
			return -1;
		}
		int s=0;
		for(int i=1;i<=n;i++){
			s+=i;
		}
		return s;
	}

	//�ݹ����(�ݹ����jvm�ڴ��С������)
	static int addRecursion(int n){
		//n������ڵ���0
		if(n<0) {
			return -1;
		}
		if(1==n || 0==n){
			return n;
		}
		return (n+addRecursion(n-1));
	}
	//��ʽ��� s=(n*(n+1))/2
	static int addFormula(int n){
		//n������ڵ���0
		if(n<0) {
			return -1;
		}
		//��ֹ�������
		//��������
		int a = n%2==0?(n/2):n;
		int b = (n+1)%2==0?((n+1)/2):(n+1);
		//�����˷�
		return a*b;
	}
}