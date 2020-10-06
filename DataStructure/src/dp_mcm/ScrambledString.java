package dp_mcm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ScrambledString {

	public static void main(String[] args) {
		String S1 = "coder";
		String S2 = "ocred";
		
		Map<String, Boolean> map = new HashMap<>();

		System.out.println("Result : \t" + isScramble(S1, S2, map));
	}

	private static boolean isScramble(String S1, String S2, Map<String, Boolean> map) {

		if (S1.length() != S2.length()) {
			return false;
		}

		int n = S1.length();

		if (n == 0) {
			return true;
		}

		if (S1.equals(S2)) {
			return true;
		}

		char[] tempArray1 = S1.toCharArray();
		char[] tempArray2 = S2.toCharArray();

		Arrays.sort(tempArray1);
		Arrays.sort(tempArray2);

		String copy_S1 = new String(tempArray1);
		String copy_S2 = new String(tempArray2);

		if (!copy_S1.equals(copy_S2)) {
			return false;
		}

		for (int i = 1; i < n; i++) {
			
			/*String swapped1 = S1.substring(0, i).concat("_").concat(S2.substring(0, i));
			if(map.containsKey(swapped1)) {
				return map.get(swapped1);
			}else {
				map.put(swapped1, isScramble(S1.substring(0, i), S2.substring(0, i), map));
			}
	
			String swapped2 = S1.substring(i, n).concat("_").concat(S2.substring(i, n));
			if(map.containsKey(swapped2)) {
				return map.get(swapped2);
			}else {
				map.put(swapped2, isScramble(S1.substring(i, n), S2.substring(i, n), map));
			}
			
			if (map.get(swapped1) && map.get(swapped2)) {
				return true;
			}
			

			String nonSwapped1 = S1.substring(n - i, n).concat("_").concat(S2.substring(0, i));
			if(map.containsKey(nonSwapped1)) {
				return map.get(nonSwapped1);
			}else {
				map.put(nonSwapped1, isScramble(S1.substring(n - i, n), S2.substring(0, i), map));
			}
	
			String nonSwapped2 = S1.substring(0, n - i).concat("_").concat(S2.substring(i, n));
			if(map.containsKey(nonSwapped2)) {
				return map.get(nonSwapped2);
			}else {
				map.put(nonSwapped2,  isScramble(S1.substring(0, n - i), S2.substring(i, n), map));
			}
			
			if (map.get(nonSwapped1) && map.get(nonSwapped2)) {
				return true;
			}*/
			
			
			if (isScramble(S1.substring(0, i), S2.substring(0, i), map)
					&& isScramble(S1.substring(i, n), S2.substring(i, n), map)) {
				return true;
			}

			if (isScramble(S1.substring(n - i, n), S2.substring(0, i), map)
					&& isScramble(S1.substring(0, n - i), S2.substring(i, n), map)) {
				return true;
			}
		}
		return false;
	}
}
