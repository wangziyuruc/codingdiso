package src;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 200. 岛屿数量
 */
public class LeetCode200 {

    public static int numIslands(char[][] grid) {

        Queue<int[]> queue = new ArrayDeque<>();
        int nums = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0' || grid[i][j] == '2') {
                    continue;
                }
                queue.add(new int[]{i, j});
                grid[i][j] = '2';
                while (!queue.isEmpty()) {
                    int[] point = queue.poll();
                    int x = point[0];
                    int y = point[1];
                    // 上
                    if (x - 1 >= 0 && grid[x - 1][y] != '0' && grid[x - 1][y] != '2') {
                        queue.add(new int[]{x - 1, y});
                        grid[x - 1][y] = '2';
                    }
                    // 下
                    if (x + 1 < grid.length && grid[x + 1][y] != '0' && grid[x + 1][y] != '2') {
                        queue.add(new int[]{x + 1, y});
                        grid[x + 1][y] = '2';
                    }
                    // 左
                    if (y - 1 >= 0 && grid[x][y - 1] != '0' && grid[x][y - 1] != '2') {
                        queue.add(new int[]{x, y - 1});
                        grid[x][y - 1] = '2';
                    }
                    // 右
                    if (y + 1 < grid[x].length && grid[x][y + 1] != '0' && grid[x][y + 1] != '2') {
                        queue.add(new int[]{x, y + 1});
                        grid[x][y + 1] = '2';
                    }
                }
                nums++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
//        char[][] grid = {{'1', '1', '1', '1', '0'},
//                        {'1', '1', '0', '1', '0'},
//                        {'1', '1', '0', '0', '0'},
//                        {'0', '0', '0', '0', '0'}};
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid));
    }
}
