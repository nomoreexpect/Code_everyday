/**
 * @Author:PanYa
 * @Date 2024/6/3-上午10:25
 * @Description:
 */
public class MergeSort {

    public static void sort(int[] arr) {
        sortSection(arr, 0, arr.length - 1);
    }

    public static void sortSection(int[] arr, int start, int end) {
        if (start < end) {
            return;
        }
        int mid = (start + end) / 2;
        sortSection(arr, start, mid);
        sortSection(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int len1 = mid - start;
        int[] arr1 = new int[len1];
        System.arraycopy(arr, start, arr1, 0, len1);
        int p1 = 0;
        int p2 = mid;
        for (int i = start; i <= end; i++) {
            if (arr1[p1] < arr[p2]) {
                arr[i] = arr1[p2];
                p1++;
                if (p1 == len1) {break;}
            }else {
                arr[i] = arr1[p2];
                p2++;
                if (p2 > end) {
                    while (p1 < len1) {
                        i++;
                        arr[i] = arr1[p1];
                        p1++;
                    }
                }
            }
        }
    }
}
