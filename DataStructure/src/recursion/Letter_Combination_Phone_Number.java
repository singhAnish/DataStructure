package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//Time Complexity = O(3^N || 4^M)
//Space Complexity = O(3^N || 4^M)

public class Letter_Combination_Phone_Number {
	
	public static void main(String[] args) {
		String input = "23";
		List<String> combination = getAllLetterCombination(input);
		System.out.println("Combination : "+ combination.toString());
	}

	
	private static List<String> getAllLetterCombination(String digits){
		List<String> ans = new ArrayList<String>();
		if(digits.length() == 0) {
			return ans;
		}
		
		Map<Character, String> map = new HashMap<Character, String>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		
		getCombination(digits, 0, map, new StringBuilder(), ans);
		return ans;
	}
	
	
	private static void getCombination(String digits, int index, Map<Character, String> map, StringBuilder builder, List<String> ans) {
		if(index == digits.length()) {
			ans.add(builder.toString());
			return;
		}
		
		String current = map.get(digits.charAt(index));
		
		for(int i = 0; i < current.length(); i++) {
			builder.append(current.charAt(i));
			getCombination(digits, index + 1, map, builder, ans);
			builder.deleteCharAt(builder.length() -1);
		}
	}
}
