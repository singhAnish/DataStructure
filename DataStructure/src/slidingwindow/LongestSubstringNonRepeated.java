package slidingwindow;

import java.util.HashSet;

//Space Complexity : O(n)
//Time Complexity : O(n)
public class LongestSubstringNonRepeated {

	public static void main(String[] args) {
		String input = "BADBDEFGABEF";
		System.out.println("Lonest Substring length is : " + lengthOfLongestSubstring(input));
	}

	private static int lengthOfLongestSubstring(String s) {
		int start = 0;
		int end = 0;
		int max = 0;

		HashSet<Character> set = new HashSet<>();

		while (end < s.length()) {
			if (!set.contains(s.charAt(end))) {
				set.add(s.charAt(end));
				end++;
				max = Math.max(set.size(), max);
			} else {
				set.remove(s.charAt(start));
				start++;
			}
		}
		return max;
	}
}
