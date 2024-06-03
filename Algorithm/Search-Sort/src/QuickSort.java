/**
 * @Author:PanYa
 * @Date 2024/6/3-上午9:59
 * @Description:
 */
public class QuickSort {

    public static void sort(int[] arr) {
        quickSort(arr,0,arr.length-1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(int[] arr) {
        int pivot = arr[0];
        int biggest_smallest = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= pivot) {
                biggest_smallest++;
                swap(arr, i, biggest_smallest);
            }
        }
        swap(arr, pivot, biggest_smallest);
        return biggest_smallest ;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static void main(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]+ " ");

        }
        System.out.println();
    }
}
