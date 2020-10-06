package stack;

//Time Complexity : O(n)
//Space Complexity : O(1)
public class RainWaterTrapping {
	
	public static void main(String[] args) {
		int[] input = {7, 1, 4, 0, 2, 8, 6, 3, 5};
		System.out.println( "Trapped Water : " +getTrappedWater(input) );
	}
	
	private static int getTrappedWater(int [] input) {
		int result = 0;
		if(input == null || input.length < 2) {
			return result;
		}
		
		int  leftPointer = 0, rightPointer = input.length -1;
		int leftMax = 0, rightMax = 0;
		
		while(leftPointer < rightPointer) {
			if(input[leftPointer] < input[rightPointer]) {
				if(input[leftPointer] > leftMax) {
					leftMax = input[leftPointer];
				}else {
					result = result + ( leftMax - input[leftPointer]);
				}
				leftPointer++;
			}else {
				if(input[rightPointer] > rightMax) {
					rightMax = input[rightPointer];
				}else {
					result = result + ( rightMax - input[rightPointer]);
				}
				rightPointer--;
			}	
		}
		return result;
	}
	
	
	
	
	
	
	//2nd Approach
	private static int getTrappedWater1(int[] input) {
		int result = 0;
		if(input.length < 2) {
			return result;
		}
		
		int[] leftToRightMax = new int[input.length];
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < input.length ; i++) {
			if(input[i] > max) {
				max = input[i] ;
			}
			leftToRightMax[i] = max;
		}
		
		
		max = Integer.MIN_VALUE;
		for(int i = input.length-1 ; i >= 0 ; i--) {
			if(input[i] > max) {
				max = input[i] ;
			}
			result = result + Math.min(leftToRightMax[i] ,max) - input[i];
		}
		
		return result;
	}
}
