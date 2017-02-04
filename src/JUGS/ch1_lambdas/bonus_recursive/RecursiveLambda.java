package JUGS.ch1_lambdas.bonus_recursive;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;

/**
 * Beispielprogramm im Rahmen des JUGS Java 8 Hands on Workshops
 * 
 * @author Michael Inden
 *
 * Copyright 2015 by Michael Inden
 */
public class RecursiveLambda {

	// Ausgangsbasis
	public static final long factorialRec(final int n)
	{
		if (n < 0)
			throw new IllegalArgumentException("n must be positive");
		
		if (n==0)
			return 1;
		
		return n * factorialRec(n-1);
	}
	
	public static void main(String[] args) {
	
		final IntFunction<Long> factorial1 = RecursiveLambda::factorialRec;
		System.out.println(factorial1.apply(5));

		System.out.println(factorialLambdaRecursiveStatic.apply(5));
		final RecursiveLambda ex = new RecursiveLambda();
		System.out.println(ex.factorialLambdaRecursiveMember.apply(5));

		System.out.println("--------------------------------");
		
		System.out.println(ex.myFactorialInt.apply(5));
		System.out.println(ex.myFactorialLong.apply(5));
		System.out.println(ex.myFactorialInt.apply(20));
		System.out.println(ex.myFactorialLong.apply(20));
		System.out.println(ex.myFactorialInt.apply(50));
		System.out.println(ex.myFactorialLong.apply(50));
	}
	
	// Variante 1
	public static Function<Integer,Long> factorialLambdaRecursiveStatic;

	// static initializer
	static {
		factorialLambdaRecursiveStatic = n -> {
			if (n < 0)
				throw new IllegalArgumentException("n must be positive");
			
			if (n==0)
				return 1L;
			
			return n * factorialLambdaRecursiveStatic.apply(n-1);
	    };
	}

	// Variante 2
	public Function<Integer,Long> factorialLambdaRecursiveMember;
	
	// Initializer Block
	{
		factorialLambdaRecursiveMember = n -> {
			if (n < 0)
				throw new IllegalArgumentException("n must be positive");
			
			if (n==0)
				return 1L;
			
			return n * factorialLambdaRecursiveMember.apply(n-1);
	    };
	}
	
	public  Function<Integer, Long> myFactorialLong;
	{
		myFactorialLong = i -> i == 0 ? 1 : i * myFactorialLong.apply( i - 1 );
		//myFactorial = i -> i == 0 ? 1 : Math.multiplyExact(i, myFactorial.apply( i - 1 ));
	}
	
	public  UnaryOperator<Integer> myFactorialInt;
	{
		myFactorialInt = i -> i == 0 ? 1 : i * myFactorialInt.apply( i - 1 );
		//myFactorialInt = i -> i == 0 ? 1 : Math.multiplyExact(i, myFactorialInt.apply( i - 1 ));
	}
}
