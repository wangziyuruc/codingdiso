/**
 * 695. 岛屿的最大面积
 */
public class LeetCode695 {


    public int maxAreaOfIsland(int[][] grid) {

        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid[i].length; i1++) {
                res = Math.max(res, dfs(i, i1, grid));
            }

        }

        return res;

    }


    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;

        int num = 1;
        num += dfs(i - 1, j, grid);
        num += dfs(i + 1, j, grid);
        num += dfs(i, j - 1, grid);
        num += dfs(i, j + 1, grid);
        return num;
    }
}
