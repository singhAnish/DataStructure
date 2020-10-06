package stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import util.Local;

public class LeftMostSmallerNumber {
	

	public static void main(String[] args) {
		int[] input = {2, 1, 3, 2, 1, 3};
		Local local = new Local();
		
		//giveLeftmostSmallestElementArray(input);
		local.printArray(giveLeftmostSmallestElementArray(input));
	}
	
	private static int[] giveLeftmostSmallestElementArray(int[] array){
		
		
	    Stack<Integer> stack = new Stack<Integer>();
	    Stack<Integer> indicesStack = new Stack<Integer>();

	    int length = array.length;
		int[] ans = new int[length];

	    for(int i = length - 1; i >= 0; i--){
	        while(!stack.isEmpty() && array[i] <= stack.peek()){
	            stack.pop();
	            indicesStack.pop();
	        }
	        stack.push(array[i]);
	        indicesStack.push(i);
	    }
	    
	    int[] bsa = new int[stack.size()];
	    int index = 0;
	    while(!stack.isEmpty()){
	        bsa[index++] = stack.pop();
	    }
	    
	    Set<Integer> set = new HashSet<Integer>();
	    for(int i : indicesStack){
	        set.add(i);
	    }
	    
	    // now we will look at all the elements of the array and find their leftmost smallest element using our bsa array and populate ans array accordingly
	    for(int i = 0; i < length; i++){
	        if(set.contains(i)){
	            ans[i] = -1;
	            continue;
	        }
	        int lo = 0;
	        int hi = bsa.length - 1;
	        while(lo < hi){ 
	            int mi = lo + (hi - lo) / 2;
	            if(bsa[mi] >= array[i])
	                lo = mi + 1;
	            else
	                hi = mi;
	        }
	        if(bsa[lo] < array[i])
	            ans[i] = bsa[lo];
	        else
	            ans[i] = -1;
        }
	    
	    return ans;
}
	
}
