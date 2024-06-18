import java.util.ArrayList;
import java.util.List;
/**
 * @Author:PanYa
 * @Date 2024/6/4-上午11:20
 * @Description:
 */
public class duplicatied_1 {
    public static List<Integer> findDuplicates(int[] numbers) {
        List<Integer> duplicates = new ArrayList<>();
        if (numbers == null || numbers.length <= 0) {
            return duplicates;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] >= numbers.length) {
                return duplicates;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    if (!duplicates.contains(numbers[i])) {
                        duplicates.add(numbers[i]);
                    }
                    break;
                }

                // 交换numbers[i]和numbers[numbers[i]]
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        List<Integer> duplicates = findDuplicates(numbers);

        if (!duplicates.isEmpty()) {
            System.out.println("Duplicate numbers found: " + duplicates);
        } else {
            System.out.println("No duplicate numbers found.");
        }
    }
}


