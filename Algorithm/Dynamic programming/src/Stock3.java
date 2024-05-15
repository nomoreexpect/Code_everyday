/**
 * @Author: PanYa
 * @Date 2024/5/15-下午3:55
 * @Description:
 */
public class Stock3 {
    public int maxProfit(int[] prices) {
        int[] dp = new int[4];
        // 存储两次交易的状态就行了
        // dp[0]代表第一次交易的买入
        dp[0] = -prices[0];
        // dp[1]代表第一次交易的卖出
        dp[1] = 0;
        // dp[2]代表第二次交易的买入
        dp[2] = -prices[0];
        // dp[3]代表第二次交易的卖出
        dp[3] = 0;
        for(int i = 1; i <= prices.length; i++){
            // 要么保持不变，要么没有就买，有了就卖
            dp[0] = Math.max(dp[0], -prices[i-1]);
            dp[1] = Math.max(dp[1], dp[0]+prices[i-1]);
            // 这已经是第二次交易了，所以得加上前一次交易卖出去的收获
            dp[2] = Math.max(dp[2], dp[1]-prices[i-1]);
            dp[3] = Math.max(dp[3], dp[2]+ prices[i-1]);
        }
        return dp[3];
    }

    public static void main(String[] args) {
        Stock stock = new Stock();
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        int maxProfit = stock.maxProfit(prices);
        System.out.println("The maximum profit is: "+maxProfit);
    }
}
