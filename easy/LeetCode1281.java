/**
 * 1281. 整数的各位积和之差
 */
public class LeetCode1281 {


    public static int subtractProductAndSum(int n) {
        int multi = 1;
        int sum = 0;

        while (n != 0) {
            //  取余数
            int tmp = n % 10;
            multi *= tmp;
            sum += tmp;
            n = n / 10;
        }
        return multi - sum;
    }


    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
    }
}
