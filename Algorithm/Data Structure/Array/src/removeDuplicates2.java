/**
 * @Author:PanYa
 * @Date 2024/5/21-下午4:50
 * @Description: 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class removeDuplicates2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length; // 如果数组长度小于等于2，直接返回

        int j = 2; // 新数组的指针，前两个元素一定保留

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[j - 2]) { // 只有当当前元素不等于新数组中倒数第二个元素时，才将其加入新数组
                nums[j] = nums[i];
                j++;
            }
        }

        return j; // 新数组的长度
    }

    public static void main(String[] args) {
        removeDuplicates2 solution = new removeDuplicates2();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int newLength = solution.removeDuplicates(nums);
        System.out.println("New length: " + newLength); // 输出: New length: 5
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " "); // 输出: 1 1 2 2 3
        }
    }
}
