public class dpBuyAndSell {
    
    // Function to calculate the maximum profit and day difference
    public static int[] maxProfitWithTransactionFee(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return new int[] {0, 0}; // No profit and no days
        }
        
        int n = prices.length;
        int[] hold = new int[n];  // Maximum profit if we hold a stock on day i
        int[] cash = new int[n];  // Maximum profit if we don't hold a stock on day i
        int buyDay = 0, sellDay = 0; // To track buy and sell days for max profit
        
        // Initialize
        hold[0] = -prices[0];  // If we buy on day 0
        cash[0] = 0;           // If we do nothing on day 0
        
        for (int i = 1; i < n; i++) {
            // Either keep holding or buy a new stock today
            if (hold[i - 1] >= cash[i - 1] - prices[i]) {
                hold[i] = hold[i - 1];
            } else {
                hold[i] = cash[i - 1] - prices[i];
                buyDay = i; // Update the buy day when we buy
            }
            
            // Either keep not holding or sell the stock today
            if (cash[i - 1] >= hold[i - 1] + prices[i] - fee) {
                cash[i] = cash[i - 1];
            } else {
                cash[i] = hold[i - 1] + prices[i] - fee;
                sellDay = i; // Update the sell day when we sell
            }
        }
        
        // The maximum profit is in cash[n-1] (when we are not holding a stock at the end)
        int maxProfit = cash[n - 1];
        int dayDifference = sellDay - buyDay; // Difference of days between buying and selling
        
        return new int[] {maxProfit, dayDifference};
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9}; // Example stock prices
        int fee = 2;                       // Transaction fee
        
        int[] result = maxProfitWithTransactionFee(prices, fee);
        System.out.println("Maximum Profit: " + result[0]);
        System.out.println("Day Difference: " + result[1]);
    }
}
