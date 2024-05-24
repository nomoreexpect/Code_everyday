import java.util.HashMap;
import java.util.Map;
/**
 * @Author:PanYa
 * @Date 2024/5/24-下午4:22
 * @Description:
 */
public class romanToInt_13 {
    public int romanToInt(String s) {
        // 创建一个哈希表，存储罗马数字字符及其对应的整数值
        Map<Character, Integer> romanToIntMap = new HashMap<>();
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);

        int result = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int currentVal = romanToIntMap.get(s.charAt(i));

            // 如果不是最后一个字符，且当前字符的值小于下一个字符的值
            if (i < n - 1 && currentVal < romanToIntMap.get(s.charAt(i + 1))) {
                result -= currentVal; // 减去当前值
            } else {
                result += currentVal; // 加上当前值
            }
        }

        return result;
    }

    public static void main(String[] args) {
        romanToInt_13 r = new romanToInt_13();
        String roman = "III";
        int result = r.romanToInt(roman);
        System.out.println(result);
    }
}
