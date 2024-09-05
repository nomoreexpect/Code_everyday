/**
 * @Author:PanYa
 * @Date 2024/5/21-下午7:33
 * @Description:
 */
public class isPalindrome_125 {
    public boolean isPalindrome(String s) {
        // 转换为小写并移除所有非字母数字字符
        StringBuilder filtered = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filtered.append(Character.toLowerCase(c));
            }
        }

        // 使用双指针法检查回文
        int left = 0, right = filtered.length() - 1;
        while (left < right) {
            if (filtered.charAt(left) != filtered.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        isPalindrome_125 p = new isPalindrome_125();
        System.out.println(p.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
