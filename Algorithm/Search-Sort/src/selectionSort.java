/**
 * @Author:PanYa
 * @Date 2024/6/18-下午8:24
 * @Description:
 */
public class selectionSort {
    public static int[] selectionSort(int[] args) {
        for (int i = 0; i < args.length; i++) {
            int min = i;
            for (int j = i + 1; j < args.length; j++) {
                if (args[j] < args[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = args[min];
                args[min] = args[i];
                args[i] = temp;
            }
        }
        return args;
    }
}
