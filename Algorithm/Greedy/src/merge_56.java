import java.util.Arrays;
import java.util.LinkedList;
/**
 * @Author: PanYa
 * @Date 2024/9/2-19:52
 * @Description:
 */


public class merge_56 {
    public int[][] merge(int[][] intervals) {
        // 如果区间为空或者只有一个区间，不需要合并，直接返回
        if (intervals.length <= 1) {
            return intervals;
        }

        // 按照区间的起始位置排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // 如果结果数组为空，或者当前区间的起始位置大于结果数组中最后一个区间的结束位置，
            // 则不重叠，可以直接添加
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                // 否则，有重叠，合并当前区间和结果数组中最后一个区间
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        // 将LinkedList转换成二维数组
        return merged.toArray(new int[merged.size()][]);
    }
}

