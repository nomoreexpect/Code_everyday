/**
 * @Author:PanYa
 * @Date 2024/6/4-下午6:06
 * @Description:
 */
public class diplicated_2 {
    public static int findDuplicate(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int count = countRange(numbers, start, mid);

            if (start == end) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }

            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        throw new IllegalArgumentException("No duplicate number found");
    }

    private static int countRange(int[] numbers, int start, int end) {
        int count = 0;
        for (int number : numbers) {
            if (number >= start && number <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        int duplicate = findDuplicate(numbers);
        System.out.println("Duplicate number found: " + duplicate);
    }
}
