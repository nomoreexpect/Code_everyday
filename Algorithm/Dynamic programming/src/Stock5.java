/**
 * @Author:PanYa
 * @Date 2024/5/15-下午8:37
 * @Description: 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 */
public class Stock5 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], - prices[1]);

        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }
    public static void main(String[] args) {
        Stock5 s = new Stock5();
        System.out.println(s.maxProfit(5, new int[]{2, 7, 1, 5}));
        System.out.println(s.maxProfit(3, new int[]{2, 7, 1, 5}));
    }
}
