package others;

//Time Complexity : O(n)
//Space Complexity : O(1)
public class StockBuySellProfit {

	public static void main(String[] args) {
		int[] input = { 7, 1, 5, 3, 6, 4 };
		System.out.println("Profit : " + maxProfit(input));
	}

	private static int maxProfit(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}

		int buy = Integer.MAX_VALUE;
		int profit = 0;
		for (int price : prices) {
			buy = Math.min(buy, price);
			profit = Math.max(profit, price - buy);
		}
		return profit;
	}

	
	
	private static int maxProfitTwoTransaction(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}

		int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
		int profit1 = 0, profit2 = 0;
		for (int price : prices) {
			buy1 = Math.min(buy1, price);
			profit1 = Math.max(profit1, price - buy1);
			buy2 = Math.min(buy2, price - profit1);
			profit2 = Math.max(profit2, price - buy2);
		}
		return profit2;
	}

}
