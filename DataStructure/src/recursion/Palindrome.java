package recursion;

import java.util.Scanner;

public class Palindrome {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		System.out.print( input + " is Palindrome : "+ isPalindrome(input));
	}
	
	private static boolean isPalindrome(int x) {
		
		if(x == 0) {
			return true;
		}
		
		if(x < 0 || x % 10 == 0) {
			return false;
		}
		
		int reverse_number = 0;
		while(x > reverse_number) {
			int pop = x % 10;
			x = x /10;
			reverse_number = (reverse_number*10) + pop;
		}
		return x == reverse_number || x == reverse_number/10;
	}

}
