import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: PanYa
 * @Date 2024/5/30-下午9:23
 * @Description:
 */
public class nextGreaterElement_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 使用 Deque 代替 Stack
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Map<Integer, Integer> indexMap = new HashMap<>();

        // 将 nums1 的元素及其索引存入 hashMap
        for (int i = 0; i < nums1.length; i++) {
            indexMap.put(nums1[i], i);
        }

        // 遍历 nums2，查找下一个更大元素
        for (int num : nums2) {
            // 检查栈顶元素是否小于当前元素
            while (!stack.isEmpty() && stack.peek() < num) {
                int smallerNum = stack.pop();
                if (indexMap.containsKey(smallerNum)) {
                    int index = indexMap.get(smallerNum);
                    res[index] = num;
                }
            }
            // 将当前元素压入栈中
            stack.push(num);
        }

        return res;
    }

    public static void main(String[] args) {
        nextGreaterElement_496 obj = new nextGreaterElement_496();
        int[] nums1 = new int[5];
        int[] nums2 = new int[6];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = ThreadLocalRandom.current().nextInt(1, 10);
            System.out.print(nums1[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = ThreadLocalRandom.current().nextInt(1, 10);
            System.out.print(nums2[i]+" ");
        }
        System.out.println();
        int[] res = obj.nextGreaterElement(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}
