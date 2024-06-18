/**
 * @Author:PanYa
 * @Date 2024/6/12-下午4:30
 * @Description:
 */
public class reverseWords_151 {
        public static void main(String[] args) {
            String s = "  the sky   is  blue  ";
            String result = reverseWords(s);
            System.out.println("Reversed words: \"" + result + "\"");
        }

        public static String reverseWords(String s) {
            // 去掉首尾空格并将多个空格替换为单个空格
            s = s.trim().replaceAll("\\s+", " ");

            // 分隔成单词数组
            String[] words = s.split(" ");

            // 反转单词数组
            int left = 0, right = words.length - 1;
            while (left < right) {
                String temp = words[left];
                words[left] = words[right];
                words[right] = temp;
                left++;
                right--;
            }

            // 用单个空格连接单词数组
            return String.join(" ", words);
        }

}
