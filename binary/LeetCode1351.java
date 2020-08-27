/**
 * 1351. 统计有序矩阵中的负数
 */
public class LeetCode1351 {


    public int countNegatives(int[][] grid) {

        int sum =0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]<0){
                    sum+=grid[0].length-j;
                    break;
                }
            }

        }

        return sum;
    }
}
