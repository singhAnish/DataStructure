package recursion;

import java.util.Scanner;

public class PrintNTo1 {

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
		
		//Induction
		System.out.print(n + " ");
		
		//Hypothesus
		printNumber(n-1);
		
	}
	
}
