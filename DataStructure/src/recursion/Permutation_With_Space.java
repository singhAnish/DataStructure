package recursion;

public class Permutation_With_Space {

	public static void main(String[] args) {
		String input = "abc";
		permutationWithSpace(input, "");
	}

	private static void permutationWithSpace(String input, String output) {

		if (input.length() == 1) {
			System.out.println(output + input);
			return;
		}
		permutationWithSpace(input.substring(1), output + input.charAt(0));
		permutationWithSpace(input.substring(1), output + input.charAt(0) + "-");
	}

}
