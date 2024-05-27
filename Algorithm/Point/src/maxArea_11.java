/**
 * @Author:PanYa
 * @Date 2024/5/27-上午10:15
 * @Description:
 */
public class maxArea_11 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int currentArea = width * minHeight;
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        maxArea_11 solution = new maxArea_11();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("The maximum amount of water that can be contained is: " + solution.maxArea(height));
    }
}
