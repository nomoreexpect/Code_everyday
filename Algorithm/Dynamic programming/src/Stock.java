/**
 * @Author: PanYa
 * @Date 2024/5/14-下午2:59
 * @Description: 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class Stock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            // 更新到目前为止的最低价格
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                // 如果今天的价格比最低价格高，计算利润并更新最大利润
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Stock stock = new Stock();
        int[] prices = new int[]{7,1,5,3,6,4};
        int maxProfit = stock.maxProfit(prices);
        System.out.println("The maximum profit is: "+maxProfit);
    }
}
