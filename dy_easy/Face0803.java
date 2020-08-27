/**
 * 面试题 08.01. 三步问题
 */
public class Face0803 {

    public int waysToStep(int n) {

        if (n==1)return 1;
        if (n==2)return 2;
        if (n==3)return 4;
        long[] dp = new long[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for (int i = 4; i <= n; i++) {
            dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%1000000007;
        }
        return (int)dp[n];
    }
}
