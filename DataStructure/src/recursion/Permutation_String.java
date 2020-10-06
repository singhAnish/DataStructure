package recursion;

import java.util.Scanner;

public class Permutation_String {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		getPermutation(input);
	}

	private static void getPermutation(String input) {
		getAllPermutation(input, "");
	}

	private static void getAllPermutation(String input, String answerSoFar) {
		if (input.length() == 0) {
			System.out.println(answerSoFar);
			return;
		}

		for (int i = 0; i < input.length(); i++) {
			char ithCharacter = input.charAt(i);
			getAllPermutation(input.substring(0, i).concat(input.substring(i + 1)), answerSoFar + ithCharacter);
		}
	}

}
