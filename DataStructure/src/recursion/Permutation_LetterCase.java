package recursion;

public class Permutation_LetterCase {
	public static void main(String[] args) {
		String input = "aB1";
		System.out.println(input.substring(1) );
		permute("aB1", "");	
	}
	
	private static void permute(String input, String answerSoFar) {
		if(input.length() == 0) {
			System.out.print(answerSoFar + "\t\t");
			return;
		}
		char character = input.charAt(0);
		
		if (Character.isDigit(character) ) {
			permute(input.substring(1), answerSoFar + character );
		}else {
			permute(input.substring(1), answerSoFar + Character.toUpperCase(character));
			permute(input.substring(1), answerSoFar + Character.toLowerCase(character) );
		}
	}
}
