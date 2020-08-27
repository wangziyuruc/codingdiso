/**
 * 1376. 通知所有员工所需的时间
 */
public class LeetCode1376 {


    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int[] arr = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int index = i;
            int sum =0;
            // 自底向上
            // 叶子结点
            if (informTime[index]==0){
                while ((index = manager[index])!=-1){
                    sum+=informTime[index];
                    if (sum<=arr[index]) break;
                    arr[index] =sum;
                    ans = Math.max(sum,ans);
                }
            }
        }

        return ans;
    }
}
