package recursion;

import java.util.HashMap;
import java.util.Map;

public class Factorial {
	
	private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static void main (String[] args) {
		System.out.print("Factorial : " + getFactorial(6));
	}
	
	private static int getFactorial(int number) {
		
		if(number == 1) {
			return number;
		}
		
		if(!map.containsKey(number -1)) {
			map.put(number-1, getFactorial(number -1));
		}
		return number* map.get((number-1));		
	}
}
