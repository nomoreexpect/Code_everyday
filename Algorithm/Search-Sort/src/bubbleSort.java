/**
 * @Author:PanYa
 * @Date 2024/6/18-下午4:12
 * @Description:
 */
public class bubbleSort {
    public static int[] bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // Set a flag, if true, that means the loop has not been swapped,
            // that is, the sequence has been ordered, the sorting has been completed.
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    // Change flag
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }
}


