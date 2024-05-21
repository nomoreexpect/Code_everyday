/**
 * @Author:PanYa
 * @Date 2024/5/21-下午4:59
 * @Description:
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
