/**
 * @Author:PanYa
 * @Date 2024/7/8-下午3:30
 * @Description:
 */
public  class addBinary_67 {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--){
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;

        }
        ans.append(ca == 1?ca : "");
        return ans.reverse().toString();
    }


    public static void main(String[] args) {
        addBinary_67 adder = new addBinary_67();
        String a = "1010";
        String b = "1101";
        System.out.println(adder.addBinary(a, b));

    }
}
