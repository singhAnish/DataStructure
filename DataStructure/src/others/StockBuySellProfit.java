 package others;

//Time Complexity : O(n)
//Space Complexity : O(1)
public class StockBuySellProfit {

	public static void main(String[] args) {
		int[] input = { 7, 1, 5, 3, 6, 4 };
		System.out.println("Profit  1 : " + maxProfit(input));
		System.out.println("Profit 2 : " + maxProfit2(input));
		System.out.println("Profit  3: " + maxProfit3(input));	
	}

	/*
	 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
	 * design an algorithm to find the maximum profit.
	 * */
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
	
	/*
	 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one
	 *  share of the stock multiple times).
	 * */
	private static  int maxProfit2(int[] prices) {
        if(prices == null && prices.length == 0){
            return 0;
        }
        
        int buy = prices[0];
        int profit = 0;
        
        for(int i = 0; i<prices.length ; i++){
            if(prices[i] > buy){
                profit += prices[i]-buy;
            }
            buy = prices[i];
        }
        
        return profit;
        
    }

	
	/*
	 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
	 * */
	private static int maxProfit3(int[] prices) {
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
