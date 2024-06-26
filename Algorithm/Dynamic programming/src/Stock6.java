/**
 * @Author:PanYa
 * @Date 2024/5/15-下午9:40
 * @Description: 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 */
public class Stock6 {
    public int maxProfit(int fee, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0]+prices[i]-fee, dp[i - 1][1]);
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
    public static void main(String[] args) {
        Stock6 s = new Stock6();
        System.out.println(s.maxProfit(2, new int[]{1, 3, 2, 8, 4, 9}));
    }
}
