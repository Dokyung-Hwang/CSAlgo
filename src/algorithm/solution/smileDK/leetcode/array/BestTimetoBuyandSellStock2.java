package algorithm.solution.smileDK.leetcode.array;

// Memo.
//  Q. 매일 주식의 가격이 주어졌을 때, 여러 번의 거래를 통해 최대 이익을 반환
//     (각 거래는 주식을 한 번 사서 한번 팔거나 아예거래를 하지 않는 것 중 하나)

public class BestTimetoBuyandSellStock2 {
    public static void main(String[] args) {
        int[] prices1 = new int[]{7,1,5,3,6,4};
        int[] prices2 = new int[]{1,2,3,4,5};
        int[] prices3 = new int[]{7,6,4,3,1};

        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
        System.out.println(maxProfit(prices3));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}
