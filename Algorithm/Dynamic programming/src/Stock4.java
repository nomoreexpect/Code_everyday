/**
 * @Author:PanYa
 * @Date 2024/5/15-下午7:32
 * @Description:
 */
import java.util.Random;
public class Stock4 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][2*k+1];

        for (int i = 1; i < 2*k; i += 2) {
            dp[0][i] = -prices[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2*k - 1; j+=2) {
                dp[i][j+1] = Math.max(dp[i-1][j+1], dp[i-1][j] - prices[j]);
                dp[i][j+2] = Math.max(dp[i-1][j+2], dp[i-1][j+1] + prices[j]);

            }
        }
        return dp[n-1][2*k];
    }
    public static void main(String[] args) {
        Stock4 s = new Stock4();
        Random random = new Random();
        int len = random.nextInt(10) + 2;
        int[] prices = new int[len];
        for (int i = 0; i < len; i++) {
            prices[i] = random.nextInt(100);
        }
        System.out.print("随机生成的价格数组： ");
        for (int price : prices) System.out.print(price + " ");
        System.out.println();
        int t = len/2;
        System.out.println("最大利润: " + s.maxProfit(t, prices));

    }
}
