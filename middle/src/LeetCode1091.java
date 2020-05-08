package src;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1091. 二进制矩阵中的最短路径
 */
public class LeetCode1091 {

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1){
            return -1;
        }
        // 最短路径 层次遍历层高即是最短路径
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                if(x==grid.length-1&&y==grid[x].length-1){
                    return level;
                }
                // 上
                if(x-1>=0&&grid[x-1][y]!=1){
                    queue.add(new int[]{x-1,y});
                    grid[x-1][y]=1;
                }
                // 下
                if(x+1<grid.length&&grid[x+1][y]!=1){
                    queue.add(new int[]{x+1,y});
                    grid[x+1][y]=1;
                }
                // 左
                if(y-1>=0&&grid[x][y-1]!=1){
                    queue.add(new int[]{x,y-1});
                    grid[x][y-1]=1;
                }
                // 右
                if(y+1<grid[x].length&&grid[x][y+1]!=1){
                    queue.add(new int[]{x,y+1});
                    grid[x][y+1]=1;
                }
                // 左上
                if(x-1>=0&&y-1>=0&&grid[x-1][y-1]!=1){
                    queue.add(new int[]{x-1,y-1});
                    grid[x-1][y-1]=1;
                }
                // 右上
                if(x-1>=0&&y+1<grid[x].length&&grid[x-1][y+1]!=1){
                    queue.add(new int[]{x-1,y+1});
                    grid[x-1][y+1]=1;
                }
                // 左下
                if(x+1<grid.length&&y-1>=0&&grid[x+1][y-1]!=1){
                    queue.add(new int[]{x+1,y-1});
                    grid[x+1][y-1]=1;
                }
                // 右下
                if(x+1<grid.length&&y+1<grid[x].length&&grid[x+1][y+1]!=1){
                    queue.add(new int[]{x+1,y+1});
                    grid[x+1][y+1]=1;
                }
            }

        }

        return -1;


    }

    public static void main(String[] args) {
//        int[][] grid = {
//                {0,1},
//                {1,0}};

        int[][] grid = {
                {0,0,0},
                {1,1,0},
                {1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
