package recursion;

public class Permutation_With_CaseChange {
	
	public static void main(String[] args) {
		permute("abc", "");	
	}
	
	private static void permute(String input, String output) {
		if(input.length() == 0) {
			System.out.println(output + "\t\t");
			return;
		}
		permute(input.substring(1), output + String.valueOf(input.charAt(0)).toLowerCase() );
		permute(input.substring(1), output + String.valueOf(input.charAt(0)).toUpperCase() );
	}

}
