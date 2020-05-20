package src;

import java.util.Arrays;

/**
 * 279. 完全平方数
 */
public class LeetCode279 {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        int maxSquareIndex = (int)Math.sqrt(n)+1;
        int squareNums[] =new int[maxSquareIndex];
        for (int i=0;i<maxSquareIndex;i++){
            squareNums[i]=i*i;
        }
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<maxSquareIndex;j++){
                if(i<squareNums[j]){
                    break;
                }


                dp[i]=Math.min(dp[i],dp[i-squareNums[j]]+1);
            }
        }
        return dp[n];


    }
}
