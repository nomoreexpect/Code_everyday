/**
 * @Author:PanYa
 * @Date 2024/7/8-下午2:18
 * @Description:
 */
public class HammingWeight_191 {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n = (n-1)&n;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        HammingWeight_191 hammingWeight = new HammingWeight_191();
        System.out.println(hammingWeight.hammingWeight(3));
    }
}
