/**
 * @Author:PanYa
 * @Date 2024-5月-2024/5/10-上午11:00
 * @Description
 */

/**
 * @Author:PanYa
 * @Date 2024-5月-2024/5/10-上午11:00
 * @Description
 */
public class Remove_ele {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        Remove_ele remover = new Remove_ele();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int newLength = remover.removeElement(nums, val);

        System.out.println("New length: " + newLength);
        System.out.print("Array after removal: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}