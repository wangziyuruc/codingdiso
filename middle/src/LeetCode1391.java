package src;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1391. 检查网格中是否存在有效路径
 */
public class LeetCode1391 {
    public static boolean hasValidPath(int[][] grid) {

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] visited = new int[grid.length][grid[0].length];
        queue.add(new int[]{0, 0});
        visited[0][0] = -1;


        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0];
            int y = p[1];
            if (x == grid.length - 1 && y == grid[x].length - 1) {
                return true;
            }
            switch (grid[x][y]) {
                case 1:
                    //1 表示连接左单元格和右单元格的街道。
                    detectL(queue, x, y, grid, visited);
                    detectR(queue, x, y, grid, visited);
                    break;
                case 2:
                    //2 表示连接上单元格和下单元格的街道。
                    detectU(queue, x, y, grid, visited);
                    detectD(queue, x, y, grid, visited);
                    break;
                case 3:
                    //3 表示连接左单元格和下单元格的街道。
                    detectL(queue, x, y, grid, visited);
                    detectD(queue, x, y, grid, visited);
                    break;
                case 4:
                    //4 表示连接右单元格和下单元格的街道。
                    detectR(queue, x, y, grid, visited);
                    detectD(queue, x, y, grid, visited);
                    break;
                case 5:
                    //5 表示连接左单元格和上单元格的街道。
                    detectL(queue, x, y, grid, visited);
                    detectU(queue, x, y, grid, visited);
                    break;
                case 6:
                    //6 表示连接右单元格和上单元格的街道。
                    detectR(queue, x, y, grid, visited);
                    detectU(queue, x, y, grid, visited);
                    break;
                default:
                    break;
            }

        }
        return false;

    }

    public static void detectL(Queue<int[]> queue, int x, int y, int[][] grid, int[][] visited) {
        if (y - 1 >= 0 && visited[x][y - 1] == -1) {
            return;
        }
        if (y - 1 >= 0 &&(grid[x][y - 1] == 4 || grid[x][y - 1] == 6 || grid[x][y - 1] == 1)) {
            queue.add(new int[]{x, y - 1});
            visited[x][y - 1] = -1;
        }

    }

    public static void detectR(Queue<int[]> queue, int x, int y, int[][] grid, int[][] visited) {
        if (y + 1 < grid[x].length && visited[x][y + 1] == -1) {
            return;
        }
        if (y + 1 < grid[x].length &&(grid[x][y + 1] == 3 || grid[x][y + 1] == 5 || grid[x][y + 1] == 1)) {

            queue.add(new int[]{x, y + 1});
            visited[x][y + 1] = -1;
        }

    }

    public static void detectU(Queue<int[]> queue, int x, int y, int[][] grid, int[][] visited) {
        if (x - 1 >= 0 && visited[x - 1][y] == -1) {
            return;
        }
        if (x - 1 >= 0 &&(grid[x - 1][y] == 3 || grid[x - 1][y] == 4 || grid[x - 1][y] == 2)) {
            queue.add(new int[]{x - 1, y});
            visited[x - 1][y] = -1;
        }

    }

    public static void detectD(Queue<int[]> queue, int x, int y, int[][] grid, int[][] visited) {
        if (x + 1 < grid.length && visited[x + 1][y] == -1) {
            return;
        }
        if (x + 1 < grid.length &&(grid[x + 1][y] == 5 || grid[x + 1][y] == 6 || grid[x + 1][y] == 2)) {
            queue.add(new int[]{x + 1, y});
            visited[x + 1][y] = -1;

        }
    }


    public static void main(String[] args) {
//        int[][] grid = {{1,2,3},{1,2,1}};
//        int[][] grid = {{1,1,2}};
//        int[][] grid = {{1,1,1,1,1,1,3}};
//        int[][] grid = {{2}, {2}, {2}, {2}, {2}, {2}, {6}};
        int[][] grid = {{2,4,3},{6,5,2}};
        System.out.println(hasValidPath(grid));


    }


}
