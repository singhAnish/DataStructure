package recursion;

import java.util.Scanner;

public class Print1ToN {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		printNumber(input);
		
	}
	
	private static void printNumber(int n) {
		
		//Base
		if(n == 0) {
			return;
		}
		//Hypothesus
		printNumber(n-1);
		
		//Induction
		System.out.print(n + " ");
	}

}
