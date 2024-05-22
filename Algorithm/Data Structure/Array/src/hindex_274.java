import java.util.Arrays;

/**
 * @Author:PanYa
 * @Date 2024/5/22-上午11:00
 * @Description: 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 *
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 */
public class hindex_274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int h = n -i;
            if (citations[i] >= h){
                return h;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        hindex_274 hindex = new hindex_274();
        int[] citations = new int[]{1,3,1};
        int index = hindex.hIndex(citations);
        System.out.println(index);
    }
}
