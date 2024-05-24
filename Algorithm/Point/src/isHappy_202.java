/**
 * @Author:PanYa
 * @Date 2024/5/24-上午10:45
 * @Description:
 */
public class isHappy_202 {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        isHappy_202 isHappy = new isHappy_202();
        int n = 1;
        Boolean t = isHappy.isHappy(n);
        System.out.println(t);

    }
}
