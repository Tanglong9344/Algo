package math;

import java.math.BigInteger;

public class FactorialBigInteger {
	static final int N = 10;
	static final int RANGE = 1000;//BigInteger has no range limit
	public static void main(String[] args) {
		int num;
		for(int i=0;i<N;i++){
			num = (int)(Math.random()*RANGE);
			System.out.println("Factorial(recursion) of " + num + " is " + countFactorialRecursion(num));
			System.out.println("Factorial(loop)      of " + num + " is " + countFactorialLoop(num));
		}
	}

	//calculate factorial(recursion)
	static BigInteger countFactorialRecursion(int num){
		BigInteger numBi=BigInteger.valueOf(num);
		if(num>1) {
			return (numBi.multiply(countFactorialRecursion(num-1)));
		}
		return BigInteger.ONE;
	}

	//calculate factorial(loop)
	static BigInteger countFactorialLoop(int num){
		BigInteger numBi=BigInteger.valueOf(num);
		BigInteger fac=BigInteger.ONE;
		for(BigInteger i=BigInteger.ONE;i.compareTo(numBi)<=0;i=i.add(BigInteger.ONE)){
			fac=fac.multiply(i);
		}
		return fac;
	}
}