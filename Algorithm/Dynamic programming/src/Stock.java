/**
 * @Author:PanYa
 * @Date 2024/5/14-下午2:59
 * @Description:
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
