/**
 * @Author:PanYa
 * @Date 2024/5/14-下午3:03
 * @Description: 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 */
public class Stock2 {
//    public int maxProfit(int[] prices) {
//        /*
//        *@Param [prices]
//        *@return int
//        *@Description:
//        * 实现1：二维数组存储
//        * 可以将每天持有与否的情况分别用 dp[i][0] 和 dp[i][1] 来进行存储
//        * 时间复杂度：O(n)，空间复杂度：O(n)
//        */
//        int n = prices.length;
//        int[][] dp = new int[n][2];     // 创建二维数组存储状态
//        dp[0][0] = 0;                   // 初始状态
//        dp[0][1] = -prices[0];
//        for (int i = 1; i < n; ++i) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);    // 第 i 天，没有股票
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);    // 第 i 天，持有股票
//        }
//        return dp[n - 1][0];    // 卖出股票收益高于持有股票收益，因此取[0]
//    }

    public int maxProfit(int[] prices) {
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for(int i = 1; i <= prices.length;i++ ){
            //前一天持有；既然不限制交易次数，那么再次买股票时，要加上之前的收益
            dp[0] = Math.max(dp[0], dp[1] - prices[i-1]);
            // 前一天卖出; 或当天卖出，当天卖出，得先持有
            dp[1] = Math.max(dp[1], dp[0] + prices[i-1]);
        }
        return dp[1];
    }

    public static void main(String[] args) {
        Stock2 stock = new Stock2();
        System.out.println(stock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(stock.maxProfit(new int[]{1, 2, 3, 4, 5}));
    }

}
