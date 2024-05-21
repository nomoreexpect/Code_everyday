/**
 * @Author:PanYa
 * @Date 2024/5/21-下午4:56
 * @Description:
 */
public class MajorElement_167 {
    public int majorityElement(int[] nums) {
        /*
        *@Param [nums]
        *@return int
        *@Description: Boyer-Moore 投票算法
        */
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        MajorElement_167 m = new MajorElement_167();
        int[] nums = new int[]{1,2,3,4,5,6,7,7,9,10};
        int majorElement = m.majorityElement(nums);
        System.out.println(majorElement);
    }
}
