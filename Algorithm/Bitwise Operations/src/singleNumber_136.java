/**
 * @Author:PanYa
 * @Date 2024/7/8-下午2:33
 * @Description:
 */
public class singleNumber_136 {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        singleNumber_136 s = new singleNumber_136();

        int[] matrix = new int[]{1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2};

        int result = s.singleNumber(matrix);

        System.out.println(result);


    }
}
