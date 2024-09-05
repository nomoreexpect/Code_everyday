/**
 * @Author:PanYa
 * @Date 2024/6/12-下午4:15
 * @Description:
 */
public class longestCommonPrefix_14 {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String prefix = longestCommonPrefix(strs);
        System.out.println("Longest common prefix: " + prefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 初始前缀为第一个字符串
        String prefix = strs[0];

        // 遍历数组中剩余的字符串
        for (int i = 1; i < strs.length; i++) {
            // 更新前缀
            prefix = commonPrefix(prefix, strs[i]);
            // 如果前缀变为空字符串，则不存在公共前缀
            if (prefix.isEmpty()) {
                break;
            }
        }

        return prefix;
    }

    // 辅助方法：计算两个字符串的公共前缀
    private static String commonPrefix(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        int i = 0;
        while (i < minLength && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return s1.substring(0, i);
    }

}
