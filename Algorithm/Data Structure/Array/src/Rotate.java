/**
 * @Author:PanYa
 * @Date 2024/5/14-下午1:59
 * @Description:
 */
public class Rotate {
    public void rotate1(int[] nums, int k) {
        // 确保k在数组长度范围内
        k %= nums.length;

        // 反转整个数组
        reverse(nums, 0, nums.length - 1);

        // 反转前k个元素
        reverse(nums, 0, k - 1);

        // 反转剩余元素
        reverse(nums, k, nums.length - 1);
    }

    // 辅助方法：反转数组中从start到end的元素
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // 交换start和end位置的元素
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        Rotate rotateInstance = new Rotate();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("Original array: ");
        printArray(nums);

        rotateInstance.rotate1(nums, k);

        System.out.println("Rotated array: ");
        printArray(nums);
    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
