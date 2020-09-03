/**
 * 1486. 数组异或操作
 */
public class LeetCode1486 {

    public int xorOperation(int n, int start) {
        int res = 0;
        for (int i=0;i<n;i++){
            res ^= (start+i*2);
        }
        return res;

    }
}
