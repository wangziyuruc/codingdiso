/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 */
public class sword17 {

    public int[] printNumbers(int n) {
        int value = (int) Math.pow(10,n)-1;
        int[] res = new int[value];
        for (int i = 0; i < value; i++) {
            res[i]=i+1;

        }
        return res;

    }
}
