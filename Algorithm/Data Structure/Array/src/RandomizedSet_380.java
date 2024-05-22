/**
 * @Author:PanYa
 * @Date 2024/5/22-下午2:43
 * @Description:
 */
import java.util.*;
public class RandomizedSet_380 {
    class RandomizedSet {
        private List<Integer> nums;
        private Map<Integer, Integer> indices;
        private Random random;

        public RandomizedSet() {
            nums = new ArrayList<>();
            indices = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (indices.containsKey(val)) {
                return false;
            }
            nums.add(val);
            indices.put(val, nums.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!indices.containsKey(val)) {
                return false;
            }
            int index = indices.get(val);
            int lastNum = nums.get(nums.size() - 1);
            nums.set(index, lastNum);
            indices.put(lastNum, index);
            nums.remove(nums.size() - 1);
            indices.remove(val);
            return true;
        }

        public int getRandom() {
            return nums.get(random.nextInt(nums.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedSet_380 setInsetence = new RandomizedSet_380();
        RandomizedSet_380.RandomizedSet set = setInsetence.new RandomizedSet();
        System.out.println(set.insert(1));
        System.out.println(set.insert(2));
        System.out.println(set.insert(3));
        System.out.println(set.insert(1));

        System.out.println(set.getRandom()); // 可能返回 1、2 或 3

        System.out.println(set.remove(2)); // 可能返回 1、2 或 3
        System.out.println(set.remove(2));
    }
}


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

