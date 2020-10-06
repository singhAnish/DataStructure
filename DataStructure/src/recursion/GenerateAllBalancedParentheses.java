package recursion;

public class GenerateAllBalancedParentheses {

	private static int count = 0;
	public static void main(String[] args) {
		getBalancedParentheses(4);
	}

	private static void getBalancedParentheses(int number) {
		getAllBalancedParentheses("", number, number);
		System.out.print("Total valid parenthesus count : \t" +count );
	}

	private static void getAllBalancedParentheses(String output, int open, int close) {
		if (open == 0 && close == 0) {
			count +=1;
			System.out.println(output);
			return;
		}

		if (open == close) {
			getAllBalancedParentheses(output.concat("("), open - 1, close);
		} else {
			if (open != 0) {
				getAllBalancedParentheses(output.concat("("), open - 1, close);
			}

			if (close != 0) {
				getAllBalancedParentheses(output.concat(")"), open, close - 1);
			}
		}
	}
}
