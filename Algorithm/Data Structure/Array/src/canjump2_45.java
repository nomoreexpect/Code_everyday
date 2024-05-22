/**
 * @Author:PanYa
 * @Date 2024/5/22-上午10:34
 * @Description:
 */
public class canjump2_45 {
    public static int canjump(int[] nums) {
        if (nums.length == 0 || nums == null || nums.length ==1) return 0;

        int count = 0, cur = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                count++;
                break;
            }
            if (cur == i){
                cur = max;
                count++;
            }
        }
        return count;
    }
}
