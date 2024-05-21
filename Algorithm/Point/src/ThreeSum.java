import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:PanYa
 * @Date 2024/5/21-下午3:32
 * @Description:
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break; // 改进：直接退出循环
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 跳过重复的元素
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; // 跳过重复的元素
                    while (left < right && nums[right] == nums[right - 1]) right--; // 跳过重复的元素
                    left++;
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> res = threeSum.threeSum(nums);
        System.out.println(res);

    }
}
