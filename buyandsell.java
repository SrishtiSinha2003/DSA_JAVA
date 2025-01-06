public class buyandsell{
    public static int buyAndsellStocks(int prices[]) {
        int buyPrice = Integer.MAX_VALUE; // plus infinity
        int maxProfit = 0;

        for(int i =0; i<prices.length; i++) {
            if(buyPrice < prices[i]) { // profit humko kab hoga
                int profit = prices[i] - buyPrice; // aaj ka profit seling price - buying price
                maxProfit = Math.max(maxProfit, profit);

            }else {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String args[]) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println(buyAndsellStocks(prices));
    }
}
