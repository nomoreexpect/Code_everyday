import java.util.HashSet;

/**
 * @Author:PanYa
 * @Date 2024/6/25-上午10:32
 * @Description:
 */
public class longestPalindrome_ {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return 0;

        HashSet<Character> hashSet = new HashSet<Character>();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!hashSet.contains(chars[i])) {
                hashSet.add(chars[i]);
            }else {
                hashSet.remove(chars[i]);
                count++;
            }
        }
        return hashSet.isEmpty() ? count*2 : count*2+1;
    }


}
