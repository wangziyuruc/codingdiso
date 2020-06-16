import java.util.Arrays;

/**
 * 56. 合并区间
 */
public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(v1,v2)->v1[0]-v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval:intervals){
            if(idx==-1 || interval[0]>res[idx][1]){
                res[++idx]=interval;
            }else {
                res[idx][1]= Math.max(res[idx][1],interval[1]);
            }
        }
        return Arrays.copyOf(res,idx+1);


    }
}
