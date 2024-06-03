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

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int biggest_smallest = start;
        for (int i = start+1; i < end; i++) {
            if (arr[i] <= pivot) {
                biggest_smallest++;
                swap(arr, i, biggest_smallest);
            }
        }
        swap(arr, start, biggest_smallest);
        return biggest_smallest ;
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }

    public static void main(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]+ " ");

        }
        System.out.println();
    }
}
