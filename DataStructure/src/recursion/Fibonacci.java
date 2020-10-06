package recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	
	private static int current = 0, next = 1, temp = 0;
    private static Map<Integer, Integer> memo = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(fib(8));
		printFibonacci(9);
		//0, 1, 1, 2, 3, 5, 8, 13
	}

	private static int fib(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}else if(!memo.containsKey(n)) {
			memo.put(n, fib(n - 1) + fib(n - 2));
		}
		return memo.get(n);
	}

	private static void printFibonacci(int input) {
		
		if (input >= 0) {
			System.out.print( current + "\t");
			temp = current+next;
			current = next;
			next  = temp;
			printFibonacci(input -1);
			
		}
	}

}
