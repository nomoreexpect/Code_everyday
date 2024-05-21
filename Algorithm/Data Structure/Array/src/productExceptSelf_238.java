/**
 * @Author:PanYa
 * @Date 2024/5/21-下午5:05
 * @Description: 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class productExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        // 初始化答案数组
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 初始化为1，因为索引为0的元素左侧没有元素
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 初始时没有元素，所以R=1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含当前元素 nums[i]，所以更新 R
            R *= nums[i];
        }

        return answer;
    }
}
