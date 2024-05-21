/**
 * @Author:PanYa
 * @Date 2024/5/21-下午4:59
 * @Description: 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
public class CanJump_55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanJump_55 canJump = new CanJump_55();
        int[] nums = {2, 3, 1, 1, 4};
        boolean jump = canJump.canJump(nums);
        System.out.println(jump);
    }
}
