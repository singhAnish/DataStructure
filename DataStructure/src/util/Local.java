package util;

import java.util.List;

public class Local {

	public Local() {
	}

	public void printArray(int[] input) {
		for (int i : input) {
			System.out.print(i + " ");
		}
		System.out.println(" ");
	}
	
	public void printArray(String[] input) {
		for (String str : input) {
			System.out.print(str + " ");
		}
		System.out.println(" ");
	}
	
	
	public static void printMatrix(int[][] input) {
		for(int i = 0; i< input.length; i++) {
			for(int j = 0; j < input[i].length; j++) {
				System.out.print(input[i][j] + "\t");
			}
			System.out.println(" ");
		}
		
		System.out.println(" ");
	}
	
	public static void printBooleanMatrix(boolean[][] input) {
		for(int i = 0; i< input.length; i++) {
			for(int j = 0; j < input[i].length; j++) {
				System.out.print(input[i][j] + "\t\t");
			}
			System.out.println(" ");
		}
		
		System.out.println(" ");
	}
	
	
	
	public void printIntegerList(List<Integer> list) { 
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println(" ");
	}
	
	
	public void printList(List<String> list) { 
		for (String str : list) {
			System.out.print(str + " ");
		}
		System.out.println(" ");
	}

}
