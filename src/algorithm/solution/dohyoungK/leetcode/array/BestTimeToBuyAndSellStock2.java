package algorithm.solution.dohyoungK.leetcode.array;

public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minPrice) {
                profit += prices[i] - minPrice;
                minPrice = prices[i];
            } else if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return profit;
    }
}
