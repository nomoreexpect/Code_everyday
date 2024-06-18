import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author:PanYa
 * @Date 2024/6/3-下午4:40
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(0, 100);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        //QuickSort.sort(arr);
        bubbleSort.bubbleSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
