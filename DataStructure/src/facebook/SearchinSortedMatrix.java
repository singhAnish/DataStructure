package facebook;

public class SearchinSortedMatrix {

	public static void main(String[] args) {
		int[][] input = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		int number = 13;
		System.out.println(number + " Number exist : \t" + searchMatrix(input, number));
	}

	private static boolean searchMatrix(int[][] matrix, int target) {
		int start = 0;
		int end = matrix.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (matrix[mid][0] <= target && matrix[mid][matrix[0].length - 1] >= target) {
				return searchSortedArray(matrix[mid], target);
			}

			if (matrix[mid][0] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return false;
	}

	private static boolean searchSortedArray(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target) {
				return true;
			}

			if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}
}
