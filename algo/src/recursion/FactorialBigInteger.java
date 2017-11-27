package recursion;

import java.math.BigInteger;

/**
 * 超大数的阶乘计算
 */
public class FactorialBigInteger {
	static final int N = 10;
	static final int RANGE = 1000;//BigInteger has no range limit
	public static void main(String[] args) {
		int num;
		for(int i=0;i<N;i++){
			num = (int)(Math.random()*RANGE);
			System.out.printf("递归,%d的阶乘:%d%n",num,facRecursion(num));
			System.out.printf("迭代,%d的阶乘:%d%n",num,facIterator(num));
		}
	}

	//calculate factorial(recursion)
	static BigInteger facRecursion(int num){
		BigInteger n = BigInteger.valueOf(num);
		return n.compareTo(BigInteger.ONE) == 0 ? BigInteger.ONE : n.multiply(facRecursion(num-1));
	}

	//calculate factorial(Iterator)
	static BigInteger facIterator(int num){
		BigInteger n = BigInteger.valueOf(num);
		BigInteger fac=BigInteger.ONE;
		for(BigInteger i=BigInteger.ONE;i.compareTo(n)<=0;i=i.add(BigInteger.ONE)){
			fac=fac.multiply(i);
		}
		return fac;
	}
}